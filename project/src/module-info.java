module project {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;  // Add this to support FXML

    opens application to javafx.graphics, javafx.fxml;
}
