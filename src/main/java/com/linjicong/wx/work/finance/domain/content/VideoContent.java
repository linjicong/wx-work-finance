package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 视频消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class VideoContent extends BaseContent{

    private Video video;

    @Data
    public static class Video extends MediaContent{
        // 资源的文件大小
        private Long filesize;
        // 视频播放长度
        private Long play_length;
    }
}
