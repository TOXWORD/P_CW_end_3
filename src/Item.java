public class Item {

    private String name;
    private String maker;
    private double price;
    private int number;

    public Item() {
        new Item("", "", 0.0, 0);
    }

    public Item(String name, String maker, double price, int number) {
        this.name = name;
        this.maker = maker;
        this.number = number;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMaker() {
        return maker;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return name + " " + maker + " " + price + " " + number;
    }

}
