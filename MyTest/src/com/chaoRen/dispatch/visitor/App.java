package com.chaoRen.dispatch.visitor;


import java.util.Arrays;
import java.util.List;

public class App {
    static List<MediaFile> mediaFiles = Arrays.asList(
            new Picture("a.jpg"),
            new Picture("b.png"),
            new Gif("c.gif"),
            new Video("d.mp4"),
            new Video("e.avi")
    );

    public static void main(String[] args) {


        Visitor extractor = new Extractor();
        for (MediaFile media : mediaFiles) {
            media.accept(extractor);
        }

        Watermark watermark = new Watermark();
        for (MediaFile media : mediaFiles) {
            media.accept(watermark);
        }
    }
}

