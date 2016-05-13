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
 *
 * @author User
 */
public class PannelloInferiore extends JPanel {
    private int ondManc;
    private JButton ready, morefast, piuLento, normale;
    private String velocita;

   
    private JLabel vel;
    private AscoltatoreDiEventiInferiore ondate, ricevitoreL, ricevitoreN, ricevitoreV;

    private JLabel vita;
    private JLabel soldi;
    private JLabel ondateMancanti;

    private JProgressBar barraProgresso = new JProgressBar(0, 100);

    /**
     *
     * @return
     */
    public JButton getReady() {
        return ready;
    }

    /**
     *
     * @return
     */
    public JProgressBar getBarraProgresso() {
        return barraProgresso;
    }

    /**
     *
     * @param barraProgresso
     */
    public void setBarraProgresso(JProgressBar barraProgresso) {
        this.barraProgresso = barraProgresso;
    }

    /**
     *
     * @return
     */
    public JLabel getVita() {
        return vita;
    }

    /**
     *
     * @param vita
     */
    public void setVita(JLabel vita) {
        this.vita = vita;
    }

    /**
     *
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

        ondate = new AscoltatoreDiEventiInferiore(ready, vel);
        ricevitoreL = new AscoltatoreDiEventiInferiore(piuLento, vel);
        ricevitoreN = new AscoltatoreDiEventiInferiore(normale, vel);
        ricevitoreV = new AscoltatoreDiEventiInferiore(morefast, vel);

        barraProgresso = new JProgressBar(0, 100);

        vita = new JLabel("Vita: " + giocatore.getVita());
        soldi = new JLabel("Soldi: " + giocatore.getSoldi());
        vel.setText("normale");

        add(vita);
        add(soldi);
        add(ready);

        add(morefast);
        add(normale);
        add(piuLento);
        add(barraProgresso);
        add(vel);
        add(ondateMancanti);
        
        morefast.addActionListener(ricevitoreV);
        normale.addActionListener(ricevitoreN);
        piuLento.addActionListener(ricevitoreL);
        ready.addActionListener(ondate);
    }

    /**
     *
     * @return
     */
    public JLabel getOndateMancanti() {
        return ondateMancanti;
    }

    /**
     *
     * @param ondateMancanti
     */
    public void setOndateMancanti(JLabel ondateMancanti) {
        this.ondateMancanti = ondateMancanti;
    }

    /**
     *
     * @param giocatore
     */
    public void update(Giocatore giocatore) {
        vita.setText("Vita: " + giocatore.getVita());
        soldi.setText("Soldi: " + giocatore.getSoldi());
        
    }

    /**
     *
     * @return
     */
    public int getOndManc() {
        return ondManc;
    }

    /**
     *
     * @param ondManc
     */
    public void setOndManc(int ondManc) {
        this.ondManc = ondManc;
    }
}
