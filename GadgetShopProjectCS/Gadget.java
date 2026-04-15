
public class Gadget {
    // these are the attributes for the gadget
    private String model;
    private double price;
    private int weight;
    private String size;

    // constructor to make a new gadget
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // getter for model
    public String getModel() {
        return model;
    }

    // getter for price
    public double getPrice() {
        return price;
    }

    // getter for weight
    public int getWeight() {
        return weight;
    }

    // getter for size
    public String getSize() {
        return size;
    }

    // method to display the gadget info
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
    }
}