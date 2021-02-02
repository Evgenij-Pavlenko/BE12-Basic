package HW20210127Statistics;

import java.sql.Time;
import java.time.LocalTime;

public class Statistic {
    LocalTime time;
    String url;
    int last10minMentions;

    public Statistic(LocalTime time, String url) {
        this.time = time;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "time=" + time +
                ", url='" + url + '\'' +
                ", last10minMentions=" + last10minMentions +
                '}';
    }
}
