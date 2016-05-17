/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascoltatori;

/**
 *
 * @author User
 */
import java.awt.event.*;
import javax.swing.*;
import static finestre.Finestra.*;

/**
 * classe che implementa l'interfaccia ActionListener per poter consentire alla classe di interagire a delle azioni con degli eventi
 * @author User
 */
public class AscoltatoreDiEventiInferiore implements ActionListener {

    private JButton b;
    private String stringBot;

    private JLabel l;

    private boolean primoclick = false;//attributo che ci consente di capire se è l'elemento è stato cliccato per la prima volta
    private boolean primaondata=true;

    /**
     *costruttore della classe che prende come parametri un JButton e una JLabel che verranno assegnate agli attributi definiti della classe
     * @param button
     * @param label
     */
    public AscoltatoreDiEventiInferiore(JButton button, JLabel label) {
        super();
        b = button;
        stringBot = b.getText();
        l = label;
        
    }
    // deve farsi dare come parametro la Jlabel su 
    // cui dovrà andare ad agire 
// metodo che gestisce gli eventi in base all'azione dell'utente, in base al testo del bottone di ingresso si eseguiranno diverse operazioni
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (stringBot) {
            case "READY": {
                panel.setReady(true);
                if (primoclick) {
                    iPanel.getBarraProgresso().setValue(99);//porta il valore della barra di progresso del pannello inferiore al valore 99 su 100
                    
                   
                   
                }
                if(primaondata){//caso in cui si tratta della prima ondata
                     iPanel.setOndManc(iPanel.getOndManc()-1); // decrementa il contatore delle ondate mancanti 
                     primaondata=false;
                      iPanel.getOndateMancanti().setText("Mancano "+ (iPanel.getOndManc())+ " ondate");//setta il testo della stringa OndateMancanti del pannello inferiore col valore dato come parametro
                }
               
               
                 
                iPanel.getReady().setVisible(false);//rende invisibile il tasto ready
                primoclick = true;
                panel.setProg(true);//setta a true la variabile "prog" di pannello, quindi rende possibile il progresso della barra

                break;
            }
            case "lento": {
                try {
                    panel.setTempobarra(270);
                    l.setText("lento");
                    System.out.println("LENTO UN BEL Pò");
                } catch (Exception ex) {
                    System.out.println("non funge");
                }
                break;
            }
            case "normale": {
                panel.setTempobarra(130);
                l.setText("normale");
                System.out.println("normale UN BEL Pò");
                break;
            }
            case "veloce": {
                panel.setTempobarra(60);
                l.setText("veloce");
                System.out.println("Veloce UN BEL Pò");
                break;
            }
            default:
                System.out.println("NADA");
        }
    }
}
