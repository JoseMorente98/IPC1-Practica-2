/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.josemorente.bean.Cliente;

/**
 *
 * @author Jose Morente
 */
public class ClienteController {
    private Cliente inicio;
    private int size;
    private ObservableList<Cliente> clientes;
    
    private ClienteController() {
        clientes = FXCollections.observableArrayList();
    }
    
    public static ClienteController getInstance() {
        return ClienteControllerHolder.INSTANCE;
    }
    
    private static class ClienteControllerHolder {

        private static final ClienteController INSTANCE = new ClienteController();
    }

    public int getSize() {
        return size;
    }

    public Boolean isVacio() {
        return inicio == null;
    }
    
    //AGREGAR CLIENTE
    public void agregarCliente(int dpi,String nombreCompleto,String usuario,String contrasena,String tipoCliente) {
        Cliente c = new Cliente();
        c.setDpi(dpi);
        c.setNombreCompleto(nombreCompleto);
        c.setUsuario(usuario);
        c.setContrasena(contrasena);
        c.setTipoCliente(tipoCliente);
        
        if(isVacio()) {
            inicio = c;
        } else {
            Cliente aux = inicio;
            while(aux.getSiguiente() != null) {
                aux.getSiguiente();
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(c);
        }
        size++;
    }
    
    public void imprimirClientes(){
        if (!isVacio()) {
            Cliente aux = inicio;
            while(aux != null){
                System.out.println("════════════════════════════════════════");
                System.out.println("                    IMPRIMIR CLIENTES");
                System.out.println("════════════════════════════════════════");
                System.out.println(aux);
                aux = aux.getSiguiente();
            }
            NotificationController.getInstance().notificarInformacion("Imprimir Clientes", "Clientes impresos en consola :D");
        } else {
            System.out.println("════════════════════════════════════════");
            System.out.println("                    LISTA VACÍA.");
            System.out.println("════════════════════════════════════════");
            NotificationController.getInstance().notificarError("Imprimir Clientes", "La lista no contiene clientes D:");
        }
    }
    
    //BUCAR CLIENTE
    public Cliente buscar(int dpi){
        Cliente aux = inicio;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (dpi == aux.getDpi()){
                return aux;
            }
            else{
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    //BUSCAR CLIENTE
    public boolean search(int dpi){
        Cliente aux = inicio;
        while(aux != null){
            if (dpi == aux.getDpi()){
                return true;
            }
            else{
                aux = aux.getSiguiente();
            }
        }
        return false;
    }
    
    //ELIMINAR CLIENTE
    public void eliminar(int dpi){
        if (search(dpi)) {
            if (inicio.getDpi() == dpi) {
                inicio = inicio.getSiguiente();
            } else{
                Cliente aux = inicio;
                while(aux.getSiguiente().getDpi() != dpi){
                    aux = aux.getSiguiente();
                }
                Cliente siguiente = aux.getSiguiente().getSiguiente();
                aux.setSiguiente(siguiente); 
            }
            size--;
            System.out.println("════════════════════════════════════════");
            System.out.println("                    CLIENTE ELIMINADO");
            System.out.println("════════════════════════════════════════");
            NotificationController.getInstance().notificarInformacion("Eliminar Cliente", "El cliente fue eliminado exitosamente :D");
        } else {
            NotificationController.getInstance().notificarError("Eliminar Cliente", "Cliente no encontrado D:");
        }
    }
    
    //EDITAR CLIENTE
    public void actualizar(int dpi,String nombreCompleto,String usuario,String contrasena,String tipoCliente){
        if (search(dpi)) {
            Cliente aux = inicio;
            while(aux.getDpi() != dpi) {
                aux = aux.getSiguiente();
            }
            aux.setDpi(dpi);
            aux.setNombreCompleto(nombreCompleto);
            aux.setUsuario(usuario);
            aux.setContrasena(contrasena);
            aux.setTipoCliente(tipoCliente);
            NotificationController.getInstance().notificarInformacion("Actuliazar Cliente", "El cliente fue actualizado exitosamente :D");
        } else {
            NotificationController.getInstance().notificarError("Actualizar Cliente", "Cliente no encontrado D:");
        }
    }
    
    //OBTENER LISTA
    public ObservableList<Cliente> getClientes() {
        clientes.clear();
        
        if(!isVacio()) {
            Cliente aux = inicio;
            while(aux != null) {
                clientes.add(aux);
                aux = aux.getSiguiente();
            }
        }
        return clientes;
    }

    
}
