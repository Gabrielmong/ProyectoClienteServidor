package proyectoclienteservidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class manejoArchivo  {

    private String ruta;
    private String nombre_archivo;
    private gestionPlato obj_plato;
    private final DecimalFormat df=new DecimalFormat("0.00");
    

    public manejoArchivo(String ruta, String nombre_archivo, gestionPlato obj_plato) {
        this.ruta = ruta;
        this.nombre_archivo = nombre_archivo;
        this.obj_plato = obj_plato;
    }

    public manejoArchivo() {
        this.ruta = "";
        this.nombre_archivo = "platoM.txt";
        this.obj_plato = new gestionPlato();
    }
    
    public manejoArchivo(gestionPlato obj_plato) {
        this.ruta = "";
        this.nombre_archivo = "platoM.txt";
        this.obj_plato = obj_plato;
    }
    
    public manejoArchivo( String nombre_archivo) {
        this.ruta = "";
        this.nombre_archivo = "";
        this.obj_plato = new gestionPlato();
    }


    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public gestionPlato getObj_plato() {
        return obj_plato;
    }

    public void setObj_plato(gestionPlato obj_plato) {
        this.obj_plato = obj_plato;
    }

  

    public void conexion() {

        try {

            String contenido = "";
            File file = new File(this.ruta + this.nombre_archivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(contenido);

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarPlato(int nombreMenu) {

        try {
            
            switch(nombreMenu){
                
                case 0:{
                    
                    this.nombre_archivo = "platoM.txt";
                    
                    break;
                }
                case 1:{
                    
                    this.nombre_archivo = "platoD.txt";
                    
                    break;
                }
                case 2:{
                    
                    this.nombre_archivo = "platoT.txt";
                    
                    
                } 
                
                
            }
            
            gestionPlato imp=new gestionPlato();
           // imp.calc_impuesto(this.obj_plato.getPrecio());
            
            this.obj_plato.setImpuesto(Double.parseDouble(df.format(imp.calc_impuesto(this.obj_plato.getPrecio()))));
            
            
            //this.nombre_archivo = "platoD.txt";
            File file = new File(this.ruta + this.nombre_archivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw= new BufferedWriter(fw);
            
            bw.write(this.obj_plato.getID()+" / "+this.obj_plato.getNombre()+" / "+this.obj_plato.getPrecio()+" / "+this.obj_plato.getImpuesto());
            
            bw.flush();
            
            bw.newLine();
            
            bw.close();
        } catch (Exception e) {
        }

    }
    
    
    public void menu_Manana(int nombreMenu){
        
         try{
            
            String registro;
            
            switch(nombreMenu){
                
                case 0:{
                    
                    this.nombre_archivo = "platoM.txt";
                    
                    break;
                }
                case 1:{
                    
                    this.nombre_archivo = "platoD.txt";
                    
                    break;
                }
                case 2:{
                    
                    this.nombre_archivo = "platoT.txt";
                    
                    
                } 
                
                
            }
                    
                    
            //this.nombre_archivo = "platoD.txt";
            
            File file = new File (this.ruta+this.nombre_archivo);
            
            if (!file.exists()){
                
                file.createNewFile();
                JOptionPane.showMessageDialog(null, "No hay registros de platos en el archivo");
                return;
                
            }
            
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            
            String temp="";
            
            temp= "-         Menu           -\n";
            temp+="  ID    Nombre       Precio       Precio I.V.I\n";
        
             while ((registro= br.readLine())!=null){
                
                StringTokenizer st= new StringTokenizer (registro,"/");
                
                temp+= "  " + st.nextToken() + "     " + st.nextToken()+"     " + st.nextToken() +"     " + st.nextToken() +"\n" ;
                
                
            }
           
            temp+= "----------------------------------\n\n";
            
            br.close();
            
            JOptionPane.showMessageDialog(null, temp);
        
    }catch (Exception ex){
            ex.printStackTrace();
        }

         
         
}
    
    
    
    public void eliminarPlato(int nombreMenu,String ID){
        
        try{
            
            String registro;
            
            
            switch(nombreMenu){
                
                case 0:{
                    
                    this.nombre_archivo = "platoM.txt";
                    
                    break;
                }
                case 1:{
                    
                    this.nombre_archivo = "platoD.txt";
                    
                    break;
                }
                case 2:{
                    
                    this.nombre_archivo = "platoT.txt";
                    
                    
                } 
                
                
            }
            
            int valida=0;
            
            
            
            File tempDB= new File (this.ruta+"Platos_temporal.txt");
            File db= new File (this.ruta+this.nombre_archivo);
            
            
            BufferedWriter bw= new BufferedWriter(new FileWriter(tempDB));
            
           
            BufferedReader br= new BufferedReader(new FileReader(db));
            
            
            
            while ((registro= br.readLine())!=null){
                
                if (registro.contains(ID)){
                    valida=1;
                    
                    continue;
                }
                
                
                bw.write(registro);
                bw.flush();
                bw.newLine();     
            }
            br.close();
            bw.close();
            
            db.delete();
            tempDB.renameTo(db);
                    
            if (valida==1){
                JOptionPane.showMessageDialog(null,"Registro Eliminado Correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"ID no encontrado en el archivo");
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
            
        }
        
        
        
    }
    
    
    
}
