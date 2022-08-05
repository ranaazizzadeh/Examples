import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecomposeNumber {
    public static void main(String[] args) {
        String number = "839";
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < number.length(); i++) {
            indexMap.put(i,Character.getNumericValue(number.charAt(i)));
        }

        List<String> listOfNumbers = new ArrayList<>();

        while ( ! indexMap.values().stream().allMatch(x-> x == 0)){
            List<Integer> eachItem = new ArrayList<>();
            indexMap.entrySet().stream().forEach(
                    (x) -> {
                        eachItem.add(x.getKey(),x.getValue() > 0 ? 1 : 0);
                        x.setValue(x.getValue() > 0 ? x.getValue() -1 : 0);
                    });
            listOfNumbers.add(eachItem.stream().map(n->String.valueOf(n))
                                .collect(Collectors.joining("")));
        }
        System.out.println(listOfNumbers);
    }
}

