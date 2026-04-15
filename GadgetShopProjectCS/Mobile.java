
public class Mobile extends Gadget {

    // How much calling credit is left
    private int credit;


    // Constructor for Mobile
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }


    // Get the current credit
    public int getCredit() {
        return credit;
    }


    // Add more credit (if amount is positive)
    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
        } else {
            System.out.println("Error: Invalid credit amount");
        }
    }


    // Try to make a call. If enough credit, reduce credit and print info.
    public void makeCall(String number, int duration) {
        if (credit >= duration) {
            System.out.println("Calling " + number + " for " + duration + " minutes");
            credit -= duration;
        } else {
            System.out.println("Not enough credit");
        }
    }


    // Print out all the mobile details
    @Override
    public void display() {
        super.display();
        System.out.println("Credit: " + credit);
    }
}