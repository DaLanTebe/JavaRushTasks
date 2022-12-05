package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.games.snake.Direction.*;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();

    public int getLength() {
        return snakeParts.size();
    }

    public boolean isAlive = true;
    private Direction direction = LEFT;

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }
        if (direction == LEFT && this.direction != RIGHT){
            this.direction = direction;
        }
        if (direction == RIGHT && this.direction != LEFT){
            this.direction = direction;
        }
        if (direction == UP && this.direction != DOWN){
            this.direction = direction;
        }
        if (direction == DOWN && this.direction != UP){
            this.direction = direction;
        }
    }

    public Snake(int x, int y) {
        GameObject obj1 = new GameObject(x, y);
        GameObject obj2 = new GameObject(x + 1, y);
        GameObject obj3 = new GameObject(x + 2, y);
        snakeParts.add(obj1);
        snakeParts.add(obj2);
        snakeParts.add(obj3);
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            String sign = i == 0 ? HEAD_SIGN : BODY_SIGN;
            if (isAlive) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, sign, Color.DARKGREEN, 75);
            } else game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, sign, Color.RED, 75);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (newHead.y >= SnakeGame.WIDTH
                || newHead.x >= SnakeGame.HEIGHT
                || newHead.y < 0
                || newHead.x < 0){
            isAlive = false;
            return;
        }
        if (checkCollision(newHead)){
            isAlive = false;
            return;
        }
        snakeParts.add(0, newHead);
        if (snakeParts.get(0).x == apple.x && snakeParts.get(0).y == apple.y){
            apple.isAlive = false;
        }else {
            removeTail();
        }
    }

    public GameObject createNewHead() {
        GameObject newHead = null;
        switch (direction) {
            case LEFT: {
                newHead = new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
                break;
            }
            case RIGHT: {
                newHead = new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
                break;
            }
            case UP:
                newHead = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
                break;
            case DOWN:
                newHead = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
                break;

        }
        return newHead;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
    public boolean checkCollision(GameObject object){
        for (GameObject snakePart : snakeParts) {
            if (snakePart.y == object.y && snakePart.x == object.x){
                return true;
            }
        }
        return false;
    }
}
