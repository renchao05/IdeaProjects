package com.chaoRen.dispatch.simple;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<MediaFile> mediaFiles = Arrays.asList(
                new Picture("a.jpg"),
                new Picture("b.png"),
                new Gif("c.gif"),
                new Video("d.mp4"),
                new Video("e.avi")
        );

        for (MediaFile media : mediaFiles) {
            media.accept(extractor);
        }
    }
}

