package menu;

import mef.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JFrame implements ActionListener {
    public JPanel panel;
    public JButton btnInstru;
    public JLabel lblFondo;
    public ImageIcon imgFondo, icnInicio, icnIndicaciones;

    public Credits() {
        //tamano de la ventana
        this.setSize(1000, 650); //ancho y alto
        this.setTitle("Credits"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
        setResizable(false);
    }
    //Inicializamos los componentes
    private void iniciarComponentes() {
        crearPaneles();
        colocarBotones();
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
        imgFondo = new ImageIcon("src/resources/img/fondo.png"); //agregando la imagen
        lblFondo = new JLabel(imgFondo); //agregando la etiqueta con la imgane
        lblFondo.setBounds(0, 0, 1000, 607);
        lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lblFondo); //agregando la etiqueta al panel
    }
    //Colocamos los botones
    private void colocarBotones() {
        //BOTON DE REGRESO
        btnInstru = new JButton();
        btnInstru.setBounds(5, 5, 64, 64);
        icnIndicaciones = new ImageIcon("src/resources/img/back.png");
        btnInstru.setIcon(new ImageIcon(icnIndicaciones.getImage().getScaledInstance(btnInstru.getWidth(), btnInstru.getHeight(), Image.SCALE_SMOOTH)));
        btnInstru.setContentAreaFilled(false);
        btnInstru.setEnabled(true);
        btnInstru.setBorder(null);
        btnInstru.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInstru.addActionListener(this); //eventos del boton
        panel.add(btnInstru);

    }
    //Eventos del boton
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON INICIO SECCION
        if (evento.getSource() == btnInstru) {
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();
        }
    }
}
