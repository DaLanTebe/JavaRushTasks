package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() throws InterruptedException {
        while (!isValuePresent){
            Thread.currentThread().wait();
        }
        notifyAll();
        System.out.println("Got: " + value);
        isValuePresent = false;
        return value;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (isValuePresent){
            Thread.currentThread().wait();
        }
        notifyAll();
        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
    }
}
