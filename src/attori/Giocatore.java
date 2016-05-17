/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

/**
 *Classe che definisce le caratteristiche del giocatore "player".
 * @author User
 */
public class Giocatore {

    private int vita, soldi;// variabili intere che definiscono rispettivamente i punti vita del giocatore e i soldi a disposizione per l'aquisto e upgrade delle torrette.

    /**
     *Metodo costruttore della classe.
     * @param vita
     * @param soldi
     */
    public Giocatore(int vita, int soldi) {

        this.vita = vita;
        this.soldi = soldi;

    }

    /**
     *Metodo che restituisce il valore di "vita".
     * @return
     */
    public int getVita() {
        return vita;
    }

    /**
     *Metodo utilizzato per il set del valore "vita".
     * @param vita
     */
    public void setVita(int vita) {
        this.vita = vita;
    }

    /**
     *Metoto che restituisce il valore di "soldi".
     * @return
     */
    public int getSoldi() {
        return soldi;
    }

    /**
     *Metodo utilizzato per il set di "soldi".
     * @param soldi
     */
    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }

    /**
     *Metodo utilizzato per aggiungere un determinato valore alla variabile "soldi".
     * @param soldi
     */
    public void aggiungiSoldi(int soldi) {
        this.soldi += soldi;
    }
}
