package com.javarush.task.task28.task2805;

public class MyThread extends Thread{
    private static int priority = 1;
    private static int counter = 0;

    {
        if (counter == 10){
            counter = 0;
            priority = 1;
        }
            if (this.getThreadGroup().getMaxPriority() < priority) {
                this.setPriority(this.getThreadGroup().getMaxPriority());
        }else this.setPriority(priority++);
        counter++;
    }

    public MyThread() {

    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
