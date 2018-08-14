package com.xlj.beanwiringhightLeve.spelandproperties.component;

import org.springframework.beans.factory.BeanNameAware;

public class BlankDisc implements IBlankDisc, BeanNameAware {

    @Override
    public String toString() {
        return "BlankDisc{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    public BlankDisc(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    private String artist;
    private String title;
    private String beanName;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void test() {
        System.out.println("BlankDisc");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
