module org.example.di_ejerciciopracticoev_tema3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.di_ejerciciopracticoev_tema3 to javafx.fxml;
    exports org.example.di_ejerciciopracticoev_tema3;
}