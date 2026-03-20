package GiorgiaFormicola;


import GiorgiaFormicola.entities.BoardGame;
import GiorgiaFormicola.entities.Game;
import GiorgiaFormicola.entities.VideoGame;
import GiorgiaFormicola.enums.Genre;

public class Application {

    public static void main(String[] args) {
        Game videogame = new VideoGame("VideoGame", 2020, 22, "PC", 130, Genre.ACTION);
        System.out.println(videogame);
        Game boardGame = new BoardGame("BoardGame", 1990, 15, 3, 120);
        System.out.println(boardGame);
    }
}
