package com.example.wallpaper.dao;


import com.example.wallpaper.entity.Wallpaper;

import java.util.List;

public interface WallpaperDao {
        List<Wallpaper> queryWallpaper();
        int insertWallpaper(Wallpaper wallpaper);
        void clearWallpaper();
        void getUserImg(String base64);
}
