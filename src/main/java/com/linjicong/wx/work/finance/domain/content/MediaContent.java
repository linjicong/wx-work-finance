package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 图片消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class MediaContent {
    // 资源的md5值，供进行校验
    private String md5sum;
    // 媒体资源的id信息
    private String sdkfileid;
}
