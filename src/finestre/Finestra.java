/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre;
//import delle librerie utili per la classe tra cui quelle grafiche awt e swing
import attori.Giocatore;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import pannelli.*;

/**
 *
 * @author User
 */
public class Finestra extends JFrame {

    private Timer timer;

    /**
     *
     * @return variabile di tipo Timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     *
     * @param timer di tipo Timer
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    private long startTime;// dichiarazione della variabile privata "startTime" di tipo long

    /**
     *dichiarazione della variabile pubblica e statica "giocatore" di tipo Giocatore
     */
    public static Giocatore giocatore;

    /**
     *dichiarazione della variabile pubblica e statica "panel" di tipo Pannello
     */
    public static Pannello panel;

    /**
     *dichiarazione della variabile pubblica e statica "sPanel" di tipo PannelloSuperiore
     */
    public static PannelloSuperiore sPanel;

    /**
     *dichiarazione della variabile pubblica e statica "iPanel" di tipo PannelloInferiore
     */
    public static PannelloInferiore iPanel;

    /**
     *dichiarazione della variabile pubblica e statica "cronometro" di tipo JPanel
     */
    public static JPanel cronometro;

    /**
     *dichiarazione della variabile pubblica e statica "s" di tipo String
     */
    public static String s;

    /**
     *costruttore della classe Finestra
     */
    public Finestra() {
        super("esempio");

        giocatore = new Giocatore(100, 30);//creazione del giocatore
        panel = new Pannello(this);//creazione del pannello centrale
        sPanel = new PannelloSuperiore(giocatore);//creazione del pannello superiore
        iPanel = new PannelloInferiore(giocatore);//creazione del pannello inferiore
        cronometro = new JPanel();//creazione del pannello cronometro
        cronometro.setBackground(Color.white);//settaggio colore di sfondo del pannello cronometro
        Container c = this.getContentPane();//acquisizione ed assegnazione delle componenti della finestra nel contenitore "c" di tipo Container

        JLabel labTime;//dichiarazione della variabile "labTime" di tipo JLabel
        labTime = new JLabel("0:00:00.0");//costruzione del labTime con inizializzazione
        labTime.setFont(new Font("SansSerif", Font.BOLD, 30));//settaggio del font del label labTime
        labTime.setHorizontalAlignment(JLabel.CENTER);//settaggio della posizione del label labTime

        JPanel BottoniPanel;//dichiarazione del pannello che conterrà i bottoni
        BottoniPanel = new JPanel(new GridLayout(1, 2));//creazione del pannello e settaggio del layout di quest'ultimo

        cronometro.add(labTime, BorderLayout.CENTER);//aggiunta al pannello cronometro della componente labTime
        cronometro.add(BottoniPanel, BorderLayout.SOUTH);//aggiunta al pannelllo cronometro del pannello BottoniPanel

        sPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 6, 6));//settaggio del layout del pannello superiore

        c.setLayout(new BorderLayout());//layout del contenitore
//aggiunta delle componenti all'interno del contenitore con le relative posizioni rispettando il BorderLayout
        c.add(getContentPane().add(sPanel), BorderLayout.NORTH);

        c.add(getContentPane().add(iPanel), BorderLayout.SOUTH);
        c.add(getContentPane().add(panel), BorderLayout.CENTER);
        c.add(cronometro, BorderLayout.EAST);

        this.pack();//pack dimensiona il frame in modo da contenere esattamente il pannello 

        this.setSize(1000, 600);//dimensione della finestra
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//operazione di default alla pressione della x in alto a destra della finestra
        this.setResizable(false);//possibilità di ridimensionare la finestra negata

        timer = new Timer(100, (ActionEvent e) -> { // costruzione dell'oggetto timer con la definizone delle sue variabili che si aggiornano all'avanzare del thread
            long diffTime = System.currentTimeMillis() - startTime;
            int decSeconds = (int) (diffTime % 1000 / 100);
            int seconds = (int) (diffTime / 1000 % 60);
            int minutes = (int) (diffTime / 60000 % 60);
            int hours = (int) (diffTime / 3600000);
            s = String.format("%d:%02d:%02d.%d", hours, minutes, seconds, decSeconds);
            labTime.setText(s);
        });

        startTime = System.currentTimeMillis();//assegnazione alla variabile startTime del tempo in millisewcondi corrente registrato dal system
        timer.start();//partenza del thread timer

        this.setVisible(true);//visualizzazione della finestra attivata
    }
}
