package com.bwie.test.bean;/**
 * Created by Administrator on 2016/11/24.
 */

import com.google.gson.Gson;

import java.util.List;

/**
 * 1.
 * 2.作者：佀晋元 2016/11/23
 */
public class Books {


    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"据说哪吒最开始是天池边的一颗石子，后由于女娲洗澡也不知为什么流血了，血粘到石头上后石头化为人形。　　这么说女娲洗澡的时候大姨妈来了，然后血沾到石头上\u2026\u2026　　哪吒就出生了\u2026\u2026","hashId":"d7888533d503efd20002f4793cc99da0","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"一天，电视与遥控板聊天　　电视：哎，人类每天都盯着别人看，都不好意思了！　　遥控板：是啊，人类老是每天按我，讨厌得很。　　电视：我们都没有饮水机惨。　　遥控板：？　　电视：因为饮水机每天脑子都要进好多水！　　遥控板：\u2026\u2026","hashId":"977b7b1c110c672dc7bcdca8a42774f4","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"早上白玉堂眼泪汪汪，哭道：\u201c包大人，求您饶我大哥钻天鼠卢方一命。\u201d　　包大人奇怪的问：\u201c我没说要杀卢方啊。\u201d　　白玉堂：\u201c大人您别瞒我了，昨天晚上我听见您在院子里高唱：我想要卢方的生命，就象矗立在彩虹之颠。\u201d","hashId":"c0bf0aa5ace33866647b27930be89f5a","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"一对夫妻新婚后，老公满脸困惑地对老婆说：\u201c以后你爸要是与我爸在一起时，你怎么称呼他们呢？要是叫\u2018爸\u2019两个都回答怎么办？\u201d　　老婆回道：\u201c这简单呀，在你父亲前加一个姓不就得了，就叫\u2018王爸\u2019\u201d。　　老公：\u201c哇靠！王八？\u201d","hashId":"d9e565a249460bf964e729b5cb2f8f33","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"文学课上，讲到四大名著，老师发问：潘金莲西门庆等人是四大名著中哪本名著？　　一哥们起身高声答到：金瓶梅\u2026","hashId":"6a800c66d0e97f9b15fe1748432c811c","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"寝室有一同学去厕所，玩手机不小心把手机掉下去了。　　然后，就回去拿了双筷子准备夹出来，正当他要下筷子捞时，一哥们进了厕所看到此景，那人关心地问道：\u201c哥们，还没吃啊\u2026\u2026\u201d","hashId":"a351c07d1b250e573daca623fcc9bb3b","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"孙子天天玩电脑。　　奶奶说：这样不行会影响学习的！　　孙子说：那我不玩电脑了，我去上网！　　奶奶说：那更不行，掉下来咋办！","hashId":"603202fb717326c944850a42164f7ee6","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"机床班接到了加工一批机器零件的紧急任务，可是，加工了一半突然停电了，工人急忙向主任汇报问怎么办？　　为保任务，主任果断命令：那也不能停，点蜡烛继续干！","hashId":"e6991651b380b4eb069be3acf8fd7d5a","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"红豆对汤说：\u201c我这辈子受尽了相思之苦，没想到最终我竟和你走在了一起，曾经有一份\u2026\u2026\u201d　　筷子对碗说：\u201c这辈子能陪我一直走下去的也就只有你了，我的世界不能没有你，如果还有来世\u2026\u2026\u201d　　这时炒锅也开始发言了：\u201c别说了，洋葱都在一边哭了。\u201d小孩生气了，这顿饭还让不让人吃啊？","hashId":"fa8412627cc24a07d40bb4302fec512b","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"},{"content":"一名叫苏丹的青年在花鸟市场卖鸟，一辆车子飞驰而过，把自己鸟笼里的的一只乌鸦和一只白鹭碾死了，自己面部也受了点伤。　　他看了一下乌鸦，被碾得像一片纸一样贴在地上，他惊叫：\u201c哇，鸦片。\u201d　　再看一下白鹭，被碾得更惨，他失落的叫了声\u201c白粉\u201d，这时他透过旁边一镜子看到了自己血迹斑斑的脸~啊，苏丹红。","hashId":"72517408fb26e7c35dd61a487e618866","unixtime":1479957230,"updatetime":"2016-11-24 11:13:50"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public static Books objectFromData(String str) {

        return new Gson().fromJson(str, Books.class);
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 据说哪吒最开始是天池边的一颗石子，后由于女娲洗澡也不知为什么流血了，血粘到石头上后石头化为人形。　　这么说女娲洗澡的时候大姨妈来了，然后血沾到石头上……　　哪吒就出生了……
         * hashId : d7888533d503efd20002f4793cc99da0
         * unixtime : 1479957230
         * updatetime : 2016-11-24 11:13:50
         */

        private List<DataBean> data;

        public static ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultBean.class);
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public static DataBean objectFromData(String str) {

                return new Gson().fromJson(str, DataBean.class);
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
