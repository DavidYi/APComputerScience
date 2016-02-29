package lab0110;

/**
 * Created by David on 1/15/2016.
 */
public class PartyGoer {
    private int age;

    /* You have to be on the list */
    private String name;

    /* Once you are admitted, you must bring a type of food. */
    private String food;

    /* There is a certain dress code you must follow at the party. */
    private boolean dressCode;

    /* Can only be admitted if you have a ticket */
    private boolean ticket;

    public PartyGoer(String name, String food, int age, boolean dressCode, boolean ticket) {
        this.name = name;
        this.food = food;
        this.age = age;
        this.dressCode = dressCode;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFood() {
        return food;
    }

    public boolean getDressCode() {
        return dressCode;
    }

    public boolean getTicket() {
        return ticket;
    }

    /* Checks if the food given is different from the original food and will print out that the member is bringing a different food. Otherwise it will print out that they are bringing the same food. */
    public void changeFood(String food){
        this.food = food;
    }

    /* Checks if the dress code is different and tells the user. */
    public void changeDressCode(boolean dressCode){
        this.dressCode = dressCode;
    }

}
