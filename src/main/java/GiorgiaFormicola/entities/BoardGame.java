package GiorgiaFormicola.entities;

import java.time.Duration;

public class BoardGame {
    //ATTRIBUTES
    private int numberOfPlayers;
    private Duration matchTime;

    //CONSTRUCTOR
    public BoardGame(String title, int releaseDate, double price, int numberOfPlayers, int minutes) {
        super();
        this.numberOfPlayers = numberOfPlayers;
        this.matchTime = Duration.ofMinutes(minutes);
    }

    //GETTERS
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public Duration getMatchTime() {
        return matchTime;
    }

    @Override
    public String toString() {
        return "BoardGame {" +
                super.toString() +
                "numberOfPlayers=" + numberOfPlayers +
                ", matchTime=" + matchTime +
                '}';
    }
}
