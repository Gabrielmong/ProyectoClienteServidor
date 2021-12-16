/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclienteservidor;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenu2 = new javax.swing.JMenu();
        mit_generaRep = new javax.swing.JMenuItem();
        mit_agregarPlan = new javax.swing.JMenuItem();
        mit_eliminarPlan = new javax.swing.JMenuItem();
        JMenu3 = new javax.swing.JMenu();
        mit_cerrarSesion = new javax.swing.JMenuItem();
        mit_cierraApp = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JMenu2.setText("Planilla");

        mit_generaRep.setText("Generar reporte");
        JMenu2.add(mit_generaRep);

        mit_agregarPlan.setText("Agregar a planilla");
        JMenu2.add(mit_agregarPlan);

        mit_eliminarPlan.setText("Eliminar de planilla");
        JMenu2.add(mit_eliminarPlan);

        jMenuBar1.add(JMenu2);

        JMenu3.setText("Salir");

        mit_cerrarSesion.setText("Cerrar sesion");
        mit_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mit_cerrarSesionActionPerformed(evt);
            }
        });
        JMenu3.add(mit_cerrarSesion);

        mit_cierraApp.setText("Cerrar aplicacion");
        mit_cierraApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mit_cierraAppActionPerformed(evt);
            }
        });
        JMenu3.add(mit_cierraApp);

        jMenuBar1.add(JMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mit_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mit_cerrarSesionActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        Administrador acceso = new Administrador();
        acceso.setVisible(true);
        acceso.setLocationRelativeTo(null);
        acceso.setTitle("Menú de admin");
    }//GEN-LAST:event_mit_cerrarSesionActionPerformed

    private void mit_cierraAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mit_cierraAppActionPerformed
        // TODO add your handling code here:
        
         int salir=JOptionPane.showConfirmDialog(null, 
                "Desea salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(salir==0){
            
            System.exit(0);
        }
    }//GEN-LAST:event_mit_cierraAppActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenu2;
    private javax.swing.JMenu JMenu3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mit_agregarPlan;
    private javax.swing.JMenuItem mit_cerrarSesion;
    private javax.swing.JMenuItem mit_cierraApp;
    private javax.swing.JMenuItem mit_eliminarPlan;
    private javax.swing.JMenuItem mit_generaRep;
    // End of variables declaration//GEN-END:variables
}
