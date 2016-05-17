/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import static finestre.Finestra.*;
import pannelli.Pannello;

/**
 *
 * @author User
 */
public class Torretta1 extends Torretta {

    /**
     *
     * @param danno
     * @param x
     * @param y
     * @param proiettili
     */
    public Torretta1(int danno, int x, int y, ArrayList<Proiettile> proiettili) {
        super();
        velocitàAttacco = 5000;
        attacco = danno;
        this.proiettili = proiettili;
        this.x = x * 40;
        this.y = y * 40 - 40;
        range = new Ellipse2D.Double();
        range.setFrame(this.x - 40, this.y - 40, 119, 119);
        temposparo = 200;
        finestrasparo = 0;
        costoAcquisto = 10;
        tipo='a';
    }

    /**
     *
     * @return
     */
    public char getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int getAttacco() {
        return attacco;
    }

    /**
     *
     * @param attacco
     */
    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    /**
     *
     * @param costoAcquisto
     */
    public void setCostoAcquisto(int costoAcquisto) {
        this.costoAcquisto = costoAcquisto;
    }

    /**
     *
     * @return
     */
    public int getGuadagnoVendita() {
        return guadagnoVendita;
    }

    /**
     *
     * @param guadagnoVendita
     */
    public void setGuadagnoVendita(int guadagnoVendita) {
        this.guadagnoVendita = guadagnoVendita;
    }

    /**
     *
     * @return
     */
    public int getCostoUpgrade() {
        return costoUpgrade;
    }

    /**
     *
     * @param costoUpgrade
     */
    public void setCostoUpgrade(int costoUpgrade) {
        this.costoUpgrade = costoUpgrade;
    }

    /**
     *
     * @return
     */
    @Override
    public int getLivelloTorretta() {
        return livelloTorretta;
    }

    /**
     *
     * @param livelloTorretta
     */
    public void setLivelloTorretta(int livelloTorretta) {
        this.livelloTorretta = livelloTorretta;
    }

    /**
     *
     * @return
     */
    @Override
    public int getVelocitàAttacco() {
        return velocitàAttacco;
    }

    /**
     *
     * @param velocitàAttacco
     */
    public void setVelocitàAttacco(int velocitàAttacco) {
        this.velocitàAttacco = velocitàAttacco;
    }

    /**
     *
     * @return
     */
    public int getTemposparo() {
        return temposparo;
    }

    /**
     *
     * @param temposparo
     */
    public void setTemposparo(int temposparo) {
        this.temposparo = temposparo;
    }

    /**
     *
     * @return
     */
    public int getFinestrasparo() {
        return finestrasparo;
    }

    /**
     *
     * @param finestrasparo
     */
    public void setFinestrasparo(int finestrasparo) {
        this.finestrasparo = finestrasparo;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Proiettile> getProiettili() {
        return proiettili;
    }

    /**
     *
     * @param proiettili
     */
    public void setProiettili(ArrayList<Proiettile> proiettili) {
        this.proiettili = proiettili;
    }

    /**
     *
     * @return
     */
    @Override
    public Ellipse2D.Double getRange() {
        return range;
    }

    /**
     *
     * @param range
     */
    public void setRange(Ellipse2D.Double range) {
        this.range = range;
    }
   
    /**
     *
     * @param bersaglio
     */
    @Override
    public void attacca(Mob bersaglio) {

        proiettili.add(new Proiettile(bersaglio, this.x, this.y, attacco,this)); // aggiunge un proiettile all'arraylist.

    }
    
    /**
     *
     * @param bersaglio
     */
    @Override
    public void colpisci(Mob bersaglio){
        bersaglio.setSalute(bersaglio.getSalute() - attacco);// scala dalla salute del mob una quantità pari all'attacco della torretta.

                bersaglio.morte();// effettua la verifica se il bersaglio è morto.
    }

    /**
     *
     */
    @Override
    public void upgrade() {
        System.out.println("mannaggiasanda");
        costoUpgrade=costoAcquisto+5;
        livelloTorretta = 1;
        attacco += 5;
        velocitàAttacco = 5500;
        giocatore.setSoldi(giocatore.getSoldi() - costoUpgrade);// toglie il valore di "costoUpgrade" dal valore di "soldi" di giocatore.
        iPanel.update(giocatore);// aggiorna le variabili gi giocatore.
        sPanel.aggiornamentoStatTor(livelloTorretta, costoAcquisto, velocitàAttacco, attacco);// aggiorna le statische della torretta nel pannello superiore.

    }

    /**
     *
     * @param g
     */
    @Override
    public void disegna(Graphics g) {
        g.drawImage(Pannello.Tipo_torr1, x, y, 40, 40, null);
        g.setColor(Color.YELLOW);
        g.drawOval(x - 40, y - 40, 120, 120);// disegno del range della torretta.
    }

    /**
     *
     * @return
     */
    @Override
    public int getCostoAcquisto() {
       return costoAcquisto;
    }

    /**
     *
     * @param bersaglio
     */
    @Override
    public void nelRange(Mob bersaglio) {
        if (!bersaglio.isMorto() && range.intersects(bersaglio) && 
            panel.getContTorr()[panel.getTorrette().indexOf(this)] == velocitàAttacco) {
            attacca(bersaglio);
            panel.getContTorr()[panel.getTorrette().indexOf(this)]=0;
        }    
    }

}
