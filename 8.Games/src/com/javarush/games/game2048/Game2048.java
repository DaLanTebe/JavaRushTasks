package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
    }

    private void drawScene() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                setCellColor(i, j, Color.RED);
            }
        }
    }

}
