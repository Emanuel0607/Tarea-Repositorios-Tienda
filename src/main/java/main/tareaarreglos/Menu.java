/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.tareaarreglos;

import javax.swing.JOptionPane;
import modulo.Inventario;
import modulo.Producto;

/**
 *
 * @author LENOVO
 */
public class Menu {

    private Inventario inventario;

    public Menu() {

        inventario = new Inventario();
    }

    public void menuPrincipal() {

        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("----- SISTEMA DE INVENTARIO -----\n"
                    + "1. Regsitrar producto\n"
                    + "2. Mostrar productos\n"
                    + "3. Buscar producto por código\n"
                    + "4. Vender unidades\n"
                    + "5. Reabastecer producto\n"
                    + "6. Calcular valor total del inventario\n"
                    + "7. Salir\n"));

            switch (opcion) {

                case 1:
                    registroProducto();
                    break;

                case 2:
                    inventario.mostrarProductos();
                    break;

                case 3:
                    buscarProducto();
                    break;

                case 4:
                    venderUnidades();
                    break;
                case 5:
                    reabastecerProducto();
                    break;

                case 6:
                    calcularInventario();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
            }

        } while (opcion != 7);
    }

    //Solicitar los datos y registrar un producto
    private void registroProducto() {

        int codigo;
        String nombre;
        double precio = 0;
        int cantidadDisponible;

        //Solicitar el codigo
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto: "));

        if (codigo <= 0) {
            JOptionPane.showMessageDialog(null, "El código debe ser mayor que cero.");

            return;
        }

        // Solicitar nombre
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");

        // Solicitar precio
        precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));

        // Verificar que el precio sea positivo
        if (precio <= 0) {JOptionPane.showMessageDialog(null,"El precio debe ser mayor que cero.");

            return;
        }

        // Solicitar cantidad disponible
        cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible: "));

        // Verificar que la cantidad sea positiva
        if (cantidadDisponible <= 0) {
            JOptionPane.showMessageDialog(null,
                    "La cantidad disponible debe ser mayor que cero.");
            return;
        }

        // Crear el objeto Producto
        Producto producto = new Producto(codigo, nombre, precio, cantidadDisponible);

        // Enviar el producto al inventario
        inventario.registroProducto(producto);
    }

    // Buscar un producto por código
    private void buscarProducto() {
        int codigo;

        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto que desea buscar:"));

        Producto producto = inventario.buscarProducto(codigo);

        if (producto == null) {
            JOptionPane.showMessageDialog(null, "No existe un producto con el código " + codigo + ".");

        } else {

            JOptionPane.showMessageDialog(null, "----- PRODUCTO ENCONTRADO -----\n\n"
                    + "Código: " + producto.getCodigo() + "\n"
                    + "Nombre: " + producto.getNombre() + "\n"
                    + "Precio: "
                    + String.format("%.2f", producto.getPrecio()) + "\n"
                    + "Cantidad disponible: "
                    + producto.getContidadDisponible());
        }
    }

    // Vender unidades de un producto
    private void venderUnidades() {

        int codigo;
        int unidades;

        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto:"));

        unidades = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea vender:"));

        inventario.venderUnidades(codigo, unidades);
    }

    // Reabastecer un producto
    private void reabastecerProducto() {

        int codigo;
        int unidades;

        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto:"));

        unidades = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea agregar:"));

        inventario.reabastecerProducto(codigo, unidades);
    }

    // Calcular el valor total del inventario
    private void calcularInventario() {

        double total = inventario.calcularInventario();

        JOptionPane.showMessageDialog(null,
                "----- VALOR TOTAL DEL INVENTARIO -----\n\n"
                + "Valor total: "
                + String.format("%.2f", total));
    }

}//Fin de la clase Menu
