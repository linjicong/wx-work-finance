package com.linjicong.wx.work.finance.domain.content;

import lombok.Data;

/**
 * 撤回消息
 * @author linjicong
 * @date 2022-03-23 20:30
 */
@Data
public class CollectContent extends BaseContent{

    private Collect collect;

    @Data
    public static class Collect {
        // 填表消息所在的群名称
        private String room_name;
        // 创建者在群中的名字
        private String creator;
        // 创建的时间
        private String create_time;
        // 表名
        private String title;
        // 表内容
        private Details details;

        private static class Details {
            // 表项id
            private Integer id;
            // 表项名称
            private String ques;
            // 表项类型，有Text(文本),Number(数字),Date(日期),Time(时间)
            private String type;
        }
    }
}
