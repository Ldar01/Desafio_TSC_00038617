package menu;

import mef.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Farewell extends JFrame{
    public JPanel panel;
    public JButton btnInicio, btnInstru;
    public JLabel lblFondo, lblInicio, lblTitle;
    public ImageIcon imgFondo, icnInicio, icnIndicaciones, imgTitle;

    public Farewell() {
        //tamano de la ventana
        this.setSize(1000, 650); //ancho y alto
        this.setTitle("Byes"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
        setResizable(false);
    }
    //Inicializamos los componentes
    private void iniciarComponentes() {
        crearPaneles();
        agregarEtiquetas();
    }
    //Creamos el panel donde estaran las cosas
    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }
    //Agregamos las etiquetas
    private void agregarEtiquetas() {
        //ETIQUETA TIPO IMAGEN
        imgFondo = new ImageIcon("src/resources/img/farewell.png"); //agregando la imagen
        lblFondo = new JLabel(imgFondo); //agregando la etiqueta con la imgane
        lblFondo.setBounds(0, 0, 1000, 607);
        lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lblFondo); //agregando la etiqueta al panel
    }
}
