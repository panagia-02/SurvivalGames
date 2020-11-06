package me.stabolitis.sg.states;

import me.stabolitis.sg.tasks.GameCountdown;
import me.stabolitis.sg.tasks.GameScoreboard;
import me.stabolitis.sg.tasks.GraceCountdown;

public enum GameState
{
    WAITING, STARTING, GRACE, PLAYING, RESTARTING;

    private static GameState state;

    public static void setState(GameState state) {

        GameState.state = state;

        switch (state) {
            case WAITING:
                GameScoreboard scoreboard = new GameScoreboard();
                scoreboard.updateWaitingBoard();

                break;
            case STARTING:
                GameCountdown taskCountdown = new GameCountdown();
                taskCountdown.startCountdown();
                GameScoreboard scoreboardStarting = new GameScoreboard();
                scoreboardStarting.updateStartingBoard();

                break;
            case GRACE:
                GraceCountdown taskGrace = new GraceCountdown();
                taskGrace.startGrace();
                break;
        }
    }

    public static boolean isState(GameState state) {
        return GameState.state == state;
    }

    public static GameState getState() {
        return state;
    }
}
