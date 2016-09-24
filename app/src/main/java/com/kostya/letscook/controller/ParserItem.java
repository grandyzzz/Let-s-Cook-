package com.kostya.letscook.controller;

/**
 * Created by Костя on 27.05.2016.
 */
public class ParserItem {
    String img;
    String name;
    String ing;
    public ParserItem(){}

    public ParserItem(String img, String name, String ing) {
        this.img = img;
        this.name = name;
        this.ing = ing;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }
}
