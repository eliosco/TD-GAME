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
 *Classe astratta di Torretta.
 * @author User
 */
public abstract class Torretta extends Rectangle {

    protected int id,

    /**
     *la variabile "id" determina l'id della torretta.
     * La variabile "attacco" determina il danno della torretta.
     * La variabile "costoAquisto" determina il costo della torretta per l'aquisto.
     */
    attacco, costoAcquisto,

    /**
     *La variabile "guadagnoVendita" determina il valore che sarà aggiunto ai soldi di giocatore al momento della vendita della torretta stessa.
     */
    guadagnoVendita,

    /**
     *La variabile "costoUpgrade" determina il prezzo necessario per l'upgrade della torretta.
     */
    costoUpgrade,

    /**
     *La variabile "livelloTorretta" determina il livello della torretta ovvero se è stato effettuato o meno l'upgrade.
     */
    livelloTorretta;

    /**
     *La variabile "velocitàAttacco" determina il valore della velocità con cui la torretta attacca.
     */
    protected int velocitàAttacco;

    /**
     *La variabile "tipo" determina il tipo di torretta.
     */
    protected char tipo;

  
    
    protected int temposparo,

    /**
     *Le variabili "temposparo" e "finestrasparo" sono utilizzate per la definizione di un delay per l'attacco della torretta.
     */
    finestrasparo;

    /**
     *Definizione di un ArrayLsit che conterrà i proiettili della torretta.
     */
    protected ArrayList<Proiettile> proiettili;

    /**
     *Definizione della variabile "range". Deve essere considerata come un area intorno la torretta all'interno della quale la torretta può attaccare.
     */
    protected Ellipse2D.Double range;
        
    /**
     *Metodo utilizzato per restituire il valore della variabile "tipo".
     * @return
     */
    public abstract char getTipo();

    /**
     *Metodo utilizzato per la restituire il vallore della variabile "costoAquisto".
     * @return
     */
    public abstract int getCostoAcquisto();

    /**
     *Metodo che restituisce l'arraylist di proiettili.
     * @return
     */
    public abstract ArrayList<Proiettile> getProiettili();

    /**
     *Metodo che restituisce il valore della variabile "livelloTorretta"
     * @return
     */
    public abstract int getLivelloTorretta();

    /**
     *Metodo che restituisce il valore della variabile "velocitàAttacco".
     * @return
     */
    public abstract int getVelocitàAttacco();

    /**
     *Metodo che restituisce il valore della variabile "attacco".
     * @return
     */
    public abstract int getAttacco();

    /**
     *Metodo che restituisce il valore della variabile "costoUpgrade".
     * @return
     */
    public abstract int getCostoUpgrade();

    /**
     *Metodo che restituisce l'oggetto "range".
     * @return
     */
    public abstract Ellipse2D.Double getRange();

    /**
     *Metodo utilizzato per disegnare la torretta.
     * @param g
     */
    public abstract void disegna(Graphics g);

    /**
     *Metodo utilizzato per definire l'attacco della torretta.
     * @param bersaglio
     */
    public abstract void attacca(Mob bersaglio);

    /**
     *Metodo definito per determinare il colpire del proiettile il bersaglio.
     * @param bersaglio
     */
    public abstract void colpisci(Mob bersaglio);

    /**
     *Metodo utilizzato per la verifica che un determinato mob sia nel range della torretta.
     * @param bersaglio
     */
    public abstract void nelRange(Mob bersaglio);

    /**
     *Metodo utilizzato per l'aggiornamento della torretta al momento dell'upgrade.
     */
    public abstract void upgrade();

   


   
}
