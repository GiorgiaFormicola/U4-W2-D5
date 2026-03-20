package GiorgiaFormicola;


import GiorgiaFormicola.entities.BoardGame;
import GiorgiaFormicola.entities.Collection;
import GiorgiaFormicola.entities.Game;
import GiorgiaFormicola.entities.VideoGame;
import GiorgiaFormicola.enums.Genre;

public class Application {

    public static void main(String[] args) {
        Game videogame = new VideoGame("VideoGame", 2020, 22, "PC", 130, Genre.ACTION);
        System.out.println(videogame);
        Game boardGame = new BoardGame("BoardGame", 1990, 15, 3, 120);
        System.out.println(boardGame);

        Collection catalog = new Collection();
        catalog.add(videogame);
        catalog.add(boardGame);
        System.out.println(catalog);

        try {
            catalog.addElement(boardGame);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(catalog.searchByID(1));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(catalog.searchByID(0));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(catalog.searchByPrice(20));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(catalog.searchByNumberOfPlayers(1));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            catalog.removeElementByID(2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        catalog.modifyElementByID(0, 15);
        catalog.modifyElementByID(1, 15);
        catalog.forEach(System.out::println);
        catalog.getCollectionStats();


    }
}
