package com.chaoRen.dispatch.simple;

/**
 * 媒体文件基类
 */
public abstract class MediaFile {
    protected String filePath;
    public MediaFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void accept(Extractor extractor);
}

/**
 * 该类代表静态图片，如jpg、png
 */
class Picture extends MediaFile {
    public Picture(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract(this);
    }
}

/**
 * 此类表示动态图，如gif
 */
class Gif extends MediaFile {
    public Gif(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract(this);
    }
}

/**
 * 此类代表视频媒体文件，如MP4、AVI等
 */
class Video extends MediaFile {
    public Video(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract(this);
    }
}
