package com.jing.entry;

import java.util.List;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/8.
 */

public class JokeImgs {


    /**
     * result : [{"content":"生活教你认清自己","hashId":"3C912CA1B471EA55C5A655C1B0BC6EC9","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=26c6272dc36b46dc96c3028ff0bfd8eb.jpg"},{"content":"说得太好了...洗头更衣见朋友，那还叫什么休息！！","hashId":"1610E54791285582D20BB9F391E6D173","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=1bbf6b9d335c4b8987621d34ad6a2f7a.jpg"},{"content":"看到一位南通博主的微博，有人开始砸车了\u2026","hashId":"1419516A72D1216476D835324640A514","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=0426e67a0c234337a06a1febd9ee9988.jpg"},{"content":"如何看待母子之间的sex love！这题超纲了","hashId":"E593419264F96854BB17F2B2FF4E7314","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=7ac3f4b1fa634b5987d8fd97b8fe3aa9.jpg"},{"content":"你应该问干爹买","hashId":"A31ECC960442C9602C947C81A483EF8A","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=e02200e72fe44375811af43e7bccb6b0.jpg"},{"content":"这是囊肿吧！","hashId":"3AFEEF423472E6F12C019811F9C609A5","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=a0652c4130724b82b6c105a5d3c155dc.gif"},{"content":"难道不应该是捡肥皂引起的吗？","hashId":"F64E7F9E8C025DE9474BF7A23C5028FD","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=d8ccef438a35409fbbfdbe150360be1d.gif"},{"content":"职业操守","hashId":"39DFEC8382D592D3F1F55FC9BE38D0FD","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=2df3a3e2131e47fdb7e7399b077c2496.jpg"},{"content":"受到了无形的伤害","hashId":"15742AB4F6A066B1B153B40DAD707600","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=b24fc56f646e4053982c30ab13fb1efb.jpg"},{"content":"感受一下什么才叫直播神器！","hashId":"B0DEE6FCE4408185D7834444D45AC3F4","unixtime":"1494385423","updatetime":"2017-05-10 11:03:43","url":"http://api.avatardata.cn/Joke/Img?file=8187469bece74202abab557d98ea844c.jpg"}]
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;
    private List<Image> result;

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

    public List<Image> getResult() {
        return result;
    }

    public void setResult(List<Image> result) {
        this.result = result;
    }

    public static class Image {
        /**
         * content : 生活教你认清自己
         * hashId : 3C912CA1B471EA55C5A655C1B0BC6EC9
         * unixtime : 1494385423
         * updatetime : 2017-05-10 11:03:43
         * url : http://api.avatardata.cn/Joke/Img?file=26c6272dc36b46dc96c3028ff0bfd8eb.jpg
         */

        private String content;
        private String hashId;
        private String unixtime;
        private String updatetime;
        private String url;

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

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
