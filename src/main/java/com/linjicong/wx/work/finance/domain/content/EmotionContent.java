package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 视频消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class EmotionContent extends BaseContent{

    private Emotion emotion;

    @Data
    public static class Emotion extends MediaContent{
        // 表情类型，png或者gif.1表示gif 2表示png
        private Integer type;
        // 表情图片宽度
        private Integer width;
        // 表情图片高度
        private Integer height;
        // 资源的文件大小
        private Integer imagesize;
    }
}
