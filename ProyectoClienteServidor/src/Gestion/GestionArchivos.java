package Gestion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class GestionArchivos {

    private String ruta;
    private String nombre_archivo;
    private Planilla datos;
    

    public GestionArchivos(String ruta, String nombre_archivo, Planilla datos) {
        this.ruta = ruta;
        this.nombre_archivo = nombre_archivo;
        this.datos = datos;
    }

    public GestionArchivos() {
        this.ruta = "";
        this.nombre_archivo = "Planilla.txt";
        this.datos = new Planilla();
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

    public Planilla getDatos() {
        return datos;
    }

    public void setDatos(Planilla datos) {
        this.datos = datos;
    }

    
    public void abrir_conexion() {

        try {

            String contenido = "Contenido";
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

    public void agregar_planilla() {

        try {

            File file = new File(this.ruta + this.nombre_archivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(this.datos.getId() + "," + this.datos.getNombre() + ","
                    + this.datos.getSalario() + "," + this.datos.getCorreo());

            bw.flush();

            bw.newLine();

            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

  

    public void borrar_planilla(int id) {

        try {

            String identificacion, registro;

            int valida = 0;

            File tempDB = new File(this.ruta + "Planilla_temporal.txt");
            File db = new File(this.ruta + this.nombre_archivo);

            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            BufferedReader br = new BufferedReader(new FileReader(db));

            identificacion = JOptionPane.showInputDialog(null, "Borrar un registro de una plato: \n"
                    + "Ingrese el id del plato a borrar: ");

            while ((registro = br.readLine()) != null) {

                if (registro.contains(identificacion)) {
                    valida = 1;

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

            if (valida == 1) {
                JOptionPane.showMessageDialog(null, "Planilla eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Id no encontrado");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
    



}
