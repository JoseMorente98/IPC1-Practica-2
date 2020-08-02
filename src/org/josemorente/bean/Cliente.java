/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.bean;

/**
 *
 * @author Jose Morente
 */
public class Cliente {
    private int dpi;
    private String nombreCompleto;
    private String usuario;
    private String contrasena;
    private String tipoCliente;
    private Cliente siguiente;

    public Cliente() {
    }

    /**
     * @return the dpi
     */
    public int getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the tipoCliente
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * @param tipoCliente the tipoCliente to set
     */
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /**
     * @return the siguiente
     */
    public Cliente getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Cliente siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "DPI: " + dpi + " NOMBRE: " + nombreCompleto + " USUARIO " +usuario+ " CONTRASEÑA " + contrasena + ""; 
    }
    
}
