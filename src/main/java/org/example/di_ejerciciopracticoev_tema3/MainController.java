package org.example.di_ejerciciopracticoev_tema3;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.di_ejerciciopracticoev_tema3.models.Usuario;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<Usuario> tabla;
    @FXML
    private TableColumn<Usuario,String> columnCorreo;
    @FXML
    private TableColumn<Usuario,String> columnPlataforma;
    @FXML
    private TableColumn<Usuario,String> columnAdmin;
    @FXML
    private TableColumn<Usuario,String> columnSoftware;
    @FXML
    private TableColumn<Usuario,String> columnFecha;
    @FXML
    private TextField tfCorreo;
    @FXML
    private ChoiceBox<String> cbPlataforma;
    @FXML
    private Spinner<Integer> spinnerVersion;
    @FXML
    private CheckBox checkAdmin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnCorreo.setCellValueFactory( (row) -> {
            return new SimpleStringProperty(row.getValue().getCorreo());
        });

        columnPlataforma.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getPlataforma());
        });

        columnAdmin.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getAdmin().toString());
        });

        columnSoftware.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getSoftware().toString());
        });

        columnFecha.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getFecha().toString());
        });

        cbPlataforma.getItems().addAll("Windows", "Linux", "Mac");
        spinnerVersion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));

        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Usuario seleccionado");
            alert.setContentText(newSelection.toString());
            alert.showAndWait();
        });
    }

    @FXML
    public void anhadir(ActionEvent actionEvent) {
        if (tfCorreo == null || cbPlataforma.getValue() == null){
            var alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Debes rellenar todos los campos del formulario");
            alert.showAndWait();
            return;
        }

        tabla.getItems().add(new Usuario(
                tfCorreo.getText(),
                cbPlataforma.getValue(),
                checkAdmin.isSelected(),
                spinnerVersion.getValue(),
                LocalDateTime.now())
        );

        tfCorreo.setText(null);
        cbPlataforma.setValue(null);
        checkAdmin.setSelected(false);
        spinnerVersion.getValueFactory().setValue(1);
    }

    @FXML
    public void vaciar(ActionEvent actionEvent) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Estás seguro de que quieres vaciar la tabla?");
        var result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL){
            return;
        } else {
            tabla.getItems().clear();
        }
    }
}