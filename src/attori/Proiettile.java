/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attori;

import static finestre.Finestra.panel;
import java.awt.*;

/**
 *Classe Proiettile utilizzata per la costruzione di un entità che determina il concetto di attacco delle torrette.
 * @author User
 */
public class Proiettile extends Rectangle {

    private boolean colpito, sparato;// Booleani necessari per alcuni controlli determinano se il proiettile ha colpito il mob e se il proiettile è stato sparato.
    private int velocitaproiettile, velocitaframe, attacco; // determinano respettivamente la velocità di spostamento del proiettile, il tempo di delay dello spawn e il valore del danno che apporta al mob.
    private Mob bersaglio;// determina il mob verso cui il proiettile si deve muovere.
    private Torretta tor;// indica la torretta dalla quale il proiettile viene generato.

    /**
     *Metodo che restituisce il valore della variabile "colpito".
     * @return
     */
    public boolean isColpito() {
        return colpito;
    }

    /**
     *Metodo che restituisce il valore della variabile "sparato".
     * @return
     */
    public boolean isSparato() {
        return sparato;
    }

    /**
     *Metodo utilizzato per il set della variabile "sparato".
     * @param sparato
     */
    public void setSparato(boolean sparato) {
        this.sparato = sparato;
    }

    
    /**
     *Metodo costruttore della classe Proiettile
     * @param bersaglio
     * @param x
     * @param y
     * @param attacco
     * @param t
     */
    public Proiettile(Mob bersaglio, int x, int y, int attacco,Torretta t) {
        this.x = x + 20;// il +20 serve per centrare il punto di spawn del proiettile al centro della cella che contiene la torretta.
        this.y = y + 20;
        tor=t;
        this.attacco = attacco;
        this.bersaglio = bersaglio;
        velocitaproiettile = 2;
        spawn();// chiamata al metodo spawn().

    }

    /**
     *Metodo che modifica dimensione e posizione del proiettile dichiarando che il proiettile è stato sparato grazie alla variabile "sparato" e setta la variabile "colpito" a false.
     */
    public void spawn() {

        setBounds(x, y, 10, 10);

        sparato = true;
        colpito = false;
    }

    /**
     *Metodo utilizzato per il movimento del proiettile. L'algoritmo attraverso una serie di controlli tra 4 variabili determina il nuovo valore delle coordinate del proiettile.
     */
    public void calcolaDirezione() {

        double xPi = x;// coordinata x del proiettile.
        double yPi = y;// coordinata y del proiettile.
        double yPf = bersaglio.getY() + 20;// coordinata y del bersaglio (il +20 è necessario per farlo arrivare al centro della cella che contiene il mob).
        double xPf = bersaglio.getX() + 20;// coordinata x del bersaglio.
        if (velocitaframe >= (velocitaproiettile*panel.getTorrette().size())) {// il delay del calcolo della direzione varia a variare del numero delle torrette piazzate sulla mappa.

            if (xPi == xPf && yPi == yPf && this.colpito == false) {// controllo che verifica se ha raggionto il bersaglio.

                this.colpito = true;
                tor.colpisci(bersaglio);// chiamata al metodo colpisci  di torretta.

            } else if (xPi > xPf && yPi < yPf) {
                x -= 1;
                y += 1;

            } else if (xPi > xPf && yPi > yPf) {
                x -= 1;
                y -= 1;

            } else if (xPi < xPf && yPi < yPf) {
                x += 1;
                y += 1;

            } else if (xPi < xPf && yPi > yPf) {    

                x += 1;
                y -= 1;

            } else if (xPi == xPf && yPi > yPf) {
                y--;
            } else if (xPi == xPf && yPi < yPf) {
                y++;
            } else if (yPi == yPf && xPi < xPf) {
                x++;
            } else if (yPi == yPf && xPi > xPf) {
                x--;
            }
            velocitaframe = 0;
        } else {
            velocitaframe += 1;
        }
    }

    /**
     *Metodo utilizzato per disegnare l'immagine del proiettile. Viene diversificata in base alle caratteristiche delle torrette.
     * @param g
     */
    public void disegna(Graphics g) {
        
        switch(tor.getTipo()){
            case 'a':{
        g.setColor(Color.red);
        g.fillOval(x, y, 8, 8);
        g.setColor(Color.GREEN);
        g.drawOval(x, y, 8, 8); break;}
        
            case 'b': {g.setColor(Color.blue);
        g.fillOval(x, y, 8, 8);
        g.setColor(Color.white);
        g.drawOval(x, y, 8, 8); break;}
        
        default:{
        g.setColor(Color.black);
        g.fillOval(x, y, 8, 8);
        g.setColor(Color.GREEN);
        g.drawOval(x, y, 8, 8); break;}
            
            
            }
        

    }
    

}
