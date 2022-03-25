package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class AgreeContent extends BaseContent{

    private Agree agree;

    @Data
    public static class Agree {
        // 同意/不同意协议者的userid，外部企业默认为external_userid
        private String userid;
        // 同意协议的时间
        private String agree_time;
    }
}
