module project.assignmentproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ie.mtu.cs.oo.ass1 to javafx.fxml;
    exports ie.mtu.cs.oo.ass1;
}