//Data holding class for player object
public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void plusPoint(int points) {
        this.points += 1;
    }

    public String getName() {
        return name;
    }
}
