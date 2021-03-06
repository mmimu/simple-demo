package com.mimu.simple.spring.dubbo.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * author: mimu
 * date: 2019/8/18
 */
public class UserData implements Serializable {
    private static final long serialVersionUID = 669849930649228488L;
    private long pid;
    private String nickName;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getNickName() {
        return StringUtils.isEmpty(nickName) ? "" : nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
