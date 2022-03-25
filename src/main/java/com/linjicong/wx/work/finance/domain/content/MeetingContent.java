package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class MeetingContent extends BaseContent{

    private Meeting meeting;

    @Data
    public static class Meeting {
        // 会议主题
        private String topic;
        // 会议开始时间
        private Long starttime;
        // 会议结束时间
        private Long endtime;
        // 会议地址
        private String address;
        // 会议备注
        private String remarks;
        // 会议消息类型。101发起会议邀请消息、102处理会议邀请消息
        private Integer meetingtype;
        // 会议id。方便将发起、处理消息进行对照
        private Long meetingid;
        // 会议邀请处理状态。1 参加会议、2 拒绝会议、3 待定、4 未被邀请、5 会议已取消、6 会议已过期、7 不在房间内。Uint32类型。只有meetingtype为102的时候此字段才有内容
        private Integer status;
    }
}
