package com.javarush.task.jdk13.task41.task4113;

import java.util.*;
import java.util.concurrent.*;

/* 
Тотальная итерация
*/

public class Solution {

    public static void main(String[] args) {
        getIterators().stream()
                .map(i -> i.getClass().getCanonicalName())
                .sorted()
                .forEach(System.out::println);
    }

    public static List<Iterator<?>> getIterators() {
        List<Iterator<?>> iterators = new ArrayList<>();
        iterators.add(new ArrayList<>(List.of()).iterator());
        iterators.add(new LinkedList<>(List.of()).iterator());
        iterators.add(new Vector<>(List.of()).iterator());

        iterators.add(new PriorityQueue<>(List.of()).iterator());
        iterators.add(new ArrayDeque<>(List.of()).iterator());
        iterators.add(new DelayQueue<>(List.of()).iterator());

        iterators.add(new HashSet<>(List.of()).iterator());
        iterators.add(new LinkedHashSet<>(List.of()).iterator());
        iterators.add(new TreeSet<>(List.of()).iterator());

        iterators.add(new TreeMap<>(Map.of()).keySet().iterator());
        iterators.add(new TreeMap<>(Map.of()).values().iterator());
        iterators.add(new LinkedHashMap<>(Map.of()).keySet().iterator());
        iterators.add(new LinkedHashMap<>(Map.of()).values().iterator());
        iterators.add(new HashMap<>(Map.of()).keySet().iterator());
        iterators.add(new HashMap<>(Map.of()).values().iterator());

        iterators.add(new LinkedBlockingQueue<>(List.of()).iterator());
        iterators.add(new LinkedBlockingDeque<>(List.of()).iterator());
        iterators.add(new ConcurrentLinkedDeque<>(List.of()).iterator());
        iterators.add(new ConcurrentLinkedQueue<>(List.of()).iterator());
        iterators.add(new CopyOnWriteArrayList<>(List.of()).iterator());
        iterators.add(new CopyOnWriteArraySet<>(List.of()).iterator());
        iterators.add(new PriorityBlockingQueue<>(List.of()).iterator());
        iterators.add(new ConcurrentHashMap<>(Map.of()).keySet().iterator());
        iterators.add(new ConcurrentHashMap<>(Map.of()).values().iterator());
        iterators.add(new ConcurrentSkipListMap<>(Map.of()).keySet().iterator());
        iterators.add(new ConcurrentSkipListMap<>(Map.of()).values().iterator());
        iterators.add(new ConcurrentSkipListSet<>(List.of()).iterator());
        return iterators;
    }
}
