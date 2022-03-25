package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class VoipDocShareContent extends BaseContent{
    // 音频id
    private String vopid;
    // 共享文档消息内容
    private VoipDocShare voip_doc_share;

    @Data
    public static class VoipDocShare extends MediaContent{
        // 文档共享文件名称
        private String filename;
        // 共享文件的大小
        private String filesize;
    }
}
