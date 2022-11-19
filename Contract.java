import java.util.ArrayList;
import java.util.Scanner;

public interface Contract {

    void grab(String item);
    String drop(String item);
    void examine(String item);
    void use(String item);
    boolean walk(String direction);
    boolean fly(int x, int y);
    Number shrink();
    Number grow();
    void rest();
    void undo();

}
/** Runs a video game containing various methods that complete actions for the user. */
 class VideoGame implements Contract {
    public int size = 5;
    public int position = 0;
    public static ArrayList<String> inventory = new ArrayList<String>();

    /** Allows the user to pick up an item and add it to their inventory
     * @param item the name of the item to pick up
     */
    public void grab(String item) {
        System.out.println("You have picked up the " + item + ". It has been added to your inventory.");
        inventory.add(item);
    }
    /** Prints the current inventory to the terminal */
    public void printInventory() {
        System.out.println("Current inventory: " + inventory);
    }
    /** Allows the user to drop an item, thus removing it from their inventory, does not work if the item is not currently in the inventory
     * @param item the name of the item to drop
     */
    public String drop(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);   
            System.out.println("You have dropped the " + item + ". It has been removed from your inventory.");
        }
        else if (!inventory.contains(item)) {
            System.out.println("Sorry, you cannot drop an item that is not in your inventory!");
        }
        return item;
    }
    /** Allows the user to examine an item, does not work if the item is not currently in the inventory
     * @param item the name of the item to examine
     */
    public void examine(String item) {
        if (inventory.contains(item)) {
            System.out.println("You are examining the " + item);
        }
        else if (!inventory.contains(item)) {
            System.out.println("Sorry, you cannot examine an item that is not in your inventory!");
        }
    }
    /** Allows the user to use an item, does not work if the item is not currently in the inventory
     * @param item the name of the item to use
     */
    public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("You are using the " + item); 
        }
        else if (!inventory.contains(item)) {
            System.out.println("Sorry, you cannot use an item that is not in your inventory!");
        }
    }
    /** Allows the user to walk in a specified direction
     * @param direction the direction to walk in
     */
    public boolean walk(String direction) {
        System.out.println("You are walking " + direction);
        return true;
    }
    /** Allows the user to fly a specific amount in the x and y directions
     * @param x amount of feet to fly horizontally
     * @param y amount of feet to fly vertically
     */
    public boolean fly(int x, int y) {
        System.out.println("You have flown " + x + " feet horizontally and " + y + " feet vertically.");
        position = position + (x*y);
        System.out.println("You are now at position " + position + ".");
        return true;
    }
    /** Allows the user to decrement their size by one inch */
    public Number shrink() {
        size = size - 1;
        System.out.println("You have shrunk by an inch, you are now " + size + " inches tall!");
        return size;
    }
    /** Allows the user to increment their size by one inch */
    public Number grow() {
        size = size + 1;
        System.out.println("You have grown by an inch, you are now " + size + " inches tall!");
        return size;
    }
    /** Allows the user to be at rest */
    public void rest() {
        System.out.println("You are now at rest.");
    }
    /** Allows the user to undo an action */
    public void undo() {
        System.out.println("Action undone.");
    }
    /** Main method, runs a video game based on user input */
    public static void main(String[] args) {
        VideoGame myGame = new VideoGame();
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());
        System.out.println("How many times would you like to complete an action?");
        int number = Integer.parseInt(input.next());
        for (int i = 0; i < number; i++) {
            System.out.println("Would you like to grab, drop, use, or examine an item; would you like to walk, fly, or rest; would you like to grow or shrink; would you like to undo an action; or would you like to print your current inventory?");
            String action = input.next();
            if (action.equals("grab")) {
                System.out.println("What item would you like to grab?");
                String grabItem = input.next();
                myGame.grab(grabItem);
            }
            else if (action.equals("drop")) {
                System.out.println("What item would you like to drop?");
                String dropItem = input.next();
                myGame.drop(dropItem);
            }
            else if (action.equals("examine")) {
                System.out.println("What item would you like to examine?");
                String examineItem = input.next();
                myGame.examine(examineItem);
            }
            else if(action.equals("use")) {
                System.out.println("What item would you like to use?");
                String useItem = input.next();
                myGame.use(useItem);
            }
            else if(action.equals("walk")) {
                System.out.println("What direction would you like to walk in?");
                String inputDirection = input.next();
                myGame.walk(inputDirection);
            }
            else if(action.equals("fly")) {
                System.out.println("How far would you like to fly horizontally?");
                int xCoord = Integer.parseInt(input.next());
                System.out.println("How far would you like to fly vertically?");
                int yCoord = Integer.parseInt(input.next());
                myGame.fly(xCoord,yCoord);
            }
            else if(action.equals("grow")) {
                myGame.grow();
            }
            else if(action.equals("shrink")) {
                myGame.shrink();
            }
            else if(action.equals("rest")) {
                myGame.rest();
            }
            else if(action.equals("undo")) {
                myGame.undo();
            }
            else if(action.equals("print inventory")) {
                myGame.printInventory();
            }
            else {
                System.out.println("Sorry, " + action + " is not a possible action in this game!");
            }

        }
        input.close();
    }
 }