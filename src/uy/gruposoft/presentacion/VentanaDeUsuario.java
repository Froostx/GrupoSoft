/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.presentacion;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uy.gruposoft.excepciones.UsuarioException;
import uy.gruposoft.logica.FachadaLogica;
import uy.gruposoft.logica.Usuario;
import uy.gruposoft.logica.Usuarios;

/**
 *
 * @author Administrador
 */
public class VentanaDeUsuario extends javax.swing.JInternalFrame {

    public Usuario usuarioFilaSeleccionada = new Usuario();

    /**
     * Creates new form VentanaDeUsuario
     */
    public VentanaDeUsuario() throws UsuarioException {
        initComponents();
        mostrarUsuarios();

    }

    public static void mostrarUsuarios() throws UsuarioException {

        String[] nombresColumnas = {"Id", "Usuario", "Nombre", "Apellido", "Email", "Contraseña", "Fecha Alta"};
        Usuarios usuarios = FachadaLogica.cargarUsuario();
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
            fila[0] = usuarios.getUsuarios().get(i).getId();
            fila[1] = usuarios.getUsuarios().get(i).getUsuario();
            fila[2] = usuarios.getUsuarios().get(i).getNombre();
            fila[3] = usuarios.getUsuarios().get(i).getApellido();
            fila[4] = usuarios.getUsuarios().get(i).getEmail();
            fila[5] = usuarios.getUsuarios().get(i).getClave();
            fila[6] = usuarios.getUsuarios().get(i).getFechaAlta();

            modelo.addRow(fila);

        }
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(60);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ingresoUsuario = new javax.swing.JTextField();
        nombreTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apellidoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        insertarUsuario = new javax.swing.JButton();
        claveTxt = new javax.swing.JPasswordField();
        buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Usuarios");
        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista De Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Clave");

        insertarUsuario.setText("Crear Usuario");
        insertarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addComponent(jLabel4))
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertarUsuario)
                    .addComponent(ingresoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(apellidoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(claveTxt))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(claveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(insertarUsuario)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardar)
                        .addComponent(eliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void validarUsuario() throws UsuarioException {
        try {
            //obtengo los valores de las cajas de texto
            String nombreUsuario = this.ingresoUsuario.getText();
            String nombre = this.nombreTxt.getText();
            String apellido = this.apellidoTxt.getText();
            String email = this.emailTxt.getText();
            String clave = new String(claveTxt.getPassword());

            //valido que no se ingresen numeros en los campos usuario, nombre y apellido
            if (caracteresValidos(nombre.trim()) && caracteresValidos(apellido.trim()) && caracteresValidos(nombreUsuario.trim())) {
                //creo un objeto de tipo Usuario

                Usuario usuario = new Usuario();

                usuario.setUsuario(nombreUsuario);
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setEmail(email);
                usuario.setClave(clave);

                if (FachadaLogica.verificarUsuario(usuario)) {
                    JOptionPane.showMessageDialog(this, " El usuario ya existe, ingrese otro");

                    return;

                }
//       
                FachadaLogica.ingresarUsuario(usuario);

                JOptionPane.showMessageDialog(this, "El usuario se ingreso correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Caracteres Validos");
            }

            //navego 
        } catch (UsuarioException ex) {

            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        FachadaLogica.cargarUsuario();
        mostrarUsuarios();
        ingresoUsuario.setText("");
        nombreTxt.setText("");
        apellidoTxt.setText("");
        emailTxt.setText("");
        claveTxt.setText("");
    }
    
    
   /* public static void buscarUsuarios() {

        String[] nombresColumnas = {"Id", "Usuario", "Nombre", "Apellido", "Email", "Contraseña", "Fecha Alta"};
        Usuarios usuarios = FachadaLogica.buscarUsuario();
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < usuarios.size(); i++) {
            fila[0] = usuarios.get(i).getId();
            fila[1] = usuarios.get(i).getUsuario();
            fila[2] = usuarios.get(i).getNombre();
            fila[3] = usuarios.get(i).getApellido();
            fila[4] = usuarios.get(i).getEmail();
            fila[5] = usuarios.get(i).getClave();
            fila[6] = usuarios.get(i).getFechaAlta();

            modelo.addRow(fila);

        }
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(60);

    }*/

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void insertarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarUsuarioActionPerformed
        try {
            // TODO add your handling code here:

            validarUsuario();
        } catch (UsuarioException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_insertarUsuarioActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        if (caracteresValidos(usuarioFilaSeleccionada.getUsuario()) && caracteresValidos(usuarioFilaSeleccionada.getNombre()) && caracteresValidos(usuarioFilaSeleccionada.getApellido())) {
            try {
                FachadaLogica.modificarUsuario(usuarioFilaSeleccionada);
            } catch (UsuarioException ex) {
                Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);

            }
            JOptionPane.showMessageDialog(this, "Registro Modificado Correctamente");

        } else {
            JOptionPane.showMessageDialog(this, "ingrese Caracteres Validos");

        }


    }//GEN-LAST:event_guardarActionPerformed

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {

            int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);

            String usuarioFila = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();

            String nombreFila = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();

            String apellidoFila = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();

            String emailFila = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();

            String claveFila = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();

            usuarioFilaSeleccionada.setId(id);
            usuarioFilaSeleccionada.setUsuario(usuarioFila);
            usuarioFilaSeleccionada.setNombre(nombreFila);
            usuarioFilaSeleccionada.setApellido(apellidoFila);
            usuarioFilaSeleccionada.setEmail(emailFila);
            usuarioFilaSeleccionada.setClave(claveFila);

        }

    }

    public static boolean caracteresValidos(String datos) {
        return datos.matches("[a-z A-Z]*");

    }//GEN-LAST:event_tablaKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);

        usuarioFilaSeleccionada.setId(id);

    }//GEN-LAST:event_tablaMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        // TODO add your handling code here:

        int seleccion = tabla.getSelectedRowCount();
        try {
            if (seleccion == 1) {
                int res = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {

                    FachadaLogica.eliminarUsuario(usuarioFilaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Fila");
            }

        } catch (UsuarioException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            mostrarUsuarios();
        } catch (UsuarioException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_eliminarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JTextField buscar;
    private javax.swing.JPasswordField claveTxt;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField ingresoUsuario;
    private javax.swing.JButton insertarUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTxt;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
