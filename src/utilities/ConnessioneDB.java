/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.*;

/**
 *
 * @author User
 * prova merge da netbeans!!!
 * aidnfoadnfpa
 */
public class ConnessioneDB {
    
    private Connection con;  //oggetto che permette la connessione ad un database in grado di fornire le info che descrivono le tabelle eil linguaggio SQL
    private Statement st;  //oggetto utilizzato per l'esecuzione di un istruzione in SQL statica e per la restituione dei risultati che produce
    private PreparedStatement pst; //oggetto che rappresenta un istruzione SQL precompilata
    private ResultSet rs; //oggetto che punta alla riga dei dati, inizia dalla prima riga
    private int i = 0; //contatore ciclo per la posizione
    private String[] classifica; // testo per la classifica

    //procedura di base per la connessione al DataBase

    /**
     * Costruttore della classe.
     * Si occupa del caricamento del driver per la connessione al DataBase.
     * provagit
     */
    public ConnessioneDB() {

        try {
            //driver per far connettere java al Database, che implementa l'interfaccia java.sql.Driver.
            Class.forName("com.mysql.jdbc.Driver"); // nome della classe implementata è com.mysql.jdbc.Driver, questo metodo ci consente di utilizare tutti i parametri e le caratterische del driver per la connessione al database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/towerdefense", "root", "");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(" Errore: " + ex);
        }
    }

    /**
     * Ordina i dati della tabella e la manda in output come classifica dei primi 10.
     * @return Ritorna il vettore di stringhe contenente la classifica ordinata.
     */
    public String[] getData() {
        try {
            classifica = new String[10];
            String query = "Select * from giocatore order by punteggio ASC";
            rs = st.executeQuery(query);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String punteggio = rs.getString("punteggio");

                classifica[i] = ((i+1) + ")  Giocatore:  " + nome + "   -    Punteggio:  " + punteggio);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return (classifica);
    }

    /**
     * Inserisce un dato alla tabella dei giocatori.
     * @param nome
     * @param tempo
     */
    public void aggiungiDato(String nome, String tempo) {

        try {
            // String query="INSERT INTO giocatore (nome,punteggio) VALUES ('mario',00:03:00);";
            pst = con.prepareStatement("INSERT INTO giocatore (nome,punteggio) VALUES ('" + nome + "','" + tempo + "');");
            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
