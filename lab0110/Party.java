package lab0110;

/**
 * Created by David on 1/15/2016.
 */
public class Party {
    /* Default age range is between 13 and 18, inclusive */
    private int maxAge;
    private int minAge;

    /* Default maximum amount of people is 10 */
    private int maxPeople;

    /* The Default list of things they can bring include chicken,
    cake, salad, pie, punch, chips, wings, pretzels, salsa, pasta */
    private String[] allowableFoods;
    private String[] listOfAdmitted;

    // Basic Default constructor sets numbers
    public Party() {
        maxAge = 18;
        minAge = 13;
        maxPeople = 10;

        String[] temp = {"chicken","cake", "salad", "pie", "punch", "chips", "wings", "pretzels", "salsa", "pasta"};
        allowableFoods = temp;
    }

    // Basic constructor assigns variables
    public Party(int maxAge, int minAge, int maxPeople, String[] foodList) {
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.maxPeople = maxPeople;
        this.allowableFoods = foodList;
    }

    /* These are accessor and return what is specified */
    public int getMaxAge() {
        return maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public String[] getFoodList() {
        return allowableFoods;
    }

    public String[] getlistOfAdmitted() {
        return listOfAdmitted;
    }

    /* Checks if they have food (if food is in the foodList), if they are admitted,
    if they are older than the age limit, if they have the ticket, makes sure they
    are not already on the people list, and if they follow the dress code. Adds the person to the people list */
    public void admit(PartyGoer person) {
        boolean food = false;
        boolean isAdmitted = true;
        if (findElement(person.getFood(), allowableFoods) != 1)
            food = true;
        if (findElement(person.getName(), listOfAdmitted) == -1)
            isAdmitted = false;

        if ((food) && !(isAdmitted)) {
            String[] temp = new String[listOfAdmitted.length + 1];

            for (int i = 0; i < listOfAdmitted.length; i++)
                temp[i] = listOfAdmitted[i];

            temp[listOfAdmitted.length] = person.getName();
            listOfAdmitted = temp;
        }
    }

    public int findElement(String s, String[] sA){
        for (int i = 0; i < sA.length; i++){
            if (sA[i].equals(s))
                return i;
        }
        return -1;
    }

    /* Checks if the person is in the list. If so, it will make that spot null */
    public void kickOut(PartyGoer person) {
        int index = findElement(person.getName(), listOfAdmitted);
        if (index != -1){
            listOfAdmitted[index] = null;
        }
    }

    /* Checks to see if the person is admitted already. */
    public boolean isAdmitted(PartyGoer person) {
        return (findElement(person.getName(), listOfAdmitted) != -1);
    }

}
