/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public abstract class Torretta extends Rectangle {

    protected int id,

    /**
     *
     */
    attacco, costoAcquisto,

    /**
     *
     */
    guadagnoVendita,

    /**
     *
     */
    costoUpgrade,

    /**
     *
     */
    livelloTorretta;

    /**
     *
     */
    protected int velocitàAttacco;

    /**
     *
     */
    protected char tipo;

  
    
      protected int temposparo,

    /**
     *
     */
    finestrasparo;

    /**
     *
     */
    protected ArrayList<Proiettile> proiettili;

    /**
     *
     */
    protected Ellipse2D.Double range;
        
    /**
     *
     * @return
     */
    public abstract char getTipo();

    /**
     *
     * @return
     */
    public abstract int getCostoAcquisto();

    /**
     *
     * @return
     */
    public abstract ArrayList<Proiettile> getProiettili();

    /**
     *
     * @return
     */
    public abstract int getLivelloTorretta();

    /**
     *
     * @return
     */
    public abstract int getVelocitàAttacco();

    /**
     *
     * @return
     */
    public abstract int getAttacco();

    /**
     *
     * @return
     */
    public abstract int getCostoUpgrade();

    /**
     *
     * @return
     */
    public abstract Ellipse2D.Double getRange();

    /**
     *
     * @param g
     */
    public abstract void disegna(Graphics g);

    /**
     *
     * @param bersaglio
     */
    public abstract void attacca(Mob bersaglio);

    /**
     *
     * @param bersaglio
     */
    public abstract void colpisci(Mob bersaglio);

    /**
     *
     * @param bersaglio
     */
    public abstract void nelRange(Mob bersaglio);

    /**
     *
     */
    public abstract void upgrade();

   


   
}
