package net.huayiyun.manbing.utils;

import java.io.InputStream;

/**
 * @Project : hlwyy_user
 * @Package Name : com.huayi.hlwyy_user.inquiryDiag.pojo.po
 * @Description : TODO FileUtils getContentTypeByUrl 使用
 * @Author : zlj
 * @Creation Date : 2020年03月11日 15:35
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class UrlBean {

    private InputStream inputStream;//输入流
    private String fileName;//文件名
    private String contentType;//文件类型

    public UrlBean(InputStream inputStream, String fileName, String contentType){
        this.inputStream = inputStream;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }
}
