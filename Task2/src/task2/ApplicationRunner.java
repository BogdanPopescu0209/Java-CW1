package task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        ApplicationRunner lvl = new ApplicationRunner();

        Scanner input = new Scanner(System.in);

        int level;

        System.out.println("---------------------------------");
        System.out.println("Welcome to the memory square game");
        System.out.println("---------------------------------");
        System.out.println("Easy.......................1");
        System.out.println("Intermediate...............2");
        System.out.println("Difficult..................3");
        System.out.println("Just give up now...........0\n");

        System.out.print("Select your preferrd level > ");
        level = input.nextInt();
        System.out.println("------------------------------");

        switch (level) {

            case 0:
                System.exit(0);
                break;

            case 1:
                lvl.easy();
                break;

            case 2:
                lvl.intermediate();
                break;

            case 3:
                lvl.difficult();
                break;

            default:
                System.out.println("Wrong choice! Please try again.");

        }

    }

    public void easy() {

        String[][] grid = new String[4][4];

        String[][] superHero = new String[4][4];

        int nrGuesses = 1;

        int position;

        Scanner input = new Scanner(System.in);

        Random random = new Random();

        ArrayList<String> smallList = new ArrayList<>();

        smallList.add("Mysterio");
        smallList.add("Hawkeye");
        smallList.add("Iron Man");
        smallList.add("Rogue");
        smallList.add("Mystique");
        smallList.add("Catwoman");
        smallList.add("Flash");
        smallList.add("Batman");
        smallList.add("Mysterio");
        smallList.add("Hawkeye");
        smallList.add("Iron Man");
        smallList.add("Rogue");
        smallList.add("Mystique");
        smallList.add("Catwoman");
        smallList.add("Flash");
        smallList.add("Batman");

        //Random position each time the game is beeing played
        for (int r = 0; r < 4; r += 1) {
            for (int c = 0; c < 4; c += 1) {
                position = random.nextInt(smallList.size());
                superHero[r][c] = smallList.get(position);
                smallList.remove(position);
            }
        }

        //Output array and applay grid
        for (int r = 0; r < 4; r += 1) {
            System.out.print(r + "|");
            System.out.print(" ");
            for (int c = 0; c < 4; c += 1) {
                System.out.print(c);
                grid[r][c] = "[XXXXXXXXXX]";
                System.out.print(grid[r][c]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

        while (true) {

            System.out.print("Enter row and column (9 9 to exit): 1> ");
            int row = input.nextInt();
            int column = input.nextInt();
            System.out.println("---------------------------");

            //Exit game
            if (row == 9 && column == 9) {

                System.exit(0);

                //Check input range and output feedback
            } else if (row > 4 || column > 4) {

                System.out.println("Out of range, try again!");
                System.out.println("---------------------------");
                continue;

            } else {

                //Check if input is equal to [XXXXXXXXXX] and outputs feedback
                if (!grid[row][column].equals("[XXXXXXXXXX]")) {

                    System.out.println("Entered before!");
                    grid[row][column] = "[XXXXXXXXXX]";
                    System.out.println("\n");

                } else {

                    //Output array, applay grid and reveals superhero
                    grid[row][column] = " " + superHero[row][column] + " ";
                    for (int r = 0; r < 4; r += 1) {
                        System.out.print(r + "|");
                        System.out.print(" ");
                        for (int c = 0; c < 4; c += 1) {
                            System.out.print(c);
                            System.out.print(grid[r][c]);
                            System.out.print(" ");
                        }
                        System.out.println("\n");
                    }
                }
            }

            System.out.print("Enter row and column (9 9 to exit): 2> ");
            int row1 = input.nextInt();
            int column1 = input.nextInt();
            System.out.println("---------------------------");

            //Game exit
            if (row1 == 9 && column1 == 9) {

                System.exit(0);

                //Check input range and output feedback
            } else if (row1 > 4 || column1 > 4) {

                System.out.println("Out of range, try again!");
                System.out.println("---------------------------");
                grid[row][column] = "[XXXXXXXXXX]";
                System.out.println("\n");

            } else {

                //Check if input was entered before and output feedback
                if (!grid[row1][column1].equals("[XXXXXXXXXX]")) {

                    System.out.print("Entered before!");
                    grid[row][column] = "[XXXXXXXXXX]";
                    System.out.println("\n");

                } else {

                    //Output array, applay grid and reveals superhero and output 
                    //feedback and number of guesses if superheroes match
                    grid[row1][column1] = " " + superHero[row1][column1] + " ";
                    if (grid[row][column].equals(grid[row1][column1])) {
                        for (int r = 0; r < 4; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 4; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                        System.out.println("Found a mtach!");
                        System.out.println("Guesses: " + nrGuesses++);
                        System.out.println("-----------");

                    } else {

                        //Output array, applay grid and feedback if superhero
                        //doesn`t match
                        for (int r = 0; r < 4; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 4; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                        System.out.println("Not a match!");
                        System.out.println("------------");
                        grid[row][column] = "[XXXXXXXXXX]";
                        grid[row1][column1] = "[XXXXXXXXXX]";
                        for (int r = 0; r < 4; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 4; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                    }
                }
            }
        }

    }

    public void intermediate() {

        String[][] grid = new String[6][6];

        String[][] superHero = new String[6][6];

        int nrGuesses = 1;

        int position;

        Scanner input = new Scanner(System.in);

        Random random = new Random();

        ArrayList<String> mediumList = new ArrayList<>();

        mediumList.add("Kingpin");
        mediumList.add("Apocalypse");
        mediumList.add("Magneto");
        mediumList.add("Mysterio");
        mediumList.add("Hawkeye");
        mediumList.add("Iron Man");
        mediumList.add("Hulk");
        mediumList.add("War Machine");
        mediumList.add("Rogue");
        mediumList.add("Mystique");
        mediumList.add("Wolverine");
        mediumList.add("Poison Ivy");
        mediumList.add("Riddler");
        mediumList.add("Catwoman");
        mediumList.add("Flash");
        mediumList.add("Supergirl");
        mediumList.add("Lex Luthor");
        mediumList.add("Batman");
        mediumList.add("Kingpin");
        mediumList.add("Apocalypse");
        mediumList.add("Magneto");
        mediumList.add("Mysterio");
        mediumList.add("Hawkeye");
        mediumList.add("Iron Man");
        mediumList.add("Hulk");
        mediumList.add("War Machine");
        mediumList.add("Rogue");
        mediumList.add("Mystique");
        mediumList.add("Wolverine");
        mediumList.add("Poison Ivy");
        mediumList.add("Riddler");
        mediumList.add("Catwoman");
        mediumList.add("Flash");
        mediumList.add("Supergirl");
        mediumList.add("Lex Luthor");
        mediumList.add("Batman");

        //Random position each time the game is beeing played
        for (int r = 0; r < 6; r += 1) {
            for (int c = 0; c < 6; c += 1) {
                position = random.nextInt(mediumList.size());
                superHero[r][c] = mediumList.get(position);
                mediumList.remove(position);
            }
        }

        //Output array and applay grid
        for (int r = 0; r < 6; r += 1) {
            System.out.print(r + "|");
            System.out.print(" ");
            for (int c = 0; c < 6; c += 1) {
                System.out.print(c);
                grid[r][c] = "[XXXXXXXXXX]";
                System.out.print(grid[r][c]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

        while (true) {

            System.out.print("Enter row and column (9 9 to exit): > ");
            int row = input.nextInt();
            int column = input.nextInt();
            System.out.println("---------------------------");

            //Exit game
            if (row == 9 && column == 9) {

                System.exit(0);

                //Check input range and output feedback
            } else if (row > 6 || column > 6) {

                System.out.println("Out of range, try again!");
                System.out.println("---------------------------");
                continue;

            } else {

                //Check if input was entered before and output feedback
                if (!grid[row][column].equals("[XXXXXXXXXX]")) {
                    System.out.println("Entered before!");
                    System.out.println("\n");

                } else {

                    //Output array, applay grid and reveals superhero
                    grid[row][column] = " " + superHero[row][column] + " ";
                    for (int r = 0; r < 6; r += 1) {
                        System.out.print(r + "|");
                        System.out.print(" ");
                        for (int c = 0; c < 6; c += 1) {
                            System.out.print(c);
                            System.out.print(grid[r][c]);
                            System.out.print(" ");
                        }
                        System.out.println("\n");
                    }
                }
            }

            System.out.print("Enter row and column (9 9 to exit): > ");
            int row1 = input.nextInt();
            int column1 = input.nextInt();
            System.out.println("---------------------------");

            //Game exit
            if (row1 == 9 && column1 == 9) {

                System.exit(0);

                //Check input range and output feedback
            } else if (row1 > 6 || column1 > 6) {

                System.out.println("Out of range, try again!");
                System.out.println("---------------------------");
                grid[row][column] = "[XXXXXXXXXX]";
                System.out.println("\n");

            } else {

                //Check if input was entered before and output feedback
                if (!grid[row1][column1].equals("[XXXXXXXXXX]")) {

                    System.out.print("Entered before!");
                    grid[row][column] = "[XXXXXXXXXX]";
                    System.out.println("\n");

                } else {

                    //Output array, applay grid and reveals superhero and output 
                    //feedback and number of guesses if superheroes match
                    grid[row1][column1] = " " + superHero[row1][column1] + " ";
                    if (grid[row][column].equals(grid[row1][column1])) {
                        for (int r = 0; r < 6; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 6; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                        System.out.println("Found a mtach!");
                        System.out.println("Guesses: " + nrGuesses++);
                        System.out.println("-----------");

                    } else {

                        //Output array, applay grid and feedback if superhero
                        //doesn`t match
                        for (int r = 0; r < 6; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 6; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                        System.out.println("Not a match!");
                        System.out.println("------------");
                        grid[row][column] = "[XXXXXXXXXX]";
                        grid[row1][column1] = "[XXXXXXXXXX]";
                        for (int r = 0; r < 6; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 6; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                    }
                }
            }
        }
    }

    public void difficult() {

        String[][] grid = new String[8][8];

        String[][] superHero = new String[8][8];

        int nrGuesses = 1;

        int position;

        Scanner input = new Scanner(System.in);

        Random random = new Random();

        ArrayList<String> largeList = new ArrayList<>();

        largeList.add("Kingpin");
        largeList.add("Elektra");
        largeList.add("Apocalypse");
        largeList.add("Magneto");
        largeList.add("Mysterio");
        largeList.add("Hawkeye");
        largeList.add("Iron Man");
        largeList.add("Black Widow");
        largeList.add("Thor");
        largeList.add("Venom");
        largeList.add("Spiderman");
        largeList.add("Hulk");
        largeList.add("War Machine");
        largeList.add("Rogue");
        largeList.add("Punisher");
        largeList.add("Daredevil");
        largeList.add("Mystique");
        largeList.add("Wolverine");
        largeList.add("Nightwing");
        largeList.add("Poison Ivy");
        largeList.add("Batgirl");
        largeList.add("Harley Quinn");
        largeList.add("Penguin");
        largeList.add("Joker");
        largeList.add("Bane");
        largeList.add("Riddler");
        largeList.add("Catwoman");
        largeList.add("Flash");
        largeList.add("Supergirl");
        largeList.add("Lex Luthor");
        largeList.add("Scarecrow");
        largeList.add("Batman");
        largeList.add("Kingpin");
        largeList.add("Elektra");
        largeList.add("Apocalypse");
        largeList.add("Magneto");
        largeList.add("Mysterio");
        largeList.add("Hawkeye");
        largeList.add("Iron Man");
        largeList.add("Black Widow");
        largeList.add("Thor");
        largeList.add("Venom");
        largeList.add("Spiderman");
        largeList.add("Hulk");
        largeList.add("War Machine");
        largeList.add("Rogue");
        largeList.add("Punisher");
        largeList.add("Daredevil");
        largeList.add("Mystique");
        largeList.add("Wolverine");
        largeList.add("Nightwing");
        largeList.add("Poison Ivy");
        largeList.add("Batgirl");
        largeList.add("Harley Quinn");
        largeList.add("Penguin");
        largeList.add("Joker");
        largeList.add("Bane");
        largeList.add("Riddler");
        largeList.add("Catwoman");
        largeList.add("Flash");
        largeList.add("Supergirl");
        largeList.add("Lex Luthor");
        largeList.add("Scarecrow");
        largeList.add("Batman");

        //Random position each time the game is beeing played
        for (int r = 0; r < 8; r += 1) {
            for (int c = 0; c < 8; c += 1) {
                position = random.nextInt(largeList.size());
                superHero[r][c] = largeList.get(position);
                largeList.remove(position);
            }
        }

        //Output array and applay grid
        for (int r = 0; r < 8; r += 1) {
            System.out.print(r + "|");
            System.out.print(" ");
            for (int c = 0; c < 8; c += 1) {
                System.out.print(c);
                grid[r][c] = "[XXXXXXXXXX]";
                System.out.print(grid[r][c]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

        while (true) {

            System.out.print("Enter row and column (9 9 to exit): > ");
            int row = input.nextInt();
            int column = input.nextInt();
            System.out.println("---------------------------");

            //Exit game
            if (row == 9 && column == 9) {

                System.exit(0);

                //Check input range and output feedback
            } else if (row > 8 || column > 8) {

                System.out.println("Out of range, try again!");
                System.out.println("---------------------------");
                continue;

            } else {

                //Check if input was entered before and output feedback
                if (!grid[row][column].equals("[XXXXXXXXXX]")) {

                    System.out.println("Entered before!");
                    System.out.println("\n");

                } else {

                    //Output array, applay grid and reveals superhero
                    grid[row][column] = " " + superHero[row][column] + " ";
                    for (int r = 0; r < 8; r += 1) {
                        System.out.print(r + "|");
                        System.out.print(" ");
                        for (int c = 0; c < 8; c += 1) {
                            System.out.print(c);
                            System.out.print(grid[r][c]);
                            System.out.print(" ");
                        }
                        System.out.println("\n");
                    }
                }
            }

            System.out.print("Enter row and column (9 9 to exit): > ");
            int row1 = input.nextInt();
            int column1 = input.nextInt();
            System.out.println("---------------------------");

            //Game exit
            if (row1 == 9 && column1 == 9) {

                System.exit(0);

                //Check input range and output feedbacks
            } else if (row1 > 8 || column1 > 8) {

                System.out.println("Out of range, try again!");
                System.out.println("---------------------------");
                grid[row][column] = "[XXXXXXXXXX]";
                System.out.println("\n");

            } else {

                //Check if input was entered before and output feedback
                if (!grid[row1][column1].equals("[XXXXXXXXXX]")) {

                    System.out.print("Entered before!");
                    grid[row][column] = "[XXXXXXXXXX]";
                    System.out.println("\n");

                } else {

                    //Output array, applay grid and reveals super hero and output 
                    //feedback and number of guesses if superheroes match
                    grid[row1][column1] = " " + superHero[row1][column1] + " ";
                    if (grid[row][column].equals(grid[row1][column1])) {
                        for (int r = 0; r < 8; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 8; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                        System.out.println("Found a mtach!");
                        System.out.println("Guesses: " + nrGuesses++);
                        System.out.println("-----------");
                    } else {

                        //Output array, applay grid and feedback if superhero
                        //doesn`t match
                        for (int r = 0; r < 8; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 8; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                        System.out.println("Not a match!");
                        System.out.println("------------");
                        grid[row][column] = "[XXXXXXXXXX]";
                        grid[row1][column1] = "[XXXXXXXXXX]";
                        for (int r = 0; r < 8; r += 1) {
                            System.out.print(r + "|");
                            System.out.print(" ");
                            for (int c = 0; c < 8; c += 1) {
                                System.out.print(c);
                                System.out.print(grid[r][c]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                    }
                }
            }
        }
    }

}
