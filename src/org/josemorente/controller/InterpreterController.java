/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.josemorente.bean.Cliente;

/**
 *
 * @author Jose Morente
 */
public class InterpreterController {
    private File file;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private String comando;
    private String instruccion;
    private ObservableList<String> observable;
    
    public InterpreterController() {
        observable = FXCollections.observableArrayList();
    }
    
    //SINGLETÓN
    public static InterpreterController getInstance() {
        return InterpreterControllerHolder.INSTANCE;
    }
    
    private static class InterpreterControllerHolder {
        private static final InterpreterController INSTANCE = new InterpreterController();
    }
    
    //ABRIR ARCHIVO CARGA MASIVA
    public void abrirArchivo(ActionEvent event) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CLI Files", "*.cli"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                System.out.println(selectedFile);
                String linea;
                BufferedReader bf = leer(selectedFile.toString());
                while((linea = bf.readLine()) != null ) {
                    agregarCliente(linea, -1);
                }
            } catch (IOException e) {
                
            }
        }
    }
    
    //CARGAR ACCIONES COMBO BOX
    public void cargarAcciones() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ACC Files", "*.acc"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                System.out.println(selectedFile);
                String linea;
                BufferedReader bf = leer(selectedFile.toString());
                observable.clear();
                while((linea = bf.readLine()) != null ) {
                    agregarObservable(linea);
                }
            } catch (IOException e) {
                
            }
        }
    }
    
    public void agregarObservable(String parametro) {
        String s = new String(parametro);
        observable.add(s);
    }

    public ObservableList<String> getObservable() {
        return observable;
    }
    
    public BufferedReader leer(String nombre) {
	try {
            file = new File(nombre);
            inputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	} catch (IOException ex) {
			
	}
	return bufferedReader;
    }
    
    //AGREGAR CLIENTE
    public void agregarCliente(String instruccion, int posicion) {
        String dpi = "";
        String nombre = "";
        String usuario = "";
        String contrasena = "";
        String tipoCliente = "";
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                dpi = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                nombre = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                usuario = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                contrasena = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion + 1).trim();
	for (int x = 0; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#") || x  == (instruccion.length() -1)) {
		tipoCliente = instruccion.substring(0, x + 1);
		break;
            }
	}
        ClienteController.getInstance().agregarCliente(Integer.parseInt(dpi), nombre, usuario, contrasena, tipoCliente);
    }
    
    //ACTUALIZAR CLIENTE
    public void actualizarCliente(String instruccion, int posicion) {
        String dpi = "";
        String nombre = "";
        String usuario = "";
        String contrasena = "";
        String tipoCliente = "";
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                dpi = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                nombre = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                usuario = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion +1).trim();
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#")) {
                contrasena = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        
        instruccion = instruccion.substring(posicion + 1).trim();
	for (int x = 0; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals("#") || x  == (instruccion.length() -1)) {
		tipoCliente = instruccion.substring(0, x + 1);
		break;
            }
	}
        
        ClienteController.getInstance().actualizar(Integer.parseInt(dpi), nombre, usuario, contrasena, tipoCliente);
    }
    
    //BUSCAR CLIENTE    
    public void buscarCliente(String instruccion, int posicion) {
        String instruccion1 = "";
        instruccion = instruccion.substring(posicion + 1).trim();
	for (int x = 0; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals(" ") || x  == (instruccion.length() -1)) {
		instruccion1 = instruccion.substring(0, x + 1);
		break;
            }
	}
        Cliente c = ClienteController.getInstance().buscar(Integer.parseInt(instruccion1));
        if(c!=null) {
            System.out.println("════════════════════════════════════════");
            System.out.println("                    BUSCAR CLIENTE.");
            System.out.println("════════════════════════════════════════");
            System.out.println(c);
            NotificationController.getInstance().notificarInformacion("Buscar Cliente", "El cliente ha sido encontrado :D \n"
                + "DPI: " + c.getDpi() + "\n"
                + "Nombre: " + c.getNombreCompleto()+ "\n"
                + "Usuario: " + c.getUsuario()+ "\n"
                + "Contraseña: " + c.getContrasena()+ "\n"
                + "Tipo de Cliente: " + c.getTipoCliente()+ "");
        } else {
            NotificationController.getInstance().notificarError("Buscar Cliente", "Cliente no encontrado D:");
        }
    }
    
    //ELIMINAR CLIENTE    
    public void eliminarCliente(String instruccion, int posicion) {
        String instruccion1 = "";
        instruccion = instruccion.substring(posicion + 1).trim();
	for (int x = 0; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals(" ") || x  == (instruccion.length() -1)) {
		instruccion1 = instruccion.substring(0, x + 1);
		break;
            }
	}
        ClienteController.getInstance().eliminar(Integer.parseInt(instruccion1));
    }
    
    //INTERPRETAR INSTRUCCIONES
    public void interpretar(String instruccion) {
        instruccion = instruccion.trim().replace("(", " ").replace(")", "");
        String comando = instruccion;
        int posicion = 0;
        for (int x = 0 ; x < instruccion.length(); x++) {
            if (instruccion.substring(x, x + 1).equals(" ")) {
                comando = instruccion.substring(0, x);
                posicion = x;
                break;
            }
        }
        switch(comando) {
            case "Imprimir":
                ClienteController.getInstance().imprimirClientes();
            break;
            case "Buscar":
                buscarCliente(instruccion, posicion);
            break;
            case "Eliminar":
                eliminarCliente(instruccion, posicion);
            break;
            case "Editar":
                actualizarCliente(instruccion, posicion);
            break;
            default:
            break;
        }
    }
        
}
