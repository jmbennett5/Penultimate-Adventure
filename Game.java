/**
 * This is the main game loop, logic will direct here for decisions.
 *
 * @Johnathan Bennett
 * @Version 1.0
 */


public class Game extends GM {
    public boolean quit = false;
    //public boolean changedRoom = false;
        
    public void startNewGame() {
        
        if(loc == Room.Bedroom){// Scanner scanner = new Scanner(System.in);
        System.out.println("********Welcome to the Penultimate Adventure, your Adventure starts NOW!***********************************");
            System.out.println("You jolt awake to an eerie silence, the once-familiar symphony of city life abruptly silenced outside your window."
            + "\nIt's as if a switch has been flipped, plunging the world into a profound stillness—no hum of engines, no electronic murmurs—"
            + "\nleaving only a ghostly echo of the bustling modernity that once surrounded you.");
                      
            
            
            
        }
        quit = false;
       while(!quit) {
            

            System.out.println("Enter 'quit' to exit the game: ");

            String userInput = Room.EnterRoom(loc);
            //String userInput = cmdin.nextLine();
            
            
            if ("fight".equalsIgnoreCase(userInput) && loc == Room.Stairs)
            {                         
              userInput = Monster.FightDruggie();
            }
             if ("fight".equalsIgnoreCase(userInput) && loc == Room.greenLight)
            {                         
              userInput = Monster.FightMonk();
            }
            
            if ("talk".equalsIgnoreCase(userInput) && loc == Room.Hallway){
              userInput = NPC.TalkToBill();
            }
            if ("RUN".equalsIgnoreCase(userInput)) 
            {
                Room.EnterRoom(Room.Street);
            }
            if ("WON".equalsIgnoreCase(userInput))
            {
                System.out.println("You have achieved immortality, and have passed the bounds of human ability, you can move on from here and see where the galaxy can take you! Thank you for playing!");
                wonGame();
            }
            
            if ("DEATH".equalsIgnoreCase(userInput))
            {
                GameOver();
            }
            if ("stairs".equalsIgnoreCase(userInput))
            {
                System.out.println("You think you should probably go to the stairs, to see what's going on");
            }
            if ("info".equalsIgnoreCase(userInput)){
               System.out.println("You got some info from bill, but it feels like there's somethign else you might want to do");
            }
            if("leave".equalsIgnoreCase(userInput)){ 
              System.out.println("You didn't even talk to your neighbour, and feel like you are missing some information");
            }
            
            if ("quit".equalsIgnoreCase(userInput)) 
            {
                quit = true;
            }
            if ("save".equalsIgnoreCase(userInput)){
             SaveGame.saveGame(GM.loc);
             
            }
            
        } 

        //cmdin.close();
    }
    
    public void GameOver()
    {
        System.out.println("You died");
        
        quit = true;
    }
    
    public void wonGame()
    {
      quit = true;
    }
}
