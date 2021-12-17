package proyectoclienteservidor;

import javax.swing.JOptionPane;


public class gestionPlato extends plato {
    
     protected double impuesto;
     private double precioFinal;

    public gestionPlato(double impuesto, String nombre, String ID, double precio) {
        super(nombre, ID, precio);
        this.impuesto = impuesto;
    }

    public gestionPlato(double impuesto) {
        this.impuesto = impuesto;
    }

     @Override
    public String getID() {
        return ID;
    }

     @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public gestionPlato() {
        super();
        this.impuesto = 0;
    }
    
    
   

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

     @Override
    public String getNombre() {
        return nombre;
    }

     @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     @Override
    public double getPrecio() {
        return precio;
    }

     @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
       public void calcularImpuesto (){
        
        precioFinal = this.precio * 0.13;
        
        impuesto = precioFinal + impuesto;
        
        
    }
    

  
    
//    
//      @Override
//    public void imprimirDatos(){
//       
//        super.imprimirDatos();
//
//        JOptionPane.showMessageDialog(null,
//                "Precio con impuesto: "+this.impuesto ); 
//        
//        
    }
     
    

