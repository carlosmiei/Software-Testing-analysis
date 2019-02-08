import java.util.Arrays;

public class Teste {


    public static void main(String[] args){

        int[] values = {3,6,8,7,9,5};
        int result = 0;
        for (int v : values) {
            int i1 = v * v;
            result += i1;
        }
        System.out.println(result);

        //Manualmente for
        int sum=0;
        for (int i=0; i<values.length;i++) {

            sum= sum + (values[i]*values[i]);
        }

        System.out.println(sum);
    }





}
