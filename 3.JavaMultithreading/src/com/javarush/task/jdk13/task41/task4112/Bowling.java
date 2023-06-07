package com.javarush.task.jdk13.task41.task4112;

import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bowling {

    private final Queue<Track> tracks;
    private final Queue<PairOfShoes> shoesShelf;

    public Bowling(int tracksNumber) {
//        IntStream.range(1, tracksNumber + 1).mapToObj(Track::new).forEach(tracks::offer);
        tracks = IntStream.range(1, tracksNumber + 1).mapToObj(Track::new).collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
//        IntStream.range(0, 50 ).mapToObj(size -> new PairOfShoes(ThreadLocalRandom.current().nextInt(38,45))).forEach(shoesShelf::offer);
        shoesShelf = IntStream.range(0, 50 ).mapToObj(size -> new PairOfShoes(ThreadLocalRandom.current().nextInt(38,45))).collect(Collectors.toCollection(ConcurrentLinkedQueue::new));

    }

    public synchronized Track acquireTrack() {
        if (tracks == null){
            return null;
        }
        Track track = tracks.poll();
        if (Objects.nonNull(track)){
            track.setPrice(100 - tracks.size() * 10);
        }
        return track;
    }

    public synchronized void releaseTrack(Track track) {
        System.out.printf("C дорожки №%d сняли бронь\n", track.getNumber());
        tracks.offer(track);
    }

    public synchronized Set<PairOfShoes> acquireShoes(int number) {
        if (shoesShelf.size() < number){
            return null;
        }
        Set<PairOfShoes> shoes = new HashSet<>();
        for (int i = 0; i < number; i++) {
            shoes.add(shoesShelf.poll());
        }
        return shoes;
    }

    public synchronized void releaseShoes(Set<PairOfShoes> shoes) {
        System.out.printf("В гардероб вернули %d пар обуви\n", shoes.size());
        shoesShelf.addAll(shoes);
    }
}
