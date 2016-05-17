/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

import ambiente.Mappa;
import java.awt.Image;

/**
 *Classe utilizzata per costruire l'oggetto ondata. Viene utilizzata per una gestione ottimizzata dei mob.
 * @author User
 */
public final class Ondata {

    private final int n;
    private Image immaginemob;

    private int vitaMob;
    private int velMob;
    private int guadagnoMob;

    private final int dimPiastrella;


    private final Mob[] mobs;// vettore di mob che caratterizzano l'ondata.
    private final Mappa mappa;// oggetto mappa che contiene il percorso che il mob può percorrere.

    /**
     *Metodo che restituisce l'oggetto "mappa".
     * @return
     */
    public Mappa getMappa() {
        return mappa;
    }
    
    /**
     *Metodo che restituisce il vettore di mob.
     * @return
     */
    public Mob[] getMobs() {
        return mobs;
    }
    
    /**
     *Metodo che restituisce il valore della variabile "vitaMob".
     * @return
     */
    public int getVitaMob() {
        return vitaMob;
    }

    /**
     *Metodo utilizzato per il set della variabile "vitaMob".
     * @param vitaMob
     */
    public void setVitaMob(int vitaMob) {
        this.vitaMob = vitaMob;
    }

    /**
     *Metodo che restituisce il valore della variabile "velMob".
     * @return
     */
    public int getVelMob() {
        return velMob;
    }

    /**
     *Metodo utilizzato per il set della variabile "velMob".
     * @param velMob
     */
    public void setVelMob(int velMob) {
        this.velMob = velMob;
    }

   

    /**
     *Metodo costruttore di ondata.
     * @param mappa
     * @param n
     * @param vitaMob
     * @param velMob
     * @param guadagnoMob
     * @param dimPiastrella
     * @param immaginemob
     */
    public Ondata(Mappa mappa, int n, int vitaMob, int velMob, int guadagnoMob,int dimPiastrella, Image immaginemob) {
        this.mappa = mappa;
        this.immaginemob= immaginemob;
        this.n = n;//numero mob dell'ondata e quindi dimensione del vettore Mob.
        mobs = new Mob[n];//istanziazione di un vetore di Mob di dimensione n.

        this.vitaMob = vitaMob;
        this.velMob = velMob;

        this.dimPiastrella = dimPiastrella;
        this.guadagnoMob=guadagnoMob;
        riempiOndata();//chiamata al metodo riempiOndata.

    }

 
    /**
     *Metodo che scorre il vettore Mob e istanzia n mob fino a riempire il vettore.
     */
    public void riempiOndata() {
        for (int i = 0; i < n; i++) {

            mobs[i] = new Mob(mappa.getPartenza(), velMob, i, vitaMob, guadagnoMob, dimPiastrella,immaginemob);

        }

    }

    /**
     *Metodo che restituisce il valore di "n".
     * @return
     */
    public int getN() {
        return n;
    }

}
