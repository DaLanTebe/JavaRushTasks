package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome (List<Horse> list) {
        horses = list;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Сивка", 3, 0));
        horses.add(new Horse("Плотва", 3, 0));
        horses.add(new Horse("Вася", 3, 0));

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses) {
            horse.print();
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (winner.getDistance() < horse.getDistance()){
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }
}
