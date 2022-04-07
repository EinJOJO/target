package de.einjojo.target.manager;

public class GameManager {

    private GAME_STATE gameState;

    public GameManager() {
        gameState = GAME_STATE.LOBBY;
    }


    public GAME_STATE getGameState() {
        return gameState;
    }
    public void setGameState(GAME_STATE gameState) {
        this.gameState = gameState;
    }

    public enum GAME_STATE {
        LOBBY,
        RUNNING,
        ENDING,
    }

}

