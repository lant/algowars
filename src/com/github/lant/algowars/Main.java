package com.github.lant.algowars;

public class Main {

    public static void main(String[] args) {
        Game game = new RockScissorsPaperGame();
        game.addPlayer(new RockScissorsPaperPlayer());
        game.addPlayer(new RockScissorsPaperPlayer());
        game.play();
    }
}
