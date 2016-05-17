/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannelli;

import attori.Giocatore;
import javax.swing.*;
import ascoltatori.AscoltatoreDiEventiInferiore;

import static finestre.Finestra.panel;

/**
 *Classe di PannelloInferiore
 * @author User
 */
public class PannelloInferiore extends JPanel {
    private int ondManc;// Variabile che determina il numero di ondate mancanti per terminare la partita.
    private JButton ready, morefast, piuLento, normale;// bottoni che determinano la velocità di scorrimento della barra di progresso e la partenza delle ondate.
    private String velocita;// Stringa che contiene il valore del bottone cliccato.

   
    private JLabel vel;// label che stampa il valore della velocità della barra di progresso
    private AscoltatoreDiEventiInferiore ondate, ricevitoreL, ricevitoreN, ricevitoreV; // recevitori di eventi per ogni bottone.

    private JLabel vita;// label che contiene la vita del giocatore.
    private JLabel soldi;// label che contiene i soldi del giocatore.
    private JLabel ondateMancanti;// label che contiene il valore delle ondate mancanti.

    private JProgressBar barraProgresso = new JProgressBar(0, 100);// inizializzazione di una barra di progresso.

    /**
     *Metodo che restituisce il bottone "ready".
     * @return
     */
    public JButton getReady() {
        return ready;
    }

    /**
     *Metodo che restituisce la barra di progresso.
     * @return
     */
    public JProgressBar getBarraProgresso() {
        return barraProgresso;
    }

    /**
     *Metodo utilizzato per il set della barra di progresso.
     * @param barraProgresso
     */
    public void setBarraProgresso(JProgressBar barraProgresso) {
        this.barraProgresso = barraProgresso;
    }

    /**
     *Metodo che restituisce la label "vita".
     * @return
     */
    public JLabel getVita() {
        return vita;
    }

    /**
     *Metodo utilizzato per il set della label "vita".
     * @param vita
     */
    public void setVita(JLabel vita) {
        this.vita = vita;
    }

    /**
     *Metodo costruttore della classe.
     * @param giocatore
     */
    public PannelloInferiore(Giocatore giocatore) {
        ondManc=3;
        ready = new JButton("READY");
        ondateMancanti=new JLabel("Mancano "+ ondManc+" ondate.");
        morefast = new JButton("veloce");
        piuLento = new JButton("lento");
        normale = new JButton("normale");
        velocita = "normale";
        vel = new JLabel();
        // inizializzazione degli ascoltatori di eventi.
        ondate = new AscoltatoreDiEventiInferiore(ready, vel);
        ricevitoreL = new AscoltatoreDiEventiInferiore(piuLento, vel);
        ricevitoreN = new AscoltatoreDiEventiInferiore(normale, vel);
        ricevitoreV = new AscoltatoreDiEventiInferiore(morefast, vel);

        barraProgresso = new JProgressBar(0, 100);

        vita = new JLabel("Vita: " + giocatore.getVita());
        soldi = new JLabel("Soldi: " + giocatore.getSoldi());
        vel.setText("normale");
        // aggiunta al pannello delle varie label e bottoni.
        add(vita);
        add(soldi);
        add(ready);

        add(morefast);
        add(normale);
        add(piuLento);
        add(barraProgresso);
        add(vel);
        add(ondateMancanti);
        // aggiunta degli ascoltatori di eventi ai bottoni.
        morefast.addActionListener(ricevitoreV);
        normale.addActionListener(ricevitoreN);
        piuLento.addActionListener(ricevitoreL);
        ready.addActionListener(ondate);
    }

    /**
     *Metodo che restituisce la label "ondateMancanti"
     * @return
     */
    public JLabel getOndateMancanti() {
        return ondateMancanti;
    }

    /**
     *Metodo utilizzato per il set della label "ondateMancanti"
     * @param ondateMancanti
     */
    public void setOndateMancanti(JLabel ondateMancanti) {
        this.ondateMancanti = ondateMancanti;
    }

    /**
     *Metodo utilizzato per aggiornare le label "vita" e "soldi" in base alle rispettive variabili di giocatore.
     * @param giocatore
     */
    public void update(Giocatore giocatore) {
        vita.setText("Vita: " + giocatore.getVita());
        soldi.setText("Soldi: " + giocatore.getSoldi());
        
    }

    /**
     *Metodo che restituisce il valore di "ondManc"
     * @return
     */
    public int getOndManc() {
        return ondManc;
    }

    /**
     *Metodo utilizzato per il set di "ondManc"
     * @param ondManc
     */
    public void setOndManc(int ondManc) {
        this.ondManc = ondManc;
    }
}
