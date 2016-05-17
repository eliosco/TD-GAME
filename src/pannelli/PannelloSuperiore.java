/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannelli;

import ascoltatori.AscoltatoreDiEventiTorretta;
import ascoltatori.AscoltatoreDiEventiSuperiore;
import attori.Giocatore;
import attori.Torretta;

import java.awt.*;
import javax.swing.*;
import ambiente.Negozio;
import static finestre.Finestra.giocatore;
import static finestre.Finestra.sPanel;

/**
 * classe che estende la classe JPanel di Java e implementa l'interfaccia Runnable (L'interfaccia Runnable deve essere implementato da ogni classe le cui istanze sono destinate ad essere eseguite da un thread. La classe deve definire un metodo run .)
 * @author User
 */
public class PannelloSuperiore extends JPanel implements Runnable {

    private JLabel costoTorretta, livello, danno, velocità; // label del pannello
    private JButton upGrade, vendi;//bottoni del pannello
    //ascoltatori del pannello
    private AscoltatoreDiEventiSuperiore ricevitore;
    private AscoltatoreDiEventiTorretta ricevitoreU, ricevitoreV;
    private Torretta torrettaSelezionata;
    private final Thread threadTop; // thread del pannello
    private Negozio negozio;
    //creazione degli oggetti risorse di tipo vettore di Immagini
    private Image[] setTipo_ris = new Image[100];
    private Image[] setTipo_tor = new Image[100];


//di seguito tutti i metodi get e set degli attributi della classe
    /**
     *
     * @return upGrade di tipo JButton
     */
    public JButton getUpGrade() {
        return upGrade;
    }

    /**
     *
     * @param upGrade
     */
    public void setUpGrade(JButton upGrade) {
        this.upGrade = upGrade;
    }

    /**
     *
     * @return vendi di tipo JButton
     */
    public JButton getVendi() {
        return vendi;
    }

    /**
     *
     * @param vendi
     */
    public void setVendi(JButton vendi) {
        this.vendi = vendi;
    }
  

    /**
     *
     * @return
     */
    public Torretta getTorrettaSelezionata() {
        return torrettaSelezionata;
    }

    /**
     *
     * @param torrettaSelezionata
     */
    public void setTorrettaSelezionata(Torretta torrettaSelezionata) {
        this.torrettaSelezionata = torrettaSelezionata;

    }
   

    /**
     *
     * @return
     */
    public Image[] getSetTipo_tor() {
        return setTipo_tor;
    }

    /**
     *
     * @param setTipo_tor
     */
    public void setSetTipo_tor(Image[] setTipo_tor) {
        this.setTipo_tor = setTipo_tor;
    }

    /**
     *
     * @return
     */
    public AscoltatoreDiEventiSuperiore getRicevitore() {
        return ricevitore;
    }

    /**
     *
     * @param ricevitore
     */
    public void setRicevitore(AscoltatoreDiEventiSuperiore ricevitore) {
        this.ricevitore = ricevitore;
    }

    /**
     *
     * @return
     */
    public AscoltatoreDiEventiTorretta getRicevitoreU() {
        return ricevitoreU;
    }

    /**
     *
     * @param ricevitoreU
     */
    public void setRicevitoreU(AscoltatoreDiEventiTorretta ricevitoreU) {
        this.ricevitoreU = ricevitoreU;
    }

    /**
     *
     * @return
     */
    public AscoltatoreDiEventiTorretta getRicevitoreV() {
        return ricevitoreV;
    }

    /**
     *
     * @param ricevitoreV
     */
    public void setRicevitoreV(AscoltatoreDiEventiTorretta ricevitoreV) {
        this.ricevitoreV = ricevitoreV;
    }

    /**
     *
     * @return
     */
    public JLabel getCostoTorretta() {
        return costoTorretta;
    }

    /**
     *
     * @param costoTorretta
     */
    public void setCostoTorretta(JLabel costoTorretta) {
        this.costoTorretta = costoTorretta;
    }

    /**
     *
     * @return
     */
    public JLabel getLivello() {
        return livello;
    }

    /**
     *
     * @param livello
     */
    public void setLivello(JLabel livello) {
        this.livello = livello;
    }

    /**
     *
     * @return
     */
    public JLabel getDanno() {
        return danno;
    }

    /**
     *
     * @param danno
     */
    public void setDanno(JLabel danno) {
        this.danno = danno;
    }

    /**
     *
     * @return
     */
    public JLabel getVelocità() {
        return velocità;
    }

    /**
     *
     * @param velocità
     */
    public void setVelocità(JLabel velocità) {
        this.velocità = velocità;
    }

    private boolean primoControl;

    /**
     *
     * @return
     */
    public Negozio getNegozio() {
        return negozio;
    }

    /**
     *
     * @param negozio
     */
    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    /**
     *
     * @return
     */
    public Image[] getSetTipo_ris() {
        return setTipo_ris;
    }

    /**
     *
     * @param setTipo_ris
     */
    public void setSetTipo_ris(Image[] setTipo_ris) {
        this.setTipo_ris = setTipo_ris;
    }
    private Point topo = new Point(0, 0);

