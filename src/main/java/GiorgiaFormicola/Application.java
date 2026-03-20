package GiorgiaFormicola;


import GiorgiaFormicola.entities.BoardGame;
import GiorgiaFormicola.entities.Collection;
import GiorgiaFormicola.entities.Game;
import GiorgiaFormicola.entities.VideoGame;
import GiorgiaFormicola.enums.Genre;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Game videogame1 = new VideoGame("GTA", 2020, 40.5, "PlayStastion", 130, Genre.RACING);
        Game videogame2 = new VideoGame("Halo", 2023, 22.0, "PC", 300, Genre.ACTION);
        Game videogame3 = new VideoGame("The Sims", 2010, 15.0, "Xbox", 500, Genre.SIMULATION);
        Game videogame4 = new VideoGame("Tekken", 2025, 30.5, "PC", 80, Genre.FIGHTING);
        Game boardGame1 = new BoardGame("Twister", 2000, 15, 10, 120);
        Game boardGame2 = new BoardGame("Carcassone", 1990, 15, 5, 120);
        Game boardGame3 = new BoardGame("Seven Wonders", 2020, 15, 6, 120);
        Game boardGame4 = new BoardGame("UNO!", 1990, 2010, 10, 120);

        Collection catalog = new Collection();
        catalog.add(videogame1);
        catalog.add(boardGame1);
        catalog.add(boardGame2);
        catalog.add(videogame2);

        System.out.println("----- INITIAL GAMES CATALOG -----");
        catalog.forEach(System.out::println);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCHOOSE THE OPERATION YOU WOULD LIKE TO DO:");
            System.out.println("1 to ADD a game to the catalog");
            System.out.println("2 to SEARCH a game by ID");
            System.out.println("3 to FILTER games by PRICE");
            System.out.println("4 to FILTER games by NUMBER OF PLAYERS");
            System.out.println("5 to REMOVE a game by ID");
            System.out.println("6 to MODIFY a game PRICE by ID");
            System.out.println("7 to get the CATALOG INFO");
            System.out.println("8 to get the CATALOG LIST");
            System.out.println("0 to QUIT");

            try {
                int operationNumber = Integer.parseInt(scanner.nextLine());
                if (operationNumber == 0) break;
                if (operationNumber < 0 || operationNumber > 8) {
                    System.out.println("You must type a number from 1 to 8, try again!\n");
                }
                if (operationNumber == 1) {
                    while (true) {
                        System.out.println("Type the number of the game you want to add:");
                        System.out.println("1. " + videogame1);
                        System.out.println("2. " + videogame2);
                        System.out.println("3. " + videogame3);
                        System.out.println("4. " + videogame4);
                        System.out.println("5. " + boardGame1);
                        System.out.println("6. " + boardGame2);
                        System.out.println("7. " + boardGame3);
                        System.out.println("8. " + boardGame4);
                        System.out.println("0 to QUIT");

                        int gameToAddNumber = Integer.parseInt(scanner.nextLine());
                        if (gameToAddNumber == 0) break;
                        if (gameToAddNumber < 1 || gameToAddNumber > 8) {
                            System.out.println("You must type a number from 1 to 8, try again!\n");
                        } else {
                            //Avrei voluto implementare ulteriormente lo scanner per far creare da 0 all'utente un
                            // nuovo Game con controlli sul costruttore annessi ma non ho fatto in tempo
                            Game gameToAdd = switch (gameToAddNumber) {
                                case 1 -> videogame1;
                                case 2 -> videogame2;
                                case 3 -> videogame3;
                                case 4 -> videogame4;
                                case 5 -> boardGame1;
                                case 6 -> boardGame2;
                                case 7 -> boardGame3;
                                case 8 -> boardGame4;
                                default -> throw new IllegalStateException("Unexpected value: " + gameToAddNumber);
                            };
                            try {
                                catalog.addElement(gameToAdd);
                                break;
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }

                }
                if (operationNumber == 2) {
                    while (true) {
                        System.out.println("Type an ID to SEARCH a game or 0 to QUIT");
                        int IDtoSearch = Integer.parseInt(scanner.nextLine());
                        if (IDtoSearch == 0) break;
                        try {
                            System.out.println(catalog.searchByID(IDtoSearch));
                            break;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                if (operationNumber == 3) {
                    while (true) {
                        System.out.println("Type a PRICE to FILTER the catalog or 0 to QUIT");
                        double maxPrice = Double.parseDouble(scanner.nextLine());
                        if (maxPrice == 0) break;
                        if (maxPrice < 0) System.out.println("You must type a positive number, try again!");
                        else {
                            try {
                                catalog.searchByPrice(maxPrice).forEach(System.out::println);
                                break;
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                }

                if (operationNumber == 4) {
                    while (true) {
                        System.out.println("Type a NUMBER OF PLAYERS to filter the catalog or 0 to QUIT");
                        int players = Integer.parseInt(scanner.nextLine());
                        if (players == 0) break;
                        try {
                            catalog.searchByNumberOfPlayers(players).forEach(System.out::println);
                            break;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                if (operationNumber == 5) {
                    while (true) {
                        System.out.println("Type an ID to REMOVE a game from the catalog or 0 to QUIT");
                        int IDtoRemove = Integer.parseInt(scanner.nextLine());
                        if (IDtoRemove == 0) break;
                        try {
                            catalog.removeElementByID(IDtoRemove);
                            break;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                if (operationNumber == 6) {
                    //Qui come scrivo anche nella classe Collection avrei voluto implementare ulteriormente lo scanner
                    // per far scegliere all'utente che tipo di dato modificare e poi in base a quello richiamare la stessa funzione
                    //con parametri diversi

                    while (true) {
                        System.out.println("Type the ID of the game you want to MODIFY or 0 to QUIT");
                        int IDtoModify = Integer.parseInt(scanner.nextLine());

                        System.out.println("Type the NEW PRICE of the game or 0 to QUIT");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        if (IDtoModify == 0 || newPrice == 0) break;
                        if (newPrice < 0) System.out.println("You must type a positive number, try again!");
                        else {
                            try {
                                catalog.modifyElementByID(IDtoModify, newPrice);
                                break;
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                }

                if (operationNumber == 7) {
                    try {
                        catalog.getCollectionStats();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (operationNumber == 8) {
                    System.out.println("----- GAMES CATALOG -----");
                    if (!catalog.isEmpty()) catalog.forEach(System.out::println);
                    else System.out.println("The catalog is empty, add a game to start filling it!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: you must type a number, try again!");
            }
        }
        //Per quanto riguarda le eccezioni avrei voluto gestirle meglio creandone qualcuna custom,
        // ma non ho fatto in tempo


        // TESTS BEFORE SCANNER
        /*catalog.forEach(System.out::println);*/

       /* try {
            catalog.addElement(videogame1);
            catalog.addElement(videogame2);
            catalog.addElement(videogame3);
            catalog.addElement(videogame4);
            catalog.addElement(boardGame1);
            catalog.addElement(boardGame2);
            catalog.addElement(boardGame3);
            catalog.addElement(boardGame4);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        catalog.forEach(System.out::println);*/


        /*try {
            System.out.println(catalog.searchByID(1));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(catalog.searchByID(0));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/

        /*try {
            catalog.searchByPrice(20).forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            catalog.searchByPrice(15).forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/

       /* try {
            catalog.searchByNumberOfPlayers(1).forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            catalog.searchByNumberOfPlayers(10).forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/

        /*try {
            catalog.removeElementByID(2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/

       /* try {
            catalog.removeElementByID(0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/

        /*catalog.modifyElementByID(0, 15);
        catalog.modifyElementByID(1, 15);*/
        /*catalog.forEach(System.out::println);
        catalog.getCollectionStats();*/


    }
}
