package com.youle.chat;

/**
 * Created by modprobe on 2015/11/13.
 */
public class Message {
    private String fromUser;//发送者

    private String toUser;//接受者

    private long unix_time; //发送时间

    private String content; //消息内容

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public long getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(long unix_time) {
        this.unix_time = unix_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", unix_time=" + unix_time +
                ", content='" + content + '\'' +
                '}';
    }
}
