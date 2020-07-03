package mef;

import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Malla extends JFrame implements ActionListener {
    public JPanel panelPrincipal, panel, panel2;
    public JButton btnNext, btnBack;
    public JLabel lblFondo, lblFondo2, imgT;
    public ImageIcon imgFondo, icnNext, icnBack, imgTitle;

    public Icon icono;
    public String imageRoot = "src/resources/img/Domain/mallado.png";
    //public String imgList[] = {"I.png","II.png","III.png","IV.png","V.png","VI.png","VII.png","VIII.png","IX.png","X.png","XI.png","XII.png","XIII.png","XIV.png","XV.png","XVI.png","XVII.png"};

    public Malla() {
        //tamano de la ventana
        this.setSize(1000, 650); //ancho y alto
        this.setTitle("Condiciones"); //titulo de la ventana
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
        lblFondo.setSize(1000,150);
        lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        panel2.add(lblFondo); //agregando la etiqueta al panel

        imgTitle = new ImageIcon("src/resources/img/Titles/condiciones.png");
        lblFondo2 = new JLabel(imgTitle); //agregando la etiqueta con la imgane
        //lblFondo.setBounds(0, 0, 1000, 607);
        lblFondo2.setSize(1000,150);
        lblFondo2.setIcon(new ImageIcon(imgTitle.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lblFondo2, BorderLayout.NORTH);

        imgT = new JLabel(new ImageIcon(imageRoot));
        imgT.setSize(200,300);
        panel.add(imgT,BorderLayout.CENTER);
    }
    //Colocamos los botones
    private void colocarBotones() {
        //boton siguiente
        btnNext = new JButton();
        btnNext.setBounds(700, 40, 64, 64);
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
        btnBack.setBounds(200, 40, 64, 64);
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
            Steps steps = new Steps();
            steps.setVisible(true);
            System.out.println("Click en next");
            this.dispose();
        }

        //EVENTO DEL BOTON ATRAS
        if (evento.getSource() == btnBack) {
            Condiciones condiciones = new Condiciones();
            condiciones.setVisible(true);
            System.out.println("Click en next");
            this.dispose();
        }

    }
}
