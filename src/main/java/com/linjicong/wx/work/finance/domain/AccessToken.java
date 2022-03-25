package com.linjicong.wx.work.finance.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author linjicong
 * @date 2022-03-25 11:09
 */
@Data
public class AccessToken {
    private Integer errcode;
    private String errmsg;
    private String access_token;
    private Integer expires_in;
    private Long expireTime;
}
