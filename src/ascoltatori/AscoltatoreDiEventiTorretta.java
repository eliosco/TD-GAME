/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascoltatori;

import attori.Torretta;
import java.awt.event.*;
import javax.swing.JButton;
import static finestre.Finestra.*;

/**
 *Classe per gestire gli eventi delle torrette.
 * @author Giacomo
 */
public class AscoltatoreDiEventiTorretta implements ActionListener, MouseListener, MouseMotionListener {

    private JButton b;
    private String stringaBot;

    /**
     *Metodo costruttore di default della classe.
     */
    public AscoltatoreDiEventiTorretta() {
        super();

    }

    /**
     *Metodo costruttore con passaggio del parametro bottone.
     * @param bottone
     */
    public AscoltatoreDiEventiTorretta(JButton bottone) {
        super();
        b = bottone;

        stringaBot = b.getText();// salva in "stringaBot" la stringa contenuta nel bottone.

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (stringaBot) {// switch case in base al valore contenuto in "stringaBot".

            case "UPGRADE": {
                try {
                    sPanel.getTorrettaSelezionata().upgrade();// chiamata la metodo upgrade di torretta.

                   
                } catch (Exception ex) {
                    System.out.println("non funge");
                }
                break;
            }
            case "VENDI": {
                try {
                    panel.getTorrette().remove(sPanel.getTorrettaSelezionata());// rimozione della torretta selezionata dall'arraylist del pannello.
                    sPanel.caratteristicheTor();
                    giocatore.aggiungiSoldi(sPanel.getTorrettaSelezionata().getCostoAcquisto()/ 2);// aggiunge una determinata quantita ai soldi di giocatore grazie alla vendita effettuata.
                    iPanel.update(giocatore);// aggiornamento dell variabili di giocatore.

                    System.out.println("HO VENDUTO");
                } catch (Exception es) {
                    System.out.println("non vende");
                }
                break;
            }
            default:
                System.out.println("SHISH");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        sPanel.caratteristicheTor();
        for (Torretta tor : panel.getTorrette()) {// ciclo che scorre per tutte le torrette dell'arraylist

            if (e.getX() >= tor.getX() && e.getX() <= tor.getX() + 40 && e.getY() >= tor.getY() && e.getY() <= tor.getY() + 40) {// controllo per vedere se nel punto in cui viene cliccato il mouse è presente una torretta.

                sPanel.setTorrettaSelezionata(tor);// se il controllo è andato a buon fine seleziona la torretta.
                if ((sPanel.getTorrettaSelezionata().getLivelloTorretta() == 0)) {// se non è stato effettuato l'upgrade visualizza le caratteristiche della torretta.
                    sPanel.caratteristicheTor(tor.getLivelloTorretta(), tor.getCostoAcquisto(), tor.getVelocitàAttacco(), tor.getAttacco());

                } else {// se è stato effettuato l'upgrade visualizza le caratteristiche della torretta ma toglie la possibilità di effettuare un'ulteriore upgrade togliendo il bottone.
                    sPanel.caratteristicheTor(tor.getLivelloTorretta(), tor.getCostoAcquisto(), tor.getVelocitàAttacco(), tor.getAttacco());
                    sPanel.getUpGrade().setVisible(false);
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
