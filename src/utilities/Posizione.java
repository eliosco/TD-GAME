/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author User
 */
public class Posizione {

    private int x, y, xPlace, yPlace;

    /**
     *
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
     *
     * @param xPlace
     */
    public void setXPlace(int xPlace) {
        this.xPlace = xPlace;
    }

    /**
     *
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
     *
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
     *
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
