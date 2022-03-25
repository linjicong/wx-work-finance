package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class RedpacketContent extends BaseContent{

    private Redpacket redpacket;

    @Data
    public static class Redpacket {
        // 红包消息类型。1 普通红包、2 拼手气群红包、3 激励群红包
        private Integer type;
        // 红包祝福语
        private String wish;
        // 红包总个数
        private Integer totalcnt;
        // 红包总金额
        private Integer totalamount;
    }
}
