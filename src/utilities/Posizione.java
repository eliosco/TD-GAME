/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 * Questa classe ci permette di gestire la posizione sia in termini di pixel che all'interno dela matrice mappa.
 * @author User
 */
public class Posizione {

    private int x, y, xPlace, yPlace;

    /**
     * Metodo costrutture. xPlace e yPlace indicano la posizione in pixel.
     * @param x
     * @param y
     */
    public Posizione(int x, int y) {

        this.x = x;
        this.y = y;
        this.xPlace = x * 40;
        this.yPlace = y * 40;

    }

    /**
     * Set della variabile xPlace.
     * @param xPlace
     */
    public void setXPlace(int xPlace) {
        this.xPlace = xPlace;
    }

    /**
     * Set della variabile yPlace.
     * @param yPlace
     */
    public void setYPlace(int yPlace) {
        this.yPlace = yPlace;
    }

    /**
     * 
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * metodo set per la variabile x. in questo metodo settiamo anche xPlace che è la x in pixel
     * @param x
     */
    public void setX(int x) {
        this.x = x;
        this.xPlace = x * 40;
    }

    /**
     * 
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * metodo set per la variabile y. in questo metodo settiamo anche yPlace che è la y in pixel
     * @param y
     */
    public void setY(int y) {
        this.y = y;
        this.yPlace = y * 40;
    }

    /**
     *
     * @return
     */
    public int getXPlace() {
        return xPlace;
    }

    /**
     *
     * @return
     */
    public int getYPlace() {
        return yPlace;
    }
}
