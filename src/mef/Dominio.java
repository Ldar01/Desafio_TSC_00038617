package mef;

import menu.Credits;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Dominio extends JFrame implements ActionListener {
    public static int cont = 0;
    public int velocidad = 1*1000; //segundos

    public JPanel panelPrincipal, panel, panel2;
    public JButton btnNext, btnBack;
    public JLabel lblFondo, lblFondo2, imgT;
    public ImageIcon imgFondo, icnNext, icnBack, imgTitle;

    public Icon icono;
    public String imageRoot = "src/resources/img/Domain/";
    public String imgList[] = {"dominio1.png","dominio2.png","dominio3.png","dominio4.png",
            "dominio5.png","dominio6.png","dominio7.png"};

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
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 3:
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 4:
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 5:
                    cont++;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
                case 6:
                    cont = 0;
                    icono =  new ImageIcon(imageRoot.concat(imgList[cont]));
                    imgT.setIcon(icono);
                    break;
            }
        }
    };
    public java.util.Timer timer = new Timer();

    public Dominio() {
        //tamano de la ventana
        this.setSize(1000, 700); //ancho y alto
        this.setTitle("Dominio"); //titulo de la ventana
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
            Condiciones condiciones = new Condiciones();
            condiciones.setVisible(true);
            //System.out.println("Click en next");
            this.dispose();
        }

        //EVENTO DEL BOTON ATRAS
        if (evento.getSource() == btnBack) {
            Modelo modelo = new Modelo();
            modelo.setVisible(true);
            //System.out.println("Click en back");
            this.dispose();
        }

    }
}
