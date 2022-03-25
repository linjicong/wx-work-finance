package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class SphfeedContent extends BaseContent{

    private Sphfeed sphfeed;

    @Data
    public static class Sphfeed {
        // 视频号消息类型
        private Integer feed_type;
        // 视频号账号名称
        private String sph_name;
        // 视频号消息描述
        private String feed_desc;
    }
}
