import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.ArrayList;


public class GadgetShop extends Application {
    private TextArea displayArea;



    // list for all gadgets (mobiles, mp3s, etc)
    private ArrayList<Gadget> gadgets;

    // gui stuff
    private Stage frame;
    private TextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNumberField, durationField, downloadField, displayField;
    private Button addMobileBtn, addMP3Btn, clearBtn, makeCallBtn, downloadBtn;




    // set up the shop and gui

    public GadgetShop() {
        gadgets = new ArrayList<>();
    }

    // Helper to generate a random song name
    private String generateRandomSongName() {
        String[] adjectives = {"Blue", "Silent", "Electric", "Golden", "Lonely", "Wild", "Happy", "Broken", "Magic", "Neon"};
        String[] nouns = {"Dream", "Night", "Heart", "Sky", "River", "Fire", "Star", "Shadow", "Light", "Road"};
        String adj = adjectives[(int)(Math.random() * adjectives.length)];
        String noun = nouns[(int)(Math.random() * nouns.length)];
        return adj + " " + noun;
    }

    @Override
    public void start(Stage primaryStage) {
        this.frame = primaryStage;
        createGUI();
    }


    // set up the main window and all the gui bits
    private void createGUI() {
        frame.setTitle("Gadget Shop - CS4001 Coursework");

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8edea, #fed6e3);");

        Label titleLabel = new Label("Welcome to Gadget Shop");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0066cc;");
        root.getChildren().add(titleLabel);

        TabPane tabs = new TabPane();
        tabs.setStyle("-fx-background-color: rgba(255,255,255,0.85); -fx-border-color: #cccccc; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
        Tab addTab = new Tab("Add Gadgets", createAddGadgetPanel());
        Tab opsTab = new Tab("Operations", createOperationsPanel());
        Tab viewTab = new Tab("View Gadgets", createDisplayPanel());
        tabs.getTabs().addAll(addTab, opsTab, viewTab);
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        root.getChildren().add(tabs);

        clearBtn = new Button("Clear All Fields");
        clearBtn.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-font-weight: bold;");
        clearBtn.setOnAction(e -> clearFields());
        HBox footer = new HBox(clearBtn);
        footer.setAlignment(Pos.CENTER);
        root.getChildren().add(footer);

        Scene scene = new Scene(root, 800, 700);
        frame.setScene(scene);
        frame.show();
    }

    // Create Add Gadget Tab
    private Pane createAddGadgetPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));

        Label commonLabel = new Label("Phone Description:");
        commonLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        panel.getChildren().add(commonLabel);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Model:"), 0, 0);
        modelField = new TextField();
        grid.add(modelField, 1, 0);

        grid.add(new Label("Price (£):"), 0, 1);
        priceField = new TextField();
        grid.add(priceField, 1, 1);

        grid.add(new Label("Weight (g):"), 0, 2);
        weightField = new TextField();
        grid.add(weightField, 1, 2);

        grid.add(new Label("Size:"), 0, 3);
        sizeField = new TextField();
        grid.add(sizeField, 1, 3);

        Separator sep1 = new Separator();
        panel.getChildren().addAll(grid, sep1);

        Label mobileLabel = new Label("Mobile Phone - Credit (minutes):");
        mobileLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        panel.getChildren().add(mobileLabel);

        HBox mobileBox = new HBox(10);
        mobileBox.getChildren().addAll(new Label("Credit:"));
        creditField = new TextField();
        mobileBox.getChildren().add(creditField);
        addMobileBtn = new Button("✓ Add Mobile");
        addMobileBtn.setStyle("-fx-background-color: #228B22; -fx-text-fill: white; -fx-font-weight: bold;");
        addMobileBtn.setOnAction(e -> addMobile());
        mobileBox.getChildren().add(addMobileBtn);
        panel.getChildren().add(mobileBox);

        Separator sep2 = new Separator();
        panel.getChildren().add(sep2);

        Label mp3Label = new Label("MP3 Player - Memory (MB):");
        mp3Label.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        panel.getChildren().add(mp3Label);

        HBox mp3Box = new HBox(10);
        mp3Box.getChildren().addAll(new Label("Memory:"));
        memoryField = new TextField();
        mp3Box.getChildren().add(memoryField);
        addMP3Btn = new Button("✓ Add MP3");
        addMP3Btn.setStyle("-fx-background-color: #228B22; -fx-text-fill: white; -fx-font-weight: bold;");
        addMP3Btn.setOnAction(e -> addMP3());
        mp3Box.getChildren().add(addMP3Btn);
        panel.getChildren().add(mp3Box);

        return panel;
    }

    // Create Operations Tab
    private Pane createOperationsPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));

        Label callLabel = new Label("Make a Call");
        callLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        panel.getChildren().add(callLabel);

        HBox callBox1 = new HBox(10);
        callBox1.getChildren().addAll(new Label("Mobile Number (Index):"));
        displayField = new TextField();
        callBox1.getChildren().add(displayField);
        panel.getChildren().add(callBox1);

        HBox callBox2 = new HBox(10);
        callBox2.getChildren().addAll(new Label("Phone Number:"));
        phoneNumberField = new TextField();
        callBox2.getChildren().add(phoneNumberField);
        panel.getChildren().add(callBox2);

        HBox callBox3 = new HBox(10);
        callBox3.getChildren().addAll(new Label("Duration (minutes):"));
        durationField = new TextField();
        callBox3.getChildren().add(durationField);
        panel.getChildren().add(callBox3);

        makeCallBtn = new Button("☎ Make a Call");
        makeCallBtn.setStyle("-fx-background-color: #ff4500; -fx-text-fill: white; -fx-font-weight: bold;");
        makeCallBtn.setOnAction(e -> makeCall());
        panel.getChildren().add(makeCallBtn);

        Separator sep = new Separator();
        panel.getChildren().add(sep);

        Label downloadLabel = new Label("Download Music");
        downloadLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        panel.getChildren().add(downloadLabel);

        HBox mp3IndexBox = new HBox(10);
        mp3IndexBox.getChildren().addAll(new Label("MP3 Player (Index):"));
        TextField displayField2 = new TextField();
        mp3IndexBox.getChildren().add(displayField2);
        panel.getChildren().add(mp3IndexBox);

        HBox downloadBox = new HBox(10);
        downloadBox.getChildren().addAll(new Label("Download Size (MB):"));
        downloadField = new TextField();
        downloadBox.getChildren().add(downloadField);
        panel.getChildren().add(downloadBox);

        downloadBtn = new Button("♫ Download Music");
        downloadBtn.setStyle("-fx-background-color: #ff4500; -fx-text-fill: white; -fx-font-weight: bold;");
        downloadBtn.setOnAction(e -> {
            displayField.setText(displayField2.getText());
            downloadMusic();
        });
        panel.getChildren().add(downloadBtn);

        return panel;
    }

    // Create Display Tab
    private Pane createDisplayPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));

        Label infoLabel = new Label("All Gadgets in Shop:");
        infoLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        panel.getChildren().add(infoLabel);

        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 11px;");
        panel.getChildren().add(displayArea);

        Button refreshBtn = new Button("🔄 Refresh List");
        refreshBtn.setStyle("-fx-background-color: #0066cc; -fx-text-fill: white; -fx-font-weight: bold;");
        refreshBtn.setOnAction(e -> refreshDisplayArea(displayArea));
        panel.getChildren().add(refreshBtn);

        Button displayAllBtn = new Button("Display All (Popout)");
        displayAllBtn.setStyle("-fx-background-color: #4682b4; -fx-text-fill: white; -fx-font-weight: bold;");
        displayAllBtn.setOnAction(e -> displayAll());
        panel.getChildren().add(displayAllBtn);

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
            return -9999;
        }
    }

    // Get weight from text field and convert to integer
    private int getWeight() {
        try {
            return Integer.parseInt(weightField.getText());
        } catch (NumberFormatException e) {
            return -9999;
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
            return -9999;
        }
    }

    // Get memory from text field and convert to integer
    private int getMemory() {
        try {
            return Integer.parseInt(memoryField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Memory must be an integer");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Duration must be an integer");
            alert.showAndWait();
            return -1;
        }
    }

    // Get download size from text field and convert to integer
    private int getDownloadSize() {
        try {
            return Integer.parseInt(downloadField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Download size must be an integer");
            alert.showAndWait();
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
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Display number must be between 0 and " + (gadgets.size() - 1));
                alert.showAndWait();
                return -1;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Display number must be an integer");
            alert.showAndWait();
            return -1;
        }
        return displayNumber;
    }

    // display all gadgets
    // Display all gadgets in the console (for 'Display All (Console)' button)
    public void displayAll() {
        StringBuilder sb = new StringBuilder();
        if (gadgets.isEmpty()) {
            String msg = "No gadgets in the shop.";
            System.out.println(msg);
            sb.append(msg);
        } else {
            for (int i = 0; i < gadgets.size(); i++) {
                Gadget g = gadgets.get(i);
                String type = "Gadget";
                if (g instanceof MP3) type = "MP3 Player";
                else if (g instanceof Mobile) type = "Mobile Phone";
                sb.append("=== Gadget " + i + ": " + type + " ===\n");
                System.out.println("Gadget " + i + ": " + type);
                sb.append("Model: " + g.getModel() + "\n");
                sb.append("Price: £" + g.getPrice() + "\n");
                sb.append("Weight: " + g.getWeight() + "g\n");
                sb.append("Size: " + g.getSize() + "\n");
                if (g instanceof MP3) {
                    sb.append("Memory: " + ((MP3)g).getMemory() + "MB\n");
                } else if (g instanceof Mobile) {
                    sb.append("Credit: " + ((Mobile)g).getCredit() + " minutes\n");
                }
                sb.append("-----------------------------\n");
                g.display();
                System.out.println();
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Gadget List");
        alert.setTitle("All Gadgets");
        // Use a scrollable TextArea for better design
        TextArea area = new TextArea(sb.toString());
        area.setEditable(false);
        area.setWrapText(true);
        area.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 13px; -fx-control-inner-background: #f8f8ff; -fx-background-color: #e0e7ef; -fx-border-color: #b0b0b0; -fx-border-radius: 6px;");
        area.setPrefWidth(400);
        area.setPrefHeight(300);
        alert.getDialogPane().setContent(area);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }

    // add mobile from gui
    private void addMobile() {
        StringBuilder errorMsg = new StringBuilder();
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int credit = getCredit();
        if (model.isEmpty()) errorMsg.append("Model is required.\n");
        if (size.isEmpty()) errorMsg.append("Size is required.\n");
        if (price == -9999) errorMsg.append("Price must be a decimal number.\n");
        else if (price <= 0) errorMsg.append("Price must be a positive number.\n");
        if (weight == -9999) errorMsg.append("Weight must be an integer.\n");
        else if (weight <= 0) errorMsg.append("Weight must be a positive integer.\n");
        if (credit == -9999) errorMsg.append("Credit must be an integer.\n");
        else if (credit < 0) errorMsg.append("Credit must be zero or positive integer.\n");
        if (errorMsg.length() > 0) {
            System.out.println("[ERROR] Could not add mobile: " + errorMsg.toString().replaceAll("\n", " | "));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("✖ Could not add mobile");
            alert.setContentText(errorMsg.toString());
            alert.showAndWait();
        } else {
            addMobile(model, price, weight, size, credit);
            System.out.println("[LOG] Mobile added: " + model);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("✔ Mobile Added!");
            alert.setContentText("The mobile was added successfully.");
            alert.showAndWait();
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
            System.out.println("[LOG] MP3 added: " + model);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "MP3 added successfully");
            alert.showAndWait();
        } else {
            System.out.println("[ERROR] Could not add MP3: Invalid input values");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input values");
            alert.showAndWait();
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
            System.out.println("[LOG] Calling " + number + " for " + duration + " minutes");
            // If phone number is empty, generate a random one
            if (number.isEmpty()) {
                number = generateRandomPhoneNumber();
                phoneNumberField.setText(number);
            }
            if (!number.isEmpty() && duration > 0) {
                if (gadgets.get(index) instanceof Mobile) {
                    Mobile mobile = (Mobile) gadgets.get(index);
                    int creditBefore = mobile.getCredit();
                    mobile.makeCall(number, duration);
                    int creditAfter = mobile.getCredit();
                    if (creditAfter < creditBefore) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Call made to " + number + " for " + duration + " minutes\nRemaining credit: " + creditAfter);
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient credit to make call");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Selected gadget is not a mobile phone");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Invalid phone number or duration");
                alert.showAndWait();
            }
        }
    }

    // Helper to generate a random UK-style phone number
    private String generateRandomPhoneNumber() {
        StringBuilder sb = new StringBuilder("07");
        for (int i = 0; i < 9; i++) {
            sb.append((int)(Math.random() * 10));
        }
        return sb.toString();
    }

    // download music
    private void downloadMusic() {
        int index = getDisplayNumber();
        if (index != -1) {
            int size = getDownloadSize();
            System.out.println("[LOG] Downloading music: " + size + "MB");
            if (size > 0) {
                if (gadgets.get(index) instanceof MP3) {
                    MP3 mp3 = (MP3) gadgets.get(index);
                    boolean success = mp3.downloadMusic(size);
                    if (success) {
                        String songName = generateRandomSongName();
                        String[] artists = {"DJ Sonic", "The Wanderers", "Echo Beat", "Luna Wave", "Starfall", "Neon Pulse", "Skyline", "Aurora", "Night Drive", "Pixel Pop"};
                        String artist = artists[(int)(Math.random() * artists.length)];
                        int duration = 2 + (int)(Math.random() * 4); // 2-5 min
                        String album = "Album: " + (char)('A' + (int)(Math.random()*26)) + "-Side";
                        StringBuilder sb = new StringBuilder();
                        sb.append("\uD83C\uDFB5  Song Downloaded!\n\n");
                        sb.append("Title: ").append(songName).append("\n");
                        sb.append("Artist: ").append(artist).append("\n");
                        sb.append("Duration: ").append(duration).append(" min\n");
                        sb.append(album).append("\n");
                        sb.append("\n");
                        sb.append("\uD83D\uDCBF Download operation completed");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Music Downloaded");
                        alert.setTitle("Download Complete");
                        TextArea area = new TextArea(sb.toString());
                        area.setEditable(false);
                        area.setWrapText(true);
                        area.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 14px; -fx-control-inner-background: #eafff5; -fx-text-fill: #1a4d2e; -fx-background-color: #b2f7ef; -fx-border-color: #1a4d2e; -fx-border-radius: 8px;");
                        area.setPrefWidth(360);
                        area.setPrefHeight(200);
                        alert.getDialogPane().setContent(area);
                        alert.getDialogPane().setStyle("-fx-background-color: #eafff5;");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("");
                        alert.setContentText("Not enough memory to download music");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("");
                    alert.setContentText("Error: Selected gadget is not an MP3 player");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("");
                alert.setContentText("Error: Invalid download size");
                alert.showAndWait();
            }
        }
    }

    // Helper to refresh display area
    private void refreshDisplayArea(TextArea displayArea) {
        System.out.println("[LOG] Displaying all gadgets");
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
    }

    // main method
    public static void main(String[] args) {
        launch(args);
    }
}
