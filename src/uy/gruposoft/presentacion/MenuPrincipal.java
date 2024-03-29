/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.presentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import uy.gruposoft.excepciones.AfiliacionesException;
import uy.gruposoft.excepciones.AfiliadoException;
import uy.gruposoft.excepciones.DeudorException;
import uy.gruposoft.excepciones.LocalException;
import uy.gruposoft.excepciones.NegocioException;
import uy.gruposoft.excepciones.UsuarioException;

/**
 *
 * @author Administrador
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
	setIconImage();
        this.setExtendedState(this.MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        ImageIcon bg = new ImageIcon(getClass().getResource("/uy/gruposoft/assets/menu-bg.jpg"));
        Image image = bg.getImage();
        Ventanas = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        afiliados = new javax.swing.JMenuItem();
        locales = new javax.swing.JMenuItem();
        Usuario = new javax.swing.JMenuItem();
        Negocio = new javax.swing.JMenuItem();
        deudores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Afiliaciones = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal - GrupoSoft v.1");
        setBackground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(900, 800));

        javax.swing.GroupLayout VentanasLayout = new javax.swing.GroupLayout(Ventanas);
        Ventanas.setLayout(VentanasLayout);
        VentanasLayout.setHorizontalGroup(
            VentanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        VentanasLayout.setVerticalGroup(
            VentanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        jMenu1.setText("Formularios");

        afiliados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        afiliados.setText("Afiliados");
        afiliados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afiliadosActionPerformed(evt);
            }
        });
        jMenu1.add(afiliados);

        locales.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        locales.setText("Locales");
        locales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localesActionPerformed(evt);
            }
        });
        jMenu1.add(locales);

        Usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        Usuario.setText("Usuarios");
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(Usuario);

        Negocio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        Negocio.setText("Negocio");
        Negocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegocioActionPerformed(evt);
            }
        });
        jMenu1.add(Negocio);

        deudores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        deudores.setActionCommand("Deudores");
        deudores.setLabel("Deudores");
        deudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deudoresActionPerformed(evt);
            }
        });
        jMenu1.add(deudores);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Informes");

        Afiliaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK));
        Afiliaciones.setText("Listados De Afiliaciones");
        Afiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfiliacionesActionPerformed(evt);
            }
        });
        jMenu2.add(Afiliaciones);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cerrar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Cerrar sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ventanas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ventanas)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void afiliadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afiliadosActionPerformed
        // TODO add your handling code here:
        VentanaAfiliados verAfiliados = null;
        try {
            verAfiliados = new VentanaAfiliados();
        } catch (AfiliadoException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (JInternalFrames_AbiertosLocal(verAfiliados) == false) {
            Ventanas.add(verAfiliados);

            Dimension desktopSize = Ventanas.getSize();
            Dimension FrameSize = verAfiliados.getSize();
            verAfiliados.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            verAfiliados.show();

        }
        
    }//GEN-LAST:event_afiliadosActionPerformed

    public boolean JInternalFrames_Abiertos(VentanaDeUsuario jif) { // Creamos un metodo publico de tipo boolean.
        JInternalFrame[] jif_Activos = MenuPrincipal.Ventanas.getAllFrames(); // Este arreglo almacena todos los JInternalFrames que esten abierto en el jDesktopPane.

        for (int i = 0; i < jif_Activos.length; i++) { // Creamos un ciclo for para recorrer nuestro arreglo utilizando la propiedad length de nuestro arreglo.

            // Validamos con un if si nuestro arreglo en la posición i es igual al JInternalFrame que esta activo en el jDesktopPane, si es igual devolverá true.
            if (jif.getClass().isInstance(jif_Activos[i])) {
                JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }
    
    public boolean JInternalFrames_AbiertosNegocios(VentanaNegocios jif) { // Creamos un metodo publico de tipo boolean.
        JInternalFrame[] jif_Activos = MenuPrincipal.Ventanas.getAllFrames(); // Este arreglo almacena todos los JInternalFrames que esten abierto en el jDesktopPane.

        for (int i = 0; i < jif_Activos.length; i++) { // Creamos un ciclo for para recorrer nuestro arreglo utilizando la propiedad length de nuestro arreglo.

            // Validamos con un if si nuestro arreglo en la posición i es igual al JInternalFrame que esta activo en el jDesktopPane, si es igual devolverá true.
            if (jif.getClass().isInstance(jif_Activos[i])) {
                JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }


    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        // TODO add your handling code here:
        VentanaDeUsuario verUsuarios = null;
        try {
            verUsuarios = new VentanaDeUsuario();
        } catch (UsuarioException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (JInternalFrames_Abiertos(verUsuarios) == false) { //Solo si es false se abrirá el InternalFrame ya que si devuelve true es porque esta abierto el mismo InternalFrame.
            Ventanas.add(verUsuarios);
            
                      
            Dimension desktopSize = Ventanas.getSize();
            Dimension FrameSize = verUsuarios.getSize();
            verUsuarios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            verUsuarios.show();

        }
    }//GEN-LAST:event_UsuarioActionPerformed

    private void localesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localesActionPerformed
        // TODO add your handling code here:
        VentanaLocales verLocales = null;
        try {
            verLocales = new VentanaLocales();
        } catch (LocalException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (JInternalFrames_AbiertosLocal(verLocales) == false) {
            Ventanas.add(verLocales);

            Dimension desktopSize = Ventanas.getSize();
            Dimension FrameSize = verLocales.getSize();
            verLocales.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            verLocales.show();

        }
    }//GEN-LAST:event_localesActionPerformed


    private void AfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfiliacionesActionPerformed
        VentanaAfiliaciones verAfiliaciones = null;
        try {
            verAfiliaciones = new VentanaAfiliaciones();
        } catch (AfiliacionesException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (JInternalFrames_AbiertosAfiliaciones(verAfiliaciones) == false) {
            Ventanas.add(verAfiliaciones);

            Dimension desktopSize = Ventanas.getSize();
            Dimension FrameSize = verAfiliaciones.getSize();
            verAfiliaciones.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            verAfiliaciones.show();

        }
    }//GEN-LAST:event_AfiliacionesActionPerformed
     public boolean JInternalFrames_AbiertosAfiliaciones(VentanaAfiliaciones jif) { 
    JInternalFrame[] jif_Activos = MenuPrincipal.Ventanas.getAllFrames();

    for (int i = 0; i < jif_Activos.length; i++) {

        if (jif.getClass().isInstance(jif_Activos[i])) {
            JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    return false;
     }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
	Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void deudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deudoresActionPerformed
        // TODO add your handling code here:
        VentanaDeudores verDeudores = null;
        try {
            
            verDeudores = new VentanaDeudores();
            
        } catch (DeudorException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (JInternalFrames_AbiertosDeudor(verDeudores) == false) { 
            Ventanas.add(verDeudores);
            
                      
            Dimension desktopSize = Ventanas.getSize();
            Dimension FrameSize = verDeudores.getSize();
            verDeudores.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            verDeudores.show();
    }//GEN-LAST:event_deudoresActionPerformed

    }
    
    private void NegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegocioActionPerformed
        // TODO add your handling code here:
	VentanaNegocios verNegocios = null;
        try {
            verNegocios = new VentanaNegocios();
        } catch (NegocioException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (JInternalFrames_AbiertosNegocios(verNegocios) == false) { //Solo si es false se abrirá el InternalFrame ya que si devuelve true es porque esta abierto el mismo InternalFrame.
            Ventanas.add(verNegocios);
            
                      
            Dimension desktopSize = Ventanas.getSize();
            Dimension FrameSize = verNegocios.getSize();
            verNegocios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            verNegocios.show();

        }
    }//GEN-LAST:event_NegocioActionPerformed
    
    

    public boolean JInternalFrames_AbiertosLocal(VentanaLocales jif) { 
    JInternalFrame[] jif_Activos = MenuPrincipal.Ventanas.getAllFrames();

    for (int i = 0; i < jif_Activos.length; i++) {

        if (jif.getClass().isInstance(jif_Activos[i])) {
            JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    return false;
    }
    
    public boolean JInternalFrames_AbiertosLocal(VentanaAfiliados jif) { 
    JInternalFrame[] jif_Activos = MenuPrincipal.Ventanas.getAllFrames();

    for (int i = 0; i < jif_Activos.length; i++) {

        if (jif.getClass().isInstance(jif_Activos[i])) {
            JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    return false;
    }
    
    
    
    public boolean JInternalFrames_AbiertosDeudor(VentanaDeudores jif) { 
    JInternalFrame[] jif_Activos = MenuPrincipal.Ventanas.getAllFrames();

    for (int i = 0; i < jif_Activos.length; i++) {

        if (jif.getClass().isInstance(jif_Activos[i])) {
            JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    return false;
    }
    
    

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Afiliaciones;
    private javax.swing.JMenuItem Negocio;
    private javax.swing.JMenuItem Usuario;
    private static javax.swing.JDesktopPane Ventanas;
    private javax.swing.JMenuItem afiliados;
    private javax.swing.JMenuItem deudores;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem locales;
    // End of variables declaration//GEN-END:variables
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/uy/gruposoft/assets/windows-icon.png")));
    }
}
