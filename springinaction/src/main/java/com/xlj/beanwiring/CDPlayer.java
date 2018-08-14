package com.xlj.beanwiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

//    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    //自动组装并且 required 设置忽略找不到异常
    @Autowired(required = false)
    CompactDisc cd = null;

    public CompactDisc getCd() {
        return cd;
    }

//    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
