/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import finestre.FinestraIniziale;
import finestre.Finestra;
import java.io.IOException;

/**
 *
 * @author User
 */

/* Classe che contiene il metodo principale, si occupa dell'avvio dell'"applicazione" */
public class TDGAME {
/* dichiarazioni delle variabili pubbliche principali */

    /**
     *  Dichiarazione Oggetto di tipo finestra.
     *  Finestra dove sarà gestito il cuore dell'applicazione
     */

    public static Finestra finestra; 

    /**
     * Dichiarazione oggetto di tipo FinestraIniziale.
     * Finestra che apparirà all'inizio dell'applicazione
     */
    public static FinestraIniziale finestraIn;

    /**
     * Dichiarazione oggetto di tipo ConnessioneDB.
     * Oggetto che permette e gestisce la connessione al database.
     */
    public static ConnessioneDB connessione;

    /* metodo principale */

    /**
     * Metodo principale dell'applicazione.
     * @param args
     * @throws IOException
     */

    public static void main(String args[]) throws IOException {  /*il metodo principale gestisce eccezioni di tipo I/O. */
        connessione = new ConnessioneDB();   /* creazione connessione database*/
        finestraIn = new FinestraIniziale(); /* creazione finestra iniziale */

    }

}
