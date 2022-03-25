package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class DocmsgContent extends BaseContent{

    private Doc doc;

    @Data
    public static class Doc {
        // 在线文档名称
        private String title;
        // 在线文档链接
        private String link_url;
        // 在线文档创建者。本企业成员创建为userid；外部企业成员创建为external_userid
        private String doc_creator;
    }
}
