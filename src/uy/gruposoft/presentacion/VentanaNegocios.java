package uy.gruposoft.presentacion;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uy.gruposoft.excepciones.NegocioException;
import uy.gruposoft.logica.FachadaLogica;
import uy.gruposoft.logica.Negocio;
import uy.gruposoft.logica.Negocios;
/**
 *
 * @author gdelgado
 */
public class VentanaNegocios extends javax.swing.JInternalFrame {

    public Negocio negocioFilaSeleccionada = new Negocio();

    public VentanaNegocios() throws NegocioException {
        initComponents();
        mostrarNegocios();
    }

    public static void mostrarNegocios() throws NegocioException {

        String[] nombresColumnas = {"Id", "Cantidad de locales", "Rubro", "Marca", "Fecha Alta"};
        Negocios negocios = FachadaLogica.cargarNegocios();
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < negocios.getNegocios().size(); i++) {
            fila[0] = negocios.getNegocios().get(i).getId();
	    fila[1] = negocios.getNegocios().get(i).getCantidad_locales();
	    fila[2] = negocios.getNegocios().get(i).getRubro();
	    fila[3] = negocios.getNegocios().get(i).getMarca();
            fila[4] = negocios.getNegocios().get(i).getFechaAlta();

            modelo.addRow(fila);

        }
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(60);

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cantidadLocales = new javax.swing.JTextField();
        rubroTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        insertarNegocio = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Negocios");
        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista De Negocios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Negocio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Locales");

        cantidadLocales.setToolTipText("");
        cantidadLocales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadLocalesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Rubro");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Marca");

        insertarNegocio.setText("Crear negocio");
        insertarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarNegocioActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertarNegocio)
                    .addComponent(cantidadLocales, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(rubroTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(marcaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadLocales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rubroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addComponent(insertarNegocio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Buscar por marca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 200, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(eliminar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Datos negocio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void validarNegocio() throws NegocioException {
        try {
            String ctdadLocales = this.cantidadLocales.getText();
            String rubro = this.rubroTxt.getText();
            String marca = this.marcaTxt.getText();

            if (caracteresValidos(rubro.trim()) && caracteresValidos(marca.trim())) {
		
		int cantidadLocales = Integer.parseInt(ctdadLocales);

                Negocio negocio = new Negocio();
		
		negocio.setCantidad_locales(cantidadLocales);
                negocio.setRubro(rubro);
                negocio.setMarca(marca);

                if (FachadaLogica.verificarNegocio(negocio)) {
                    JOptionPane.showMessageDialog(this, " El negocio ya existe, ingrese otro");

                    return;

                }
                FachadaLogica.insertarNegocio(negocio);

                JOptionPane.showMessageDialog(this, "El negocio se ingreso correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Caracteres Validos");
            }

        } catch (NegocioException ex) {

            Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        FachadaLogica.cargarNegocios();
        mostrarNegocios();
        cantidadLocales.setText("");
        rubroTxt.setText("");
        marcaTxt.setText("");
    }

    

    private void insertarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarNegocioActionPerformed
        try {

            validarNegocio();
        } catch (NegocioException ex) {
            Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_insertarNegocioActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        
        int seleccion = tabla.getSelectedRowCount();

        if (seleccion == 1) {
            if (Integer.valueOf(negocioFilaSeleccionada.getCantidad_locales()) == null && negocioFilaSeleccionada.getRubro() == null && negocioFilaSeleccionada.getMarca() == null) {
                JOptionPane.showMessageDialog(this, "No se modifico ningun registro");
            } else {
                if (!caracteresValidos(String.valueOf(negocioFilaSeleccionada.getCantidad_locales())) && caracteresValidos(negocioFilaSeleccionada.getRubro()) && caracteresValidos(negocioFilaSeleccionada.getMarca())) {
                    try {
                        FachadaLogica.modificarNegocio(negocioFilaSeleccionada);

                    }catch (NegocioException ex) {
                        Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Registro Modificado Correctamente");
                  
                }else {
                    JOptionPane.showMessageDialog(this, "Ingrese Caracteres Validos");
                }
            }
        
        }else{
            JOptionPane.showMessageDialog(this, "No hay fila seleccionada");
    
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
	    
	    int id = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
	    
	    int localesFila = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
	    
            String rubroFila = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();

            String marcaFila = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
	    
	    negocioFilaSeleccionada.setId(id);
            negocioFilaSeleccionada.setCantidad_locales(localesFila);
            negocioFilaSeleccionada.setRubro(rubroFila);
            negocioFilaSeleccionada.setMarca(marcaFila);

        }

    }

    public static boolean caracteresValidos(String datos) {
        return datos.matches("[a-z A-Z]*");

    }//GEN-LAST:event_tablaKeyReleased

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked

        int seleccion = tabla.getSelectedRowCount();
        try {
            if (seleccion == 1) {
                int res = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {

                    FachadaLogica.eliminarNegocio(negocioFilaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila para eliminar");
            }

        } catch (NegocioException ex) {
            Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            mostrarNegocios();
        } catch (NegocioException ex) {
            Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_eliminarMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
       
	if(txtbuscar.getText().equals("")){
           try {
               mostrarNegocios();
           } catch (NegocioException ex) {
               Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{
            try {
            buscarNegocios();
        } catch (NegocioException ex) {
            Logger.getLogger(VentanaNegocios.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void cantidadLocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadLocalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadLocalesActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
            int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
	    negocioFilaSeleccionada.setId(id);
    }//GEN-LAST:event_tablaMouseClicked

    public  void buscarNegocios() throws NegocioException {

        String[] nombresColumnas = {"Id", "Cantidad de locales", "Rubro", "Marca", "Fecha Alta"};
        
        String buscar = txtbuscar.getText();
        Negocio negocio = new Negocio();
        negocio.setMarca(buscar);
        Negocios negocios = FachadaLogica.buscarNegocio(negocio);
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < negocios.getNegocios().size(); i++) {
            fila[0] = negocios.getNegocios().get(i).getId();
            fila[1] = negocios.getNegocios().get(i).getCantidad_locales();
            fila[2] = negocios.getNegocios().get(i).getRubro();
            fila[3] = negocios.getNegocios().get(i).getMarca();

            modelo.addRow(fila);

        }
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(60);

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidadLocales;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton insertarNegocio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marcaTxt;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField rubroTxt;
    public static javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
