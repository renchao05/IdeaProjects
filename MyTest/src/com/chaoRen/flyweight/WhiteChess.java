package com.chaoRen.flyweight;

//白棋
public class WhiteChess implements Chess {
    //内部状态，共享
    private final String color = "白色";

    public String getColor() {
        return color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.printf("%s棋子置于（%d，%d）处%n", color, x, y);
    }
}
