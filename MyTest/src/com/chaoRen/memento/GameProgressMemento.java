package com.chaoRen.memento;

public class GameProgressMemento {
    private final int score;

    public GameProgressMemento(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}