package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;


/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class CalendarContent extends BaseContent{

    private Calendar calendar;

    @Data
    public static class Calendar {
        // 日程主题
        private String title;
        // 日程组织者
        private String creatorname;
        // 日程参与人
        private String attendeename	;
        // 日程开始时间
        private Long starttime;
        // 日程结束时间
        private Long endtime;
        // 日程地点
        private String place;
        // 日程备注
        private String remarks;
    }
}
