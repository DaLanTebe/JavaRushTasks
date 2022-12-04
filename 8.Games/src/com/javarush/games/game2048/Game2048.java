package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.*;

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
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {

        boolean isCreated = false;
        do {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[y][x] == 0) {
                gameField[y][x] = getRandomNumber(10) < 9 ? 2 : 4;
                isCreated = true;
            }
        }
        while (!isCreated);
    }

    private void drawScene() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    private boolean compressRow(int[] row){
        boolean flag = false;
        int position = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0){
                if (i != position){
                    row[position] = row[i];
                    row[i] = 0;
                    flag = true;
                }
                position++;
            }
        }
        return flag;
    }

    private  boolean mergeRow(int[] row){
        boolean flag = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]){
                row[i] += row[i + 1];
                row[i + 1] = 0;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void onKeyPress(Key key) {
        if(key == Key.UP){
            moveUp();
            drawScene();
        } else if (key == Key.DOWN) {
            moveDown();
            drawScene();
        }else if (key == Key.LEFT) {
            moveLeft();
            drawScene();
        }else if (key == Key.RIGHT) {
            moveRight();
            drawScene();
        }
    }

    private void moveUp(){}
    private void moveRight(){}
    private void moveDown(){}
    private void moveLeft(){
        boolean isNewNumberNeeded = false;
        for (int[] row : gameField) {
            boolean wasCompressed = compressRow(row);
            boolean wasMerged = mergeRow(row);
            if (wasMerged) {
                compressRow(row);
            }
            if (wasCompressed || wasMerged) {
                isNewNumberNeeded = true;
            }
        }
        if (isNewNumberNeeded) {
            createNewNumber();
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, getColorByValue(value), str);
    }

    private Color getColorByValue(int value) {
        Color color = Color.NONE;
        switch (value) {
            case 0: {
                color = Color.WHITE;
                break;
            }
            case 2: {
                color = Color.BEIGE;
                break;
            }
            case 4: {
                color = Color.YELLOW;
                break;
            }
            case 8: {
                color = Color.RED;
                break;
            }
            case 16: {
                color = Color.ORANGE;
                break;
            }
            case 32: {
                color = Color.BLACK;
                break;
            }
            case 64: {
                color = Color.BLUE;
                break;
            }
            case 128: {
                color = Color.VIOLET;
                break;
            }
            case 256: {
                color = Color.TAN;
                break;
            }
            case 512: {
                color = Color.ROSYBROWN;
                break;
            }
            case 1024: {
                color = Color.WHEAT;
                break;
            }
            case 2048: {
                color = Color.ANTIQUEWHITE;
                break;
            }
        }
        return color;
    }

}
