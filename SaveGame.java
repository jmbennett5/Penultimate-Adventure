
/**
 * Write a description of class saveGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class SaveGame extends GM {
    public static void saveGame(Room currentRoom) {
        try {
            FileOutputStream fileOut = new FileOutputStream("savegame.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(currentRoom);
            objectOut.close();
            fileOut.close();
            System.out.println("Game saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Room loadGame() {
        Room savedRoom = null;
        try {
            FileInputStream fileIn = new FileInputStream("savegame.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            savedRoom = (Room) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedRoom;
    }
    
}