
/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class NPC extends GM {
    
    public static String TalkToBill() {
        String prompt = "Hello neighborino! Watch out for the DRUGGIE on the stairs! Let me know if you need other INFORMATION before you LEAVE.";
        
        
        System.out.println(prompt);
        
        String userInput = cmdin.nextLine();
        
        if ("druggie".equalsIgnoreCase(userInput)){
             System.out.println("There's a crazy guy over there on the stairs! Keeps rambling about dragons.");
        
             return "stairs";
            }
        else if ("information".equalsIgnoreCase(userInput) || "info".equalsIgnoreCase(userInput)){
          provideInformation();
          return "info";
        }
        else if ("leave".equalsIgnoreCase(userInput)){
         System.out.println("Thanks for stopping by, sorry I couldn't help you!");
         return "left";
        }
       return userInput;
    }
    public void interactWithPlayer() { //not currently in use
        boolean infoProvided = false;
        Scanner scanner = new Scanner(System.in);
         
        System.out.println("Hello Adventurer! I am Bill, I am a helpful guide to the new System");
        System.out.println("Would you like some information about the new system?");
        
        while(!infoProvided){
        String userInput = scanner.nextLine().toLowerCase();
        
        if (userInput.equals("information")) {
            provideInformation();
            infoProvided = true;
        } else {
            System.out.println("I am sorry, your voice is very garbled and I didn't understand what you just said, do you want information?");
        }
        
        
    }   scanner.close();
    
    
     }

    private static void provideInformation() {
        System.out.println("The System has taken over your planet, and now operates on what you would consider to be video game logic, meaning that you now have stats such as levels and experience");
        System.out.println("This means that you can now kill monsters and do quests to earn levels and experience to become a stronger human for when other races invade your planet");
    }
}