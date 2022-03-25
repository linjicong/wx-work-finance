package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class DisagreeContent extends BaseContent{

    private Disagree disagree;

    @Data
    public static class Disagree {
        // 同意/不同意协议者的userid，外部企业默认为external_userid
        private String userid;
        // 不同意协议的时间
        private String disagree_time;
    }
}
