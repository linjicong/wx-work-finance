package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class CardContent extends BaseContent{

    private Card card;

    @Data
    public static class Card {
        // 名片所有者所在的公司名称
        private String corpname;
        // 名片所有者的id，同一公司是userid，不同公司是external_userid
        private Long userid;
    }
}
