module project {
    requires javafx.controls;
    requires javafx.graphics;  

    opens application to javafx.graphics;
}
