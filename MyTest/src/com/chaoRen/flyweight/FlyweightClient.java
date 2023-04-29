package com.chaoRen.flyweight;

public class FlyweightClient {

    public void playChess() {
        //下黑子
        Chess backChess1 = ChessFactory.getChess("黑色");
        backChess1.draw(2, 5);

        //下白子
        Chess whiteChess = ChessFactory.getChess("白色");
        whiteChess.draw(3, 5);

        //下黑子
        Chess backChess2 = ChessFactory.getChess("黑色");
        backChess2.draw(2, 6);

        System.out.printf("backChess1:%d | backChess2:%d | whiteChess:%d%n",
                backChess1.hashCode(), backChess2.hashCode(), whiteChess.hashCode());
    }
}
