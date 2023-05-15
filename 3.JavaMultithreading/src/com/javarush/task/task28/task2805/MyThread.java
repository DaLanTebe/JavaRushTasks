package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
//    private static AtomicInteger priority = new AtomicInteger(1);
//    private static AtomicInteger counter = new AtomicInteger(1);
//
//    {
//        if (counter.get() > MAX_PRIORITY) {
//            priority.set(MIN_PRIORITY);
//        }
//        counter.set(priority.get());
//        if (getThreadGroup().getMaxPriority() < priority.get()) {
//            setPriority(getThreadGroup().getMaxPriority());
//            priority.incrementAndGet();
//        }else {
//            setPriority(priority.getAndIncrement());
//        }
//        counter.incrementAndGet();
//    }

    //    private static AtomicInteger integer = new AtomicInteger(1);
//    {
//        int priority = integer.getAndIncrement();
//        if (priority > MAX_PRIORITY){
//            priority = MIN_PRIORITY;
//        }
//        integer.set(priority);
//        setPriority(integer.getAndIncrement());
//        if (getThreadGroup().getMaxPriority() < priority){
//            setPriority(getThreadGroup().getMaxPriority());
//        }
//    }
    private static AtomicInteger integer = new AtomicInteger(9);
    {
        setPriority(integer.incrementAndGet() % 10 + 1);
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
