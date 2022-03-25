package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 视频消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class FileContent extends BaseContent{

    private File file;

    @Data
    public static class File extends MediaContent{
        // 文件名称
        private String filename;
        // 文件类型后缀
        private String fileext;
        // 文件大小
        private Integer filesize;
    }
}
