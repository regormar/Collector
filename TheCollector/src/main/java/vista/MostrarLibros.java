package vista;

import excepciones.AlertException;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import persistencia.CollectorDao;


public class MostrarLibros extends javax.swing.JDialog {

    
    public static CollectorDao collectorDao;
    private int mousepX;
    private int mousepY;
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Libro> librosUsuario = new ArrayList<>();
    private static String [] titulos = {"Nombre", "Autor", "Género", "Número de Páginas", "Página Actual", "Valoración"};
    private static DefaultTableModel dtm = new DefaultTableModel(null, titulos);

    public MostrarLibros() throws AlertException {
        initComponents();
        actualizarDatos();
        actualizarTabla();
    }

    
    //Funcion que actualiza los datos de los libros.
    public void actualizarDatos() throws AlertException{
        try {
            libros = collectorDao.selectLibros();
            if(!libros.isEmpty()){
                for(Libro libro : libros){
                    if(collectorDao.checkLibroUsuario(libro.getId())){
                        libro = collectorDao.selectLibroUsuario(libro);
                        librosUsuario.add(libro);
                    }
                }
                if(librosUsuario.isEmpty()){
                    throw new AlertException(AlertException.NO_TIENE_LIBROS);
                }
            }else{
                throw new AlertException(AlertException.NO_EXISTEN_LIBROS);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Funcion que actualiza los datos de la tabla.
    public void actualizarTabla() throws AlertException{
        try {
            for(Libro libro : librosUsuario){
                String genero = collectorDao.getNombreGeneroById(libro.getGenero());
                String numPaginas = Integer.toString (libro.getNumPaginas());
                String pagActual = Integer.toString (libro.getPaginaActual());
                String valoracion = Integer.toString (libro.getValoracion());
                String [] filas = {libro.getNombre(), libro.getAutor(), genero, numPaginas, pagActual, valoracion};
                dtm.addRow(filas);
            }
            jTable1.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tfCerrar = new javax.swing.JLabel();
        PanelTitulo = new javax.swing.JPanel();
        LabelMostrar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        PanelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        PanelTitulo.setForeground(new java.awt.Color(51, 51, 51));

        LabelMostrar.setFont(new java.awt.Font("Tiza", 0, 24)); // NOI18N
        LabelMostrar.setForeground(new java.awt.Color(255, 255, 255));
        LabelMostrar.setText("MOSTRAR LIBROS");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelMostrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(LabelMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
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

    private void tfCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseMoved
        jPanel4.setBackground(Color.decode("#EAEAEA"));
    }//GEN-LAST:event_tfCerrarMouseMoved

    private void tfCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseClicked
        dtm.setRowCount(0);
        libros.clear();
        librosUsuario.clear();
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
    private javax.swing.JLabel LabelMostrar;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tfCerrar;
    // End of variables declaration//GEN-END:variables
}
