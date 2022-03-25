package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

import java.util.List;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class NewsContent extends BaseContent{
    // 图文消息的内容
    private Info info;

    @Data
    public static class Info {
        // 图文消息数组，每个item结构包含title、description、url、picurl等结构
        private List<Item> item;

        private static class Item {
            // 图文消息标题
            private String title;
            // 图文消息描述
            private String description;
            // 图文消息点击跳转地址
            private String url;
            // 图文消息配图的url
            private String picurl;
        }
    }
}
