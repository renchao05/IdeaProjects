package com.hspedu.enum_;

public class Homework08 {
    public static void main(String[] args) {
        Color color = Color.BLUE;
        switch (color) {
            case RED:
                System.out.println("匹配到红色。");
                color.show();
                break;
            case BLUE:
                System.out.println("匹配到蓝色。");
                color.show();
                break;
            case BLACK:
                System.out.println("匹配到黑色。");
                color.show();
                break;
            case GREEN:
                System.out.println("匹配到绿色。");
                color.show();
                break;
            case YELLOW:
                System.out.println("匹配到黄色。");
                color.show();
                break;
            default:
                System.out.println("没有匹配到。。。");

        }
    }
}

enum  Color implements ColorInterface {
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

//    @Override
//    public String toString() {
//        return "RGB颜色值为：" + redValue + "," + greenValue + "," + blueValue;
//    }

    @Override
    public void show() {
        System.out.println("RGB颜色值为：" + redValue + "," + greenValue + "," + blueValue);
    }
}

interface ColorInterface {
    public void show();
}