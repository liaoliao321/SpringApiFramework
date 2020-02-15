package com.example.wallpaper.web;

import com.example.wallpaper.entity.Wallpaper;
import com.example.wallpaper.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superAdmin")
public class AdminController {

    private final String BASEURL = "http://liaoyingjian.top:8088/imgs/";
    @Autowired
    WallpaperService wallpaperService;
    private int result;

    @RequestMapping(value = "/initWallpapers",method = RequestMethod.GET)
    private Map<String,Object> initWallpapers(){
        wallpaperService.clearWallpaper();
        Map<String,Object> showInfo = new HashMap();

        String filepath = "C:/phpStudy/PHPTutorial/WWW/imgs";
         File file = new File(filepath);//File类型可以是文件也可以是文件夹
         File[] fileList = file.listFiles();//将该目录下的所有文件放置在一个File类型的数组中

        for (int i = 0; i < fileList.length; i++) {
            result = wallpaperService.insertWallpaper(new Wallpaper(BASEURL+fileList[i].getName(),0));
        }
        showInfo.put("result",result);
        return showInfo;
    }

}
