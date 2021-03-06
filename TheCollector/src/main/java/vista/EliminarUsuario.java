package vista;

import excepciones.AlertException;
import excepciones.Excepcion;
import excepciones.Succestion;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;
import persistencia.CollectorDao;

public class EliminarUsuario extends javax.swing.JDialog {

    private static MostrarExcepciones mostrar;
    public static CollectorDao collectorDao;
    private int mousepX;
    private int mousepY;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Usuario> borrarUsuarios = new ArrayList<>();
    
    public EliminarUsuario() throws AlertException {
        initComponents();
        mostrar = MostrarExcepciones.getInstace();
        actualizarComboBox();
    }
    
    //Funcion que actualiza los datos de los usuarios.
    public void actualizarComboBox() throws AlertException{
        try {
            usuariosComboBox.removeAllItems();
            usuariosComboBox.addItem("Selecciona un usuario:");
            usuarios = collectorDao.selectUsuarios();
            if(!usuarios.isEmpty()){
                for(Usuario usu : usuarios){
                    if(!collectorDao.usuActual.equals(usu.getUsername())){
                        usuariosComboBox.addItem(usu.getUsername()); 
                        borrarUsuarios.add(usu);
                    }
                }
                if(usuariosComboBox.getItemCount() <= 1){
                    throw new AlertException(AlertException.UNICO_USUARIO);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        LabelUsuario = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfCerrar = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        PanelTitulo = new javax.swing.JPanel();
        LabelEliminar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usuariosComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LabelUsuario.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelUsuario.setText("USUARIO");

        btnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Tiza", 0, 8)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tfCerrar.setBackground(new java.awt.Color(255, 255, 255));
        tfCerrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tfCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfCerrar.setText("x");
        tfCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tfCerrarMouseMoved(evt);
            }
        });
        tfCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfCerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfCerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(tfCerrar)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        result.setForeground(new java.awt.Color(255, 0, 0));

        PanelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        PanelTitulo.setForeground(new java.awt.Color(51, 51, 51));

        LabelEliminar.setFont(new java.awt.Font("Tiza", 0, 24)); // NOI18N
        LabelEliminar.setForeground(new java.awt.Color(255, 255, 255));
        LabelEliminar.setText("ELIMINAR USUARIO");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(LabelEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel5MouseDragged(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        usuariosComboBox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try{
            int u = usuariosComboBox.getSelectedIndex();
            if(u == 0){
                throw new Excepcion(Excepcion.INVALID_USER);
            }
            String username = (String) usuariosComboBox.getSelectedItem();
            try {
                collectorDao.eliminarUsuario(username);
                throw new Succestion(Succestion.USER_REMOVED);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch(Excepcion ex){
            usuariosComboBox.setSelectedIndex(0);
            result.setText(ex.getMessage());
        } catch(Succestion ex) {
            usuarios.clear();
            borrarUsuarios.clear();
            mostrar.mostrar(ex);
            this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tfCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseMoved
        jPanel4.setBackground(Color.decode("#EAEAEA"));
    }//GEN-LAST:event_tfCerrarMouseMoved

    private void tfCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseClicked
        usuarios.clear();
        borrarUsuarios.clear();
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_tfCerrarMouseClicked

    private void tfCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseExited
        jPanel4.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfCerrarMouseExited

    private void jLabel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseDragged
        int coordenadaX = evt.getXOnScreen();
        int coordenadaY = evt.getYOnScreen();
        this.setLocation(coordenadaX-mousepX, coordenadaY-mousepY);
    }//GEN-LAST:event_jLabel5MouseDragged

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jLabel5MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelEliminar;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel result;
    private javax.swing.JLabel tfCerrar;
    private javax.swing.JComboBox<String> usuariosComboBox;
    // End of variables declaration//GEN-END:variables
}
