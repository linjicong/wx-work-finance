package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author linjicong
 * @date 2022-03-23 20:40
 */
@Data
public class BaseContent {
    // 消息id，消息的唯一标识，企业可以使用此字段进行消息去重
    private String msgid;
    // 文本消息为：text
    private String msgtype;
    // 消息发送时间戳，utc时间，ms单位
    private Long msgtime;
    // 消息动作，目前有send(发送消息)/recall(撤回消息)/switch(切换企业日志)三种类型
    private String action;
    // 消息发送方id。同一企业内容为userid，非相同企业为external_userid。消息如果是机器人发出，也为external_userid
    private String from;
    // 消息接收方列表，可能是多个，同一个企业内容为userid，非相同企业为external_userid。
    private List<String> tolist;
    // 群聊消息的群id。如果是单聊则为空
    private String roomid;
}
