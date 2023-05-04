package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) throws InterruptedException {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        synchronized (o1){
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    synchronized (o2){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    try {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            thread2.start();
            thread1.start();
            Thread.sleep(50);
            System.out.println(thread1.getState() + " " + thread2.getState());
            return thread1.getState() != Thread.State.BLOCKED;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
