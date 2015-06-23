import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    
   //string - the name of the exit
   //Room - the room object
   private HashMap<String, Room> exits;
    

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        
        //initialise the exits collections
        exits = new HashMap<String, Room>();
    }

    
    
    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            //northExit = north;
            exits.put("north", north);
        if(east != null)
            //eastExit = east;
            exits.put("east", east);
        if(south != null)
            //southExit = south;
            exits.put("south", south);
        if(west != null)
            //westExit = west;
            exits.put("west", west);
            
    }
    
    /**
     * getExit 
     * 
     * @param String.  the specified direction
     * @return Room.    Room Object
     */
    public Room getExit(String direction)
    {
        /*
         * 
         if (direction.equals("north")) {
            return northExit;
        }
        if (direction.equals("south")) {
            return southExit;
        }
        if (direction.equals("east")) {
            return eastExit;
        }
        if (direction.equals("west")) {
            return westExit;
        }
        */
       
       return exits.get(direction);
       
        //return null;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * printLocation. Prints the location of the user
     */
    public void printLocation()
    {
        System.out.println("You are " + getDescription());
        System.out.print("Exits: ");
        if(northExit != null) {
        //if(exits.get("north") != null) {
            System.out.print("north ");
        }
        if(eastExit != null) {
        //if(exits.get("east") != null) {
            System.out.print("east ");
        }
        if(southExit != null) {
        //if(exits.get("south") != null) {
            System.out.print("south ");
        }
        if(westExit != null) {
        //if(exits.get("west") != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

}
