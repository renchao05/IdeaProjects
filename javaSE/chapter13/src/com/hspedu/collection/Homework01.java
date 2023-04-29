package com.hspedu.collection;

import java.util.ArrayList;

public class Homework01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河”圣浴“引民众担忧。");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生。");
        News news3 = new News("8位省级党委原书记履新职");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        arrayList.add(news3);
        int size = arrayList.size();
        for (int i = size - 1; i >= 0 ; i--) {
            String newsTitle = ((News)arrayList.get(i)).getTitle();
            if (newsTitle.length() > 15)
                System.out.println(newsTitle.substring(0,15) + "...");
            else
                System.out.println(arrayList.get(i));
        }
    }
}


class News {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}