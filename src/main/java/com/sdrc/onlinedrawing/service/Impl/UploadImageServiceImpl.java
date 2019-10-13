package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.service.UploadImageService;
import com.sdrc.onlinedrawing.util.FileUtils;
import com.sdrc.onlinedrawing.util.ImageUtils;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadImageServiceImpl implements UploadImageService{

    @Value("${imageUrl}")
    private String imageUrl;

    @Value("${imageLocalPath}")
    private String imageLocalPath;

    /**
     * 对上传图片进行保存
     * @param files
     * @return
     */
    public InfoUtils uploadCustomerImage(MultipartFile[] files) {
        Boolean aBoolean = true;
        InfoUtils infoUtils = new InfoUtils();
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
             aBoolean = ImageUtils.checkImageFormat(originalFilename);
             if (!aBoolean){
                infoUtils.setaBoolean(false);
                infoUtils.setMessage("图片格式不正确");
                return infoUtils;
             }
        }
        String imageSuffix = null;
        String imagePrefix = null;
        if (aBoolean){
            for (MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                imageSuffix = FileUtils.getFIleSuffix(originalFilename);
                imagePrefix = UUID.randomUUID().toString().replace("-","");
                File locaFile = new File(imageLocalPath+"//"+imagePrefix+"."+imageSuffix);
                if (!locaFile.getParentFile().exists()){
                   locaFile.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(locaFile);
                } catch (IOException e) {
                    infoUtils.setMessage("图片保存失败");
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
