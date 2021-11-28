/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Flia Vasquez
 */
import entidades.Fabricante;
import entidades.Producto;
import java.util.ArrayList;

public class TiendaDAO extends DAO {

    public Integer obtenerCodigo(String tabla) {
        Integer codigo = null;
        try {
            consultarBd("SELECT COUNT(codigo) FROM "+tabla);
            while (resultado.next()) {
                codigo = resultado.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                desconectarBd();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return codigo;
    }

    public ArrayList<Producto> listarProductos(String query) {
        ArrayList<Producto> productos = new ArrayList();
        try {
            consultarBd(query);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                try {
                    producto.setCodigo(resultado.getInt("codigo"));
                } catch (Exception e) {

                }

                try {
                    producto.setNombre(resultado.getString("nombre"));
                } catch (Exception e) {

                }
                try {
                    producto.setPrecio(resultado.getDouble("precio"));
                } catch (Exception e) {

                }
                try {
                    producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                } catch (Exception e) {

                }

                try {
                    producto.setNombreF(resultado.getString("fabricante"));
                } catch (Exception e) {

                }
                productos.add(producto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                desconectarBd();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return productos;
    }

    public ArrayList<Fabricante> listarFabricantes(String query) {
        ArrayList<Fabricante> fabricantes = new ArrayList();
        try {
            consultarBd(query);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                desconectarBd();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return fabricantes;
    }

}
