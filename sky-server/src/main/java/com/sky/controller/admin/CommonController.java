package com.sky.controller.admin;

import com.sky.annotation.AutoFill;
import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}", file);
        
        // 获得原始文件名
        String originalFilename = file.getOriginalFilename();
        // 获得文件后缀
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 构造新的文件名
        String newFileName = UUID.randomUUID().toString() + fileSuffix;

        try {
            // 上传文件到阿里云
            String fileUrl = aliOssUtil.upload(file.getBytes(), newFileName);
            return Result.success(fileUrl);
        } catch (IOException e) {
            log.info("异常：{}", e);
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
