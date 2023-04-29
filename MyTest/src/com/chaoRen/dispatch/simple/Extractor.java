package com.chaoRen.dispatch.simple;

/**
 * 为了以后更好的扩展，如针对媒体文件可能还会有其他操作，而不仅仅是提取图像内容
 * 因此，我们把提取图像内容单独分离出来，弄成一个提取器
 */
public class Extractor {

    public void extract(Picture picture) {
        Image image = new Image();
        System.out.println("提取静态图片[" + picture.filePath + "]中的图像信息");
        // 省略:image对象数据填充操作，图像鉴别操作
    }

    public void extract(Gif gif) {
        Image image = new Image();
        System.out.println("提取动态图片[" + gif.filePath + "]中的图像信息");
        // 省略:image对象数据填充操作，图像鉴别操作
    }

    public void extract(Video video) {
        Image image = new Image();
        System.out.println("提取视频[" + video.filePath + "]中的图像信息");
        // 省略:image对象数据填充操作，图像鉴别操作
    }
}

