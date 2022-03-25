package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class LinkContent extends BaseContent{

    private Link link;

    @Data
    public static class Link {
        // 消息标题
        private String title;
        // 消息描述
        private String description;
        // 链接url地址
        private String link_url;
        // 链接图片url
        private String image_url;
    }
}
