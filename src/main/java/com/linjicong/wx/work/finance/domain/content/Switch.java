package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class Switch {
    // 消息id，消息的唯一标识，企业可以使用此字段进行消息去重
    private String msgid;
    // 消息动作，切换企业为switch
    private String action;
    // 消息发送时间戳，utc时间，ms单位
    private Long time;
    // 具体为切换企业的成员的userid
    private String user;

    @Data
    public static class Agree {
        // 同意/不同意协议者的userid，外部企业默认为external_userid
        private String userid;
        // 同意协议的时间
        private String agree_time;
    }
}
