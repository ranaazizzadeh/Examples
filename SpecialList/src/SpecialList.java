import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpecialList {
    public static void main(String[] args) {
        List<Integer> earlyList = Arrays.asList(16,17,6,2,5,3);
        System.out.println("early list: " + earlyList);
        System.out.println("result list: " + changeList(earlyList));

    }
    private static List<Integer> changeList(List<Integer> earlyList){
        List<Integer> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.addAll(earlyList);
        while (list.size()>0){
             list.remove(0);
             resultList.add(list.stream().max(Integer::compareTo).orElse(-1));
        }
        return resultList;
    }
}
