/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascoltatori;

import attori.Torretta1;
import attori.Torretta2;
import java.awt.*;
import java.awt.event.*;
import static finestre.Finestra.*;

/**
 *classe che implementa le interfaccie MouseListener e MouseMotionListener che si occupano della gestione degli eventi in base alle azioni del mouse
 * @author User
 */
public class AscoltatoreDiEventiSuperiore implements MouseListener, MouseMotionListener {

    /**
     *
     */
  //ho cancellato il costruttore 
  
  
  //se il mouse viene cliccato allora la variabile "drag viene settata a -1"
    @Override
    public void mouseClicked(MouseEvent e) {

        panel.setDrag(-1);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
//se il mouse viene rilasciato viene confrontato il denaro del giocatore con quello della torretta in drag, se la posizione in cui viene rilasciata sia quella giusta e se il drag è diverso da -1, dopo di che, se vengono soddisfatte tutte le condizioni si attiva una delle casistitische dello switch case;
    @Override
    public void mouseReleased(MouseEvent e) {
        try {

         
            if (giocatore.getSoldi() >= panel.getTortipo()[panel.getDrag()].getCostoAcquisto()
                    && panel.getGriglia().giustaposizione(e.getX(), e.getY() )
                    && panel.getDrag() != -1) {

                switch (panel.getDrag()) {//in base alla torretta rilasciata si andranno a modificare le caratteristiche del giocatore con un decremento del contatore delle torrette
                    case 0:
                        panel.getTorrette().add(new Torretta1(15, e.getX() / 40, e.getY() / 40, panel.getProiettili()));
                        panel.getContTorr()[panel.getTorrette().size()-1]=0;
                        giocatore.setSoldi(giocatore.getSoldi() - panel.getTortipo()[panel.getDrag()].getCostoAcquisto());
                        break;
                    case 1:
                        panel.getTorrette().add(new Torretta2(5, e.getX() / 40, e.getY() / 40, panel.getProiettili()));
                        panel.getContTorr()[panel.getTorrette().size()-1]=0;
                        giocatore.setSoldi(giocatore.getSoldi() - panel.getTortipo()[panel.getDrag()].getCostoAcquisto());
                    break;
                }

                iPanel.update(giocatore);//vengono aggiornati i dati del giocatore con la chiamata al metodo update del pannello inferiore

            }
            panel.setDrag(-1); //settaggio a -1 della variabile "drag"
        } catch (Exception ec) {
            System.out.println("Pannello sbagliato");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
// quando il mouse è in drag scorre il ciclo for fino alla dimensione del negozio del pannello superiore e controlla se il bottone del negozio contiene il mouse e se i soldi del giocatore sono maggiori o al massimo uguali al costo della torretta contenuta dal bottone del negozio
 // se la condizione risulta verificata setta il drag uguale alla variabile i-esima del for per poi settare la x e la y della torretta i-esima del negozio   
    @Override
    public void mouseDragged(MouseEvent e) {

        for (int i = 0; i < 8; i++) {
            if (i < panel.getTortipo().length) {
                if (sPanel.getNegozio().getBottone()[i].contains(sPanel.getTopo()) && giocatore.getSoldi() >= panel.getTortipo()[i].getCostoAcquisto()) {
                    panel.setDrag(i);
                    panel.getTortipo()[i].x=(e.getX() - 20);
                    panel.getTortipo()[i].y=(e.getY() - 60);
                }
            }
        }
    }
// crea un nuovo punto del mouse e lo assegna alla variabile "topo del pannello superiore"
    @Override
    public void mouseMoved(MouseEvent e) {
        sPanel.setTopo(new Point((e.getX()), e.getY()));
    }
}
