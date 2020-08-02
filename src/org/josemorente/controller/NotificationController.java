/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.controller;

import javafx.scene.control.Alert;

/**
 *
 * @author Jose Morente
 */
public class NotificationController {
    
    private NotificationController() {
    }
    
    public static NotificationController getInstance() {
        return NotificationControllerHolder.INSTANCE;
    }
    
    private static class NotificationControllerHolder {

        private static final NotificationController INSTANCE = new NotificationController();
    }
    
    public void notificarInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
    
    public void notificarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR); alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}
