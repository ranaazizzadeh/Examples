import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {


        System.out.println(mapCharactersToCharacterFrequency("aabd"));
        System.out.println(isCharacterFrequencyUnique(mapCharactersToCharacterFrequency("acaccdbda")));
        System.out.println(isCharacterFrequencyUnique(mapCharactersToCharacterFrequency("acaccdbda")));
        printStringBasedOnCharacterFrequency("addcc");
    }

    private static Map<Character, Integer> mapCharactersToCharacterFrequency(String str) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char ch : str.toCharArray())
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        return characterFrequencyMap;
    }

    public static boolean isCharacterFrequencyUnique(Map<Character, Integer> characterFrequencyMap) {
        return
                characterFrequencyMap.keySet().stream().count() ==
                        characterFrequencyMap.values().stream().distinct().count();
    }

    public static void printStringBasedOnCharacterFrequency(String str) {

        Map<Character, Integer> characterIntegerMap = mapCharactersToCharacterFrequency(str);
        LinkedHashMap<Character, Integer> collect = characterIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));


        List<Character> characterList = new ArrayList<>();


        System.out.println(collect);

    }

}
