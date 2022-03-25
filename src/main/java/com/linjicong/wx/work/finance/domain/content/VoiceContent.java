package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class VoiceContent extends BaseContent{

    private Voice voice;

    @Data
    public static class Voice extends MediaContent{
        // 语音消息大小
        private Long voice_size;
        // 播放长度
        private Long play_length;
    }
}
