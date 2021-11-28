/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.Scanner;

/**
 *
 * @author Flia Vasquez
 */
public class Menu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String rta = "";
        ProductoServicio ps = new ProductoServicio();
        FabricanteService fs = new FabricanteService();
        do {
            System.out.println("a) Listar el nombre de todos los productos que hay en la tabla productos");
            System.out.println("b) Listar los nombres y los precios de todos los productos de la tabla productos");
            System.out.println("c) Listar aquellos productos que su precio este entre 120 y 202");
            System.out.println("d) Buscar y listar todos los Portatiles de la tabla producto");
            System.out.println("e) Listar el nombre y el precio del producto mas barato");
            System.out.println("f) Ingresar un producto a la base de datos");
            System.out.println("g) Ingresar un fabricante a la base de datos");
            System.out.println("h) Editar un producto con datos a eleccion");
            System.out.println("x) Salir.");
            rta = sc.next();
            switch (rta) {
                case "a":
                    ps.mostrarProductos("SELECT nombre, codigo_fabricante FROM producto");
                    break;
                case "b":
                    ps.mostrarProductos("SELECT nombre, precio FROM producto");
                    break;
                case "c":
                    ps.mostrarProductos("SELECT * FROM producto WHERE precio > 120 AND precio < 202");
                    break;
                case "d":
                    ps.mostrarProductos("SELECT * FROM producto WHERE nombre LIKE 'porta%'");
                    break;
                case "e":
                    ps.mostrarProductos("SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1");
                    break;
                case "f":
                    try {
                        ps.agregarProducto();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "g":
                    try {
                        fs.agregarFab();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        ps.editarProducto();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "x":
                    System.out.println("Saliendo");
                    break;
            }

        } while (!rta.toUpperCase().equals("X"));

    }

}
