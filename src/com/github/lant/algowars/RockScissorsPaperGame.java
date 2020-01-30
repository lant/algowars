package com.github.lant.algowars;

import java.util.ArrayList;
import java.util.List;

public class RockScissorsPaperGame extends Game {
    List<Player> players = new ArrayList<>();

    @Override
    public void addPlayer(Player player) {
        if (players.size() < 2) {
            players.add(player);
        } else {
            throw new IllegalStateException("Too many players, this game only accepts 2");
        }
    }

    @Override
    public void play() {
        boolean finished = false;
        RockScissorsPaperPlayer player1 = (RockScissorsPaperPlayer) players.get(0);
        RockScissorsPaperPlayer player2 = (RockScissorsPaperPlayer) players.get(1);
        GameState gameState = new GameState();

        int turn = 1;

        while (!finished) {
            System.out.println("=== TURN " + turn + " ====");
            option player1Option = player1.turn();
            System.out.println("Player 1 goes for: " + player1Option);
            option player2Option = player2.turn();
            System.out.println("Player 2 goes for: " + player2Option);
            gameState.update(player1Option, player2Option);
            player1.setTurnFeedback(gameState.getFeedbackForPlayerOne());
            player2.setTurnFeedback(gameState.getFeedbackForPlayerTwo());
            System.out.println(gameState.scoreboard);
            finished = gameState.finished();
            turn++;
        }
    }

    private class GameState {
        Feedback player1 = new Feedback();
        Feedback player2 = new Feedback();
        Scoreboard scoreboard = new Scoreboard();

        public void update(option player1Option, option player2Option) {
            // put what the other player did
            player1.setOtherPlayerOption(player2Option);
            player2.setOtherPlayerOption(player1Option);

            // decide who won
            if (player1Option == player2Option) {
                player1.setTurnResult(result.DRAW);
                player2.setTurnResult(result.DRAW);
            } else {
                // I'm pretty sure this can be done better
                switch (player1Option) {
                    case ROCK: {
                        if (player2Option == option.SCISSORS) {
                            playerOneWins();
                        } else {
                            playerTwoWins();
                        }
                        break;
                    }
                    case SCISSORS: {
                        if (player2Option == option.PAPER) {
                            playerOneWins();
                        } else {
                            playerTwoWins();
                        }
                        break;
                    }
                    case PAPER: {
                        if (player2Option == option.ROCK) {
                            playerOneWins();
                        } else {
                            playerTwoWins();
                        }
                        break;
                    }
                }
            }
        }

        private void playerOneWins() {
            System.out.println("Player 1 wins round");
            player1.setTurnResult(result.WON);
            player2.setTurnResult(result.LOST);
            scoreboard.scorePlayer1();
        }

        private void playerTwoWins() {
            System.out.println("Player 2 wins round");
            player2.setTurnResult(result.WON);
            player1.setTurnResult(result.LOST);
            scoreboard.scorePlayer2();
        }

        public boolean finished() {
            return (scoreboard.scorePlayer1 == 3 || scoreboard.scorePlayer2 == 3);
        }

        public Feedback getFeedbackForPlayerOne() {
            return player1;
        }

        public Feedback getFeedbackForPlayerTwo() {
            return player2;
        }

    }

    class Feedback {
        private result turnResult;
        private option otherPlayerOption;

        public option getOtherPlayerOption() {
            return otherPlayerOption;
        }

        public result getTurnResult() {
            return turnResult;
        }

        public void setTurnResult(result turnResult) {
            this.turnResult = turnResult;
        }

        public void setOtherPlayerOption(option otherPlayerOption) {
            this.otherPlayerOption = otherPlayerOption;
        }
    }
}

enum option {
    ROCK, SCISSORS, PAPER
}

enum result {
    WON, DRAW, LOST
}
