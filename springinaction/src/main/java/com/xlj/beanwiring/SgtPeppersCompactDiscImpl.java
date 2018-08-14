package com.xlj.beanwiring;


import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.List;

@Named("lonelyHeartsClub")
public class SgtPeppersCompactDiscImpl implements CompactDisc {

    String title = "sgt. pepper's lonely hearts club band.";
    String artist = "the beatles.";
    java.util.List<String> list = null;

    @Override
    public String toString() {
        return "SgtPeppersCompactDiscImpl{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", list=" + list +
                '}';
    }

    public SgtPeppersCompactDiscImpl() {

    }

    public SgtPeppersCompactDiscImpl(String title, String artist, List<String> list) {
        this.title = title;
        this.artist = artist;
        this.list = list;
    }

    @Override
    public void play() {

        System.out.println("playing " + this.title + " by " + this.artist);

    }
}
