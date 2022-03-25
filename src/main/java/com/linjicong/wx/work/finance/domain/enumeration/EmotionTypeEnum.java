package com.linjicong.wx.work.finance.domain.enumeration;

/**
 * @author linjicong
 * @date 2022-03-24 14:43
 */
public enum EmotionTypeEnum {
    gif(1),
    png(2);

    private Integer type;

    EmotionTypeEnum(Integer type) {
        this.type = type;
    }

    public static EmotionTypeEnum fromValue(Integer type) {
        for (EmotionTypeEnum b : EmotionTypeEnum.values()) {
            if (b.type.equals(type)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected type '" + type + "'");
    }
}
