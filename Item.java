
/**
 * Item class. This class describes an item in the game.
 * An item can either be in a room or held by a player
 * 
 * @author Andrew Yiannaki
 * @version v1.0 12.05.2015
 */
public class Item
{
    //Item fields
    private String itemName;
    private String itemDescription;
    private String itemColour;
    private double itemWeight;
    

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, String itemDescription, String itemColour, double itemWeight)
    {
        // initialise Item Fields
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemColour = itemColour;
        this.itemWeight = itemWeight;
    }
    
    /**
     * getName. Get the Name of the item.
     *
     * @return     String. The Item Name
     */
    public String getName()
    {
        return this.itemName;
    }
    
    /**
     * setName. Set the name of the item.
     *
     * @param    String The Item Name
     */
    public void setNamme(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * getDescription. Get the description of the item.
     *
     * @return     String. The Item Description
     */
    public String getDescription()
    {
        return this.itemDescription;
    }
    
    /**
     * setDescription. Set the description of the item.
     *
     * @param    String The Item Description
     */
    public void setDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }
    
    /**
     * getColour. Get the colour of the item.
     *
     * @return     String. The Item Colour
     */
    public String getColour()
    {
        return this.itemColour;
    }
    
    /**
     * setColour. Set the description of the item.
     *
     * @param    String The Item Colour
     */
    public void setColour(String itemColour)
    {
        this.itemColour = itemColour;
    }
    
     /**
     * getWeight. Get the weight of the item.
     *
     * @return     double. The Item Weight
     */
    public double getWeight()
    {
        return this.itemWeight;
    }
    
    /**
     * setWeight. Set the weight of the item.
     *
     * @param    double The Item Weight
     */
    public void setWeight(double setWeight)
    {
        this.itemWeight = itemWeight;
    }
    
    
    
    
    
    
}
