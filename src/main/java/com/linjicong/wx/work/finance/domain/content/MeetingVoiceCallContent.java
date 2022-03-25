package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class MeetingVoiceCallContent extends BaseContent{
    // 音频id
    private String voiceid;
    // 音频消息内容
    private MeetVoiceCall meeting_voice_call;

    @Data
    public static class MeetVoiceCall {
        // 音频结束时间
        private Long endtime;
        // 音频媒体下载的id
        private String sdkfileid;
        // 文档分享对象
        private DemoFileData demofiledata;
        // 屏幕共享对象
        private ShareScreenData sharescreendata;
        @Data
        private static class DemoFileData {
            //
            private Object filename;
            private Object demooperator;
            private Long starttime;
            private Long endtime;
        }
        @Data
        private static class ShareScreenData {
            private String share;
            private Long starttime;
            private Long endtime;
        }
    }
}
