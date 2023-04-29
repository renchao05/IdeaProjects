package com.renchao.maven;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class OSSTest {

    @Test
    public void test01() throws FileNotFoundException {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5t9q4xbRvMV3iNv72JkS";
        String accessKeySecret = "tFLMdrkD7iu6zMBMVgBPujh2F441eh";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        ossClient.putObject("gulimall-renchao", "2022-07-14/sss.jpg", new FileInputStream("E:\\sss.jpg"));
        ossClient.shutdown();
        System.out.println("上传成功");
    }
}
