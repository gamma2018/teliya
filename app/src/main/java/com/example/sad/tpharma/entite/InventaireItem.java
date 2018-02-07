package com.example.sad.tpharma.entite;

public class InventaireItem {

    String title;
    String subTitle;

    public InventaireItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public InventaireItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
