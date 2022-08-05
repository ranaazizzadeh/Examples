import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperation {
    private static Scanner scanner = new Scanner(System.in);
    static List<Integer> convertNumberToReversedList(Long number) {
        List<Integer> resultList = new ArrayList<>();
        String numberStr = number.toString();

        for (int i = numberStr.length(); i > 0; i--) {
            resultList.add(Character.getNumericValue(numberStr.charAt(i - 1)));
        }

        return resultList;
    }

    static Long changeListToReversedNumber(List<Integer> list) {
        Long number = 0l;
        for (int i = 0; i < list.size(); i++) {
            number = number +(list.get(i) * (long)Math.pow(10,i));
        }
        return number;
    }

    static List<Integer> getListMembers(Integer listSize) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            System.out.println("please enter the item for index " + i);
            list.add(scanner.nextInt());
        }
        return list;
    }
}
