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
    public JButton btnNext, btnBack;
    public JLabel lblFondo, lblFondo2, imgT;
    public ImageIcon imgFondo, icnNext, icnBack;

    public Icon icono;
    public String imageRoot = "src/resources/img/Ensamblaje K/";
    public String imgList[] = {"I.png","II.png","III.png","IV.png","V.png","VI.png","VII.png","VIII.png","IX.png","X.png","XI.png","XII.png","XIII.png","XIV.png","XV.png","XVI.png","XVII.png"};

    public TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            switch(cont){
                case 0:
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 1:
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 2:
                    cont = 0;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
            }
        }
    };
    public Timer timer = new Timer();

    public Modelo() {
        //tamano de la ventana
        this.setSize(1000, 650); //ancho y alto
        this.setTitle("Modelo"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
        setResizable(false);

        timer.scheduleAtFixedRate(tarea, velocidad, velocidad);
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
        panelPrincipal.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.DARK_GRAY);
        panelPrincipal.add(panel, BorderLayout.CENTER);
        panelPrincipal.add(panel2, BorderLayout.SOUTH);
    }
    //Agregamos las etiquetas
    private void agregarEtiquetas() {
        //ETIQUETA TIPO IMAGEN
       // imgFondo = new ImageIcon("src/resources/img/fondo.png"); //agregando la imagen
        //lblFondo = new JLabel(imgFondo); //agregando la etiqueta con la imgane
        //lblFondo.setBounds(0, 0, 1000, 607);
        //lblFondo.setSize(100,600);
        //lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        //panel.add(lblFondo, BorderLayout.WEST); //agregando la etiqueta al panel

        //lblFondo2 = new JLabel(imgFondo); //agregando la etiqueta con la imgane
        //lblFondo.setBounds(0, 0, 1000, 607);
        //lblFondo2.setSize(100,600);
        //lblFondo2.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        //panel.add(lblFondo2, BorderLayout.EAST);

        imgT = new JLabel(new ImageIcon(imageRoot.concat(imgList[0])));
        imgT.setSize(100,300);
        panel.add(imgT,BorderLayout.CENTER);
    }
    //Colocamos los botones
    private void colocarBotones() {
        //boton siguiente
        btnNext = new JButton();
        //btnNext.setBounds(750, 450, 64, 64);
        btnNext.setSize(64,64);
        icnNext = new ImageIcon("src/resources/img/next.png");
        btnNext.setIcon(new ImageIcon(icnNext.getImage().getScaledInstance(btnNext.getWidth(), btnNext.getHeight(), Image.SCALE_SMOOTH)));
        btnNext.setContentAreaFilled(false);
        btnNext.setEnabled(true);
        btnNext.setBorder(null);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.addActionListener(this); //eventos del boton
        panel2.add(btnNext, BorderLayout.EAST);

        //BOTON DE INSTRUCCIONES
        btnBack = new JButton();
        //btnBack.setBounds(200, 450, 64, 64);
        btnBack.setSize(64,64);
        icnBack = new ImageIcon("src/resources/img/return.png");
        btnBack.setIcon(new ImageIcon(icnBack.getImage().getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), Image.SCALE_SMOOTH)));
        btnBack.setContentAreaFilled(false);
        btnBack.setEnabled(true);
        btnBack.setBorder(null);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this); //eventos del boton
        panel2.add(btnBack, BorderLayout.WEST);

    }
    //Eventos del boton
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON SIGUIENTE
        if (evento.getSource() == btnNext) {
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();
        }

        //EVENTO DEL BOTON ATRAS
        if (evento.getSource() == btnBack) {
            Credits credits = new Credits();
            credits.setVisible(true);
            this.dispose();
        }

    }
}
