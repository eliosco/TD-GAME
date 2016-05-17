/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

import java.awt.*;
import utilities.*;
import static finestre.Finestra.*;

/**
 * prova modifica
 * @author User
 */
public class Mob extends Rectangle{ //la classe Mob estende la classe Rectangle ereditando metodi e attributi

    private Posizione posizione, lastPos;// oggetti utilizzati per salvare le coordinate del mob sulla mappa
    private int id, salute, guadagno, velocità, velocitaframe;// variabili caratteristiche del mob apparte "velocitaframe" che viene utilizzata come delay nel movimento del mob
    private boolean primaVolta, uP, ingioco, nelrange, morto;// booleani necessari per i vari controlli nei metodi di mob
    private Image immagine;// oggetto che contiene l'immagine del mob
    private boolean[][] pos;// una matrice di booleani necessaria per il controllo della posizione durante il movimento del mob
    private boolean rallentato;// booleano che viene settato da una torretta caratteristica che appunto rallenta il mob
    private long tempoRallentato;// stabilisce il tempo di durata del rallentamento
    private int debuffVelocità;// stabilisce la "quantità" di rallentamento 

    /**
     *Metodo che restituisce il valore di rallentato.
     * 
     * @return true or false se è rallentato o meno
     */
    public boolean isRallentato() {
        return rallentato;
    }

    /**
     *Metodo per settare il boleano "rallentato".
     * @param rallentato
     */
    public void setRallentato(boolean rallentato) {
        this.rallentato = rallentato;
    }

    private final int dimPiastrella;// è la dimensione fissa del mob, ovvero la dimensione costante di ogni singola piastrella della mappa

    /**
     *Metodo che restituisce il valore di "nelrange".
     * @return true or false se è o non è nel range 
     */
    public boolean isNelrange() {
        return nelrange;
    }

    /**
     *Metodo utilizzato per settare il valore di "nelrange".
     * Viene utilizzato per determinare se il mob è all'interno di qualche range di attacco di qualunque torretta.
     * 
     * @param nelrange
     */
    public void setNelrange(boolean nelrange) {
        this.nelrange = nelrange;
    }

    /**
     *Metodo utilizzato per settare il valore di "ingioco".
     *Viene utilizzato per determinare se il mob è entrato in gioco.
     * @param ingioco
     */
    public void setIngioco(boolean ingioco) {
        this.ingioco = ingioco;
    }

    /**
     *Metodo che determina la "morte" del mob.
     *Viene utilizzato nel momento in cui il mob non ha più punti vita o ha raggiunto la casella finale.
     * @param morto
     */
    public void setMorto(boolean morto) {
        this.morto = morto;
        panel.setMobUccisi(panel.getMobUccisi() + 1);// contatore utilizzato per determinare il numero di mob uccisi e per stabilire l'eventuale vittoria o sconfitta del giocatore

    }



