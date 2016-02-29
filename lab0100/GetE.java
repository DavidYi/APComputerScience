
/**
 * Created by David on 11/25/2015.
 */
public class GetE { //need to use command prompt to run
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double e = 1;
        double temp = 1;
        for (int i = n - 1; i > 0; i--){
            for (int j = i; j > 0; j--){
                temp *= j;
            }
            e += (1/temp);
            temp = 1;
        }

        System.out.println(e);

    }
}
