package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.mapper.UploadImageMapper;
import com.sdrc.onlinedrawing.pojo.CustomerImage;
import com.sdrc.onlinedrawing.service.UploadImageService;
import com.sdrc.onlinedrawing.util.FileUtils;
import com.sdrc.onlinedrawing.util.ImageUtils;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UploadImageServiceImpl implements UploadImageService{

    @Value("${imageUrl}")
    private String imageUrl;

    @Value("${imageLocalPath}")
    private String imageLocalPath;

    @Resource
    private UploadImageMapper uploadImageMapper;

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

        String suffix = null;
        String prefix = null;


        List<CustomerImage> arrayList = new ArrayList();
        int count = 0;
        if (aBoolean){
            for (MultipartFile file : files) {
                CustomerImage customerImage = new CustomerImage();
                String originalFilename = file.getOriginalFilename();
                suffix = FileUtils.getFIleSuffix(originalFilename);
                prefix = UUID.randomUUID().toString().replace("-","");
                File locaFile = new File(imageLocalPath+"//"+prefix+"."+suffix);
                if (!locaFile.getParentFile().exists()){
                    locaFile.getParentFile().mkdirs();
                }
                if (!StringUtils.isEmpty(locaFile)){
                    try {
                        file.transferTo(locaFile);
                        customerImage.setImagePath(imageUrl+prefix+"."+suffix);
                        arrayList.add(customerImage);

                    } catch (IOException e) {
                        infoUtils.setMessage("图片保存失败");
                        infoUtils.setaBoolean(false);
                        aBoolean = false;
                        e.printStackTrace();
                    }
                }
            }
        }
        int returnCount = 0;
        if (arrayList.size() != 0){
            infoUtils.setObject(arrayList);
            try {
                returnCount = this.uploadImageMapper.insertUploadCustomer(arrayList);
                infoUtils.setaBoolean(true);
                infoUtils.setMessage("上传成功");
            } catch (RuntimeException e) {
                infoUtils.setMessage("上传失败");
                infoUtils.setaBoolean(false);
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return infoUtils;
    }
}