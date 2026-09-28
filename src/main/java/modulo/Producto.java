/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author LENOVO
 */
public class Producto {
    
    //Atributos de producto
    private int codigo;
    private String nombre;
    private double precio;
    private int contidadDisponible;
    
    
    //constructores
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int contidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.contidadDisponible = contidadDisponible;
    }
    
    //Get y set

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getContidadDisponible() {
        return contidadDisponible;
    }

    public void setContidadDisponible(int contidadDisponible) {
        this.contidadDisponible = contidadDisponible;
    }
    
}//Final de clase producto
