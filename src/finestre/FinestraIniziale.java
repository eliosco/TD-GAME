/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre;
/*import delle librerie utili alla classe tra cui le librerie awt e swing che si ccupano della grafica , la sottolibreria event di awt che si occupa della gestione degli eventi,
uso della libreria javax che si occupa della grafica avanzata*/
import ascoltatori.AscoltatoreInfo;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import utilities.DocSalvato;
import static utilities.TDGAME.*;

/**
 *
 * @author User
 */
 
 /* classe derivata che estende la classe di java JFrame e implementa l'interfaccia ActionListener, la classe JFrame è una versione evoluta della java.wat.Frame aggiungendo il supporto per le componenti swing, l'interfaccia ActionListener viene implementata per poter consentire alla classe l'elaborazione di un evento azione.*/
public class FinestraIniziale extends JFrame implements ActionListener {

    private JPanel pannelloIn;
    private JButton start;
    private JButton info;
    private JLabel testo, testo1;
    private JTextArea classifica;//dichiarazione di una variabile di tipo JTestArea preso dalla libreria awt di java , cioè una zona con più linee che consente la visualizzazione di un testo
    private File file;//il tipo file ci consente di rappresentare in modo astratto un percorso di un file e una directory
    private String test;

    /**
     *
     * @return test di tipo String
     */
    public String getTest() {
        return test;
    }

    /**
     *
     * @param test di tipo String
     */
    public void setTest(String test) {
        this.test = test;
    }

  
    private DocSalvato ds;

   
    private AscoltatoreInfo aF;

    /**
     *
     * @throws IOException
     * il costruttore di questa classe gestisce eccezioni di tipo input/output, nel costruttore creiamo tutti gli oggetti per la finestra iniziale
     */
    public FinestraIniziale() throws IOException {
        super(" MENU' INIZIALE");//prende tutti i metodi e attributi della super classe
        this.setLocation(600, 400);
       aF=new AscoltatoreInfo();
        pannelloIn = new JPanel();
DocSalvato s=new DocSalvato();
        testo = new JLabel("<html> &nbsp; &nbsp; &nbsp; &nbsp; Il cronometro partirà alla pressione del tasto START &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  !!!! Buona Fortuna!!!! </html>  ");
        start = new JButton("START");
        info=new JButton("INFO");
        testo1 = new JLabel("CLASSIFICA:");
        classifica = new JTextArea("");
        file = new File("salvato/infoGAME.txt");
        ds=new DocSalvato();
        add(pannelloIn);    //aggiungiamo alla finestra iniziale il pannello iniziale 
        pannelloIn.setLayout(new BorderLayout());//settaggio del layout del pannello iniziale
        start.addActionListener(this);//il JButton start riceve azioni di eventi gestiti da questa stessa classe grazie al metodo actionPerformed
        info.addMouseListener(aF);//il tasto info riceve eventi del mouse grazie gestiti dall'ascoltatore di eventi aF

        stampa(connessione.getData());//chiamata al metodo stampa di questa classe con paraetro di ingresso i dati presi dalla connessione al database
        //settaggio delle posizioni delle componenti all'interno del pannello iniziale con il border layout
        pannelloIn.add(start,BorderLayout.SOUTH);
       pannelloIn.add(info,BorderLayout.EAST);
        pannelloIn.add(testo, BorderLayout.NORTH);
        pannelloIn.add(testo1, BorderLayout.WEST);
        pannelloIn.add(classifica, BorderLayout.CENTER);
        test=ds.caricaIlFile(file); //assegnazione alla string "test" del testo estrapolato dal metodo caricaIlFile di file dell'oggetto ds
        classifica.setEditable(false);
      //settaggio dei parametri di base della finestra
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.dispose();//cancellazione di questo JFrame

        finestra = new Finestra();//creazione del JFrame finestra

    }

    /**
     *
     * @param s di tipo String[]
     * questo metodo concatena stinghe in un vettore stringhe assegnandolo per ogni giro del ciclo all'oggetto classifica con il metodo append
     */
    public void stampa(String[] s) {
        for (int j = 0; j < s.length; j++) {
            if (s[j] != null) {
                classifica.append("\n" + s[j] + "\n");
            }
        }
       
    
        
        
    }
    
    /**
     *
     * @return file di tipo File
     */
    public File getFile() {
        return file;
    }

    /**
     *
     * @param file di tipo File
     */
    public void setFile(File file) {
        this.file = file;
    }
    
    /**
     *
     * @return ds di tipo DocSalvato
     */
    public DocSalvato getDs() {
        return ds;
    }

    /**
     *
     * @param ds di tipo DocSalvato
     */
    public void setDs(DocSalvato ds) {
        this.ds = ds;
    }
}
