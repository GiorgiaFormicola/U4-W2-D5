package GiorgiaFormicola.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Collection extends ArrayList<Game> {
    public void addElement(Game element) {
        if (stream().noneMatch(game -> game.getID() == element.getID())) {
            add(element);
            System.out.println("Game added successfully!");
        } else throw new RuntimeException("Game already present in the catalog!");
    }

    public Game searchByID(long ID) {
        Optional<Game> searchResult = stream().filter(game -> game.getID() == ID).findAny();
        if (searchResult.isPresent()) return searchResult.get();
        else throw new RuntimeException("Game not found in the catalog!");
    }

    public List<Game> searchByPrice(double price) {
        List<Game> catalogFiltered = stream().filter(game -> game.getPrice() < price).toList();
        if (!catalogFiltered.isEmpty()) return catalogFiltered;
        else throw new RuntimeException("No games found in the catalog with a price lower than " + price);
    }

    public List<Game> searchByNumberOfPlayers(int players) {
        List<Game> catalogFiltered = stream().filter(game -> game.getClass().equals(BoardGame.class)).filter(game -> ((BoardGame) game).getNumberOfPlayers() == players).toList();
        if (!catalogFiltered.isEmpty()) return catalogFiltered;
        else
            throw new RuntimeException("No games for " + players + (players == 1 ? " player " : " players ") + "found in the catalog!");
    }

    public void removeElementByID(long ID) {
        if (removeIf(game -> game.getID() == ID)) System.out.println("Game removed successfully!");
        else throw new RuntimeException("Game not found in the catalog!");
    }

    //Per ora questo metodo l'ho immaginato che mi faccia modificare il prezzo dell'articolo.
    //Avendo più tempo avrei voluto fare degli overloads del metodo cambiando il tipo di parametro
    //Per modificare altri attributi
    public void modifyElementByID(long ID, double newPrice) {
        try {
            Game gameToModify = searchByID(ID);
            gameToModify.setPrice(newPrice);
            System.out.println("Game modified successfully!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCollectionStats() {
        if (isEmpty()) throw new RuntimeException("No games in the catalog: impossible to get the catalog stats!");
        else {
            Map<Class, Long> gamesDividedPerClassAndCounted = stream().collect(Collectors.groupingBy(game -> game.getClass(), Collectors.counting()));

            System.out.println("-----CATALOG INFO-----");
            gamesDividedPerClassAndCounted.forEach((gameClass, totalAmount) -> System.out.println("Total amount of" + (gameClass.getSimpleName().equals("VideoGame") ? " VIDEOGAMES " : " BOARD GAMES ") + "in the catalog = " + totalAmount));

            OptionalDouble maxPrice = stream().mapToDouble(product -> product.getPrice()).max();
            List<Game> mostExpensiveGame = stream().filter(game -> game.getPrice() == maxPrice.getAsDouble()).toList();

            System.out.println((mostExpensiveGame.size() == 1 ? "\nMost expensive game in the catalog:" : "\nMost expensive games in the catalog:").toUpperCase());
            mostExpensiveGame.forEach(System.out::println);

            Double gamesAveragePrice = stream().mapToDouble(game -> game.getPrice()).average().getAsDouble();
            System.out.println("\nTHE AVERAGE PRICE OF THE GAMES IN THE CATALOG IS: " + gamesAveragePrice);

        }


    }

}
