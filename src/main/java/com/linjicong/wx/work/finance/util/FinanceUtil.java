package com.linjicong.wx.work.finance.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.tencent.wework.Finance;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 会话存档工具类
 * @author linjicong
 * @date 2022-03-25 10:41
 */
public class FinanceUtil {
    public static final String CORP_ID=System.getenv("CORP_ID");
    public static final String SECRET=System.getenv("SECRET");;
    public static final String PRIVATE_KEY =System.getenv("PRIVATE_KEY");

    static long ret=0;
    static final long sdk= Finance.NewSdk();
    static {
        ret = Finance.Init(sdk, CORP_ID, SECRET);
        if(ret != 0){
            Finance.DestroySdk(sdk);
            System.out.println("init sdk err ret " + ret);
        }
    }
    /**
     * 获取会话存档
     * @param seq 存档消息序号，该序号单调递增，拉取序号建议设置为上次拉取返回结果中最大序号。首次拉取时seq传0，sdk会返回有效期内最早的消息
     * @param limit 拉取的最大消息条数，取值范围为1~1000
     * @param proxy 代理链接,支持socks5,http,如：socks5://10.0.0.1:8081 或者 http://10.0.0.1:8081
     * @param passwd 代理账号密码,如 user_name:passwd_123
     * @param timeout 超时时间，单位秒
     * @return
     */
    public static String getChatData(Integer seq, Integer limit, String proxy, String passwd, Integer timeout){
        long slice = Finance.NewSlice();
        try {
            ret = Finance.GetChatData(sdk, seq, limit, proxy, passwd, timeout, slice);
            if (ret != 0) {
                System.out.println("getchatdata ret " + ret);
                Finance.FreeSlice(slice);
                return null;
            }
            return Finance.GetContentFromSlice(slice);
        } finally {
            Finance.FreeSlice(slice);
        }
    }

    /**
     * 获取媒体文件
     * @param sdkfileid 媒体文件id，从解密后的会话存档中得到
     * @param savefile 媒体文件保存路径
     * @param proxy 代理链接,支持socks5,http,如：socks5://10.0.0.1:8081 或者 http://10.0.0.1:8081
     * @param passwd 代理账号密码,如 user_name:passwd_123
     * @param timeout 超时时间，单位秒
     * @return
     */
    public static void getMediaData(String sdkfileid,String savefile,String proxy,String passwd,Integer timeout){
        //媒体文件每次拉取的最大size为512k，因此超过512k的文件需要分片拉取。若该文件未拉取完整，sdk的IsMediaDataFinish接口会返回0，同时通过GetOutIndexBuf接口返回下次拉取需要传入GetMediaData的indexbuf。
        //indexbuf一般格式如右侧所示，”Range:bytes=524288-1048575“，表示这次拉取的是从524288到1048575的分片。单个文件首次拉取填写的indexbuf为空字符串，拉取后续分片时直接填入上次返回的indexbuf即可。
        String indexbuf = "";
        while(true){
            //每次使用GetMediaData拉取存档前需要调用NewMediaData获取一个media_data，在使用完media_data中数据后，还需要调用FreeMediaData释放。
            long media_data = Finance.NewMediaData();
            ret = Finance.GetMediaData(sdk, indexbuf, sdkfileid, proxy, passwd, timeout, media_data);
            if(ret!=0){
                System.out.println("getmediadata ret:" + ret);
                Finance.FreeMediaData(media_data);
                return;
            }
            System.out.printf("getmediadata outindex len:%d, data_len:%d, is_finis:%d\n",Finance.GetIndexLen(media_data),Finance.GetDataLen(media_data), Finance.IsMediaDataFinish(media_data));
            try {
                //大于512k的文件会分片拉取，此处需要使用追加写，避免后面的分片覆盖之前的数据。
                FileOutputStream outputStream  = new FileOutputStream(new File(savefile), true);
                outputStream.write(Finance.GetData(media_data));
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(Finance.IsMediaDataFinish(media_data) == 1){
                //已经拉取完成最后一个分片
                Finance.FreeMediaData(media_data);
                break;
            }else{
                //获取下次拉取需要使用的indexbuf
                indexbuf = Finance.GetOutIndexBuf(media_data);
                Finance.FreeMediaData(media_data);
            }
        }
    }

    /**
     * 解密会话存档内容
     * @param encrypt_key 用rsa私钥解密chatData中的encrypt_random_key
     * @param encrypt_chat_msg 加密的会话内容
     * @return 解密会话内容
     */
    public static String decryptData(String encrypt_key,String encrypt_chat_msg){
        long msg = Finance.NewSlice();
        try {
            ret = Finance.DecryptData(sdk, encrypt_key, encrypt_chat_msg, msg);
            if (ret != 0) {
                System.out.println("getchatdata ret " + ret);
                return null;
            }
            return Finance.GetContentFromSlice(msg);
        } finally {
            Finance.FreeSlice(msg);
        }
    }

    /**
     * 解密会话内容中的加密key
     * @param encrypt_random_key chatdata中的encrypt_random_key
     * @return 解密后的key
     */
    public static String decryptRandomKey(String encrypt_random_key){
        byte[] str1 = Base64.decode(encrypt_random_key);
        RSA rsaA = new RSA(PRIVATE_KEY,null);
        return new String(rsaA.decrypt(str1, KeyType.PrivateKey));
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
