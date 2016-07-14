package com.shangliu.china.android.ui.activity;

/**
 * Created by Administrator on 2016/4/11.
 */
public enum MainTab {
    // 枚举类构造函数后面有；
    // TODO  这里填充你想要的大Fragment
    ;

    private int idx;
    private int resName;     // 资源名
    private int resIcon;     // 资源icon
    private Class<?> clz;   // 指定的字节码（可以是Activity,也可以是Frament）

    MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public Class<?> getClz() {
        return clz;
    }

    public int getResIcon() {
        return resIcon;
    }

    public int getResName() {
        return resName;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

}
