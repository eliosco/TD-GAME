/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import pannelli.Pannello;
import java.awt.*;
import utilities.Valore;

/**
 * questa classe estende la classe Rectangle di Java ereditando tutti i metodi e attributi
 * @author User
 */
public class Piastrella extends Rectangle {

    private int terrenoId, ariaId;

    /**
     * Costruttore della classe che prende in ingresso tutti i paramentri per dimensionare un oggetto di questa classe identificandolo anche con un id 
     * @param x
     * @param y
     * @param larghezza
     * @param altezza
     * @param terrenoId
     * @param ariaId
     */
    public Piastrella(int x, int y, int larghezza, int altezza, int terrenoId, int ariaId) {
        setBounds(x, y, larghezza, altezza);//Sposta e ridimensiona questo componente(Un componente è un oggetto con una rappresentazione grafica che può essere visualizzato sullo schermo e che può interagire con l'utente):
        this.terrenoId = terrenoId;
        this.ariaId = ariaId;
    }

    /**
     *
     * @return id del terreno
     */
    public int getTerrenoId() {
        return terrenoId;
    }

    /**
     *
     * @param terrenoId
     */
    public void setTerrenoId(int terrenoId) {
        this.terrenoId = terrenoId;
    }

    /**
     *
     * @return id dell'aria
     */
    public int getAriaId() {
        return ariaId;
    }

    /**
     *
     * @param ariaId
     */
    public void setAriaId(int ariaId) {
        this.ariaId = ariaId;
    }

    /**
     * il metodo disegna consente prendendo una componente di tipo Graphics di disegnare l'immagine della piastrella prendendola dal pannello in base al'id della piastrella 
     * @param g
     */
    public void disegna(Graphics g) {

        g.drawImage(Pannello.Tipo_terreno[terrenoId], x, y, width, height, null);
        if (ariaId != Valore.ariaAria) {
            g.drawImage(Pannello.Tipo_aria[ariaId], x, y, width, height, null);//Disegna la maggior quantità di immagine specificata come è già stato ridimensionata per adattarsi all'interno del rettangolo specificato .
        }
    }

}
