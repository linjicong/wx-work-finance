package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

import java.util.List;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class ChatRecordContent extends BaseContent{

    private ChatRecord chatRecord;

    @Data
    public static class ChatRecord {
        // 消息标题
        private String title;
        // 消息记录内的消息内容
        private List<Item> item;

        @Data
        private static class Item {
            // 每条聊天记录的具体消息类型：ChatRecordText/ ChatRecordFile/ ChatRecordImage/ ChatRecordVideo/ ChatRecordLink/ ChatRecordLocation/ ChatRecordMixed ….
            private String type;
            // 消息时间，utc时间，单位秒
            private Long msgtime;
            // 消息内容。Json串，内容为对应类型的json
            private String content;
            // 是否来自群会话
            private Boolean from_chatroom;
        }
    }
}
