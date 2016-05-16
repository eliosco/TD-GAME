/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import ambiente.Griglia;
import ambiente.Piastrella;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Salvato {

    /**
     * Metodo caricaSalvato. Setta le piastrelle della griglia in base al File dato in input
     * @param caricaPercorso Percorso che contiene i valori per settare il terreno della griglia
     * @param griglia che rappresenterà la mappa.
     */
    public void caricaSalvato(File caricaPercorso, Griglia griglia) {
        
        try (Scanner caricaScanner = new Scanner(caricaPercorso) // caricaPercorso viene considerato pubblico
                ) {
            while (caricaScanner.hasNext()) {
                for (Piastrella[] piastrella : griglia.getPiastrella()) {
                    for (int j = 0; j < griglia.getPiastrella()[0].length; j++) {
                        piastrella[j].setTerrenoId(caricaScanner.nextInt());
                    }
                }

                for (Piastrella[] piastrella : griglia.getPiastrella()) {
                    for (int j = 0; j < griglia.getPiastrella()[0].length; j++) {
                        piastrella[j].setAriaId(caricaScanner.nextInt());
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
     
}
