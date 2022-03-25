package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

import java.util.List;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class VoteContent extends BaseContent{

    private Vote vote;

    @Data
    public static class Vote {
        // 投票主题
        private String votetitle;
        // 投票选项，可能多个内容
        private List<String> voteitem;
        // 投票类型.101发起投票、102参与投票
        private Integer votetype;
        // 投票id，方便将参与投票消息与发起投票消息进行前后对照
        private String voteid;
    }
}
