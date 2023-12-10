import java.io.Serializable;
public class Room extends GM implements Serializable
{
    // Class Variables
    //private boolean north, south, west, east, battle, npc_present;
    private String room_name, npc_name, fight_level, north_name, south_name, west_name, east_name, description;
    
    private Room room_north, room_south, room_west, room_east;

    private boolean hasMonster = false;
    //set Functions
   /*
    public void setNorth(boolean north){
        this.north = north;
    }
    public void setSouth(boolean south){
        this.south = south;
    }
    public void setWest(boolean west){
        this.west = west;
    }
    public void setEast(boolean east){
        this.east = east;
    }

    public void setNpc_present(boolean npc){
        this.npc_present = npc;
    }

    public void setBattle(boolean battle){
        this.battle = battle;
    }
    */

    public void setRoom_name(String room_name){
        this.room_name = room_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNpc_name(String npc_name) {
        this.npc_name = npc_name;
    }

    public void setFight_level(String fight_level) {
        this.fight_level = fight_level;
    }

    public void setNorth_name(String north_name) {
        this.north_name = north_name;
    }

    public void setSouth_name(String south_name) {
        this.south_name = south_name;
    }

    public void setWest_name(String west_name) {
        this.west_name = west_name;
    }

    public void setEast_name(String east_name) {
        this.east_name = east_name;
    }


    //get Functions
    /*
    public boolean getNorth(){
        return this.north;
    }

    public boolean getSouth(){
        return this.south;
    }

    public boolean getWest(){
        return this.west;
    }

    public boolean getEast(){
        return this.east;
    }
    public boolean getNpc_present(){
        return this.npc_present;
    }

    public boolean getBattle(){
        return this.battle;
    }
    */

    public String getRoom_name(){
        return this.room_name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getNpc_name() {
        return this.npc_name;
    }

    public String getFight_level() {
        return this.fight_level;
    }

    public String getNorth_name() {
        return this.north_name;
    }

    public String getSouth_name() {
        return this.south_name;
    }

    public String getWest_name() {
        return this.west_name;
    }

    public String getEast_name() {
        return this.east_name;
    }

    public Room() {
        this.setNorth_name(null);
        this.setSouth_name(null);
        this.setWest_name(null);
        this.setEast_name(null);
        this.setFight_level(null);
        this.setNpc_name(null);
        this.setDescription(null);

    }

    public Room(String room_name, String north, String south, String west, String east, String fight_level, String npc, String description){
        this.setRoom_name(room_name);
        this.setNorth_name(north);
        this.setSouth_name(south);
        this.setWest_name(west);
        this.setEast_name(east);
        this.setFight_level(fight_level);
        this.setNpc_name(npc);
        this.setDescription(description);
    }

    // This function is called only by currentRoom in order to move the game along
    public void changeTo(Room target){
        this.setRoom_name(target.getRoom_name());
        this.setNorth_name(target.getNorth_name());
        this.setSouth_name(target.getSouth_name());
        this.setWest_name(target.getWest_name());
        this.setEast_name(target.getEast_name());
        this.setFight_level(target.getFight_level());
        this.setNpc_name(target.getNpc_name());
        this.setDescription(target.getDescription());
    }
    
    public static String EnterRoom(Room roomy)
    {
        GM.loc = roomy;
        
        String prompt   = "You have entered " + roomy.room_name + ".\n" 
                        + "North: " + roomy.north_name + "\n"
                        + "East: " + roomy.east_name + "\n"
                        + "West: " + roomy.west_name + "\n"
                        + "South: " +roomy.south_name + "\n"
                        + "\n"
                        + roomy.description + "\n";                  

        System.out.print(prompt);
        
    
        String userInput = cmdin.nextLine();
        
        if (roomy.hasMonster) return "fight";
        
        else if ("north".equalsIgnoreCase(userInput) && roomy.room_north != null)
        {
            
            return Room.EnterRoom(roomy.room_north);
        }
        
        else if ("south".equalsIgnoreCase(userInput) && roomy.room_south != null)
        {
            System.out.println("You typed south");
            return Room.EnterRoom(roomy.room_south); 
            
        }
        
        else if ("east".equalsIgnoreCase(userInput) && roomy.room_east != null)
        {
            return Room.EnterRoom(roomy.room_east);
        }
        
         else if ("west".equalsIgnoreCase(userInput) && roomy.room_west != null)
        {
            return Room.EnterRoom(roomy.room_west);
        }
        
        return userInput;

    }
    public static Room Street;
    public static Room Stairs;
    public static Room Hallway;
    public static Room Bedroom;
    public static Room greenLight;

    static {
     greenLight = new Room();
     greenLight.room_name = "GreenLight";
     greenLight.east_name = "To the east is the curtain of green shimmering light you went through to come here";
     greenLight.west_name = "Approach the monk to the WEST";
     greenLight.north_name = "There is nothing of interest here";
     greenLight.south_name = "There is nothing of interest here";
     greenLight.description = "You see a strange man sitting in a lotus position floating over the ground, he seems to becon you with his aura";
     greenLight.hasMonster = true;
    
    }
    
    
    
        //Street
     static
    {
        Street = new Room();
        Street.room_name = "Street";
        Street.north_name = "You see a very gruesome looking wreck to your north, and don't particularly want to encounter that.";
        Street.west_name = "To the west is a weird looking green shimmering light that you aren't sure you should go into.";
        Street.east_name = "To the east you see various storefronts that seem to be being actively looted by random people named george.";
        Street.south_name = "The stairs are back to your south but you should definitely not go back there.";
        Street.description = "You find yourself on the street in front of your building, with looting, fires, and random people chasing each other as if in a weird game of tag.";
        Street.room_west = greenLight;
    };
    
    
        //Stairs
     static
    {
        Stairs = new Room();
        Stairs.room_name = "Stairs";
        Stairs.north_name = "You see a door leading to the strert.";
        Stairs.west_name = "There is a blank wall to the west.";
        Stairs.east_name = "A blank wall is to the east.";
        Stairs.south_name = "The hallway is to the south.";
        Stairs.description = "There is a very strange looking man, who looks very emaciated, yelling something incomprehensible about dragons here.";
        Stairs.room_north = Street;
        Stairs.room_south = Hallway;
        Stairs.hasMonster = true;
    };
    
         static
    {
        Hallway = new Room();
        Hallway.room_name = "Hallway";
        Hallway.north_name = "You see stairs to the street to your north.";
        Hallway.west_name = "Your roommate Bill is in the hallway to your west. You can TALK to him.";
        Hallway.east_name = "A blank wall is to the east.";
        Hallway.south_name = "Your bedroom is to the south.";
        Hallway.description = "You hear someone yelling something incomprehensible about dragons somewhere down the stairs.";
        Hallway.room_north = Stairs;
        Hallway.room_south = Bedroom;
    };
    
    
    //Bedroom
    static
    {
        Bedroom = new Room();
        Bedroom.room_name = "Bedroom";
        Bedroom.north_name = "You see a hallway to your north.";
        Bedroom.west_name = "You see a bag of clothes to your west.";
        Bedroom.east_name = "An elephant statue lies on your right, next to a big pink wall.";
        Bedroom.south_name = "To your south is a bare wall with a picture of Darth Vader in a blond ponytail for some reason.";
        Bedroom.description = "There is a small bedside table with an mp3 player and a book named 'The Dragon Inside of You', which is your favorite self 'help' book. IT has lots of... pictures.";
        Bedroom.room_north = Hallway;
    };
    
    
    

    



}
