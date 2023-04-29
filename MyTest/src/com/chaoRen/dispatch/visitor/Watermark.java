package com.chaoRen.dispatch.visitor;

/**
 * 添加水印访问者
 */
public class Watermark implements Visitor{
    @Override
    public void visit(Picture picture) {
        System.out.println("给静态图片[" + picture.filePath + "]添加水印");
    }

    @Override
    public void visit(Gif gif) {
        System.out.println("给动态图片[" + gif.filePath + "]添加水印");
    }

    @Override
    public void visit(Video video) {
        System.out.println("给视频[" + video.filePath + "]添加水印");
    }
}
