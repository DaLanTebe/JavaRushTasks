package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import static com.javarush.engine.cell.Key.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        isGameStopped = false;
        score = 0;
        setScore(score);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        drawScene();

    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i, j, Color.ANTIQUEWHITE, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            score += 5;
            setScore(score);
            turnDelay = turnDelay - 10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (!snake.isAlive){
            gameOver();
        }
        if (snake.getLength() > GOAL){
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {

        if (key == Key.SPACE && isGameStopped) {
            createGame();
        }

        if (key == Key.SPACE && isGameStopped) {
            createGame();
        }
        Direction direction = null;
        switch (key) {
            case DOWN : {
                direction = Direction.DOWN;
                    break;
            }
            case UP : {
                direction = Direction.UP;
                break;
            }
            case RIGHT : {
                direction = Direction.RIGHT;
                break;
            }
            case LEFT : {
                direction = Direction.LEFT;
                break;
            }
        }
        snake.setDirection(direction);
    }

    private void createNewApple() {
        Apple newApple;
        do {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            newApple = new Apple(x, y);
        } while (snake.checkCollision(newApple));
        apple = newApple;
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.RED, "GAME OVER", Color.BLUE, 70);
    }
   private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "YOU WIN", Color.BLUE, 70);
   }
}
