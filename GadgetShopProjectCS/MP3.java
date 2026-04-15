
public class MP3 extends Gadget {
    // memory for the mp3
    private int memory;

    // constructor for mp3
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    // get the memory
    public int getMemory() {
        return memory;
    }

    // download music to the mp3
    public void downloadMusic(int size) {
        if (memory >= size) {
            memory -= size;
            System.out.println("Downloaded music, remaining memory: " + memory);
        } else {
            System.out.println("Not enough memory");
        }
    }

    // delete music from the mp3
    public void deleteMusic(int size) {
        memory += size;
        System.out.println("Deleted music, available memory: " + memory);
    }

    // display the mp3 info
    @Override
    public void display() {
        super.display();
        System.out.println("Memory: " + memory);
    }
}