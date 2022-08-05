import java.util.List;
import java.util.Scanner;

public class MainClass {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("please enter the size of first list");
        Integer firstListSize = scanner.nextInt();
        List<Integer> firstList = ListOperation.getListMembers(firstListSize);

        System.out.println("please enter the size of second list");
        Integer secondListSize = scanner.nextInt();
        List<Integer> secondList = ListOperation.getListMembers(secondListSize);

        Long sumOfNumbers =
                ListOperation.changeListToReversedNumber(firstList) +
                ListOperation.changeListToReversedNumber(secondList);

        List<Integer> resultList = ListOperation.convertNumberToReversedList(sumOfNumbers);
        System.out.println(resultList);
    }

}


