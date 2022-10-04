package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Empleado;
import model.Empresa;
import model.Producto;
import persistencia.Persistencia;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class MainViewController implements Initializable {

    private Empresa empresa = new Empresa("ACME");
    @FXML
    private TextField txtNombreEmpleado;
    @FXML
    private TextField txtIdEmpleado;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtIdProducto;
    @FXML
    private TextField txtValorProducto;
    @FXML
    private TextField txtSueldoEmpleado;

    @FXML
    private Label lblConfirmEmpleado;
    @FXML
    private Label lblConfirmProducto;

    @FXML
    private void guardarEmpleado(ActionEvent event) throws IOException, InterruptedException {
        String nombreEmpleado = txtNombreEmpleado.getText();
        String idEmpleado = txtIdEmpleado.getText();
        int sueldoEmpleado = Integer.parseInt(txtSueldoEmpleado.getText());
        Empleado empleado = new Empleado(nombreEmpleado, idEmpleado, sueldoEmpleado);
        guardarEmpleadoArchivo(empleado);
        lblConfirmEmpleado.setText("Se ha guardado el empleado!");
    }

    @FXML
    private void guardarProducto(ActionEvent event) throws IOException {
        String nombreProducto = txtNombreProducto.getText();
        String idProducto = txtIdProducto.getText();
        int valorProducto = Integer.parseInt(txtValorProducto.getText());
        Producto producto = new Producto(nombreProducto, idProducto, valorProducto);
        guardarProductoArchivo(producto);
        lblConfirmProducto.setText("Se ha guardado el producto!");
    }

    private void guardarEmpleadoArchivo(Empleado empleado) throws IOException {
        Persistencia.guardarEmpleados(empleado);
    }

    private void guardarProductoArchivo(Producto producto) throws IOException {
        Persistencia.guardarProducto(producto);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
