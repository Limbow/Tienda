/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author Flia Vasquez
 */
public class Fabricante implements Serializable {

    private Integer codigo;
    private String nombre;

    public Fabricante() {
    }

    public Fabricante(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean empiezaPor(String inicio) {
        if (inicio.isEmpty() || inicio.length() > nombre.length()) {
            return false;
        }
        for (int i = 0; i < inicio.length(); i++) {
            if (inicio.charAt(i) != nombre.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
