import java.util.ArrayList;
/**
 * Player. A class that hold information about a player or collection of players
 * 
 * @author Andrew Yiannaki 
 * @version v1.0 13.05.2015
 */
public class Player
{
    // instance variables
    String playerName;
    int playerAge;
    double playerCarryLimit;
    Room currentRoom;
    ArrayList<Item> items;
    
    

    /**
     * Constructor for objects of class Player
     */
    public Player(String playerName, int playerAge, double playerCarryLimit, Room currentRoom)
    {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerCarryLimit = playerCarryLimit;
        this.currentRoom = currentRoom;
        items = new ArrayList<Item>();
    }

    /**
     * takeItem. Enables a player to take an item
     * 
     * @param Item. An item object
     */
    public void takeItem(Item item)
    {
        if (checkNewWeight(item)) {
            items.add(item);
        } 
    }
    
    /**
     * dropItem. Enables a player to drop an item
     * 
     */
    public void dropItem(int arrayIndex)
    {
        items.remove(arrayIndex);
    }
    
    public boolean checkNewWeight(Item newItem)
    {
        double currentWeight = 0.0;
        double newWeight = 0.0;
        
        for (Item currentItem : items) {
            currentWeight += currentItem.getWeight();
        }
        
        newWeight = currentWeight + newItem.getWeight();
        
        if (newWeight > playerCarryLimit) {
            return false;
        }
        else {
            return true;
        }
    }
}
