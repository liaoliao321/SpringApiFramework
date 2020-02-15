package com.example.wallpaper.entity;

public class Wallpaper {
    private int id;
    private String fileName;
    private int star;

    public Wallpaper(int id, String fileName, int star) {
        this.id = id;
        this.fileName = fileName;
        this.star = star;
    }
    public Wallpaper(String fileName, int star) {

        this.fileName = fileName;
        this.star = star;
    }

//    public Wallpaper(String fileName, int star) {
//        this.fileName = fileName;
//        this.star = star;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
