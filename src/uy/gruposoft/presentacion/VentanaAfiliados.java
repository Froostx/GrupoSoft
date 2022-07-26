/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.presentacion;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uy.gruposoft.excepciones.AfiliadoException;
import uy.gruposoft.logica.Afiliado;
import uy.gruposoft.logica.Afiliados;
import uy.gruposoft.logica.FachadaLogica;
import uy.gruposoft.logica.Paises;

/**
 *
 * @author Administrador
 */
public class VentanaAfiliados extends javax.swing.JInternalFrame {

    /**
     * Creates new form Afiliados
     */
    public VentanaAfiliados() throws AfiliadoException {
        initComponents();
        mostrarAfiliados();
        cargarPaises();
    }

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

    public static void mostrarAfiliados() throws AfiliadoException {

        String[] nombresColumnas = {"Cedula", "Nombre", "Apellido", "Nacionalidad", "Direccion", "Telefono", "Email", "Nacimiento", "Numero_Local", "Propietario", "Fecha Alta"};
        Afiliados afiliados = FachadaLogica.cargarAfiliados();
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < afiliados.getAfiliados().size(); i++) {
            fila[0] = afiliados.getAfiliados().get(i).getCedula();
            fila[1] = afiliados.getAfiliados().get(i).getNombre();
            fila[2] = afiliados.getAfiliados().get(i).getApellido();
            fila[3] = afiliados.getAfiliados().get(i).getNacionalidad();
            fila[4] = afiliados.getAfiliados().get(i).getDireccion();
            fila[5] = afiliados.getAfiliados().get(i).getTelefono();
            fila[6] = afiliados.getAfiliados().get(i).getMail();
            fila[7] = afiliados.getAfiliados().get(i).getNacimiento();
            fila[8] = afiliados.getAfiliados().get(i).getNumeroLocal();
            fila[9] = afiliados.getAfiliados().get(i).isPropietario();
            fila[10] = afiliados.getAfiliados().get(i).getFechaAlta();

            modelo.addRow(fila);

        }
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(10).setPreferredWidth(80);

        tabla.setAutoResizeMode(tabla.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);
    }

    public void cargarPaises() throws AfiliadoException {
        Paises paises = FachadaLogica.cargarPaises();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (int i = 0; i < paises.getPaises().size(); i++) {
            model.addElement(paises.getPaises().get(i).getPais());

        }
       
        model.setSelectedItem("Seleccione Un Pais...");
        nacionalidad.setModel(model);
        
    }

    public void validarAfiliado() throws AfiliadoException {

        Date date = nacimiento.getDate(); //ic es la interfaz, jDate el JDatechooser

        long d = date.getTime(); //guardamos en un long el tiempo

        java.sql.Date nacimientoAfiliado = new java.sql.Date(d);// parseamos al formato del sql  

        String nombreAfiliado = nombre.getText();
        String apellidoAfiliado = apellido.getText();
        String nacionalidadAfiliado = (String) nacionalidad.getSelectedItem();
        String direccionAfiliado = direccion.getText();
        String telefonoAfiliado = telefono.getText();
        String mailAfiliado = mail.getText();

        int numeroLocal = Integer.parseInt(local.getText());
        boolean propietarioAfiliado = propietario.isSelected();
        if (caracteresValidos(nombreAfiliado.trim()) && caracteresValidos(apellidoAfiliado.trim()) && !caracteresValidos(cedula.getText()) && !caracteresValidos(String.valueOf(numeroLocal))) {
            int cI = Integer.parseInt(cedula.getText());
            Afiliado afiliado = new Afiliado();

            afiliado.setCedula(cI);
            afiliado.setNombre(nombreAfiliado);
            afiliado.setApellido(apellidoAfiliado);
            afiliado.setNacionalidad(nacionalidadAfiliado);
            afiliado.setDireccion(direccionAfiliado);
            afiliado.setTelefono(telefonoAfiliado);
            afiliado.setMail(mailAfiliado);
            afiliado.setNacimiento(nacimientoAfiliado);
            afiliado.setNumeroLocal(numeroLocal);
            afiliado.setPropietario(propietarioAfiliado);

            FachadaLogica.insertarAfiliado(afiliado);
            FachadaLogica.cargarAfiliados();
            mostrarAfiliados();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese Caracteres Validos");
        }

    }

    public static boolean caracteresValidos(String datos) {
        return datos.matches("[a-z A-Z]*");

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
        cedula = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nacionalidad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        local = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nuevoAfiliado = new javax.swing.JButton();
        nacimiento = new com.toedter.calendar.JDateChooser();
        propietario = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));
        setPreferredSize(new java.awt.Dimension(1150, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Afiliado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cedula");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nacionalidad");

        nacionalidad.setToolTipText("");
        nacionalidad.setAutoscrolls(true);
        nacionalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacionalidadActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Direccion");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Telefono");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Mail");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Nacimiento");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Numero Local");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Propietario");

        nuevoAfiliado.setText("Crear Afiliado");
        nuevoAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoAfiliadoActionPerformed(evt);
            }
        });

        propietario.setText("SI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(local, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nacionalidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(propietario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(nuevoAfiliado)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(propietario))
                .addGap(18, 18, 18)
                .addComponent(nuevoAfiliado)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, 350, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista De Afiliados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 66, 726, 600));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Buscar Por Cedula");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 31, -1, -1));
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 26, 144, -1));

        modificar.setText("Modificar");
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 22, -1, -1));

        eliminar.setText("Eliminar");
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1026, 22, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoAfiliadoActionPerformed
        try {
            // TODO add your handling code here:
            validarAfiliado();
        } catch (AfiliadoException ex) {
            Logger.getLogger(VentanaAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_nuevoAfiliadoActionPerformed

    private void nacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacionalidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField local;
    private javax.swing.JTextField mail;
    private javax.swing.JButton modificar;
    private com.toedter.calendar.JDateChooser nacimiento;
    private javax.swing.JComboBox<String> nacionalidad;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevoAfiliado;
    private javax.swing.JRadioButton propietario;
    private static javax.swing.JTable tabla;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables

}
