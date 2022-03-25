package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class LocationContent extends BaseContent{

    private Location location;

    @Data
    public static class Location {
        // 经度
        private Double longitude;
        // 纬度
        private Double latitude;
        // 地址信息
        private String address;
        // 位置信息的title
        private String title;
        // 缩放比例
        private Integer zoom;
    }
}
