package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (getRandomNumber(10) == 0){
                    gameField[y][x] = new GameObject(x, y, true);
                    countMinesOnField++;
                }else gameField[y][x] = new GameObject(x, y, false);
                setCellColor(x, y, Color.ALICEBLUE);
            }
        }
    }
}
