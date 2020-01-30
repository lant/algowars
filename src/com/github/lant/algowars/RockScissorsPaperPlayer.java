package com.github.lant.algowars;

import java.util.Random;

public class RockScissorsPaperPlayer extends Player {
    Random rd = new Random();

    public option turn() {
        switch (rd.nextInt(3)) {
            case 0: return option.PAPER;
            case 1: return option.ROCK;
            case 2: return option.SCISSORS;
            default: throw new IllegalStateException();
        }
    }

    public void setTurnFeedback(RockScissorsPaperGame.Feedback feedback) {
       // understand what happened and change the inner state of this.
       // in this case, basically do nothing

        // but here you could spin up an aws cluster to do review the history of the turns, connect to a db, ....
    }
}
