import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println("please enter the world to check: ");
        String world = new Scanner(System.in).nextLine();
        System.out.println(isPalindrome(world));

    }

    public static boolean isPalindrome(String text){
        if (text.equals(null)) return false;
        int startIndex = 0;
        int endIndex = text.length() - 1;
        while (startIndex<endIndex){
            if(text.charAt(startIndex) != text.charAt(endIndex)) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
