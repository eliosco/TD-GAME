/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import java.io.*;
import java.util.Scanner;
import utilities.Posizione;

/**
 * questa classe definisce una matrice di interi che servirà per rappresentare un percorso e la posizione di partenza di questo percorso
 * @author User
 */
public class Mappa {

    private Posizione partenza;
    private final int[][] matricePercorso;

    /**
     *
     * @return partenza
     */
    public Posizione getPartenza() {
        return partenza;
    }

    /**
     *
     * @return matricePercorso
     */
    public int[][] getMatricePercorso() {
        return matricePercorso;
    }
    
    /**
     * costruttore della classe che costruisce la matrice con le dimensione date come parametri di ingresso
     * @param larghezza
     * @param altezza
     */
    public Mappa(int larghezza,int altezza){
        this.matricePercorso = new int[altezza][larghezza];
 
    }
    
    /**
     * questo metodo prende come parametro di ingresso un oggetto di tipo File, crea un oggetto di tipo Scanner che scansiona il file passato come parametro e assegna i valori del file rilevati agli elementi della matrice percorso uno alla volta, se un valore rilevato è uguale a 2 crea una posizione di partenza;
     * in questo metodo vengono gestite le eccezioni nel caso di mancato funzionamento di qualche operazione stampando in output sulla console una stringa
     * @param cPercorso
     */
    public void percorso(File cPercorso){
        try(Scanner caricaScanner = new Scanner(cPercorso)) {
            int temp;
            
            while(caricaScanner.hasNext())
            {
                for(int i=0; i < matricePercorso.length; i++)
                {
                    for(int j=0; j< matricePercorso[0].length;j++)
                    {
                        temp=caricaScanner.nextInt();

                        matricePercorso[i][j]=temp;

                        if (temp==2)
                        {
                           partenza= new Posizione(i,j);
                        }
                    }
                }
            }
        } 
        catch(Exception e)
        {
            System.out.println("ciao c'è qualquadra che non cosa");
        }       
    }   
}

                   
