package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class MarkdownContent extends BaseContent{

    private Info info;

    @Data
    public static class Info {
        // markdown消息内容，目前为机器人发出的消息
        private String content;
    }
}
