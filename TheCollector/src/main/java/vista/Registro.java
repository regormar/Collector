package vista;

import excepciones.Excepcion;
import excepciones.Succestion;
import manager.Controlador;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import modelo.Usuario;
import persistencia.CollectorDao;

public class Registro extends javax.swing.JDialog {

    private static Controlador manager;
    private static MostrarExcepciones mostrar;
    public static CollectorDao collectorDao;
    private int mousepX;
    private int mousepY;
    
    
    public Registro(){
        initComponents();
        manager = Controlador.getInstace();
        mostrar = MostrarExcepciones.getInstace();
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
        LabelUsername = new javax.swing.JLabel();
        LabelPass = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfCerrar = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        result = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        apellidosUsuario = new javax.swing.JTextField();
        LabelApellidos = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        LabelPass2 = new javax.swing.JLabel();
        password2 = new javax.swing.JPasswordField();
        LabelEmail = new javax.swing.JLabel();
        PanelTitulo = new javax.swing.JPanel();
        LabelRegistro = new javax.swing.JLabel();
        emailUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LabelUsername.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelUsername.setText("USERNAME");

        LabelPass.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelPass.setText("PASSWORD");

        btnRegistrar.setBackground(new java.awt.Color(51, 51, 51));
        btnRegistrar.setFont(new java.awt.Font("Tiza", 0, 8)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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

        LabelName.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelName.setText("NOMBRE");

        LabelApellidos.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelApellidos.setText("APELLIDOS");

        LabelPass2.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelPass2.setText("VERIFICAR");

        LabelEmail.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelEmail.setText("EMAIL");

        PanelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        PanelTitulo.setForeground(new java.awt.Color(51, 51, 51));

        LabelRegistro.setFont(new java.awt.Font("Tiza", 0, 24)); // NOI18N
        LabelRegistro.setForeground(new java.awt.Color(255, 255, 255));
        LabelRegistro.setText("REGISTRO");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(LabelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                        .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFondoLayout.createSequentialGroup()
                                .addComponent(LabelPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                        .addComponent(LabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseExited
        jPanel4.setBackground(Color.WHITE);
    }//GEN-LAST:event_tfCerrarMouseExited

    private void abrirLogin(){
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); 
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    private void tfCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseClicked
        abrirLogin();
    }//GEN-LAST:event_tfCerrarMouseClicked

    private void tfCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseMoved
        jPanel4.setBackground(Color.decode("#EAEAEA"));
    }//GEN-LAST:event_tfCerrarMouseMoved

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try{
            String usuario = username.getText();
            String nombre = nombreUsuario.getText();
            String apellidos = apellidosUsuario.getText();
            String pass = String.valueOf(password.getPassword());
            String pass2 = String.valueOf(password2.getPassword());
            String email = emailUsuario.getText();
            try {
                Usuario usu = new Usuario(nombre, apellidos, 1, usuario, email, pass);
                manager.validarRegistro(usu, pass2);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }        
        } catch(Excepcion ex){
            username.setText("");
            nombreUsuario.setText("");
            apellidosUsuario.setText("");
            password.setText("");
            password2.setText("");
            emailUsuario.setText("");
            result.setText(ex.getMessage());
        } catch (Succestion ex) { 
            mostrar.mostrar(ex);  
            abrirLogin();              
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
    private javax.swing.JLabel LabelApellidos;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPass;
    private javax.swing.JLabel LabelPass2;
    private javax.swing.JLabel LabelRegistro;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JTextField apellidosUsuario;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField emailUsuario;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password2;
    private javax.swing.JLabel result;
    private javax.swing.JLabel tfCerrar;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
