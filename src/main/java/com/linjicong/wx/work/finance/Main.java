package com.linjicong.wx.work.finance;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.linjicong.wx.work.finance.domain.GetChatData;
import com.linjicong.wx.work.finance.domain.content.*;
import com.linjicong.wx.work.finance.domain.enumeration.EmotionTypeEnum;
import com.linjicong.wx.work.finance.domain.enumeration.MsgTypeEnum;
import com.linjicong.wx.work.finance.util.FinanceUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @author linjicong
 * @date 2022-03-23 17:47
 */
public class Main {
    public static void main(String[] args) {
        // 1.拉取会话存档数据(加密)
        String originChatData = FinanceUtil.getChatData(0, 1000, null, null, 5);
        System.out.println(JSONUtil.toJsonPrettyStr(originChatData));
        GetChatData getChatData=JSONUtil.toBean(originChatData, GetChatData.class);
        // 2. 解密会话存档数据
        List<CommonContent> commonContentList = new ArrayList<>();
        for (GetChatData.ChatData chatData : getChatData.getChatdata()) {
            // 先用私钥解密消息加密的密钥,得到encrypt_key
            String decryptData = FinanceUtil.decryptData(FinanceUtil.decryptRandomKey(chatData.getEncrypt_random_key()), chatData.getEncrypt_chat_msg());
            System.out.println(JSONUtil.toJsonPrettyStr(decryptData));
            // 3.转换成通用bean,可存储到数据库(可选)
            JSONObject decryptDataJson = JSONUtil.parseObj(decryptData);
            String msgtype = decryptDataJson.getStr("msgtype");
            CommonContent commonContent = JSONUtil.toBean(decryptDataJson, CommonContent.class);
            commonContent.setContent(JSONUtil.toJsonStr(decryptDataJson.get(msgtype)));
            commonContent.setTolistStr(JSONUtil.toJsonStr(decryptDataJson.get("tolist")));
            commonContentList.add(commonContent);
            // 4.下载媒体文件(可选)
            // 图片
            if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.IMAGE)){
                ImageContent content = JSONUtil.toBean(decryptData, ImageContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getImage().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid() + ".png", null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.VOICE)){
                VoiceContent content = JSONUtil.toBean(decryptData, VoiceContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getVoice().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid()+".mp3", null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.VIDEO)){
                VideoContent content = JSONUtil.toBean(decryptData, VideoContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getVideo().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid()+".mp3", null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.EMOTION)){
                EmotionContent content = JSONUtil.toBean(decryptData, EmotionContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getEmotion().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid() + "."+EmotionTypeEnum
                            .fromValue(content.getEmotion().getType()).name(), null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.FILE)){
                FileContent content = JSONUtil.toBean(decryptData, FileContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getFile().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid() + content.getFile().getFilename()+"."+content.getFile().getFileext(), null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.MEETING_VOICE_CALL)){
                MeetingVoiceCallContent content = JSONUtil.toBean(decryptData, MeetingVoiceCallContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getMeeting_voice_call().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid() + ".mp3", null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.VOIP_DOC_SHARE)){
                VoipDocShareContent content = JSONUtil.toBean(decryptData, VoipDocShareContent.class);
                if(!FileUtil.exist(FileUtil.getTmpDirPath()+content.getMsgid())) {
                    FinanceUtil.getMediaData(content.getVoip_doc_share().getSdkfileid(), FileUtil.getTmpDirPath() + content.getMsgid() + content.getVoip_doc_share().getFilename(), null, null, 5);
                }
            }else if(MsgTypeEnum.fromValue(msgtype).equals(MsgTypeEnum.MIXED)){
                MixedContent content = JSONUtil.toBean(decryptData, MixedContent.class);
                // TODO 混合消息类型,可能包含多种消息
            }
        }
        System.out.println(commonContentList.size());
    }
}
