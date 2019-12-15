import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static String pathIn = "input.txt";
    private static String pathOut = "out.txt";
    private static String pathOut1 = "out1.txt";
    private static String pathOut2 = "out2.txt";
    private static String pathOut3 = "out3.txt";
    private static String pathOut4 = "out4.txt";

    public static void main(String[] args) {
        try {
            ItemHandler ih = new ItemHandler();
            ih.readFromFile(pathIn);
            ih.writeToFile(pathOut);
            ih.sort();
            ih.printSorted(pathOut1);

            try (Scanner sc = new Scanner(System.in)) {

                System.out.println("Enter name to find: ");
                ih.filterByName(sc.next());
                ih.printSorted(pathOut2);

                System.out.println("Enter name and maker to find: ");
                ih.filterByNM(sc.next(), sc.next());
                ih.printSorted(pathOut3);

                System.out.println("Enter name, maker and price to find: ");
                ih.filterByNMP(sc.next(), sc.next(), Double.parseDouble(sc.next()));
                ih.printSorted(pathOut4);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
