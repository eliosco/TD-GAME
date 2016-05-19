/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import attori.Torretta;
import java.awt.*;
import static finestre.Finestra.panel;
import static utilities.Valore.terrenoErba;

/**
 * questa classe racchiude la categoria di oggetti che sono formati da una griglia o matrice di piastrelle
 * @author User
 */
public final class Griglia {
    private int dimPiastrelle,worldAltezza,worldLarghezza;
 
    private Piastrella[][] piastrella;
   
    /**
     *costruttore della classe Griglia che assegna le dimensioni standard utilizzate e richiama il metodo definisci() della classe
     */
    public Griglia(){
        this.dimPiastrelle = 40;
        this.worldAltezza = 13;
        this.worldLarghezza = 20;
        definisci();    
    }
    
    /**
     *
     * @return la dimensione della piastrella
     */
    public int getDimPiastrelle() {
        return dimPiastrelle;
    }

    /**
     *
     * @param dimPiastrelle di tipo int
     */
    public void setDimPiastrelle(int dimPiastrelle) {
        this.dimPiastrelle = dimPiastrelle;
    }

    /**
     *
     * @return l'altezza del mondo(griglia)
     */
    public int getWorldAltezza() {
        return worldAltezza;
    }

    /**
     *
     * @param worldAltezza
     */
    public void setWorldAltezza(int worldAltezza) {
        this.worldAltezza = worldAltezza;
    }

    /**
     *
     * @return la larghezza del mondo
     */
    public int getWorldLarghezza() {
        return worldLarghezza;
    }

    /**
     *
     * @param worldLarghezza
     */
    public void setWorldLarghezza(int worldLarghezza) {
        this.worldLarghezza = worldLarghezza;
    }

    /**
     *
     * @return la piastrella di tipo Piastrella[][] 
     */
    public Piastrella[][] getPiastrella() {
        return piastrella;
    }

    /**
     *
     * @param piastrella
     */
    public void setPiastrella(Piastrella[][] piastrella) {
        this.piastrella = piastrella;
    }
    
    /**
     * questo metodo definisce la griglia che andremo a costruire, esso costruisce una matrice di piastrelle con dimensioni uguali a quelle del mondo che ci interessa costruire e per ogni posizione della matrice di tipo piastrella crea una piastrella passandogli le relative dimensioni prefissate
     */
    public void definisci(){
        piastrella=new Piastrella[worldAltezza][worldLarghezza];
        for (int i=0;i<piastrella.length;i++){
            for(int j=0;j<piastrella[0].length;j++){
                piastrella[i][j]=new Piastrella(j*dimPiastrelle,i*dimPiastrelle,dimPiastrelle,dimPiastrelle,0,0);
            }
        }
    }
       
    /**
     * questo metodo disegna ogni singola piastrella scorrendo il vettore elemento per elemento grazie alla variabile g di tipo graphics  che sostanzialmente racchiude una componente grafiche con le relative caratteristiche
     * @param g
     */
    public void disegna(Graphics g){
       for (Piastrella[] piastrella1 : piastrella) {
           for (int j = 0; j<piastrella[0].length; j++) {
               piastrella1[j].disegna(g);
           }
       }   
    }
        
    /**
     *questo metodo prende in ingresso delle coordinate x e y e, scorrendo la lista delle torrette, controlla se questi parametri di ingresso sono nella posizione esatta per poter installare una torretta confrontandoli con le dimensioni della torretta stessa 
     * @param x
     * @param y
     * @return
     */
    public boolean giustaposizione(int x, int y){
        for (Torretta tor: panel.getTorrette())
        {
        
            if (x>tor.getX() && x < tor.getX()+40 && y-40> tor.getY() && y-40 < tor.getY()+40)
            {
                return false;
            }else {
                if(x==tor.getX() || x == tor.getX()+40 || y-40== tor.getY() || y-40 == tor.getY()+40){
                return false;
            }}
                
            
        }
        return piastrella[y/40-1][x/40].getTerrenoId()==terrenoErba; //ritorna true se è soddisfatta la condizione
    }
}
