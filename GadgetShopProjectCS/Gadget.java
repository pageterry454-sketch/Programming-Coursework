

// Gadget class for uni project
public class Gadget {
    // fields for gadget info
    private String model;
    private double price;
    private int weight;
    private String size;

    // constructor
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
        // System.out.println("Gadget created: " + model); // debug
    }

    // get model
    public String getModel() {
        return model;
    }

    // get price
    public double getPrice() {
        return price;
    }

    // get weight
    public int getWeight() {
        return weight;
    }

    // get size
    public String getSize() {
        return size;
    }

    // print details
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
        // System.out.println("--- end of gadget ---");
    }
}
}