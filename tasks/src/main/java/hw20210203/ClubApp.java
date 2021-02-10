package hw20210203;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
1.
public class FootballClub {
  String country;
  String name;
  int achievedPoint;
}
Есть список команд. Необходимо расположить команды по принципу: страны в алфавитном порядке и количество набранных очков
 */
public class ClubApp {

    public List<FootballClub> sortedClub(List<FootballClub> clubList) {
        return clubList.stream()
                .sorted(Comparator.comparing(FootballClub::getCountry).thenComparing(FootballClub::getAchievedPoint))
                .collect(Collectors.toList());
    }

}
