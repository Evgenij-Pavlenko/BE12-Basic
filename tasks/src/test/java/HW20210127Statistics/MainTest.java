package HW20210127Statistics;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    List<Statistic> statistics = new ArrayList<>();
    Statistic statistic1 = new Statistic(LocalTime.parse("09:00"), "url.de");
    Statistic statistic2 = new Statistic(LocalTime.parse("09:08"), "url.de");
    Main main = new Main();

    @Test
    public void testLast10Minute_1(){
        statistics.add(statistic1);
        statistics.add(statistic2);
        List<Statistic> actual = main.last10Minute(statistics);
        statistic1.last10minMentions=1;
        statistic1.last10minMentions=2;
        List<Statistic> expected = Arrays.asList(statistic1, statistic1);
        assertEquals(expected, actual);

    }


}
