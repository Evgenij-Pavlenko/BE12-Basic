package hw20210309_race;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    final private String name;
    private final int distance;
    private final long startTime;
    final List<Score> scoreList;

    public Tarakan(String name, int distance, long startTime, List<Score> scoreList) {
        this.name = name;
        this.distance = distance;
        this.startTime = startTime;
        this.scoreList = scoreList;
    }

    private final Random random = new Random();

    @Override
    public void run() {

        for (int i = 0; i < distance; i++) {
            int runningTime = random.nextInt(5)+50;
            try {
                Thread.sleep(runningTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int result = (int) (System.currentTimeMillis() - startTime);
        synchronized (scoreList){
            scoreList.add(new Score(name, result));
        }
    }
}
