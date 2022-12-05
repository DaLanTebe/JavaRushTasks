package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import static com.javarush.engine.cell.Key.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        drawScene();

    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i, j, Color.ANTIQUEWHITE,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive){
            createNewApple();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        Direction direction = null;
        switch (key){
            case DOWN : { direction = Direction.DOWN;
                break;
            }
            case UP : { direction = Direction.UP;
                break;
            }
            case RIGHT : { direction = Direction.RIGHT;
                break;
            }
            case LEFT : { direction = Direction.LEFT;
                break;
            }
        }
        snake.setDirection(direction);
    }
    private void createNewApple(){
        apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
    }
}
