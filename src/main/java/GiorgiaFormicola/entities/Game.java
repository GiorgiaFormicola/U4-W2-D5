package GiorgiaFormicola.entities;

import java.time.Year;

public abstract class Game {
    //STATIC ATTRIBUTE TO GENERATE ID
    private static long gamesAmount;
    // ATTRIBUTES
    private long ID;
    private String title;
    private Year releaseDate;
    private double price;

    //CONSTRUCTOR
    public Game(String title, int releaseDate, double price) {
        gamesAmount++;
        this.ID = gamesAmount;
        this.title = title;
        this.releaseDate = Year.of(releaseDate);
        this.price = price;
    }

    //GETTERS
    public long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public Year getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price;
    }
}
