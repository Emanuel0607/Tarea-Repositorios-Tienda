/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Inventario {

    //arreglo que almacena hasta los 10 productos
    private Producto[] productos;
    private int cantidad;

    public Inventario() {

        productos = new Producto[10];
        cantidad = 0;

    }

    //Registrar un producto
    public void registroProducto(Producto producto) {

        //if para verificar si ya se superó la capacidad máxima
        if (cantidad >= 10) {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más de 10 productos.\n"
                    + "El inventario está lleno");

            return;
        }

        //for para verificar si el codigo ya existe
        for (int i = 0; i < cantidad; i++) {

            if (productos[i].getCodigo() == producto.getCodigo()) {
                JOptionPane.showMessageDialog(null, "No se puede registrar el producto.\n"
                        + "El código ya existe.");
                return;
            }

        }//final de for

        //Guardar el producto en la sigueinte posisción disponible
        productos[cantidad] = producto;
        cantidad++;

        JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");

    }

    //Mostrar todos los productos registrados
    public void mostrarProductos() {

        //if para verificar si no hay productos
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");

            return;
        }

        //for para recorrer solo las posiciones ocupadas
        for (int i = 0; i < cantidad; i++) {

            JOptionPane.showMessageDialog(null, "===== PRODUCTO " + (i + 1) + " =====\n"
                    + "Código: " + productos[i].getCodigo() + "\n"
                    + "Nombre: " + productos[i].getNombre() + "\n"
                    + "Precio: ₡" + productos[i].getPrecio() + "\n"
                    + "Cantidad disponible: "
                    + productos[i].getContidadDisponible());
        }

    }

    //buscar un producto por codigo
    public Producto buscarProducto(int codigo) {

        for (int i = 0; i < cantidad; i++) {

            if (productos[i].getCodigo() == codigo) {

                return productos[i];
            }
        }

        //Si no se encontró
        return null;
    }

    //Vender productos por unidad
    public void venderUnidades(int codigo, int unidades) {

        Producto producto = buscarProducto(codigo);

        //if para verificar si existe
        if (producto == null) {
            JOptionPane.showMessageDialog(null, "No existe un producto con ese código.");

            return;
        }

        //Verificar si la cantidad es mayor a 0
        if (unidades <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número mayor a cero.");

            return;
        }

        //if para verificar si hay suficientes unidades
        if (unidades > producto.getContidadDisponible()) {
            JOptionPane.showMessageDialog(null, "No hay suficientes unnidades dsiponibles.\n"
                    + "Cantidad disponible: " + producto.getContidadDisponible());

        }

        //Quitar una existencia cuando se venda un producto
        producto.setContidadDisponible(producto.getContidadDisponible() - unidades);

        JOptionPane.showMessageDialog(null, "Venta realizada de forma correcta.\n"
                + "Unidades vendidas: " + unidades
                + "\nUnidades restantes: " + producto.getContidadDisponible());

    }

    //rellenar un producto
    public void rellenarProducto(int codigo, int unidades) {

        //buscar el producto
        Producto producto = buscarProducto(codigo);

        //ver si ya existe
        if (producto == null) {
            JOptionPane.showMessageDialog(null, "No existe un producto con ese código");

            return;

        }

        //Verificar si la cantidad es mayor a 0
        if (unidades <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número mayor a cero.");

            return;
        }

        //Aunmentar las existencas del producto
        producto.setContidadDisponible(producto.getContidadDisponible() + unidades);

        JOptionPane.showMessageDialog(null, "Producto rellenado correctamente.\n"
                + "Cantidad disponible: " + producto.getContidadDisponible());

    }
    
    //Calcular el valor del inventario
    public double calcularInventario() {
    
        double total = 0;
        
        for (int i = 0; i < cantidad; i++) {
        
            total += productos[i].getPrecio() * productos[i].getContidadDisponible();
        }
        
        return total;
    }

}//Fin de clase Inventario
