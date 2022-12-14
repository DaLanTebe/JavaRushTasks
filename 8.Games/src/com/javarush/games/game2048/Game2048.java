package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.*;

public class Game2048 extends Game {

    private static final int SIDE = 6;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void win() {
        showMessageDialog(Color.ANTIQUEWHITE, "А ты не плох, чувачок", Color.GREEN, 50);
        isGameStopped = true;
    }

    private void gameOver() {
        showMessageDialog(Color.ANTIQUEWHITE, "Повезет в следующей жизни", Color.RED, 50);
        isGameStopped = true;
    }

    private boolean canUserMove() {

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                } else if (i < SIDE - 1 && gameField[i][j] == gameField[i + 1][j]) {
                    return true;
                } else if (j < SIDE - 1 && gameField[i][j] == gameField[i][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void createNewNumber() {

        if (getMaxTileValue() == 2048) {
            win();
        }

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
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    private boolean compressRow(int[] row) {
        boolean flag = false;
        int position = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0) {
                if (i != position) {
                    row[position] = row[i];
                    row[i] = 0;
                    flag = true;
                }
                position++;
            }
        }
        return flag;
    }

    private boolean mergeRow(int[] row) {
        boolean flag = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                flag = true;
                score += row[i];
                setScore(score);
            }
        }
        return flag;
    }

    @Override
    public void onKeyPress(Key key) {

        if (isGameStopped){
            if (key == Key.SPACE){
                isGameStopped = false;
                score = 0;
                setScore(score);
                createGame();
                drawScene();
            } else return;
        }

        if (!canUserMove()) {
            gameOver();
            return;
        }

        if (key == Key.UP) {
            moveUp();
            drawScene();
        } else if (key == Key.DOWN) {
            moveDown();
            drawScene();
        } else if (key == Key.LEFT) {
            moveLeft();
            drawScene();
        } else if (key == Key.RIGHT) {
            moveRight();
            drawScene();
        }
    }


    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveLeft() {
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

    private void rotateClockwise() {
        int[][] temp = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                temp[j][SIDE - 1 - i] = gameField[i][j];
            }
        }
        gameField = temp;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, getColorByValue(value), str);
    }

    private int getMaxTileValue() {
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (max < gameField[i][j]) {
                    max = gameField[i][j];
                }
            }
        }
        return max;
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
                color = Color.DEEPPINK;
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
