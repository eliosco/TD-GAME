/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascoltatori;

import finestre.*;
import java.awt.event.*;
import javax.swing.*;
import static finestre.Finestra.*;
import java.io.IOException;
import utilities.ConnessioneDB;

import static utilities.TDGAME.*;

/**
 * classe che implementa l'interfaccia  ActionListener  che consente di far ricevere eventi azione alla classe
 * @author User
 */
public class AscoltatoreDiEventiGameOver implements ActionListener {

    private JButton b;
    private String stringBot;

    /**
     *costruttore che prende come parametro un JButton e lo assegna alla variabile b della classe per poi estrapolarne il testo che lo raffigura
     * @param button
     */
    public AscoltatoreDiEventiGameOver(JButton button) {
        super();
        b = button;
        stringBot = b.getText();
    }
// in base alla stringa estrapolata dal bottone l'ascoltatore attiverà un evento che in questo determinerà la chiusura o il restart dell'app, nel caso in cui si decide di finire la partita apparirà un pop up dove bisognerà scrivere il proprio nome che verrà aggiunto in seguito al database che contiene la classifica
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (stringBot) {
            case "ricomincia": {

                finestra.dispose();

                finestra = new Finestra();

                break;
            }

            case "chiudi": {
                System.exit(0);
                break;
            }
            case "fine": {

                String nome;

                nome = JOptionPane.showInputDialog(finestra, "Come ti chiami?", "Nome", JOptionPane.QUESTION_MESSAGE);

                String output = "Hai scritto: \"" + nome;
                JOptionPane.showMessageDialog(finestra, output);
                connessione.aggiungiDato(nome, s);
                finestra.dispose();
                finestraIn.dispose();
                

            try {connessione=new ConnessioneDB();
                finestraIn = new FinestraIniziale();
            } catch (IOException ex) {
                System.out.println(ex+" non carica");
            }
                break;
            }
            default:
                System.out.println("NADA");
        }
    }
}
