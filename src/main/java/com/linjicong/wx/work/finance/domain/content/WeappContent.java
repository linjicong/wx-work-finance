package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class WeappContent extends BaseContent{

    private Weapp weapp;

    @Data
    public static class Weapp {
        // 消息标题
        private String title;
        // 消息描述
        private String description;
        // 用户名称
        private String username;
        // 小程序名称
        private String displayname;
    }
}
