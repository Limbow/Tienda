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
public class Producto implements Serializable{

    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer codigo_fabricante;
    private String nombreF;

    public Producto() {
    }

    public Producto(Integer codigo, String nombre, Double precio, Integer codigo_fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigo_fabricante;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(Integer codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
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

    public void toStringa() {
        if (getCodigo() == null) {
            //nada
        } else {
            System.out.print(getCodigo() + "|");
        }

        if (getNombre() == null) {
            //nada
        } else {
            System.out.print(getNombre() + "|");
        }

        if (getPrecio() == null) {
            //nada
        } else {
            System.out.print(getPrecio() + "|");
        }

        if (getCodigo_fabricante() == null) {
            //nada
        } else {
            System.out.print(getCodigo_fabricante());
        }
    }

}
