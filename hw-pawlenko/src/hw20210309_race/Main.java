package hw20210309_race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final int PARTICIPANTS_AMOUNT = 1000;
    static final int DISTANCE = 10;
    private static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] taracanThreads = new Thread[PARTICIPANTS_AMOUNT];
         List<Score> results = new ArrayList<>();

        long startingTime = System.currentTimeMillis();

        for (int i = 0; i < PARTICIPANTS_AMOUNT; i++) {
            taracanThreads[i] = new Thread(new Tarakan("Tarakan" + i, DISTANCE , startingTime, results));
        }
        for (int i = 0; i < PARTICIPANTS_AMOUNT; i++) {
            taracanThreads[i].start();
        }
        for (int i = 0; i < PARTICIPANTS_AMOUNT; i++) {
            taracanThreads[i].join();
        }
        System.out.println("Total results"+ results.size());
        results.sort(Comparator.comparing(Score::getScore));
//        Collections.sort(results, Comparator.comparing(Score::getScore));
        for (Score score: results){
            System.out.println(score.getName() + " " + score.getScore());
        }
    }


}
