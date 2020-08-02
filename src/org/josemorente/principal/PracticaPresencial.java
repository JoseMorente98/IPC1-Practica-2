/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.principal;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.josemorente.bean.Cliente;
import org.josemorente.controller.ClienteController;
import org.josemorente.controller.InterpreterController;
import org.josemorente.controller.NotificationController;

/**
 *
 * @author Jose Morente
 */
public class PracticaPresencial extends Application {
    private TableView<Cliente> tableView;
    private TableColumn<Cliente, Integer> tableColumnIdCliente;
    private TableColumn<Cliente, String> tableColumnNombre;
    private TableColumn<Cliente, String> tableColumnUsuario;
    private TableColumn<Cliente, String> tableColumnContrasena;
    private TableColumn<Cliente, String> tableColumnTipo;
    private ObservableList<Cliente> observableList;
    private ObservableList<String> observableAccion;
    private GridPane gridPane;
    private HBox hboxButtons = new HBox(10);
    private VBox vBox = new VBox(15);
    ComboBox<String> comboBoxAccion;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Cargar Clientes");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InterpreterController.getInstance().abrirArchivo(event);
                tableView.setItems(ClienteController.getInstance().getClientes());
            }
        });
        
        Button btnUpdate = new Button();
        btnUpdate.setText("Actualizar");
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tableView.setItems(ClienteController.getInstance().getClientes());
            }
        });
        
        //COMBO BOX ACCIONES
        comboBoxAccion = new ComboBox<>(observableAccion);
        comboBoxAccion.setPrefWidth(300);
        
        Button btnEvents = new Button();
        btnEvents.setText("Cargar Acciones");
        btnEvents.setPrefWidth(300);
        btnEvents.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InterpreterController.getInstance().cargarAcciones();
                comboBoxAccion.setItems(InterpreterController.getInstance().getObservable());
            }
        });
        
        Button btnEjecutar = new Button();
        btnEjecutar.setText("Ejecutar Acción");
        btnEjecutar.setPrefWidth(300);
        btnEjecutar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(comboBoxAccion.getSelectionModel().getSelectedItem() != null) {
                    InterpreterController.getInstance().interpretar(comboBoxAccion.getSelectionModel().getSelectedItem());
                    tableView.setItems(ClienteController.getInstance().getClientes());
                }
            }
        });
        
        vBox.getChildren().add(btnEvents);
        vBox.getChildren().add(comboBoxAccion);
        vBox.getChildren().add(btnEjecutar);
        
        //TABLA CLIENTES
        tableColumnIdCliente = new TableColumn<>();
        tableColumnIdCliente.setText("DPI Cliente");
        tableColumnIdCliente.setCellValueFactory(new PropertyValueFactory<>("dpi") );
        tableColumnIdCliente.setMinWidth(150);
        
        tableColumnNombre = new TableColumn<>();
        tableColumnNombre.setText("Nombre");
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        tableColumnNombre.setMinWidth(175);
        
        tableColumnUsuario = new TableColumn<>();
        tableColumnUsuario.setText("Usuario");
        tableColumnUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tableColumnUsuario.setMinWidth(175);
        
        tableColumnContrasena = new TableColumn<>();
        tableColumnContrasena.setText("Contraseña");
        tableColumnContrasena.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
        tableColumnContrasena.setMinWidth(175);
        
        tableColumnTipo = new TableColumn<>();
        tableColumnTipo.setText("Tipo de Cliente");
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));
        tableColumnTipo.setMinWidth(175);
        
        tableView = new TableView<>(observableList);
        tableView.getColumns().addAll(tableColumnIdCliente, tableColumnNombre,
            tableColumnUsuario, tableColumnContrasena, tableColumnTipo);
        
        //HBOX BUTTONS
        hboxButtons.getChildren().addAll(btn, btnUpdate);
        
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        
        gridPane.add(hboxButtons, 0, 0);
        gridPane.add(tableView, 0, 1);
        gridPane.add(vBox, 1, 1);
        
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        
        Scene scene = new Scene(root, 1200, 620);
        
        primaryStage.setTitle("Practica No. 3");
        primaryStage.setScene(scene);
        primaryStage.show();
        NotificationController.getInstance().notificarInformacion("Información", "Los archivos de carga se encuentran en el paquete org.josemorente.assets");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
