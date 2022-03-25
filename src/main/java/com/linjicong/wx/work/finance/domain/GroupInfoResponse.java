package com.linjicong.wx.work.finance.domain;

import lombok.Data;

import java.util.List;

/**
 * @author linjicong
 * @date 2022-03-25 15:15
 */
@Data
public class GroupInfoResponse {
    private Integer errcode;
    private String errmsg;
    // 群名称
    private String roomname;
    // 群创建者，userid
    private String creator;
    // 群创建时间
    private Long room_create_time;
    // 群公告
    private String notice;
    // 群成员列表
    private List<Members> members;

    @Data
    private static class Members {
        // 群成员的id
        private String memberid;
        // 群成员的入群时间
        private Long jointime;
    }
}
