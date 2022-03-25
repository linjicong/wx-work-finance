package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class Revoke extends BaseContent{

    private RevokeInfo revoke;

    @Data
    public static class RevokeInfo {
        // 标识撤回的原消息的msgid
        private String pre_msgid;
    }
}
