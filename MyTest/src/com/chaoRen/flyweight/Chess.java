package com.chaoRen.flyweight;

/**
 * 我们的棋子对象有一个绘制自己的通用操作
 */
public interface Chess {
    //绘制棋子
    void draw(int x,int y);
}
