package com.example.wallpaper.service;

import com.example.wallpaper.entity.Wallpaper;

import java.util.List;

public interface WallpaperService {
    List<Wallpaper> queryWallpaper();
    int insertWallpaper(Wallpaper wallpaper);
    void clearWallpaper();
    void getUserImg(String base64);
}