    /**
     *
     * @return
     */
    public Point getTopo() {
        return topo;
    }

    /**
     *
     * @param topo
     */
    public void setTopo(Point topo) {
        this.topo = topo;
    }

    /**
     * costruttore della classe che eredita attributi e metodi della super classe, crea il thread da eseguire e costruisce tutti gli oggetti utili al pannello superiore
     * @param giocatore
     */
    public PannelloSuperiore(Giocatore giocatore) {
        super();
        primoControl = true;
        threadTop = new Thread(this);

        velocità = new JLabel("velocità attacco torretta :");
        danno = new JLabel("danno torretta: ");
        costoTorretta = new JLabel("costo torretta: ");
        livello = new JLabel("livello torretta: ");
        upGrade = new JButton("UPGRADE");
        vendi = new JButton("VENDI");
        ricevitore = new AscoltatoreDiEventiSuperiore();
        ricevitoreU = new AscoltatoreDiEventiTorretta(upGrade);
        ricevitoreV = new AscoltatoreDiEventiTorretta(vendi);

        setPreferredSize(new Dimension(800, 40));//dimensiona il pannello superiore

        threadTop.start();//fa partire il thread
    }

    /**
     *metodo che crea l'oggetto negozio e le diverse immagini delle risorse
     */
    public void definisci() {
        negozio = new Negozio();

        setTipo_ris[0] = new ImageIcon("risorse/cella.png").getImage();
        setTipo_ris[1] = new ImageIcon("risorse/cellaUp.png").getImage();
        setTipo_ris[2] = new ImageIcon("risorse/cellaDown.png").getImage();
        setTipo_tor[0] = new ImageIcon("risorse/laser.png").getImage();
        setTipo_tor[1] = new ImageIcon("risorse/laser1.png").getImage();
     //aggiunta degli ascoltatori del mouse al pannello superiore
        addMouseListener(ricevitore);
        addMouseMotionListener(ricevitore);
 //aggiunta delle componenti grafiche al pannello superiore
        add(livello);
        add(costoTorretta);
        add(velocità);
        add(danno);
        add(upGrade);
        add(vendi);
  //aggiunta degli ascoltatori 
        upGrade.addActionListener(ricevitoreU);
        vendi.addActionListener(ricevitoreV);
        //invisibilità dei bottoni seguenti
        upGrade.setVisible(false);
        vendi.setVisible(false);
    }

//metodo che si occupa della definizione del pannello  se è stato esuito il primo accesso e del disegno del negozio passando i parametri necessari
    @Override
    public void paintComponent(Graphics g) {
        if (primoControl) {
            definisci();
            primoControl = false;
        }
        g.clearRect(0, 0, getWidth(), getHeight());
        negozio.disegna(g, getTopo(), getSetTipo_ris(), getSetTipo_tor());
    }
//metodo obbligatorio dell'interfaccia Runnable che si occupa dell'esecuzione del thread
    @Override
    public void run() {

        while (true) {

            if (!primoControl) {

                repaint();
            }//il metodo repaint esegue la chiamata al metodo update()(che cancella la parte di schermo dedicata all'applicazione dipingendo tutto con il colore di sfondo causando un possibile sfarfallio nelle animazioni) poi di conseguenza al metodo paint() al termine delle operazione di preparazione dell'immagine(il metodo paint() è un metodo chiamato automaticamente da Java tutte le volte che risulta necessario aggiornare la zona del video dedicata all'applicazione).
            try {
                threadTop.sleep(1);//Thread.sleep fa sì che il thread corrente sospenda l'esecuzione per un periodo determinato . Si tratta di uno strumento efficace per dare tempo al processore per gestire altri thread di un'applicazione o di altre applicazioni che potrebbero essere in esecuzione su un sistema informatico .
            } catch (Exception e) {
            }
        }
    }

    /**
     *metodo che presi come parametri di ingresso le caratteristiche di una torretta aggiorna le carratteristiche obsolete di quest'ultima gestendo la visualizzazione dei tasti della torretta stessa
     * @param liv
     * @param costo
     * @param vel
     * @param dan
     */
    public void caratteristicheTor(int liv, int costo, int vel, int dan) {

        velocità.setText("velocità attacco torretta :" + vel);
        danno.setText("danno torretta: " + dan);
        livello.setText("livello torretta: " + liv);
        costoTorretta.setText("costo torretta: " + costo);

        vendi.setVisible(true);
if(giocatore.getSoldi()>=sPanel.getTorrettaSelezionata().getCostoUpgrade() && liv==0)
        upGrade.setVisible(true);
        else upGrade.setVisible(false);
    }

    /**
     *metodo che non avendo parametri di ingresso viene attivato quando non viene cliccata alcuna torrete cosicchè non vengono visualizzate le caratteristiche
     */
    public void caratteristicheTor() {

        velocità.setText("velocità attacco torretta :");
        danno.setText("danno torretta: ");
        livello.setText("livello torretta: ");
        costoTorretta.setText("costo torretta: ");

        upGrade.setVisible(false);
        vendi.setVisible(false);
    }

    
}
