package lab0010;

import java.text.DecimalFormat;

/**
 * Created by David on 10/29/2015.
 */
public class TaxCalc {//use separate file to run like TaxCalcRunner.java

    double oldt, newt, tdiff, first, second, third, fourth;
    DecimalFormat formatter = new DecimalFormat("#,###.00");

    /*
     * oldTax returns the old tax, rounded to the nearest penny, properly
     * formatted with dollar signs and commas, such as “$4,564.25"
     */
    public String oldTax(double income) {
        first = 0.1 * (17400);
        second = 0.15 * (70700 - 1740) + first;
        third = 0.25 * (142700 - 70700) + second;
        fourth = 0.28 * (217450 - 142700) + third;
        if (income <= 17400) {
            oldt = 0;
        } else if (income <= 70699.99) {
            oldt = first + .15 * (income - 17400);
        } else if (income <= 142699.99) {
            oldt = second + .25 * (income - 70700);
        } else if (income <= 217449.99) {
            oldt = third + .28 * (income - 142700);
        } else {
            oldt = fourth + .33 * (income - 217450);
        }

        return "$" + formatter.format(oldt);
    }

    /* newTax returns the net tax in the same format as above */
    public String newTax(double income) {
        first = 0.1 * (17400);
        second = 0.15 * (70700 - 1740) + first;
        third = 0.25 * (142700 - 70700) + second;
        fourth = 0.28 * (217450 - 142700) + third;
        if (income <= 17400) {
            newt = 0;
        } else if (income <= 70699.99) {
            newt = first + .15 * (income - 17400);
        } else if (income <= 142699.99) {
            newt = second + .25 * (income - 70700);
        } else if (income <= 217449.99) {
            newt = third + .28 * (income - 142700);
        } else {
            newt = .33 * (income);
        }

        return "$" + formatter.format(newt);
    }

    /*
     * taxDifference returns the new tax minus the old tax. For low incomes,
     * should return “$0.00”
     */
    public String taxDifference(double income) {
        if (income <= 17400) {
            return "$0.00";
        } else {
            newTax(income);
            oldTax(income);
            tdiff = newt - oldt;
            return "$" + formatter.format(tdiff);
        }
    }

}
