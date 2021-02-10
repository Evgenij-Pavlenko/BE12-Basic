package hw20210203;

public class FootballClub {
    private String country;
    private String name;
    private int achievedPoint;

    public FootballClub(String name, String country, int achievedPoint) {
        this.country = country;
        this.name = name;
        this.achievedPoint = achievedPoint;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAchievedPoint() {
        return achievedPoint;
    }

    public void setAchievedPoint(int achievedPoint) {
        this.achievedPoint = achievedPoint;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "name='" + name + '\'' +
                '}';
    }
}
