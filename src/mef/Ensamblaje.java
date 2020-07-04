package mef;

import menu.Credits;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Ensamblaje extends JFrame implements ActionListener {
    public static int cont = 0;
    public int velocidad = 1*1000; //segundos

    public JPanel panelPrincipal, panel, panel2;
    public JButton btnNext, btnBack;
    public JLabel lblFondo, lblFondo2, imgT;
    public ImageIcon imgFondo, icnNext, icnBack, imgTitle;

    public Icon icono;
    public String imageRoot = "src/resources/img/Ensamblaje K/";
    public String imgList[] = {"I.png","II.png","III.png","IV.png","V.png","VI.png","VII.png","VIII.png","IX.png","X.png","XI.png","XII.png","XIII.png","XIV.png","XV.png","XVI.png","XVII.png",
            "IB.png","IIB.png","IIIB.png","IVB.png","VB.png","VIB.png","VIIB.png","VIIIB.png","IXB.png","XB.png","XIB.png","XIIB.png","XIIIB.png","XIVB.png","XVB.png","XVIB.png","XVIIB.png",
            "proceed.png"};

    public TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            switch(cont){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 34:
                    cont = 0;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
            }
        }
    };
    public java.util.Timer timer = new Timer();

    public Ensamblaje() {
        //tamano de la ventana
        this.setSize(1000, 700); //ancho y alto
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

        imgT = new JLabel(new ImageIcon(imageRoot.concat(imgList[0])));
        imgT.setSize(1000,450);
        panel.add(imgT,BorderLayout.CENTER);
    }
    //Colocamos los botones
    private void colocarBotones() {
        //boton siguiente
        btnNext = new JButton();
        btnNext.setBounds(700, 7, 64, 64);
        //btnNext.setSize(64,64);
        icnNext = new ImageIcon("src/resources/img/next.png");
        btnNext.setIcon(new ImageIcon(icnNext.getImage().getScaledInstance(btnNext.getWidth(), btnNext.getHeight(), Image.SCALE_SMOOTH)));
        btnNext.setContentAreaFilled(false);
        btnNext.setEnabled(true);
        btnNext.setBorder(null);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.addActionListener(this); //eventos del boton
        panel2.add(btnNext);

        //BOTON DE INSTRUCCIONES
        btnBack = new JButton();
        btnBack.setBounds(200, 7, 64, 64);
        //btnBack.setSize(64,64);
        icnBack = new ImageIcon("src/resources/img/return.png");
        btnBack.setIcon(new ImageIcon(icnBack.getImage().getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), Image.SCALE_SMOOTH)));
        btnBack.setContentAreaFilled(false);
        btnBack.setEnabled(true);
        btnBack.setBorder(null);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this); //eventos del boton
        panel2.add(btnBack);

    }
    //Eventos del boton
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON SIGUIENTE
        if (evento.getSource() == btnNext) {
            menu.Menu menu = new Menu();
            menu.setVisible(true);
            //System.out.println("Click en next");
            this.dispose();
        }

        //EVENTO DEL BOTON ATRAS
        if (evento.getSource() == btnBack) {
            Credits credits = new Credits();
            credits.setVisible(true);
            //System.out.println("Click en back");
            this.dispose();
        }

    }
}
