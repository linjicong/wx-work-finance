package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class TodoContent extends BaseContent{

    private Todo todo;

    @Data
    public static class Todo {
        // 待办的来源文本
        private String title;
        // 待办的具体内容
        private String content;
    }
}
