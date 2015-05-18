import java.util.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Andrew Yiannaki
 * @version v1.0 15.05.2015
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> roomHistory;
    
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        roomHistory = new Stack<Room>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university", new Task("Addition", 20, "Add 34 to 74"));
        theater = new Room("in a lecture theater", new Task("Subtraction", 20, "Subtract 102 from 274"));
        pub = new Room("in the campus pub", new Task("Multiplication", 20, "Multiply 72 * 7"));
        lab = new Room("in a computing lab", new Task("Division", 20, "Divide 81 by 9"));
        office = new Room("in the computing admin office", null);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
    }
    
    /**
     * Create tasks for all the room
     */
    private void createTasks()
    {
        
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
                
            case BACK:
                goBack(command);
                break;
                
            case ACCEPT:
                acceptTask();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
       
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        
        //check if the room is locked.  If it is, print message and return out of the function
        if (currentRoom.getRoomLocked())
        {
            System.out.println("This room is locked. You cant get out at this time.");
            return;
        }
   

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            roomHistory.push(currentRoom);
          
            enterRoom(nextRoom);
        }
    }
    
    
    private void goBack(Command command)
    {
        if(command.hasSecondWord()) {
            // if there is no second word, print the following message and return
            System.out.println("Back should be used as one single word command");
            return;
        }
        
        //if the roomHistory stack is empty, then inform the player they are back to where they first started the game.
        if (roomHistory.empty()) {
            System.out.println("You are back to where you first started out in the game!");
        }
        else
        {
            Room previousRoom = (Room) roomHistory.pop();
            enterRoom(previousRoom);
        }
    }
    
    /**
     * Enters the specified room and prints the description.
     */
    private void enterRoom(Room nextRoom) {
        currentRoom = nextRoom;
        System.out.println(currentRoom.getLongDescription());
        
        //check if the room has a task. If it has ask the user if they want to accept it.
        //if they say yes, they must complete the task in time allowed.
        if (currentRoom.getTask() != null) {
            System.out.println("There is a " + currentRoom.getTask().getTaskName() + " task. Do you wish to accept this task?");
        }
        
    }
    
    /**
     * acceptTask. Sets the parameters in the event of task being accepted.
     * i.e. lock the door, start the timer.
     */
    private void acceptTask()
    {
        
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
