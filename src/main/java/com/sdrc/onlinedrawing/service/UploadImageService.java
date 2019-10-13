package com.sdrc.onlinedrawing.service;

import com.sdrc.onlinedrawing.util.InfoUtils;
import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
    InfoUtils uploadCustomerImage(MultipartFile[] files);
}
