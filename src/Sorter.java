import java.util.ArrayList;
import java.util.Scanner;

public class Sorter {

    private static ArrayList<String> userInput = new ArrayList<>();

    private static void reverse(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            String element = array.get(i);
            String setter = "";
            for (int k = 0; k < element.length(); k++) {
                char temp = element.charAt(element.length() - k - 1);
                setter += temp;
            }
            array.set(i, setter);
        }
    }

    private static void alhabetize(ArrayList<String> array) {
        int length = array.size();
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                String index1 = array.get(i);
                String index2 = array.get(j);
                if (index2.compareTo(index1) < 0) {
                    minIndex = j;
                }
            }
            String temp = array.get(i);
            array.set(i, array.get(minIndex));
            array.set(minIndex, temp);
        }
        userInput = array;
    }

    private static void print(ArrayList<String> arrayList) {
        arrayList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Type your input. Enter in \"-h\" if you need help.");
        Scanner in = new Scanner(System.in);
        String input;

        boolean reverse = false;
        boolean alphabetize = false;

        while (in.hasNextLine()) {
            input = in.nextLine();
            if (input.contains("-r")) {
                reverse = true;
                break;
            } else if (input.contains("-a")) {
                alphabetize = true;
                break;
            } else if (input.contains("-q")) {
                break;
            } else if (input.contains("-h")) {
                System.out.println("Need some help? " +
                        "Don't worry!\n The commands for this program are: \n" +
                        "\"-q\": END INPUT INTO AND ECHO\n" +
                        "\"-r\": REVERSE INPUT ECHO\n" +
                        "\"-a\": SLPHABETZE INPUT IN ACENDING ORDER AND ECHO BACK\n");
            } else {
                userInput.add(input.toLowerCase());
            }
        }
        in.close();

        if (reverse) {
            reverse(userInput);
            print(userInput);
        } else if (alphabetize) {
            alhabetize(userInput);
            print(userInput);
        } else {
            print(userInput);
        }
        System.out.println("--------------------------");
        System.out.println("Thank you for using Sorter");
        System.out.println("--------------------------");
    }
}
