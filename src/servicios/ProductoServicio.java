/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.TiendaDAO;
import entidades.Producto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Flia Vasquez
 */
public class ProductoServicio {

    TiendaDAO tdao = new TiendaDAO();

    public void mostrarProductos(String query) {
        ArrayList<Producto> productos = tdao.listarProductos(query);
        for (Producto producto : productos) {
            producto.toStringa();
            System.out.println("");
        }
        System.out.println("");
    }

    public ArrayList<Producto> traerProductos(String query){
        ArrayList<Producto> productos = tdao.listarProductos(query);
        return productos;
    }
    
    public void agregarProducto() {
        try {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Agregar productos");
            System.out.println("codigo: ");
            Integer codigo = sc.nextInt();
            System.out.println("Nombre: ");
            String nombre = sc.next();
            System.out.println("Precio: ");
            Double precio = sc.nextDouble();
            System.out.println("Codigo de fabricante: ");
            Integer cod_fab = sc.nextInt();

            String query = "INSERT INTO producto VALUES(" + codigo + ",'" + nombre + "'," + precio + "," + cod_fab + ")";
            tdao.editarAgregar(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void editarProducto() {
        try {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Que producto desea modificar? (MEDIANTE CODIGO)");
            Integer codigo = sc.nextInt();
            System.out.println("Que aspecto del producto desea modificar? codigo|nombre|precio|codigo-fabricante");
            String label = sc.next();
            System.out.println("Ingrese el nuevo valor");
            String nuevoValor = sc.next();
            
            if (label.equals("nombre")) {
                nuevoValor = "'"+nuevoValor+"'";
            }
            String query = "UPDATE producto SET " + label + " = " + nuevoValor + " WHERE codigo = " + codigo;
            tdao.editarAgregar(query);
            /*
            METODO EXECUTEUPDATE(query) desde DAO
            preguntar que producto desea editar mediante el codigo
            y depositarla en una variable.
            crear una variable label que significa que aspecto desea editar
            para ingresar el dato que el usuario desea editar y luego pedirle el nuevo valor
             */
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
