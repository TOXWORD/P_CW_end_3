import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class ItemHandler {

    private List<Item> items;
    private List<Item> sorted;

    ItemHandler() {
        items = new ArrayList<>();
        sorted = new ArrayList<>();
    }

    public void readFromFile(String pathIn) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(pathIn))) {
            while (sc.hasNextLine()) {
                //Для подобного вида ввода файл ввода должен быть корректен: на каждой строке 4 элемента строго нужного формата
                items.add(new Item(sc.next(), sc.next(), Double.parseDouble(sc.next()), Integer.parseInt(sc.next())));
            }
        }
    }

    public void writeToFile(String pathOut) throws FileNotFoundException {
        try (PrintStream ps = new PrintStream(pathOut)) {
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                ps.println(iter.next());
            }
        }
    }

    public void sort() {

        sorted = items.stream().sorted((item, t1) -> {
            if (item.getName().compareToIgnoreCase(t1.getName()) != 0) {
                return item.getName().compareToIgnoreCase(t1.getName());
            } else if (item.getMaker().compareToIgnoreCase(t1.getMaker()) != 0) {
                return item.getMaker().compareToIgnoreCase(t1.getMaker());
            } else {
                return Double.compare(item.getPrice(), t1.getPrice());
            }
        }).collect(Collectors.toList());

    }

    public void printSorted(String pathOut) throws FileNotFoundException {
        try (PrintStream ps = new PrintStream(pathOut)) {
            Iterator<Item> iter = sorted.iterator();
            while (iter.hasNext()) {
                ps.println(iter.next());
            }
        }
    }

    public void filterByName(String name) {
        sorted = items.stream().filter(item -> item.getName().equals(name)).collect(Collectors.toList());
    }

    public void filterByNM(String name, String maker) {
        sorted = items.stream().filter(item -> item.getName().equals(name) && item.getMaker().equals(maker)).collect(Collectors.toList());
    }

    public void filterByNMP(String name, String maker, double price){
        sorted = items.stream().filter(item -> item.getName().equals(name) && item.getMaker().equals(maker) && item.getPrice() < price).collect(Collectors.toList());
    }
}
