/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.presentacion;

import uy.gruposoft.logica.CeldaRenderer;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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

    public Afiliado afiliadoFilaSeleccionada = new Afiliado();
    JComboBox comboBox = new JComboBox();

    /**
     * Creates new form Afiliados
     */
    public VentanaAfiliados() throws AfiliadoException {
        initComponents();
        mostrarAfiliados();
        cargarPaises();
        crearTablaCombo();
        cargarComboPropietario();
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

    public void mostrarAfiliados() throws AfiliadoException {

        String[] nombresColumnas = {"Cedula", "Nombre", "Apellido", "Nacionalidad", "Direccion", "Telefono", "Email", "Nacimiento", "Numero_Local", "Propietario", "Fecha Alta"};
        Afiliados afiliados = FachadaLogica.cargarAfiliados();

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas) {

            public boolean isCellEditable(int row, int col) {
                if (col == 0 || col == 3 || col == 7 || col == 10) { //columnIndex: the column you want to make it editable

                    return false;
                } else {
                    return true;
                }
            }

        };

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
            fila[9] = afiliados.getAfiliados().get(i).getPropietario();
            fila[10] = afiliados.getAfiliados().get(i).getFechaAlta();

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(9).setCellEditor(new DefaultCellEditor(comboBox));
        tabla.setDefaultRenderer(Object.class, new CeldaRenderer(9));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(10).setPreferredWidth(80);

        tabla.setAutoResizeMode(tabla.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);

        Date date = new Date();

        nacimiento1.setMaxSelectableDate(date);
        tabla.getInputMap(tabla.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), 9);
    }

    public void buscarAfiliado() throws AfiliadoException {
        String[] nombresColumnas = {"Cedula", "Nombre", "Apellido", "Nacionalidad", "Direccion", "Telefono", "Email", "Nacimiento", "Numero Local", "Propietario", "Fecha Alta"};
        int buscarAfiliado = Integer.valueOf(btnBuscar.getText());
        Afiliado afiliado = new Afiliado();
        afiliado.setCedula(buscarAfiliado);
        Afiliados afiliados = FachadaLogica.buscarAfiliado(afiliado);

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas) {

            public boolean isCellEditable(int row, int col) {
                if (col == 0 || col == 3 || col == 7 || col == 10) { //columnIndex: the column you want to make it editable

                    return false;
                } else {
                    return true;
                }
            }

        };

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
            fila[9] = afiliados.getAfiliados().get(i).getPropietario();
            fila[10] = afiliados.getAfiliados().get(i).getFechaAlta();

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(9).setCellEditor(new DefaultCellEditor(comboBox));
        tabla.setDefaultRenderer(Object.class, new CeldaRenderer(9));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(10).setPreferredWidth(80);

        tabla.setAutoResizeMode(tabla.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);

        Date date = new Date();

        nacimiento1.setMaxSelectableDate(date);
        tabla.getInputMap(tabla.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), 9);
    }

    private void cargarComboPropietario() {
        //Combo y valores
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Si");
        model.addElement("No");
        model.setSelectedItem("Seleccione Si/No...");
        propietario.setModel(model);

    }

    private void crearTablaCombo() {
        //Combo y valores

        comboBox.addItem("No");
        comboBox.addItem("Si");

        tabla.setRowHeight(22);//altura de filas

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

        if (validarVacio() == true) {
            JOptionPane.showMessageDialog(this, "no dejar campos vacios");

        } else {
            Date date = nacimiento1.getDate();

            long d = date.getTime(); //guardamos en un long el tiempo

            java.sql.Date nacimientoAfiliado = new java.sql.Date(d);// parseamos al formato del sql  

            String nombreAfiliado = nombre.getText();
            String apellidoAfiliado = apellido.getText();
            String nacionalidadAfiliado = (String) nacionalidad.getSelectedItem();
            String direccionAfiliado = direccion.getText();
            String telefonoAfiliado = telefono.getText();
            String mailAfiliado = mail.getText();

            int numeroLocal = Integer.parseInt(local.getText());
            String propietarioAfiliado = (String) propietario.getSelectedItem();
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

                JOptionPane.showMessageDialog(this, "El Usuario Se Ingreso Correctamente");

                FachadaLogica.insertarAfiliado(afiliado);

            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Caracteres Validos");
            }

            FachadaLogica.cargarAfiliados();
            mostrarAfiliados();
            cargarPaises();

            nombre.setText("");
            apellido.setText("");
            direccion.setText("");
            telefono.setText("");
            mail.setText("");
            local.setText("");

            cedula.setText("");
            nacimiento1.setDate(null);

        }
    }

    public static boolean caracteresValidos(String datos) {
        return datos.matches("[a-z A-Z]*");

    }

    public boolean validarVacio() {
        boolean validacion = false;
        if (cedula.getText() == "" || nombre.getText() == "" || apellido.getText() == "" || nacionalidad.getSelectedItem() == "Seleccione Un Pais..."
                || direccion.getText() == "" || telefono.getText() == "" || mail.getText() == "" || local.getText() == "" || nacimiento1.getDate() == null) {
            validacion = true;

        }
        return validacion;
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
        nacimiento1 = new com.toedter.calendar.JDateChooser();
        propietario = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JTextField();
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

        nacimiento1.setMaxSelectableDate(new java.util.Date(253370779275000L));

        propietario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        propietario.setToolTipText("");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre)
                            .addComponent(apellido)
                            .addComponent(local)
                            .addComponent(nacimiento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mail)
                            .addComponent(telefono)
                            .addComponent(direccion)
                            .addComponent(nacionalidad, 0, 180, Short.MAX_VALUE)
                            .addComponent(cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(propietario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(nacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(propietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nuevoAfiliado)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, 350, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista De Afiliados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 66, 726, 600));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Buscar Por Cedula");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 31, -1, -1));

        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 26, 144, -1));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 22, -1, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
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
    public Date getDateFormat(String date) {

        java.sql.Date fechaConvertida = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date parsed = dateFormat.parse(date);
            fechaConvertida = new java.sql.Date(parsed.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un Error" + e.getMessage());
        }

        return fechaConvertida;
    }

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {

            String cedula = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();

            String nombre = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();

            String apellido = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();

            String nacionalidad = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();

            String direccion = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();

            String telefono = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();

            String mail = tabla.getValueAt(tabla.getSelectedRow(), 6).toString();

            Date nacimiento = getDateFormat(tabla.getValueAt(tabla.getSelectedRow(), 7).toString());

            int numeroLocal = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 8).toString());

            String propietario = (String) comboBox.getSelectedItem();

            Date fechaAlta = (java.sql.Date) tabla.getValueAt(tabla.getSelectedRow(), 10);

            long d = fechaAlta.getTime(); //guardamos en un long el tiempo

            java.sql.Date alta = new java.sql.Date(d);// parseamos al formato del sql  

            if (cedula == null && nombre == null && apellido == null && direccion == null && telefono == null && mail == null && nacimiento == null && Integer.valueOf(numeroLocal) == null) {
                JOptionPane.showMessageDialog(this, "no se modifico ningun registro");
            } else {
                if (!caracteresValidos(String.valueOf(numeroLocal)) && caracteresValidos(nombre) && caracteresValidos(apellido) && caracteresValidos(direccion) && !caracteresValidos(telefono)) {

                    afiliadoFilaSeleccionada.setCedula(Integer.valueOf(cedula));
                    afiliadoFilaSeleccionada.setNombre(nombre);
                    afiliadoFilaSeleccionada.setApellido(apellido);
                    afiliadoFilaSeleccionada.setNacionalidad(nacionalidad);
                    afiliadoFilaSeleccionada.setDireccion(direccion);
                    afiliadoFilaSeleccionada.setTelefono(telefono);
                    afiliadoFilaSeleccionada.setMail(mail);
                    afiliadoFilaSeleccionada.setNacimiento(nacimiento);
                    afiliadoFilaSeleccionada.setNumeroLocal(numeroLocal);
                    afiliadoFilaSeleccionada.setPropietario(propietario);
                    afiliadoFilaSeleccionada.setFechaAlta(alta);
                } else {
                    JOptionPane.showMessageDialog(this, "ingrese Caracteres Validos");
                }
            }

        }


    }//GEN-LAST:event_tablaKeyReleased

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        int seleccion = tabla.getSelectedRowCount();

        if (seleccion == 1) {

            try {

                FachadaLogica.modificarAfiliado(afiliadoFilaSeleccionada);
                JOptionPane.showMessageDialog(this, "Registro Modificado Correctamente");
            } catch (AfiliadoException ex) {
                Logger.getLogger(VentanaDeUsuario.class
                        .getName()).log(Level.SEVERE, null, ex);

            }

        } else {
            JOptionPane.showMessageDialog(this, "no hay fila seleccionada");

        }
        try {
            mostrarAfiliados();
        } catch (AfiliadoException ex) {
            Logger.getLogger(VentanaAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_modificarActionPerformed

    private void btnBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyReleased
        // TODO add your handling code here:

        if (btnBuscar.getText().equals("")) {

            try {
                mostrarAfiliados();
            } catch (AfiliadoException ex) {
                Logger.getLogger(VentanaAfiliados.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!caracteresValidos(btnBuscar.getText())) {
                try {
                    buscarAfiliado();

                } catch (AfiliadoException ex) {
                    Logger.getLogger(VentanaAfiliados.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese caracteres validos");
            }

        }
    }//GEN-LAST:event_btnBuscarKeyReleased

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:

        int seleccion = tabla.getSelectedRowCount();
        try {
            if (seleccion == 1) {
                int res = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {

                    FachadaLogica.eliminarAfiliado(afiliadoFilaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Fila");
            }

        } catch (AfiliadoException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            mostrarAfiliados();
        } catch (AfiliadoException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_eliminarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);

        afiliadoFilaSeleccionada.setCedula(id);
    }//GEN-LAST:event_tablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField btnBuscar;
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
    private com.toedter.calendar.JDateChooser nacimiento1;
    private javax.swing.JComboBox<String> nacionalidad;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevoAfiliado;
    private javax.swing.JComboBox<String> propietario;
    private static javax.swing.JTable tabla;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables

}
