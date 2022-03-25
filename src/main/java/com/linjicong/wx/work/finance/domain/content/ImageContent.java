package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 图片消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class ImageContent extends BaseContent{

    private Image image;

    @Data
    public static class Image extends MediaContent{
        // 图片资源的文件大小
        private Long filesize;
    }
}
