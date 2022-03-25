package com.linjicong.wx.work.finance.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.linjicong.wx.work.finance.domain.*;

/**
 * @author linjicong
 * @date 2022-03-25 13:49
 */
public class MsgAuditUtil {
    /**
     * 获取token
     * @return accesstoken
     */
    public static PermitUserList getPermitUserList(){
        String result = HttpRequest.get("https://qyapi.weixin.qq.com/cgi-bin/msgaudit/get_permit_user_list?access_token="+TokenUtil.getToken())
                .timeout(5000)
                .execute()
                .body();
        return JSONUtil.toBean(result,PermitUserList.class);
    }

    /**
     * 获取会话同意情况-单聊
     * @return accesstoken
     */
    public static CheckSingleAgreeResponse checkSingleAgree(CheckSingleAgreeParam checkSingleAgreeParam){
        String result = HttpRequest.post("https://qyapi.weixin.qq.com/cgi-bin/msgaudit/check_single_agree?access_token=" + TokenUtil.getToken())
                .body(JSONUtil.toJsonStr(checkSingleAgreeParam))
                .timeout(5000)
                .execute()
                .body();
        return JSONUtil.toBean(result,CheckSingleAgreeResponse.class);
    }

    /**
     * 获取会话同意情况-群聊
     * @return accesstoken
     */
    public static CheckRoomAgreeResponse checkRoomAgree(String roomId){
        String result = HttpRequest.post("https://qyapi.weixin.qq.com/cgi-bin/msgaudit/check_room_agree?access_token=" + TokenUtil.getToken())
                .body("{\"roomid\":\""+roomId+"\"}")
                .timeout(5000)
                .execute()
                .body();
        return JSONUtil.toBean(result,CheckRoomAgreeResponse.class);
    }

    /**
     * 获取会话同意情况-群聊
     * @return accesstoken
     */
    public static GroupInfoResponse getGroupInfo(String roomId){
        String result = HttpRequest.post("https://qyapi.weixin.qq.com/cgi-bin/msgaudit/groupchat/get?access_token=" + TokenUtil.getToken())
                .body("{\"roomid\":\""+roomId+"\"}")
                .timeout(5000)
                .execute()
                .body();
        return JSONUtil.toBean(result,GroupInfoResponse.class);
    }

    public static void main(String[] args) {
        //PermitUserList permitUserList = getPermitUserList();
        //System.out.println(permitUserList);
        GroupInfoResponse groupInfo = getGroupInfo("wr7maBCwAAMGI_gswddSwn5nXs3IDWzg");
        System.out.println(groupInfo);
    }
}
