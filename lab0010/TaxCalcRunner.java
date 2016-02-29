package lab0010;

/**
 * Created by David on 10/29/2015.
 */
public class TaxCalcRunner {//used to test TaxCalc

    public static void main(String[] args) {
        TaxCalc myCalc = new TaxCalc();
        System.out.println(myCalc.oldTax(45000.57));
        System.out.println(myCalc.newTax(1000000));
        System.out.println(myCalc.taxDifference(10000000));
    }

}
