package vista;

import excepciones.AlertException;
import excepciones.Excepcion;
import excepciones.Succestion;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class MostrarExcepciones {
    
    private static MostrarExcepciones instance;
    private JOptionPane optionPane;
    
    public static MostrarExcepciones getInstace() {
        if (instance == null) {
            instance = new MostrarExcepciones();
        }
        return instance;
    }
    
    public void mostrar(Succestion ex){            
        optionPane = new JOptionPane(ex.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        JDialog dialogException = optionPane.createDialog("Info");
        dialogException.setAlwaysOnTop(true);
        dialogException.setVisible(true);       
    }
    
    public void mostrar(Excepcion ex){
        optionPane = new JOptionPane(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        JDialog dialogException = optionPane.createDialog("Error");
        dialogException.setAlwaysOnTop(true);
        dialogException.setVisible(true);
    }
    
    public void mostrar(AlertException ex){
        optionPane = new JOptionPane(ex.getMessage(), JOptionPane.WARNING_MESSAGE);
        JDialog dialogException = optionPane.createDialog("Alerta");
        dialogException.setAlwaysOnTop(true);
        dialogException.setVisible(true);
    } 
}
