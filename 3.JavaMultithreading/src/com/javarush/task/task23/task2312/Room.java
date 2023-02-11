package com.javarush.task.task23.task2312;

public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Room game;

    public Room(int wight, int height, Snake snake) {
        this.width = wight;
        this.height = height;
        this.snake = snake;
    }

    public static void main(String[] args) {
        Snake newSnake = new Snake(10, 10);
        newSnake.setDirection(SnakeDirection.DOWN);
        game = new Room(20, 20, newSnake);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void run(){}
    public void print(){}

    public void createMouse(){
        mouse = new Mouse((int) (Math.random() * width), (int) (Math.random() * height));
    }
    public void eatMouse(){
        createMouse();
    }
}
