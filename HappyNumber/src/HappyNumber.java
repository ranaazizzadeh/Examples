import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {

        FunctionalHappy happyFunction = number ->{
            Set<Integer> set = new HashSet<>();
            Integer sum,digit;
            while (set.add(number)){
                sum = 0;
                while (number>0){
                    digit = number % 10;
                    sum += digit * digit;
                    number = number / 10;
                }
                if (sum == 1) return true;
                else  number = sum;
            }
            return false;
        };
        System.out.println(happyFunction.isHappy(12));
    }
}
