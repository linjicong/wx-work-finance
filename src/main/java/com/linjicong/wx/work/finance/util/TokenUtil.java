package com.linjicong.wx.work.finance.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.linjicong.wx.work.finance.domain.AccessToken;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author linjicong
 * @date 2022-03-25 11:53
 */
public class TokenUtil {
    public static final String CORP_ID=System.getenv("CORP_ID");
    public static final String SECRET=System.getenv("SECRET");
    public static final String TOKEN_FILE = System.getProperty("user.dir") + "/accessToken.json";
    /**
     * 获取token
     * @return accesstoken
     */
    public static String getToken(){
        if(FileUtil.exist(TOKEN_FILE)) {
            AccessToken accessToken = JSONUtil.toBean(FileUtil.readString(new File(TOKEN_FILE), Charset.defaultCharset()), AccessToken.class);
            if(accessToken.getExpireTime()>new Date().getTime()) {
                return accessToken.getAccess_token();
            }else{
                return fetchToken().getAccess_token();
            }
        }else{
            return fetchToken().getAccess_token();
        }
    }

    public static AccessToken fetchToken(){
        String result = HttpRequest.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORP_ID + "&corpsecret=" + SECRET + "")
                .timeout(5000)
                .execute()
                .body();
        AccessToken accessToken = JSONUtil.toBean(result, AccessToken.class);
        accessToken.setExpireTime(new Date().getTime()+accessToken.getExpires_in()*1000);
        FileUtil.writeString(JSONUtil.toJsonStr(accessToken), TOKEN_FILE,Charset.defaultCharset());
        return accessToken;
    }

    public static void main(String[] args) {
        String token = getToken();
        System.out.println(token);
    }
}
