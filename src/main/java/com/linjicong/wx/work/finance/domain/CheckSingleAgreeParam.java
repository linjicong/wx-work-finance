package com.linjicong.wx.work.finance.domain;

import lombok.Data;

/**
 * @author linjicong
 * @date 2022-03-25 14:01
 */
@Data
public class CheckSingleAgreeParam {
    //待查询的会话信息
    private Info info;

    @Data
    private static class Info {
        // 内部成员的userid
        private String userid;
        // 外部成员的exteranalopenid
        private String externalopenid;
    }
}
