/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.TiendaDAO;
import entidades.Fabricante;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Flia Vasquez
 */
public class FabricanteService {

    TiendaDAO tdao = new TiendaDAO();

    public void mostrarFabricantes(String query) {
        ArrayList<Fabricante> fabricantes = tdao.listarFabricantes(query);
        for (Fabricante fabricante : fabricantes) {
            if (fabricante.getCodigo() == null) {

            } else {
                System.out.print(fabricante.getCodigo() + "|");
            }

            if (fabricante.getNombre() == null) {

            } else {
                System.out.print(fabricante.getNombre());
            }
        }
        System.out.println("");
    }

    public void agregarFab() {
        try {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingresando fabricantes");
            System.out.println("Codigo: ");
            Integer codigo = sc.nextInt();
            System.out.println("Nombre: ");
            String nombre = sc.next();
            String query = "INSERT INTO fabricante VALUES(" + codigo + ",'" + nombre + "')";
            tdao.editarAgregar(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
