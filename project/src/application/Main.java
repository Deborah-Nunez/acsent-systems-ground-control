package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ACSENT Systems Ground Control");

        // Dashboard section
        Label dashboardLabel = new Label("System Status");
        Label powerLabel = new Label("Power: ON");
        Label connectionLabel = new Label("Connection: Stable");
        Label sensorLabel = new Label("Sensors: Operational");

        VBox dashboardBox = new VBox(10, dashboardLabel, powerLabel, connectionLabel, sensorLabel);
        dashboardBox.setPadding(new Insets(10));
        dashboardBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        
        // values of attitude are declared before the labels and received from the serializtion 
        double attX = 0.0;
        double attY = 0.0;
        double attZ = 0.0;
        // Attitude Labels
        Label attLabel = new Label("Attitude");
        attLabel.setStyle("-fx-font-weight: bold;");

        Label attX_label = new Label("X:   " + String.valueOf(attX));
        Label attY_label = new Label("Y:   " + String.valueOf(attY));
        Label attZ_label = new Label("Z:   " + String.valueOf(attZ));
        VBox attBox = new VBox(attLabel, attX_label, attY_label, attZ_label);
        
        
        // values of position are declared before the labels and received from the serializtion 
        double posX = 0.0;
        double posY = 0.0;
        double posZ = 0.0;
        // Position Labels
        Label posLabel = new Label("Position");
        posLabel.setStyle("-fx-font-weight: bold;");

        Label posX_label = new Label("X:   " + String.valueOf(posX));
        Label posY_label = new Label("Y:   " + String.valueOf(posY));
        Label posZ_label = new Label("Z:   " + String.valueOf(posZ));
        VBox posBox = new VBox(10, posLabel, posX_label, posY_label, posZ_label);
        
        
        // values of velocity are declared before the labels and received from the serializtion 
        double velX = 0.0;
        double velY = 0.0;
        double velZ = 0.0;    
        // Velocity Labels
        Label velLabel = new Label("Velocity");
        velLabel.setStyle("-fx-font-weight: bold;");

        Label velX_label = new Label("X:   " + String.valueOf(velX));
        Label velY_label = new Label("Y:   " + String.valueOf(velY));
        Label velZ_label = new Label("Z:   " + String.valueOf(velZ));
        VBox velBox = new VBox(10, velLabel, velX_label, velY_label, velZ_label);
        
        
        // values of acceleration are declared before the labels and received from the serializtion 
        double accelX = 0.0;
        double accelY = 0.0;
        double accelZ = 0.0;   
        // Acceleration Labels
        Label accelLabel = new Label("Acceleration");
        accelLabel.setStyle("-fx-font-weight: bold;");

        Label accelX_label = new Label("X:   " + String.valueOf(accelX));
        Label accelY_label = new Label("Y:   "  + String.valueOf(accelY));
        Label accelZ_label = new Label("Z:   " + String.valueOf(accelZ));
        VBox accelBox = new VBox(10, accelLabel, accelX_label, accelY_label, accelZ_label);
   
        
        // Pyro Arming
        Label pyro_armLabel = new Label("Pyro Arming");
        pyro_armLabel.setStyle("-fx-font-weight: bold;");

        Label pyro0 = new Label("Pyro 0   Not Safe");
        Label pyro1 = new Label("Pyro 1   Not Safe");
        Label pyro2 = new Label("Pyro 2   Not Safe");
        VBox pyro_armBox = new VBox(10, pyro_armLabel, pyro0, pyro1, pyro2);
        pyro_armBox.setPadding(new Insets(10));
        pyro_armBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        
        // Control panel section
        Label controlPanelLabel = new Label("Control Panel");
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button resetButton = new Button("Reset");
        Button launchButton = new Button("Launch");
        launchButton.setPrefSize(100, 100);
        VBox controlPanelBox = new VBox(10, controlPanelLabel, startButton, stopButton, resetButton, launchButton);
        controlPanelBox.setPadding(new Insets(5));
        controlPanelBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        controlPanelBox.setAlignment(Pos.CENTER_LEFT);
        
        // Console section
        Label consoleLabel = new Label("System Logs");
        TextArea consoleArea = new TextArea();
        consoleArea.setEditable(false);
        consoleArea.setPrefHeight(200);

        VBox consoleBox = new VBox(10, consoleLabel, consoleArea);
        consoleBox.setPadding(new Insets(10));
        consoleBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        // Network connection settings
        Label connectionSettingsLabel = new Label("Connection Settings");
        TextField ipAddressField = new TextField();
        ipAddressField.setPromptText("Enter IP Address");
        TextField portField = new TextField();
        portField.setPromptText("Enter Port");

        VBox connectionSettingsBox = new VBox(10, connectionSettingsLabel, ipAddressField, portField);
        connectionSettingsBox.setPadding(new Insets(10));
        connectionSettingsBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        
        // sideBox1 includes attitude and position labels
        VBox sideBox1 = new VBox(10, attBox, posBox);
        sideBox1.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        sideBox1.setPadding(new Insets(10));
        // sideBox2 includes velocity and acceleration labels
        VBox sideBox2 = new VBox(10, velBox, accelBox);
        sideBox2.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        sideBox2.setPadding(new Insets(10));

        // Layout setup (main grid)
        GridPane mainLayout = new GridPane();
        mainLayout.setPadding(new Insets(10));
        mainLayout.setHgap(20);
        mainLayout.setVgap(20);

        mainLayout.add(dashboardBox, 0, 0); // Dashboard at top-left
        mainLayout.add(controlPanelBox, 1, 0); // Control Panel at top-right
        mainLayout.add(sideBox1, 2, 0);
        mainLayout.add(sideBox2, 2, 1);
        mainLayout.add(pyro_armBox, 2, 2);
        mainLayout.add(consoleBox, 0, 1, 2, 1); // Console at bottom (spanning two columns)
        mainLayout.add(connectionSettingsBox, 0, 2, 2, 1); // Connection settings at bottom

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        
        // Event handling
        startButton.setOnAction(e -> consoleArea.appendText("System started...\n"));
        stopButton.setOnAction(e -> consoleArea.appendText("System stopped...\n"));
        resetButton.setOnAction(e -> consoleArea.appendText("System reset...\n"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
