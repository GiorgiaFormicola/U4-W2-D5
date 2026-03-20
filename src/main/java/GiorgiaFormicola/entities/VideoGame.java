package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.Genre;

import java.time.Duration;

public class VideoGame extends Game {
    //ATTRIBUTES
    private String platform;
    private Duration gameTime;
    private Genre genre;

    //CONSTRUCTOR
    public VideoGame(String title, int releaseDate, double price, String platform, int hours, Genre genre) {
        super(title, releaseDate, price);
        this.platform = platform;
        this.gameTime = Duration.ofHours(hours);
        this.genre = genre;
    }

    //GETTERS

    public String getPlatform() {
        return platform;
    }

    public Duration getGameTime() {
        return gameTime;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "VideoGame {" +
                super.toString() +
                ", platform='" + platform + '\'' +
                ", gameTime=" + gameTime.toHours() + "h" +
                ", genre=" + genre +
                '}';
    }
}
