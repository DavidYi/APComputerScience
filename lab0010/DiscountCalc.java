package lab0010;

/**
 * Created by David on 10/29/2015.
 */
public class DiscountCalc {//use separate file to run like DiscountRunner.java

    public double calculateTheDiscount(int numOfItems, double cost) {
        double discount;

        if (numOfItems <= 5 && numOfItems >= 1) {
            discount = .1;
        } else if (numOfItems <= 10) {
            discount = .09;
        } else {
            discount = 0;
        }
        cost *= (1 - discount);

        cost = ((int) ((100 * cost) + .5)) / 100.0;

        return cost;
    }

}
