package com.example.wallpaper.service.mpl;

import com.example.wallpaper.dao.WallpaperDao;
import com.example.wallpaper.entity.Wallpaper;
import com.example.wallpaper.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class WallpaperMpl implements WallpaperService {

    @Autowired
    private WallpaperDao wallpaperDao;

    @Override
    public List<Wallpaper> queryWallpaper() {
        return wallpaperDao.queryWallpaper();
    }

    @Override
    public int insertWallpaper(Wallpaper wallpaper) { return wallpaperDao.insertWallpaper(wallpaper); }

    @Override
    public void clearWallpaper() {  wallpaperDao.clearWallpaper(); }

    @Override
    public void getUserImg(String base64) {

    }
}
