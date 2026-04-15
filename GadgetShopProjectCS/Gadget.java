
public class Gadget {

    // Gadget details
    private String model;
    private double price;
    private int weight;
    private String size;


    // Constructor for Gadget
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }


    // Get the model name
    public String getModel() {
        return model;
    }


    // Get the price
    public double getPrice() {
        return price;
    }


    // Get the weight
    public int getWeight() {
        return weight;
    }


    // Get the size
    public String getSize() {
        return size;
    }


    // Print out all the gadget details
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
    }
}