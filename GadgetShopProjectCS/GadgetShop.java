
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
    private JButton addMobileBtn, addMP3Btn, clearBtn, makeCallBtn, downloadBtn;

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
        frame.setSize(800, 700);
        frame.getContentPane().setBackground(new Color(240, 248, 255));

        // title label
        JLabel titleLabel = new JLabel("Welcome to Gadget Shop", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Create tabbed pane for different operations
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(240, 248, 255));

        // Tab 1: Add Gadgets
        JPanel addGadgetPanel = createAddGadgetPanel();
        tabbedPane.addTab("Add Gadgets", addGadgetPanel);

        // Tab 2: Operations (Make Call, Download Music)
        JPanel operationsPanel = createOperationsPanel();
        tabbedPane.addTab("Operations", operationsPanel);

        // Tab 3: Display & Manage
        JPanel displayPanel = createDisplayPanel();
        tabbedPane.addTab("View Gadgets", displayPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);

        // footer with clear button
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(240, 248, 255));
        clearBtn = new JButton("Clear All Fields");
        clearBtn.setBackground(new Color(255, 165, 0));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 12));
        clearBtn.addActionListener(e -> clearFields());
        footerPanel.add(clearBtn);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Create Add Gadget Tab
    private JPanel createAddGadgetPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Common fields section
        JLabel commonLabel = new JLabel("Common Fields:");
        commonLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(commonLabel, gbc);
        gbc.gridwidth = 1;

        // Model
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        modelField = new JTextField(20);
        panel.add(modelField, gbc);

        // Price
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Price (£):"), gbc);
        gbc.gridx = 1;
        priceField = new JTextField(20);
        panel.add(priceField, gbc);

        // Weight
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Weight (g):"), gbc);
        gbc.gridx = 1;
        weightField = new JTextField(20);
        panel.add(weightField, gbc);

        // Size
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Size:"), gbc);
        gbc.gridx = 1;
        sizeField = new JTextField(20);
        panel.add(sizeField, gbc);

        // Mobile section
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        JSeparator sep1 = new JSeparator();
        panel.add(sep1, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        JLabel mobileLabel = new JLabel("Mobile Phone - Credit (minutes):");
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(mobileLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 7;
        panel.add(new JLabel("Credit:"), gbc);
        gbc.gridx = 1;
        creditField = new JTextField(20);
        panel.add(creditField, gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        addMobileBtn = new JButton("✓ Add Mobile");
        addMobileBtn.setBackground(new Color(34, 139, 34));
        addMobileBtn.setForeground(Color.WHITE);
        addMobileBtn.setFont(new Font("Arial", Font.BOLD, 12));
        addMobileBtn.addActionListener(e -> addMobile());
        gbc.gridwidth = 2;
        panel.add(addMobileBtn, gbc);
        gbc.gridwidth = 1;

        // MP3 section
        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 2;
        JSeparator sep2 = new JSeparator();
        panel.add(sep2, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 2;
        JLabel mp3Label = new JLabel("MP3 Player - Memory (MB):");
        mp3Label.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(mp3Label, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 11;
        panel.add(new JLabel("Memory:"), gbc);
        gbc.gridx = 1;
        memoryField = new JTextField(20);
        panel.add(memoryField, gbc);

        gbc.gridx = 0; gbc.gridy = 12;
        addMP3Btn = new JButton("✓ Add MP3");
        addMP3Btn.setBackground(new Color(34, 139, 34));
        addMP3Btn.setForeground(Color.WHITE);
        addMP3Btn.setFont(new Font("Arial", Font.BOLD, 12));
        addMP3Btn.addActionListener(e -> addMP3());
        gbc.gridwidth = 2;
        panel.add(addMP3Btn, gbc);

        return panel;
    }

    // Create Operations Tab
    private JPanel createOperationsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Make Call section
        JLabel callLabel = new JLabel("Make a Call");
        callLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(callLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Mobile Number (Index):"), gbc);
        gbc.gridx = 1;
        displayField = new JTextField(20);
        panel.add(displayField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        phoneNumberField = new JTextField(20);
        panel.add(phoneNumberField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Duration (minutes):"), gbc);
        gbc.gridx = 1;
        durationField = new JTextField(20);
        panel.add(durationField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        makeCallBtn = new JButton("☎ Make a Call");
        makeCallBtn.setBackground(new Color(255, 69, 0));
        makeCallBtn.setForeground(Color.WHITE);
        makeCallBtn.setFont(new Font("Arial", Font.BOLD, 12));
        makeCallBtn.addActionListener(e -> makeCall());
        gbc.gridwidth = 2;
        panel.add(makeCallBtn, gbc);
        gbc.gridwidth = 1;

        // Download Music section
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        JSeparator sep = new JSeparator();
        panel.add(sep, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        JLabel downloadLabel = new JLabel("Download Music");
        downloadLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(downloadLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 7;
        panel.add(new JLabel("MP3 Player (Index):"), gbc);
        gbc.gridx = 1;
        JTextField displayField2 = new JTextField(20);
        panel.add(displayField2, gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        panel.add(new JLabel("Download Size (MB):"), gbc);
        gbc.gridx = 1;
        downloadField = new JTextField(20);
        panel.add(downloadField, gbc);

        gbc.gridx = 0; gbc.gridy = 9;
        downloadBtn = new JButton("♫ Download Music");
        downloadBtn.setBackground(new Color(255, 69, 0));
        downloadBtn.setForeground(Color.WHITE);
        downloadBtn.setFont(new Font("Arial", Font.BOLD, 12));
        downloadBtn.addActionListener(e -> {
            displayField.setText(displayField2.getText());
            downloadMusic();
        });
        gbc.gridwidth = 2;
        panel.add(downloadBtn, gbc);

        return panel;
    }

    // Create Display Tab
    private JPanel createDisplayPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("All Gadgets in Shop:");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(infoLabel, BorderLayout.NORTH);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Courier New", Font.PLAIN, 11));
        displayArea.setBackground(new Color(255, 255, 255));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton refreshBtn = new JButton("🔄 Refresh List");
        refreshBtn.setBackground(new Color(0, 102, 204));
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 12));
        refreshBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            if (gadgets.isEmpty()) {
                sb.append("No gadgets in the shop yet.\n");
            } else {
                for (int i = 0; i < gadgets.size(); i++) {
                    sb.append("═══════════════════════════════════\n");
                    sb.append("Gadget Index: ").append(i).append("\n");
                    sb.append("───────────────────────────────────\n");
                    Gadget g = gadgets.get(i);
                    sb.append("Model: ").append(g.getModel()).append("\n");
                    sb.append("Price: £").append(g.getPrice()).append("\n");
                    sb.append("Weight: ").append(g.getWeight()).append("g\n");
                    sb.append("Size: ").append(g.getSize()).append("\n");
                    if (g instanceof Mobile) {
                        sb.append("Type: MOBILE PHONE\n");
                        sb.append("Credit: ").append(((Mobile) g).getCredit()).append(" minutes\n");
                    } else if (g instanceof MP3) {
                        sb.append("Type: MP3 PLAYER\n");
                        sb.append("Memory: ").append(((MP3) g).getMemory()).append(" MB\n");
                    }
                    sb.append("\n");
                }
            }
            displayArea.setText(sb.toString());
        });
        panel.add(refreshBtn, BorderLayout.SOUTH);

        return panel;
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
            System.out.println("No gadgets in the shop.");
            return;
        }
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
                    int creditBefore = mobile.getCredit();
                    mobile.makeCall(number, duration);
                    int creditAfter = mobile.getCredit();
                    if (creditAfter < creditBefore) {
                        JOptionPane.showMessageDialog(frame, "Call made to " + number + " for " + duration + " minutes\nRemaining credit: " + creditAfter);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient credit to make call");
                    }
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