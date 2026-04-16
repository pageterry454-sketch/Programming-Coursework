

// Mobile class for uni project
public class Mobile extends Gadget {
    // credit in minutes
    private int credit;

    // constructor
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
        // System.out.println("Mobile created: " + model); // debug
    }

    // get credit
    public int getCredit() {
        return credit;
    }

    // add credit
    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
        } else {
            System.out.println("Error: Invalid credit amount");
        }
    }

    // make a call
    public void makeCall(String number, int duration) {
        if (credit >= duration) {
            System.out.println("Calling " + number + " for " + duration + " minutes");
            credit -= duration;
        } else {
            System.out.println("Not enough credit");
        }
    }

    // print details
    @Override
    public void display() {
        super.display();
        System.out.println("Credit: " + credit);
        // System.out.println("--- end of mobile ---");
    }
}