package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator{
    private Thread thread;


    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()){
            System.out.println(currentThread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void start(String threadName) {
        Thread newThread = new Thread(this, threadName);
        thread = newThread;
        newThread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
