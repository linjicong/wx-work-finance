package com.linjicong.wx.work.finance.domain.enumeration;

/**
 * @author linjicong
 * @date 2022-03-24 14:43
 */
public enum ActionEnum {
    SEND("send"),
    RECALL("recall"),
    SWITCH("switch");

    private String action;

    ActionEnum(String action) {
        this.action = action;
    }
}
