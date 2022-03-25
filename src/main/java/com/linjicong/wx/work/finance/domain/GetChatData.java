package com.linjicong.wx.work.finance.domain;

import lombok.Data;

import java.util.List;

/**
 * 会话存档数据
 * @author linjicong
 * @date 2022-03-23 20:03
 */
@Data
public class GetChatData {
    // 0表示成功，错误返回非0错误码，需要参看errmsg
    private Integer errcode;
    // 返回信息，如非空为错误原因
    private String errmsg;
    // 聊天记录数据内容
    private List<ChatData> chatdata;

    @Data
    public static class ChatData {
        // 消息的seq值，标识消息的序号。再次拉取需要带上上次回包中最大的seq。Uint64类型，范围0-pow(2,64)-1
        private Integer seq;
        // 消息id，消息的唯一标识，企业可以使用此字段进行消息去重。String类型。msgid以_external结尾的消息，表明该消息是一条外部消息。
        private String msgid;
        // 加密此条消息使用的公钥版本号
        private Integer publickey_ver;
        // 使用publickey_ver指定版本的公钥进行非对称加密后base64加密的内容，需要业务方先base64 decode处理后，再使用指定版本的私钥进行解密，得出内容
        private String encrypt_random_key;
        // 消息密文。需要业务方使用将encrypt_random_key解密得到的内容，与encrypt_chat_msg，传入sdk接口DecryptData,得到消息明文
        private String encrypt_chat_msg;
    }
}
