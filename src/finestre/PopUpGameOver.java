/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre;

import ascoltatori.AscoltatoreDiEventiGameOver;
import javax.swing.*;
import static utilities.TDGAME.finestra;

/**
 *
 * @author Luca
 */
public class PopUpGameOver extends JOptionPane {

    private JButton ricomincia, chiudi, fine;

    /**
     *
     */
    public static JOptionPane popUp;
    private AscoltatoreDiEventiGameOver ricevitoreSi, ricevitoreNo, ricevitoreF;

    /**
     *costruttore della classe che crea i bottoni e gli ascoltatori di eventi per poi assegnarli ai relativi bottoni
     */
    public PopUpGameOver() {
        ricomincia = new JButton("ricomincia");
        chiudi = new JButton("chiudi");
        fine = new JButton("fine");
        ricevitoreSi = new AscoltatoreDiEventiGameOver(ricomincia);
        ricevitoreNo = new AscoltatoreDiEventiGameOver(chiudi);
        ricevitoreF = new AscoltatoreDiEventiGameOver(fine);
        ricomincia.addActionListener(ricevitoreSi);
        chiudi.addActionListener(ricevitoreNo);
        fine.addActionListener(ricevitoreF);
        popUp = new JOptionPane(); // crea un oggetto di tipo JOptionePane cioè un oggetto pop-up cioè una finestra di dialogo standard che richiede agli utenti un valore o li informa di qualcosa . 

    }

    /**
     * metodo che gestisce il pop up secondo in caso di sconfitta
     */
    public void HaiPerso() {
        Object[] options = {ricomincia, chiudi}; // vettore di oggetti , un oggeto object appartiene alla classe Object che è la radice della gerarchia delle classi

        popUp.showOptionDialog(finestra, "Hai perso... che nabbo dimmerda", "I MOB SONO OP",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options,
                options[0]);
    }

    /**
     *metodo che gestisce il pop up in caso di vittoria
     */
    public void HaiVinto() {

        Object[] options = {ricomincia, chiudi, fine};

        popUp.showOptionDialog(finestra, "Hai vinto... bravo al niubbeto", "I MOB ERANO SCARSI",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options,
                options[0]);
    }
}
