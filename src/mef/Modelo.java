package mef;

import menu.Credits;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Modelo extends JFrame implements ActionListener {

    public static int cont = 0;
    public int velocidad = 2*1000; //segundos

    public JPanel panelPrincipal, panel, panel2;
    public JButton btnNext;
    public JLabel lblFondo, imgT;
    public ImageIcon imgFondo, icnNext;

    public Icon icono;
    public String imageRoot = "src/resources/img/Steps/Modelo.PNG";
    //public String imgList[] = {"I.png","II.png","III.png","IV.png","V.png","VI.png","VII.png","VIII.png","IX.png","X.png","XI.png","XII.png","XIII.png","XIV.png","XV.png","XVI.png","XVII.png"};

    public Modelo() {
        //tamano de la ventana
        this.setSize(1000, 700); //ancho y alto
        this.setTitle("Modelo"); //titulo de la ventana
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
        panelPrincipal = new JPanel(); //creacion de un panel
        panel = new JPanel();
        panel2 = new JPanel();
        this.getContentPane().add(panelPrincipal); //agregamos el panel a la ventana
        panelPrincipal.setLayout(new BorderLayout(0,0));
        panel.setLayout(new BorderLayout(0,0));
        panel2.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);
        panelPrincipal.add(panel, BorderLayout.CENTER);
        panelPrincipal.add(panel2, BorderLayout.SOUTH);
    }
    //Agregamos las etiquetas
    private void agregarEtiquetas() {
        //ETIQUETA TIPO IMAGEN
        imgFondo = new ImageIcon("src/resources/img/footer.png"); //agregando la imagen
        lblFondo = new JLabel(imgFondo); //agregando la etiqueta con la imgane
        //lblFondo.setBounds(0, 0, 1000, 607);
        lblFondo.setSize(1000,75);
        lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        panel2.add(lblFondo); //agregando la etiqueta al panel

        imgT = new JLabel(new ImageIcon(imageRoot));
        imgT.setSize(1000,450);
        panel.add(imgT,BorderLayout.CENTER);
    }
    //Colocamos los botones
    private void colocarBotones() {
        //boton siguiente
        btnNext = new JButton();
        btnNext.setBounds(500, 7, 64, 64);
        //btnNext.setSize(64,64);
        icnNext = new ImageIcon("src/resources/img/next.png");
        btnNext.setIcon(new ImageIcon(icnNext.getImage().getScaledInstance(btnNext.getWidth(), btnNext.getHeight(), Image.SCALE_SMOOTH)));
        btnNext.setContentAreaFilled(false);
        btnNext.setEnabled(true);
        btnNext.setBorder(null);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.addActionListener(this); //eventos del boton
        panel2.add(btnNext);
    }
    //Eventos del boton
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON SIGUIENTE
        if (evento.getSource() == btnNext) {
            Dominio dominio = new Dominio();
            dominio.setVisible(true);
            System.out.println("Click en next");
            this.dispose();
        }
    }
}
