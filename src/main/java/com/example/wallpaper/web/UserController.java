package com.example.wallpaper.web;

import com.example.wallpaper.entity.Wallpaper;
import com.example.wallpaper.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final String BASEURL = "http://liaoyingjian.top:8088/imgs/";
    int resultCode;
    String message;
    @Autowired
    WallpaperService wallpaperService;

    @RequestMapping(value = "/listWallpaper",method = RequestMethod.GET)
    private Map<String,Object> listWallpaper(){

        Map<String,Object> showInfo = new HashMap();
        List<Wallpaper> wallpaperList = wallpaperService.queryWallpaper();
        if (wallpaperList.size()>0) {
            showInfo.put("wallpapers",wallpaperList);
            resultCode = 200;
            message = "success";
        }else{
            showInfo.put("wallpapers","no data");
            resultCode = 400;
            message = "failed";
        }
        showInfo.put("resultCode",this.resultCode);
        showInfo.put("message",this.message);

        return showInfo;
    }


    @RequestMapping(value = "/uploadUserImg")
    private Map<String,Object> uploadUserImg(@RequestParam("file") MultipartFile uploadImage){
        try {
            File file = new File("/Volumes/macFile/test.jpg");
            InputStream inputStream = uploadImage.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            int len = 0;
            byte b[] = new byte[1024];
            while ((len = inputStream.read(b))!=-1) {
                fileOutputStream.write(b,0,len);
                System.out.println(len);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(uploadImage.getSize());
        Map<String,Object> showInfo = new HashMap();
        resultCode = 200;

        showInfo.put("resultCode",this.resultCode);
        showInfo.put("message",this.message);
        showInfo.put("image",uploadImage);
        try {
//            System.out.println(base64);
//            Base64ToImage(base64,"/Volumes/macFile/test.jpeg");
        } catch (Exception e) {
            e.printStackTrace();
            showInfo.put("exception",e);
        }
        return showInfo;
    }


        public static boolean Base64ToImage(String imgStr,String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片

//            if (StringUtil.isEmpty(imgStr)) // 图像数据为空
//                return false;
//                String str =   ImageToBase64ByLocal("/Users/me/Documents/1.jpg");
            System.out.println(imgStr);
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                // Base64解码
                byte[] b = decoder.decodeBuffer(imgStr);
                for (int i = 0; i < b.length; ++i) {
                    if (b[i] < 0) {// 调整异常数据
                        b[i] += 256;
                    }
                }

                OutputStream out = new FileOutputStream(imgFilePath);
                out.write(b);
                out.flush();
                out.close();

                return true;
            } catch (Exception e) {
                return false;
            }
        }


    public static String ImageToBase64ByLocal(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理

        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

}
