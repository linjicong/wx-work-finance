package com.linjicong.wx.work.finance.domain;

import lombok.Data;

import java.util.List;

/**
 * @author linjicong
 * @date 2022-03-25 14:01
 */
@Data
public class CheckSingleAgreeResponse {
    private Integer errcode;
    private String errmsg;
    // 同意情况
    private List<AgreeInfo> agreeinfo;

    @Data
    private static class AgreeInfo {
        //同意状态改变的具体时间，utc时间
        private Long status_change_time;
        // 内部成员的userid
        private String userid;
        // 群内外部联系人的externalopenid
        private String exteranalopenid;
        // 同意:"Agree"，不同意:"Disagree"
        private String agree_status;

    }
}
