
package Gestion;

import java.util.Scanner;


public class Planilla {
    private int id;
    private String nombre;
    private double salario;
    private String correo;
    private Scanner teclado;

    public Planilla(int id, String nombre, double salario, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.correo = correo;
    }
     public Planilla() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

}
