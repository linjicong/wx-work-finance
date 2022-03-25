package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 文本消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class TextContent extends BaseContent{

    private Text text;

    @Data
    public static class Text {
        // 消息内容
        private String content;
    }
}
