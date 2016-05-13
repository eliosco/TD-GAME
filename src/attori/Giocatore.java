/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

/**
 *
 * @author User
 */
public class Giocatore {

    private int vita, soldi;

    /**
     *
     * @param vita
     * @param soldi
     */
    public Giocatore(int vita, int soldi) {

        this.vita = vita;
        this.soldi = soldi;

    }

    /**
     *
     * @return
     */
    public int getVita() {
        return vita;
    }

    /**
     *
     * @param vita
     */
    public void setVita(int vita) {
        this.vita = vita;
    }

    /**
     *
     * @return
     */
    public int getSoldi() {
        return soldi;
    }

    /**
     *
     * @param soldi
     */
    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }

    /**
     *
     * @param soldi
     */
    public void aggiungiSoldi(int soldi) {
        this.soldi += soldi;
    }
}
