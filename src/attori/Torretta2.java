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
public class Torretta2 extends Torretta {
 
    /**
     *
     * @param danno
     * @param x
     * @param y
     * @param proiettili
     */
    public Torretta2(int danno, int x, int y, ArrayList<Proiettile> proiettili) {
        super();
        costoUpgrade=costoAcquisto+5;
        velocitàAttacco = 4000;
        attacco = danno;
        this.proiettili = proiettili;
        this.x = x * 40;
        this.y = y * 40 - 40;
        range = new Ellipse2D.Double();
        range.setFrame(this.x - 40, this.y - 40, 119, 119);
        temposparo = 600;
        finestrasparo = 0;
        costoAcquisto = 20;
        tipo='b';

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
     * @return
     */
    @Override
    public int getCostoAcquisto() {
        return costoAcquisto;
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
        proiettili.add(new Proiettile(bersaglio, this.x, this.y, attacco,this));

      
    }

    /**
     *
     * @param bersaglio
     */
    @Override
      public void colpisci(Mob bersaglio){
          
          if(bersaglio.getTempoRallentato()<=0){
              bersaglio.setRallentato(true);
          bersaglio.setDebuffVelocità(attacco);
      bersaglio.setVelocità(bersaglio.getVelocità()+ attacco);
        }
          bersaglio.setTempoRallentato(bersaglio.getTempoRallentato()+2000);
    }

    /**
     *
     */
    @Override
    public void upgrade() {
        System.out.println("mannaggiasanda");

        livelloTorretta = 1;
        attacco += 5;
        velocitàAttacco = 4500;
        giocatore.setSoldi(giocatore.getSoldi() - 20);
        iPanel.update(giocatore);
        sPanel.aggiornamentoStatTor(livelloTorretta, costoAcquisto, velocitàAttacco, attacco);

    }

    /**
     *
     * @param g
     */
    @Override
    public void disegna(Graphics g) {
        g.drawImage(Pannello.Tipo_torr2, x, y, 40, 40, null);
        g.setColor(Color.YELLOW);
        g.drawOval(x - 40, y - 40, 120, 120);
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
