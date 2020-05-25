package vista;

import excepciones.AlertException;
import excepciones.Excepcion;
import excepciones.Succestion;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.Controlador;
import modelo.Libro;
import persistencia.CollectorDao;


public class AñadirLibro extends javax.swing.JDialog {

    private static Controlador manager;
    private static MostrarExcepciones mostrar;
    public static CollectorDao collectorDao;
    private int mousepX;
    private int mousepY;
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static Libro book;
    
    public AñadirLibro() throws AlertException {
        initComponents();
        actualizarComboBox();
        manager = Controlador.getInstace();
        mostrar = MostrarExcepciones.getInstace();   
    }
    
    //Funcion que actualiza los datos de los libros.
    public void actualizarComboBox() throws AlertException{
        try {
            libroComboBox.removeAllItems();
            libroComboBox.addItem("Selecciona una libro:");
            libros = collectorDao.selectLibros();
            if(!libros.isEmpty()){
                for(Libro libro : libros){
                    if(!collectorDao.checkLibroUsuario(libro.getId())){
                        libroComboBox.addItem(libro.getNombre()+" (" + libro.getAutor() + ")");
                    }
                    if(collectorDao.getNumBooksByUser() == libros.size()){
                        throw new AlertException(AlertException.NO_EXISTEN_MAS_LIBROS);
                    }
                }
            }else{
                throw new AlertException(AlertException.NO_EXISTEN_LIBROS);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        LabelLibro = new javax.swing.JLabel();
        btnAnyadir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfCerrar = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        LabelPageNum = new javax.swing.JLabel();
        LabelValoracion = new javax.swing.JLabel();
        PanelTitulo = new javax.swing.JPanel();
        LabelAñadir = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        libroComboBox = new javax.swing.JComboBox<>();
        spinnerValoracion = new javax.swing.JSpinner();
        spActualPg = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LabelLibro.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelLibro.setText("LIBRO");

        btnAnyadir.setBackground(new java.awt.Color(51, 51, 51));
        btnAnyadir.setFont(new java.awt.Font("Tiza", 0, 8)); // NOI18N
        btnAnyadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAnyadir.setText("AÑADIR");
        btnAnyadir.setBorder(null);
        btnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnyadirActionPerformed(evt);
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

        LabelPageNum.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelPageNum.setText("PÁGINA ACTUAL");

        LabelValoracion.setFont(new java.awt.Font("Tiza", 0, 11)); // NOI18N
        LabelValoracion.setText("VALORACION");

        PanelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        PanelTitulo.setForeground(new java.awt.Color(51, 51, 51));

        LabelAñadir.setFont(new java.awt.Font("Tiza", 0, 24)); // NOI18N
        LabelAñadir.setForeground(new java.awt.Color(255, 255, 255));
        LabelAñadir.setText("ANADIR Libro");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LabelAñadir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(LabelAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        libroComboBox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        spinnerValoracion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        spinnerValoracion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        spActualPg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        spActualPg.setModel(new javax.swing.SpinnerNumberModel());

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
                        .addGap(26, 26, 26)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(btnAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(libroComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spActualPg)
                            .addComponent(spinnerValoracion, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
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
                    .addComponent(LabelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spActualPg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnyadirActionPerformed
        try{
            int libro = libroComboBox.getSelectedIndex();
            if(libro == 0){
                throw new Excepcion(Excepcion.BOOK_INVALIDO);
            }
            int position = libro - 1;
            book = libros.get(position);

            int paginaActual = Integer.parseInt(spActualPg.getValue().toString());
            if(paginaActual > book.getNumPaginas()){
                throw new Excepcion(Excepcion.INVALID_PAGE_NUMBER);
            }
            int valoracion = Integer.parseInt(spinnerValoracion.getValue().toString());

            try {
                book.setPaginaActual(paginaActual);
                book.setValoracion(valoracion);
                collectorDao.insertarLibroUsuario(book);
                throw new Succestion(Succestion.BOOK_ADDED);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch(Excepcion ex){
            spActualPg.setValue(0);
            spinnerValoracion.setValue(0);
            libroComboBox.setSelectedIndex(0);
            result.setText(ex.getMessage());
        } catch(Succestion ex) {
            mostrar.mostrar(ex);
            this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_btnAnyadirActionPerformed

    private void tfCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseMoved
        jPanel4.setBackground(Color.decode("#EAEAEA"));
    }//GEN-LAST:event_tfCerrarMouseMoved

    private void tfCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCerrarMouseClicked
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
    private javax.swing.JLabel LabelAñadir;
    private javax.swing.JLabel LabelLibro;
    private javax.swing.JLabel LabelPageNum;
    private javax.swing.JLabel LabelValoracion;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAnyadir;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> libroComboBox;
    private javax.swing.JLabel result;
    private javax.swing.JSpinner spActualPg;
    private javax.swing.JSpinner spinnerValoracion;
    private javax.swing.JLabel tfCerrar;
    // End of variables declaration//GEN-END:variables
}
