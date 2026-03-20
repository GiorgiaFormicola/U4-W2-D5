package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.Genre;

import java.time.LocalTime;

public class VideoGame {
    //ATTRIBUTES
    private String platform;
    private LocalTime gameTime;
    private Genre genre;

    //CONSTRUCTOR
    public VideoGame(String title, int releaseDate, double price, String platform, int hours, int minutes, Genre genre) {
        super();
        this.platform = platform;
        this.gameTime = LocalTime.of(hours, minutes);
        this.genre = genre;
    }

    //GETTERS

    public String getPlatform() {
        return platform;
    }

    public LocalTime getGameTime() {
        return gameTime;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "VideoGame {" +
                super.toString() +
                "platform='" + platform + '\'' +
                ", gameTime=" + gameTime +
                ", genre=" + genre +
                '}';
    }
}
