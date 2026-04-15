
public class Mobile extends Gadget {
    // credit for the mobile
    private int credit;

    // constructor for mobile
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    // get the credit
    public int getCredit() {
        return credit;
    }

    // add credit to the mobile
    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
        } else {
            System.out.println("Error: Invalid credit amount");
        }
    }

    // make a call with the mobile
    public void makeCall(String number, int duration) {
        if (credit >= duration) {
            System.out.println("Calling " + number + " for " + duration + " minutes");
            credit -= duration;
        } else {
            System.out.println("Not enough credit");
        }
    }

    // display the mobile info
    @Override
    public void display() {
        super.display();
        System.out.println("Credit: " + credit);
    }
}