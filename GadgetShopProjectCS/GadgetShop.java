
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GadgetShop {
    // list to store gadgets
    private ArrayList<Gadget> gadgets;
    // gui stuff
    private JFrame frame;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNumberField, durationField, downloadField, displayField;
    private JButton addMobileBtn, addMP3Btn, clearBtn, displayAllBtn, makeCallBtn, downloadBtn;

    // constructor for the shop
    public GadgetShop() {
        gadgets = new ArrayList<>();
        createGUI();
    }

    private void createGUI() {
        // make the main window
        frame = new JFrame("Gadget Shop - CS4001 Coursework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(550, 450);
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Light blue background

        // title label
        JLabel titleLabel = new JLabel("Welcome to Gadget Shop", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // add model field
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(modelLabel, gbc);
        gbc.gridx = 1;
        modelField = new JTextField(15);
        modelField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(modelField, gbc);

        // Row 1: Price
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(priceLabel, gbc);
        gbc.gridx = 1;
        priceField = new JTextField(15);
        priceField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(priceField, gbc);

        // Row 2: Weight
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(weightLabel, gbc);
        gbc.gridx = 1;
        weightField = new JTextField(15);
        weightField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(weightField, gbc);

        // Row 3: Size
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(sizeLabel, gbc);
        gbc.gridx = 1;
        sizeField = new JTextField(15);
        sizeField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(sizeField, gbc);

        // Row 4: Credit
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel creditLabel = new JLabel("Credit:");
        creditLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(creditLabel, gbc);
        gbc.gridx = 1;
        creditField = new JTextField(15);
        creditField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(creditField, gbc);

        // Row 5: Memory
        gbc.gridx = 0; gbc.gridy = 5;
        JLabel memoryLabel = new JLabel("Memory:");
        memoryLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(memoryLabel, gbc);
        gbc.gridx = 1;
        memoryField = new JTextField(15);
        memoryField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(memoryField, gbc);

        // Row 6: Duration
        gbc.gridx = 0; gbc.gridy = 6;
        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(durationLabel, gbc);
        gbc.gridx = 1;
        durationField = new JTextField(15);
        durationField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(durationField, gbc);

        // Row 7: Download Size
        gbc.gridx = 0; gbc.gridy = 7;
        JLabel downloadLabel = new JLabel("Download Size:");
        downloadLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(downloadLabel, gbc);
        gbc.gridx = 1;
        downloadField = new JTextField(15);
        downloadField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(downloadField, gbc);

        // Row 8: Phone Number
        gbc.gridx = 0; gbc.gridy = 8;
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(phoneNumberLabel, gbc);
        gbc.gridx = 1;
        phoneNumberField = new JTextField(15);
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(phoneNumberField, gbc);

        // Row 9: Display Number
        gbc.gridx = 0; gbc.gridy = 9;
        JLabel displayLabel = new JLabel("Display Number:");
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(displayLabel, gbc);
        gbc.gridx = 1;
        displayField = new JTextField(15);
        displayField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(displayField, gbc);

        // buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(240, 248, 255));

        // add mobile button
        addMobileBtn = new JButton("Add Mobile");
        addMobileBtn.setBackground(new Color(34, 139, 34));
        addMobileBtn.setForeground(Color.WHITE);
        addMobileBtn.setFont(new Font("Arial", Font.BOLD, 12));

        addMP3Btn = new JButton("Add MP3");
        addMP3Btn.setBackground(new Color(34, 139, 34));
        addMP3Btn.setForeground(Color.WHITE);
        addMP3Btn.setFont(new Font("Arial", Font.BOLD, 12));

        clearBtn = new JButton("Clear");
        clearBtn.setBackground(new Color(255, 165, 0));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 12));

        displayAllBtn = new JButton("Display All");
        displayAllBtn.setBackground(new Color(0, 102, 204));
        displayAllBtn.setForeground(Color.WHITE);
        displayAllBtn.setFont(new Font("Arial", Font.BOLD, 12));

        makeCallBtn = new JButton("Make a Call");
        makeCallBtn.setBackground(new Color(255, 69, 0));
        makeCallBtn.setForeground(Color.WHITE);
        makeCallBtn.setFont(new Font("Arial", Font.BOLD, 12));

        downloadBtn = new JButton("Download Music");
        downloadBtn.setBackground(new Color(255, 69, 0));
        downloadBtn.setForeground(Color.WHITE);
        downloadBtn.setFont(new Font("Arial", Font.BOLD, 12));

        buttonPanel.add(addMobileBtn);
        buttonPanel.add(addMP3Btn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(displayAllBtn);
        buttonPanel.add(makeCallBtn);
        buttonPanel.add(downloadBtn);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // action listeners for buttons
        addMobileBtn.addActionListener(e -> addMobile());
        addMP3Btn.addActionListener(e -> addMP3());
        clearBtn.addActionListener(e -> clearFields());
        displayAllBtn.addActionListener(e -> displayAll());
        makeCallBtn.addActionListener(e -> makeCall());
        downloadBtn.addActionListener(e -> downloadMusic());

        frame.setVisible(true);
    }

    // method to add mobile
    public void addMobile(String model, double price, int weight, String size, int credit) {
        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);
    }

    // method to add mp3
    public void addMP3(String model, double price, int weight, String size, int memory) {
        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);
    }

    // INPUT GETTER METHODS
    // Get model from text field
    private String getModel() {
        return modelField.getText();
    }

    // Get price from text field and convert to double
    private double getPrice() {
        try {
            return Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Price must be a decimal number");
            return -1;
        }
    }

    // Get weight from text field and convert to integer
    private int getWeight() {
        try {
            return Integer.parseInt(weightField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Weight must be an integer");
            return -1;
        }
    }

    // Get size from text field
    private String getSize() {
        return sizeField.getText();
    }

    // Get credit from text field and convert to integer
    private int getCredit() {
        try {
            return Integer.parseInt(creditField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Credit must be an integer");
            return -1;
        }
    }

    // Get memory from text field and convert to integer
    private int getMemory() {
        try {
            return Integer.parseInt(memoryField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Memory must be an integer");
            return -1;
        }
    }

    // Get phone number from text field
    private String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    // Get duration from text field and convert to integer
    private int getDuration() {
        try {
            return Integer.parseInt(durationField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Duration must be an integer");
            return -1;
        }
    }

    // Get download size from text field and convert to integer
    private int getDownloadSize() {
        try {
            return Integer.parseInt(downloadField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Download size must be an integer");
            return -1;
        }
    }

    // Get display number from text field with validation
    private int getDisplayNumber() {
        int displayNumber = -1;
        try {
            displayNumber = Integer.parseInt(displayField.getText());
            // Check if the display number is in the correct range
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(frame, "Error: Display number must be between 0 and " + (gadgets.size() - 1));
                return -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Display number must be an integer");
            return -1;
        }
        return displayNumber;
    }

    // display all gadgets
    public void displayAll() {
        if (gadgets.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No gadgets in the shop.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gadgets.size(); i++) {
            sb.append("Gadget ").append(i).append(":\n");
            Gadget g = gadgets.get(i);
            sb.append("Model: ").append(g.getModel()).append("\n");
            sb.append("Price: ").append(g.getPrice()).append("\n");
            sb.append("Weight: ").append(g.getWeight()).append("\n");
            sb.append("Size: ").append(g.getSize()).append("\n");
            if (g instanceof Mobile) {
                sb.append("Credit: ").append(((Mobile) g).getCredit()).append("\n");
            } else if (g instanceof MP3) {
                sb.append("Memory: ").append(((MP3) g).getMemory()).append("\n");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
        // Also print to console
        for (int i = 0; i < gadgets.size(); i++) {
            System.out.println("Gadget " + i + ":");
            gadgets.get(i).display();
            System.out.println();
        }
    }

    // add mobile from gui
    private void addMobile() {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int credit = getCredit();
        if (price > 0 && weight > 0 && credit >= 0 && !model.isEmpty() && !size.isEmpty()) {
            addMobile(model, price, weight, size, credit);
            JOptionPane.showMessageDialog(frame, "Mobile added successfully");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid input values");
        }
    }

    // add mp3 from gui
    private void addMP3() {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int memory = getMemory();
        if (price > 0 && weight > 0 && memory > 0 && !model.isEmpty() && !size.isEmpty()) {
            addMP3(model, price, weight, size, memory);
            JOptionPane.showMessageDialog(frame, "MP3 added successfully");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid input values");
        }
    }

    // clear all fields
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        durationField.setText("");
        downloadField.setText("");
        displayField.setText("");
    }

    // make a call
    private void makeCall() {
        int index = getDisplayNumber();
        if (index != -1) {
            String number = getPhoneNumber();
            int duration = getDuration();
            if (!number.isEmpty() && duration > 0) {
                if (gadgets.get(index) instanceof Mobile) {
                    Mobile mobile = (Mobile) gadgets.get(index);
                    mobile.makeCall(number, duration);
                    JOptionPane.showMessageDialog(frame, "Call operation completed");
                } else {
                    JOptionPane.showMessageDialog(frame, "Error: Selected gadget is not a mobile phone");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Invalid phone number or duration");
            }
        }
    }

    // download music
    private void downloadMusic() {
        int index = getDisplayNumber();
        if (index != -1) {
            int size = getDownloadSize();
            if (size > 0) {
                if (gadgets.get(index) instanceof MP3) {
                    MP3 mp3 = (MP3) gadgets.get(index);
                    mp3.downloadMusic(size);
                    JOptionPane.showMessageDialog(frame, "Download operation completed");
                } else {
                    JOptionPane.showMessageDialog(frame, "Error: Selected gadget is not an MP3 player");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Invalid download size");
            }
        }
    }

    // main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GadgetShop());
    }
}