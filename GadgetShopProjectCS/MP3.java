
public class MP3 extends Gadget {

    // How much memory is left (MB)
    private int memory;


    // Constructor for MP3 player
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }


    // Get the available memory
    public int getMemory() {
        return memory;
    }


    // Try to download music. Returns true if successful.
    public boolean downloadMusic(int size) {
        if (memory >= size) {
            memory -= size;
            return true;
        } else {
            return false;
        }
    }


    // Delete music and free up memory
    public void deleteMusic(int size) {
        memory += size;
    }


    // Print out all the MP3 details
    @Override
    public void display() {
        super.display();
        System.out.println("Memory: " + memory);
    }
}