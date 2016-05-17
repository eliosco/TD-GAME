/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascoltatori;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import static utilities.TDGAME.finestraIn;

/**
 *questa classe implementa le interfacce per gestire gli eventi del mouse
 * @author User
 */
public class AscoltatoreInfo implements MouseListener,ActionListener{
private JOptionPane popup;

    /**
     * con il costruttore viene creato un oggetto JOptionPane che sarebbe una finestra di dialogo o popup
     */
    public AscoltatoreInfo(){
popup=new JOptionPane();
}

 // al click del mouse sarà possibile vedere una finestra popup di tipo testuale
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            popup.showMessageDialog(finestraIn,finestraIn.getTest());
        } catch (Exception ex) {System.out.println(ex+"asdasdas");
            
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
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
