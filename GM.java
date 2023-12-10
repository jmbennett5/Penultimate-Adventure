
/**
 * Write a description of class MainMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class GM {
    public static Scanner cmdin;
    public static Room loc = Room.Bedroom;

    public static void main(String[] args) {
        cmdin = new Scanner(System.in);
        int choice;
        Game game = new Game();
        
        do {
            System.out.println("Penultimate Adventure Main Menu");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            System.out.println("3. Quit Game");
            System.out.print("Please enter your choice: ");

            cmdin = new Scanner(System.in);
            GM.loc = Room.Bedroom;
            choice = cmdin.nextInt();

            switch (choice) {
                case 1:
                    game.startNewGame();
                    break;
                case 2:
                    Room savedRoom = SaveGame.loadGame();
                    if (savedRoom != null){
                       loc = savedRoom;
                       game.startNewGame();
                    } else{
                      loc = Room.Bedroom;
                      System.out.println("There is currently no saved game, starting a new game");
                      game.startNewGame();
                    }
                    break;
                   
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (choice != 3);

        cmdin.close();
    }
    
}