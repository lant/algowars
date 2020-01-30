package com.github.lant.algowars;

public class Scoreboard {
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    public void scorePlayer1() {
        this.scorePlayer1++;
    }

    public void scorePlayer2() {
        this.scorePlayer2++;
    }

    @Override
    public String toString() {
        return "Score: " + scorePlayer1 + " - " + scorePlayer2;
    }
}
