/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoclienteservidor;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author Usuario
 */
public class frm_menuComida extends javax.swing.JFrame implements Runnable {
    
   String hora, min, seg, ampm;
    Calendar calendario;
    Thread h1;
private Ventana v=new Ventana();
    
    
    /**
     * Creates new form frm_menuComida
     */
 static int contador = 0;
    public frm_menuComida() {
        initComponents();
        hilo();
   h1 = new Thread(this);
        h1.start();
    }
    
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lbl_hora.setText(hora + ":" + min + ":" + seg + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }
        }
    }
     private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraactual = new Date();
        calendario.setTime(fechaHoraactual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            if(h==00){
                   hora="12";
             }else{
                   hora=h>9?""+h:"0"+h;
             }      
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

public void hilo (){
    int velocidad = 2;//es en s
        Timer timer;
        TimerTask tarea;
        
     //  frm_menuComida imagen = new frm_menuComida();
     //  imagen.setVisible(true);
        
        int velmil = velocidad * 1000;
          tarea = new TimerTask() {

            @Override
            public void run() {
                Icon icono;

                switch (contador) {
                    case 0:
                        contador = 1;
                        icono = new ImageIcon(getClass().getResource("/iconos/dia.jpg"));
                       jLabel1.setIcon(icono);
                        break;
                    case 1:
                        contador = 2;
                        icono = new ImageIcon(getClass().getResource("/iconos/tarde.jpg"));
                        jLabel1.setIcon(icono);
                        break;
                    case 2 :
                        contador = 0;
                        icono = new ImageIcon(getClass().getResource("/iconos/mañana.jpg"));
                        jLabel1.setIcon(icono);
                        break;

                }

            }

        };
         timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velmil, velmil);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_menuManana = new javax.swing.JButton();
        lbl_selecMenu = new javax.swing.JLabel();
        btn_menuDia = new javax.swing.JButton();
        btn_menuTarde = new javax.swing.JButton();
        btn_salir1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));

        btn_menuManana.setBackground(new java.awt.Color(255, 255, 102));
        btn_menuManana.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_menuManana.setText("Menu mañana");
        btn_menuManana.setBorderPainted(false);
        btn_menuManana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuMananaActionPerformed(evt);
            }
        });

        lbl_selecMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_selecMenu.setText("SELECCIONE SU MENU");

        btn_menuDia.setBackground(new java.awt.Color(255, 204, 0));
        btn_menuDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_menuDia.setText("Menu dia");
        btn_menuDia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_menuDia.setBorderPainted(false);
        btn_menuDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuDiaActionPerformed(evt);
            }
        });

        btn_menuTarde.setBackground(new java.awt.Color(255, 102, 0));
        btn_menuTarde.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_menuTarde.setText("Menu tarde");
        btn_menuTarde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_menuTarde.setBorderPainted(false);
        btn_menuTarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuTardeActionPerformed(evt);
            }
        });

        btn_salir1.setBackground(new java.awt.Color(204, 0, 0));
        btn_salir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_salir1.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir1.setText("Salir");
        btn_salir1.setBorderPainted(false);
        btn_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/mañana.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        lbl_hora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_selecMenu)
                        .addGap(115, 115, 115)
                        .addComponent(lbl_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_menuManana)
                        .addGap(94, 94, 94)
                        .addComponent(btn_menuDia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btn_menuTarde, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_salir1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_selecMenu)
                    .addComponent(lbl_hora))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_menuManana, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_menuDia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_menuTarde, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_salir1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuMananaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuMananaActionPerformed
        // TODO add your handling code here:
        
        
        
        frm_menuManana menuM = new frm_menuManana();
                
      
        menuM.setVisible(true);
        menuM.setLocationRelativeTo(null);
        menuM.setTitle("Gestion Menus");


    }//GEN-LAST:event_btn_menuMananaActionPerformed

    private void btn_menuDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuDiaActionPerformed
        // TODO add your handling code here:
        
         frm_menuManana menuM = new frm_menuManana();
                
        
        menuM.setVisible(true);
        menuM.setLocationRelativeTo(null);
        menuM.setTitle("Gestion Menus");
    }//GEN-LAST:event_btn_menuDiaActionPerformed

    private void btn_menuTardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuTardeActionPerformed
        // TODO add your handling code here:
        
         frm_menuManana menuM = new frm_menuManana();
                
        
        menuM.setVisible(true);
        menuM.setLocationRelativeTo(null);
        menuM.setTitle("Gestion Menus");
    }//GEN-LAST:event_btn_menuTardeActionPerformed

    private void btn_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir1ActionPerformed
        // TODO add your handling code here:

        v.setVisible(true);
        v.setLocationRelativeTo(null);
       // v.setTitle("");
        
        this.dispose();
    }//GEN-LAST:event_btn_salir1ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_menuComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_menuComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_menuComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_menuComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_menuComida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menuDia;
    private javax.swing.JButton btn_menuManana;
    private javax.swing.JButton btn_menuTarde;
    private javax.swing.JButton btn_salir1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_selecMenu;
    // End of variables declaration//GEN-END:variables

    public Ventana getV() {
        return v;
    }

    public void setV(Ventana v) {
        this.v = v;
    }
}
