
/**
 * Public class TransporterRoom.
 * 
 * 
 * @author Andrew Yiannaki
 * @version v1.0 27/06/15
 */
public class TransporterRoom extends Room
{
    
    private Game theGame;

    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(Game theGame)
    {
        super("Transporter Room", null);
        this.theGame = theGame;
    }

    
    /**
     * Returns a random room. Independent of the direction
     * 
     * @param direction ignored
     * @return A random room
     */
    
    public Room getExit(String direction)
    {
        return findRandomRoom();
    }
    
    /**
     * Choose a random room
     * @return A random room
     */
    private Room findRandomRoom()
    {
        return theGame.getRandomRoom();
    }
}
