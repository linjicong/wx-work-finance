package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

import java.util.List;


/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class MixedContent extends BaseContent{

    private Mixed mixed;

    @Data
    public static class Mixed {
        // 消息内容
        private List<Item> item;

        @Data
        private static class Item {
            // 类型
            private String type;
            // 消息内容
            private String content;
        }
    }
}
