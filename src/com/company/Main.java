//Modifica el programa anterior para para calcular el IVA de 3 productos, el programa deberá solicitar
//el nombre del producto y el precio, al final deberá retornarnos el monto final mas el IVA (puede usar
//un Map).
// solicitar nombre y precio de 3 productos
//calcular el iva de precio
//mostrar nombre y precio


package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<Integer, Producto> productosMap = new HashMap<Integer, Producto>();

        String nombre = "";
        double precio = 0.0;
        double iva = 0.0;

        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese Nombre Producto: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese Costo Producto: ");
            precio = sc.nextDouble();
            iva = precio*0.13;
            productosMap.put(i, new Producto(nombre, precio, iva));
        }
        System.out.println(productosMap);

        try (PrintWriter out = new PrintWriter("productos.txt")){
            out.println(productosMap);
        }
    }
}

class Producto {
    public Producto(String n, double p, double i) {
        nombre = n;
        precio = p;
        iva = i;
    }

    public String toString() {
        return "Nombre: " + nombre + " Precio: " + precio+ " Costo IVA: "+iva;
    }

    private String nombre;
    private double precio;
    private double iva;
}