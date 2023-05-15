package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    private static AtomicInteger priority = new AtomicInteger(1);
    private static AtomicInteger counter = new AtomicInteger(1);

    {
        if (counter.get() == 10){
            counter.set(0);
            priority.set(1);
        }
            if (this.getThreadGroup().getMaxPriority() < priority.get()) {
                this.setPriority(this.getThreadGroup().getMaxPriority());
        }else this.setPriority(priority.getAndIncrement());
        counter.incrementAndGet();
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
