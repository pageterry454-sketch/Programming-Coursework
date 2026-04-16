

// MP3 class for uni project
public class MP3 extends Gadget {
    // memory in MB
    private int memory;

    // constructor
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
        // System.out.println("MP3 created: " + model); // debug
    }

    // get memory
    public int getMemory() {
        return memory;
    }

    // download music
    public boolean downloadMusic(int size) {
        if (memory >= size) {
            memory -= size;
            return true;
        } else {
            return false;
        }
    }

    // delete music
    public void deleteMusic(int size) {
        memory += size;
    }

    // print details
    @Override
    public void display() {
        super.display();
        System.out.println("Memory: " + memory);
        // System.out.println("--- end of mp3 ---");
    }
}