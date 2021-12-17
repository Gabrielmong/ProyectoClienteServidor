package proyectoclienteservidor;

import javax.swing.JOptionPane;


public class plato {
    
     protected String nombre,ID;
     
     protected double precio;

    public plato(String nombre, String ID, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ID = ID;
        
    }
    
    public plato() {
        this.nombre = "";
        this.precio = 0;
        this.ID = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
     
//      public void imprimirDatos(){
//         
//         JOptionPane.showMessageDialog(null,
//                "Informacion de plato:\n "
//                + "Nombre: " + this.nombre 
//                +"Precio: "+this.precio+"\n");
//         
//         
//         
//     }  
     
}
