package com.chaoRen.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFactory {
    private static final Map<String, Chess> chessMap = new HashMap<>();

    public static Chess getChess(String color) {
        Chess chess = chessMap.get(color);
        if (chess == null) {
            chess = color.equals("白色") ? new WhiteChess() : new BlackChess();
            chessMap.put(color, chess);
        }
        return chess;
    }
}