    /**
     *Metodo costruttore della classe mob.
     * @param posizione
     * @param velocità
     * @param id
     * @param salute
     * @param guadagno
     * @param dimPiastrella
     * @param immagine
     */
    public Mob(Posizione posizione, int velocità, int id, int salute, int guadagno, int dimPiastrella, Image immagine) {
        this.ingioco = false;

        this.id = id;
        this.immagine= immagine;

        this.dimPiastrella = dimPiastrella;

        this.posizione = posizione;

        this.velocità = velocità;
        this.salute = salute;
        this.guadagno = guadagno;
        y = this.posizione.getXPlace();
        x = this.posizione.getYPlace();
        nelrange = false;
        rallentato=false;
        velocitaframe = 0;
        tempoRallentato=0;
        debuffVelocità=0;

        lastPos = new Posizione(x, y);
        primaVolta = true;
        pos = new boolean[13][20];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 20; j++) {

                pos[i][j] = false;
            }
        }
    }

    /**
     *Metodo che restituisce il valore di "debuffVelocità".
     * @return
     */
    public int getDebuffVelocità() {
        return debuffVelocità;
    }

    /**
     *Metodo che effettua il set di "debuffVelocità".
     * @param debuffVelocità
     */
    public void setDebuffVelocità(int debuffVelocità) {
        this.debuffVelocità = debuffVelocità;
    }

    /**
     *Metodo che restituisce il valore di "tempoRallentato".
     * @return
     */
    public long getTempoRallentato() {
        return tempoRallentato;
    }

    /**
     *Metodo che effettua il set di "tempoRallentato".
     * @param tempoRallentato
     */
    public void setTempoRallentato(long tempoRallentato) {
        this.tempoRallentato = tempoRallentato;
    }

 

    /**
     *Metodo che modifica dimensione e posizione del mob dichiarando che il mob è in gioco grazie alla variabile ingioco.
     */

    public void spawn() {

        setBounds(x, y, 40, 40);

        ingioco = true;
        morto = false;
        nelrange = false;

    }

   

    /**
     *Metodo che si occupa di disegnare il mob grazie al metodo drawImage. 
     * @param g
     */
 
    public void disegna(Graphics g) {

        g.drawImage(immagine, x, y, dimPiastrella, dimPiastrella, null);
        g.setColor(Color.red);
        g.fillRect(x, y-2, salute/2, 4);
        

    }

    /**
     *Metodo che restituisce l'oggetto "posizione".
     * @return
     */
    public Posizione getPosizione() {
        return posizione;
    }

    /**
     *Metodo che restituisce il valore della variabile "ingioco".
     * @return
     */
    public boolean isIngioco() {
        return ingioco;
    }

    /**
     *Metodo che restituisce il valore della variabile "morto".
     * @return
     */
    public boolean isMorto() {
        return morto;
    }

    /**
     *Metodo utilizzato per il set dell'oggetto "posizione".
     * @param posizione
     */
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    /**
     *Metodo che restituisce il valore della variabile "id".
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *Metodo utilizzato per il set della variabile "id".
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *Metodo che restituisce il valore della variabile "velocità".
     * @return
     */
    public int getVelocità() {
        return velocità;
    }

    /**
     *Metodo utilizzato per il set della variabile "velocità".
     * @param velocità
     */
    public void setVelocità(int velocità) {
        this.velocità = velocità;
    }

    /**
     *Metodo che restituisce il valore della variabile "salute".
     * @return
     */
    public int getSalute() {
        return salute;
    }

    /**
     *Metodo utilizzato per il set della variabile "salute".
     * @param salute
     */
    public void setSalute(int salute) {
        this.salute = salute;
    }

    /**
     *Metodo che restituisce il valore della variabile "guadagno".
     * @return
     */
    public int getGuadagno() {
        return guadagno;
    }

    /**
     *Metodo utilizzato per il set della variabile "guadagno".
     * @param guadagno
     */
    public void setGuadagno(int guadagno) {
        this.guadagno = guadagno;
    }

    /**
     *Metodo che effettua delle modifiche ai valori di determinate variabili di giocatore e incrementa il contatore dei mob "morti".
     * Viene richiamata nel momento in cul mob raggiunge l'ultima posizione che determina la perdita di "punti vita" del giocatore.
     */
    public void togliVita() {

        giocatore.setVita(giocatore.getVita() - 10);
        iPanel.update(giocatore);
        panel.setMobUccisi(panel.getMobUccisi() + 1);

    }

   

    /**
     *Metodo utilizzato per effettuare il movimento del mob. 
     * Attraverso una serie di controlli l'algoritmo stabilisce la posizione successiva nella quale il mob può muoversi.
     * @param mappa
     */
    
    public void avanzamento(int[][] mappa) {
        if (velocitaframe >= velocità) {
            if (mappa[y / 40 + 1][x / 40] == 3 || mappa[y / 40][x / 40 + 1] == 3) {// controllo della posizione finale
                togliVita();
                this.ingioco = false;
                this.morto = true;
            } else if (primaVolta) {// controlla se è la prima volta che il mob cerca di muoversi

                tiMuovi(mappa);
                primaVolta = false;

            } else if (x % 40 == 0 && y % 40 == 0) {// controlla se il resto della divisione tra le variabili e la costanti della dimensione della casella è pari a 0. Se è così effettua ulteriori controlli per determinare la direzione corretta.
                if (uP == true) {// significa che il mob può andare verso l'alto
                    pos[(lastPos.getY() / 40) + 1][(lastPos.getX() / 40)] = true;//setta la posizione precedente a true ovvero significa che il mob è gia passato da quella posizione e non può tornarci.

                    tiMuovi(mappa);
                } else {
                    pos[(lastPos.getY() / 40)][(lastPos.getX() / 40)] = true;
                    tiMuovi(mappa);
                }
                
            } else if (x % 40 != 0 || y % 40 != 0) {// almeno una delle due divisioni ha resto diverso da 0.
                tiMuovi(mappa);
            }
            velocitaframe = 0;

        } else {
            velocitaframe += 1;
        }
    }

    /**
     * Metodo che effettua controlli e modifica le variabili della posizione del mob ovvero x e y.
     * Attraverso una serie di controlli sulla mappa e sulla posizione del mob l'algoritmo decide quale variabile viene modificata affinchè il mob si possa muovere nella posizione corretta.
     * @param mappa
     */
    public void tiMuovi(int[][] mappa) {
        int xM, yM;// sono respettivamente la x e la y che verrano utilizzate all'interno di mappa. ATTENZIONE : la xM di mappa corrisponde alla y di mob e la yM di mappa corrisponde alla x di mob.
        xM = (int) y / 40;
        yM = (int) x / 40;

        if (xM != 0 && mappa[xM][yM] == 1 && pos[xM - 1][yM] == false) {

            uP = true;
            lastPos.setY(y);
            lastPos.setX(x);
            y -= 1;
        } else if (mappa[xM][yM + 1] == 1 && pos[xM][yM + 1] == false) {
            uP = false;
            lastPos.setY(y);
            lastPos.setX(x);

            x += 1;
        } else if (mappa[xM + 1][yM] == 1 && pos[xM + 1][yM] == false) {
            uP = false;
            lastPos.setY(y);
            lastPos.setX(x);
            y += 1;

        } else if (mappa[xM][yM - 1] == 1 && pos[xM][yM - 1] == false) {
            uP = false;
            lastPos.setY(y);
            lastPos.setX(x);
            x -= 1;
        }
    }

    /**
     *Metodo utilizzato al momento della "morte" del mob.
     *Vengono modificati dei valori delle variabili di giocatore e in più vengono settati alcuni valori di mob per definire la sua "morte".
     */
    public void morte() {
        if (getSalute() <= 0) {
            giocatore.setSoldi(giocatore.getSoldi() + guadagno);

            iPanel.update(giocatore);

            setIngioco(false);
            if (morto == false) {
                setMorto(true);
            }
        }
    }
}
