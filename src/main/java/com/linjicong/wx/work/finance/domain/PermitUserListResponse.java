package com.linjicong.wx.work.finance.domain;

import lombok.Data;

import java.util.List;

/**
 * @author linjicong
 * @date 2022-03-25 13:52
 */
@Data
public class PermitUserListResponse {
    private Integer errcode;
    private String errmsg;
    // 设置在开启范围内的成员的userid列表
    private List<String> ids;
}
