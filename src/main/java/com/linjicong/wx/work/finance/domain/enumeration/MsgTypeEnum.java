package com.linjicong.wx.work.finance.domain.enumeration;

/**
 * @author linjicong
 * @date 2022-03-24 14:43
 */
public enum MsgTypeEnum {
    TEXT("text"),
    IMAGE("image"),
    REVOKE("revoke"),
    AGRREE("agree"),
    DISAGREE("disagree"),
    VOICE("voice"),
    VIDEO("video"),
    CARD("card"),
    LOCATION("location"),
    EMOTION("emotion"),
    FILE("file"),
    LINK("link"),
    WEAPP("weapp"),
    CHARRECORD("chatrecord"),
    TODO("todo"),
    VOTE("vote"),
    COLLECT("collect"),
    REDPACKET("redpacket"),
    MEETING("meeting"),
    DOCMSG("docmsg"),
    MARKDOWN("markdown"),
    NEWS("news"),
    CALENDAR("calendar"),
    MIXED("mixed"),
    MEETING_VOICE_CALL("meeting_voice_call"),
    VOIP_DOC_SHARE("voip_doc_share"),
    EXTERNAL_REDPACKET("external_redpacket"),
    SPHFEED("sphfeed");

    private String msgtype;

    public String getMsgtype() {
        return msgtype;
    }

    MsgTypeEnum(String msgtype) {
        this.msgtype = msgtype;
    }

    public static MsgTypeEnum fromValue(String msgtype) {
        for (MsgTypeEnum b : MsgTypeEnum.values()) {
            if (b.msgtype.equals(msgtype)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected msgtype '" + msgtype + "'");
    }
}
