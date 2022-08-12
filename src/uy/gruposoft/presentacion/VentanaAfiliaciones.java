/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.presentacion;

import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uy.gruposoft.excepciones.AfiliacionesException;
import uy.gruposoft.logica.Afiliacion;
import uy.gruposoft.logica.Afiliaciones;
import uy.gruposoft.logica.FachadaLogica;
import uy.gruposoft.logica.RangoFechas;

/**
 *
 * @author Administrador
 */
public class VentanaAfiliaciones extends javax.swing.JInternalFrame {

    public Afiliacion afiliacionFilaSeleccionada = new Afiliacion();

    /**
     * Creates new form VentanaAfiliaciones
     */
    public VentanaAfiliaciones() throws AfiliacionesException {
        initComponents();
        mostrarAfiliaciones();
    }

    public void mostrarAfiliaciones() throws AfiliacionesException {

        String[] nombresColumnas = {"Id", "Cedula", "Monto", "Fecha De Pago"};
        Afiliaciones afiliaciones = FachadaLogica.cargarAfiliaciones();

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas) {

            public boolean isCellEditable(int row, int col) {
                if (col == 0 || col == 3) { //columnIndex: the column you want to make it editable

                    return false;
                } else {
                    return true;
                }
            }

        };

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < afiliaciones.getAfiliaciones().size(); i++) {
            fila[0] = afiliaciones.getAfiliaciones().get(i).getId();
            fila[1] = afiliaciones.getAfiliaciones().get(i).getCedula();
            fila[2] = afiliaciones.getAfiliaciones().get(i).getMonto();
            fila[3] = afiliaciones.getAfiliaciones().get(i).getFechaDePago();

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(135);
        tabla.setAutoResizeMode(tabla.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);

    }

    public void mostrarAfiliacionesFecha(RangoFechas rangoFechas) throws AfiliacionesException {

        String[] nombresColumnas = {"Id", "Cedula", "Monto", "Fecha De Pago"};
        Afiliaciones afiliaciones = FachadaLogica.buscarAfiliacion(rangoFechas);

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas) {

            public boolean isCellEditable(int row, int col) {
                if (col == 0 || col == 3) { //columnIndex: the column you want to make it editable

                    return false;
                } else {
                    return true;
                }
            }

        };

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < afiliaciones.getAfiliaciones().size(); i++) {
            fila[0] = afiliaciones.getAfiliaciones().get(i).getId();
            fila[1] = afiliaciones.getAfiliaciones().get(i).getCedula();
            fila[2] = afiliaciones.getAfiliaciones().get(i).getMonto();
            fila[3] = afiliaciones.getAfiliaciones().get(i).getFechaDePago();

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(135);
        tabla.setAutoResizeMode(tabla.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);

    }

    public void validarAfiliacion() throws AfiliacionesException {

        if (validarVacio() == true) {
            JOptionPane.showMessageDialog(this, "no dejar campos vacios");

        } else {

            String cedulaAfiliacion = cedulaTxt.getText();
            String montoAfiliacion = montoTxt.getText();

            if (!caracteresValidos(cedulaAfiliacion.trim()) && !caracteresValidos(montoAfiliacion.trim())) {

                Afiliacion afiliacion = new Afiliacion();

                afiliacion.setCedula(Integer.parseInt(cedulaAfiliacion));
                afiliacion.setMonto(Integer.parseInt(montoAfiliacion));

                JOptionPane.showMessageDialog(this, "El Usuario Se Ingreso Correctamente");

                FachadaLogica.insertarAfiliacion(afiliacion);

            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Caracteres Validos");
            }

            FachadaLogica.cargarAfiliaciones();
            mostrarAfiliaciones();

            cedulaTxt.setText("");
            montoTxt.setText("");

        }
    }

    public static boolean caracteresValidos(String datos) {
        return datos.matches("[a-z A-Z]*");

    }

    public boolean validarVacio() {
        boolean validacion = false;
        if (cedulaTxt.getText() == "" || montoTxt.getText() == "") {
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
        jLabel1 = new javax.swing.JLabel();
        cedulaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        montoTxt = new javax.swing.JTextField();
        nuevaAfiliacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        buscarFecha = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modificarTxt = new javax.swing.JButton();
        eliminarTxt = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximumSize(new java.awt.Dimension(1060, 700));
        setMinimumSize(new java.awt.Dimension(1060, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Afiliaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cedula");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Monto");

        nuevaAfiliacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nuevaAfiliacion.setText("Nueva Afiliacion");
        nuevaAfiliacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaAfiliacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(montoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(nuevaAfiliacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cedulaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66)
                .addComponent(nuevaAfiliacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista De Afiliaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
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

        buscarFecha.setText("Buscar");
        buscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFechaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Desde");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Hasta");

        modificarTxt.setText("Modificar");
        modificarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTxtActionPerformed(evt);
            }
        });

        eliminarTxt.setText("Eliminar");
        eliminarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarTxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel5)
                        .addGap(49, 49, 49)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(buscarFecha)
                        .addGap(18, 18, 18)
                        .addComponent(modificarTxt)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarTxt)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarFecha)
                        .addComponent(modificarTxt)
                        .addComponent(eliminarTxt)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaAfiliacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaAfiliacionActionPerformed
        try {
            // TODO add your handling code here:
            validarAfiliacion();
        } catch (AfiliacionesException ex) {
            Logger.getLogger(VentanaAfiliaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nuevaAfiliacionActionPerformed

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            int id = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());

            String cedula = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();

            String monto = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();

            Date fechaPago = (java.util.Date) tabla.getValueAt(tabla.getSelectedRow(), 3);

            long d = fechaPago.getTime(); //guardamos en un long el tiempo

            java.sql.Date pago = new java.sql.Date(d);// parseamos al formato del sql  

            if (cedula == null && monto == null) {
                JOptionPane.showMessageDialog(this, "no se modifico ningun registro");
            } else {
                if (!caracteresValidos(String.valueOf(cedula)) && !caracteresValidos(monto)) {

                    afiliacionFilaSeleccionada.setId(id);
                    afiliacionFilaSeleccionada.setCedula(Integer.valueOf(cedula));
                    afiliacionFilaSeleccionada.setMonto(Integer.valueOf(monto));
                    afiliacionFilaSeleccionada.setFechaDePago(pago);
                } else {
                    JOptionPane.showMessageDialog(this, "ingrese Caracteres Validos");
                }
            }

        }
    }//GEN-LAST:event_tablaKeyReleased

    private void modificarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTxtActionPerformed
        // TODO add your handling code here:
        int seleccion = tabla.getSelectedRowCount();

        if (seleccion == 1) {

            try {

                FachadaLogica.modificarAfiliacion(afiliacionFilaSeleccionada);
                JOptionPane.showMessageDialog(this, "Registro Modificado Correctamente");
            } catch (AfiliacionesException ex) {
                Logger.getLogger(VentanaDeUsuario.class
                        .getName()).log(Level.SEVERE, null, ex);

            }

        } else {
            JOptionPane.showMessageDialog(this, "no hay fila seleccionada");

        }
        try {
            mostrarAfiliaciones();
        } catch (AfiliacionesException ex) {
            Logger.getLogger(VentanaAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarTxtActionPerformed

    private void eliminarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseClicked
        // TODO add your handling code here:

        int seleccion = tabla.getSelectedRowCount();
        try {
            if (seleccion == 1) {
                int res = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {

                    FachadaLogica.eliminarAfiliacion(afiliacionFilaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Fila");
            }

        } catch (AfiliacionesException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            mostrarAfiliaciones();
        } catch (AfiliacionesException ex) {
            Logger.getLogger(VentanaDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarTxtMouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);

        afiliacionFilaSeleccionada.setId(id);
    }//GEN-LAST:event_tablaMouseClicked

    private void buscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFechaActionPerformed

        Date fechaUno = fechaDesde.getDate();
        Date fechaDos = fechaHasta.getDate();

        if (fechaUno == null || fechaDos == null) {
            JOptionPane.showMessageDialog(this, "Uno De los Calendarios esta vacio");
        } else if (fechaUno.getDate() >= fechaDos.getDate()) {
            JOptionPane.showMessageDialog(this, "Rango de Fechas Invalido");
        
        } else {
            long f = fechaUno.getTime();

            java.sql.Date fDesde = new java.sql.Date(f);

            long d = fechaDos.getTime();

            java.sql.Date fHasta = new java.sql.Date(d);

            RangoFechas rangoFechas = new RangoFechas();

            rangoFechas.setFechaUno(fDesde);

            rangoFechas.setFechaDos(fHasta);
            try {
                mostrarAfiliacionesFecha(rangoFechas);
            } catch (AfiliacionesException ex) {
                Logger.getLogger(VentanaAfiliaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        
    }//GEN-LAST:event_buscarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarFecha;
    private javax.swing.JTextField cedulaTxt;
    private javax.swing.JButton eliminarTxt;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarTxt;
    private javax.swing.JTextField montoTxt;
    private javax.swing.JButton nuevaAfiliacion;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
