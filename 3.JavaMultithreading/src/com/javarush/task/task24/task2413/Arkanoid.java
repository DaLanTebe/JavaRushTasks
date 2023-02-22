package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {

    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    public static Arkanoid game;
    private boolean isGameOver;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public Stand getStand() {
        return stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public static void main(String[] args) {
        
    }

    public void run(){}
    public void move(){
        stand.move();
        ball.move();
    }
    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
    }

    public void checkBricksBump(){
        for (int i = 0; i < bricks.size(); i++) {
            if (ball.intersects(bricks.get(i))){
                ball.setDirection(Math.random() * 360);
                bricks.remove(i);
            }
        }
    }

    public void checkStandBump(){
        if (ball.intersects(stand)){
            ball.setDirection(90 + 20 * (Math.random() - 0.5));
        }
    }

    public void checkEndGame(){
        if (ball.y > height){
            isGameOver = true;
        }
    }
}
