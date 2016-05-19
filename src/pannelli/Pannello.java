package pannelli;

import finestre.*;
import ascoltatori.AscoltatoreDiEventiTorretta;
import attori.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import ambiente.*;
import utilities.Salvato;
import static finestre.Finestra.*;
import static utilities.TDGAME.finestra;

/**
 *classe che contiente la maggior parte delle caratteristiche della nostra applicazione
 * @author User
 */
@SuppressWarnings("serial")
public class Pannello extends JPanel implements Runnable // implements Runnable ci permette di sfruttare i thread e lo facciamo perchè senza i thread ci è impossibile effettuare il rinfresco dello schermo grazie al paint() bloccato dal ciclo infinito presente nel metodo start() che può monopolizzare le risorse del sistema rendendo anche impossibile la sospensione dell'applicazione perchè non si può chiamare il metodo stop(). Quindi l'applicazione deve essere scritte utilizzando i thread(processi) che si occupano di determinate operazioni indipendenti da thread differenti..
{

    /**
     *
     */
    public Thread thread; // definiamo una variabile di istanza che contenga il thread dell'applicazione

    /**
     *vettore di immagini che contiene il terreno
     */
    public static Image[] Tipo_terreno;

    /**
     * vettore di immagini che contiene l'aria
     */
    public static Image[] Tipo_aria;

    /**
     * vettore di immagini che contiene l'acqua
     */
    public static Image[] Tipo_acqua ;

    /**
     *immagine del mob
     */
    public static Image Tipo_mob;

    /**
     *immagine della torretta1
     */
    public static Image Tipo_torr1; 

    /**
     *immagine della torretta2
     */
    public static Image Tipo_torr2 ;
    private volatile boolean running;

   
    private boolean primoControl = true;
    private int a, idmob;
    private PopUpGameOver fine;
     /**
     *forse non servono
     */
    public int myWidth,myHeight;

   
    
    private boolean ready;

    private Griglia griglia;

    private Torretta[] tortipo;
    
    private int contond;
    private int max;
    private int velMob;
    private int vitaMob;
    private int mobMax;
    private int guadagnoMob;
    
    
    private int mobUccisi;
    private boolean prog,fin;

    private int drag;

    private ArrayList<Torretta> torrette;
    private ArrayList<Proiettile> proiettili;
    private ArrayList<Ondata> ond;
    private int[] contTorr;


    private AscoltatoreDiEventiTorretta ricevitoreTor;

    private Salvato save;

    private Mappa map1;
    private Mappa map2;
    private Mappa map3;

    private int tempospawn, finestraspawn, tempobarra, finestrabarra;

    /**
     *costruttore della classe che crea le icone del gioco e fa partire il thread
     * @param finestra principale di gioco
     */
    public Pannello(Finestra finestra) {
        thread = new Thread(this);// definiamo una variabile di istanza che contenga il thread dell'applicazione
    Tipo_terreno = new Image[100];
    Tipo_aria = new Image[100];
    Tipo_acqua = new Image[100];
    Tipo_mob = new ImageIcon("risorse/mob0.png").getImage();
    Tipo_torr1 = new ImageIcon("risorse/laser.png").getImage();
    Tipo_torr2 = new ImageIcon("risorse/laser1.png").getImage();
     ready = false;
     a = 0;
     idmob=1;
     contond = 0;
     max = 4;
     velMob= 12;
     vitaMob=45;
     guadagnoMob=1;
      mobMax = max * 3;

    
      mobUccisi = 0;
      prog = false;

      drag = -1;
      tortipo = new Torretta[2];
        tempospawn = 1200;
        finestraspawn = 0;

        tempobarra = 250;
        finestrabarra = 0;
        fine = new PopUpGameOver();

        ricevitoreTor = new AscoltatoreDiEventiTorretta();
        thread.start(); //inizia l'esecuzione del processo innescando l'invocazione al metodo run() dell'applicazione
    }
    
    /**
     *
     * @return massimo dei mob
     */
    public int getMobMax() {
        return mobMax;
    }

    /**
     *
     * @param mobMax
     */
    public void setMobMax(int mobMax) {
        this.mobMax = mobMax;
    }
    
    /**
     *
     * @return i mob uccisi
     */
    public int getMobUccisi() {
        return mobUccisi;
    }

    /**
     *
     * @param mobUccisi
     */
    public void setMobUccisi(int mobUccisi) {
        this.mobUccisi = mobUccisi;
    }
    
    /**
     *
     * @return un flag che mi serve per capire se il thead si sta eseguendo
     */
    public boolean isRunning() {
        return running;
    }

    /**
     *
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     *
     * @return un vettore di torrette
     */
    public Torretta[] getTortipo() {
        return tortipo;
    }

    /**
     *
     * @param tortipo
     */
    public void setTortipo(Torretta[] tortipo) {
        this.tortipo = tortipo;
    }

    /**
     *
     * @return un lista di proiettili
     */
    public ArrayList<Proiettile> getProiettili() {
        return proiettili;
    }

    /**
     *
     * @param proiettili
     */
    public void setProiettili(ArrayList<Proiettile> proiettili) {
        this.proiettili = proiettili;
    }
    
    /**
     *
     * @return un vettore di interi che tiene il conto delle torrentte
     */
    public int[] getContTorr() {
        return contTorr;
    }

    /**
     *
     * @return una lista di torrette
     */
    public ArrayList<Torretta> getTorrette() {
        return torrette;
    }

    /**
     *
     * @param torrette
     */
    public void setTorrette(ArrayList<Torretta> torrette) {
        this.torrette = torrette;
    }

    /**
     *
     * @param prog
     */
    public void setProg(boolean prog) {
        this.prog = prog;
    }

    /**
     *
     * @param ready
     */
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    /**
     *
     * @return drag
     */
    public int getDrag() {
        return drag;
    }

    /**
     *
     * @param drag
     */
    public void setDrag(int drag) {
        this.drag = drag;
    }

    /**
     *
     * @return una lista di ondate
     */
    public ArrayList<Ondata> getOnd() {
        return ond;
    }

    /**
     *
     * @return una griglia di valori
     */
    public Griglia getGriglia() {
        return griglia;
    }

    /**
     *
     * @param griglia
     */
    public void setGriglia(Griglia griglia) {
        this.griglia = griglia;
    }

    /**
     * questo metodo aggiunge gli ascoltatori al pannello, crea una griglia,le mappe e un salvato; dopodichè carica le immagini delle risorse
     */
    public void definisci() {
        addMouseListener(ricevitoreTor);
        addMouseMotionListener(ricevitoreTor);
        griglia = new Griglia();

        map1 = new Mappa(griglia.getWorldLarghezza(), griglia.getWorldAltezza());
        map2 = new Mappa(griglia.getWorldLarghezza(), griglia.getWorldAltezza());
        map3 = new Mappa(griglia.getWorldLarghezza(), griglia.getWorldAltezza());

        save = new Salvato();
        for (int i = 0; i < Tipo_terreno.length; i++) {
            Tipo_terreno[i] = new ImageIcon("risorse/tipo_terreno.png").getImage();//ImageIcon è un'implementazione dell'interfaccia icona che dipinge le icone dalle immagini prese da un array di url o nome del file precaricate tramite Media Traker per monitorare lo stato caricato dell'immagine. getImage restituisce l'immagine che ottiene i dati dei pixel dal file specificato , il cui formato può essere sia GIF, JPEG o PNG .
            Tipo_terreno[i] = createImage(new FilteredImageSource(Tipo_terreno[i].getSource(), new CropImageFilter(0, 20 * i, 20, 20))); //la classe FilteredImageSource è un'implementazione dell'interfaccia ImageProducer(interfaccia di oggetti che possono produrre dati di immagine per l'immagine. Ogni immagine contiene un ImageProducer che viene utilizzato per ricostruire l'immagine ogni volta che è necessario). Essa prende un'immagine esistente e un oggetto filtro e li utilizza per produrre dati di un'immagine nuova filtrata da quella originale.  La classe CropImageFilter estende la classe ImageFilter e serve per estrarre una data regione rettangolare di un'immagine esistente e fornirne una fonte per una nuova immagine che contiene solo la regione estratta. Essa è utilizzata in combinazione con un oggetto FiltereImageSource per produrre versioni ritagliate delle immagini esistenti.

        }
        for (int i = 0; i < Tipo_aria.length; i++) {
            Tipo_aria[i] = new ImageIcon("risorse/Acqua.png").getImage();

        }

        save.caricaSalvato(new File("salvato/missione1_cavalli.txt"), griglia);

        map1.percorso(new File("salvato/mappa1.txt"));
        map2.percorso(new File("salvato/mappa2.txt"));
        map3.percorso(new File("salvato/mappa3.txt"));
        
        ond = new ArrayList<>();
        ond.add(new Ondata(map1, max, vitaMob, velMob,guadagnoMob, griglia.getDimPiastrelle(),Tipo_mob));
        ond.add(new Ondata(map2, max, vitaMob, velMob,guadagnoMob,griglia.getDimPiastrelle(),Tipo_mob));
        ond.add(new Ondata(map3, max, vitaMob, velMob,guadagnoMob,griglia.getDimPiastrelle(),Tipo_mob));

        torrette = new ArrayList<>();
        proiettili = new ArrayList<>();
        contTorr= new int[100];

        tortipo[0] = new Torretta1(0, 80, 80, proiettili);
        tortipo[1] = new Torretta2(0, 80, 80, proiettili);

    }

    /**
     *
     * @return
     */
    public int getTempobarra() {
        return tempobarra;
    }

    /**
     *
     * @param tempobarra
     */
    public void setTempobarra(int tempobarra) {
        this.tempobarra = tempobarra;
    }

    @Override
    public void paintComponent(Graphics g)//g è l'oggetto che disegna ciò che gli ordiniamo
    {
        if (primoControl) {
            myWidth = getWidth();
            myHeight = getHeight();
            definisci();
            primoControl = false;
        }

        g.clearRect(0, 0, getWidth(), getHeight());
        griglia.disegna(g);

        for (int i = a; i < ond.size(); i++) {
            for (Mob mob : ond.get(i).getMobs()) {
                if (mob.isIngioco()) {
                    mob.disegna(g);
                }
            }
          
        }

       

        if (drag != -1) {
            tortipo[drag].disegna(g);
        } 
        
        torrette.stream().map((tor) -> {
            tor.disegna(g);
            return tor;
        }).forEach((Torretta tor) -> {
            try {
                tor.getProiettili().stream().filter((p) -> (p.isSparato() && !p.isColpito())).forEach((p) -> {
                    p.disegna(g);
                });
            } catch (Exception e) {
                System.out.println("c'è un problema con i proiettili "+e);
            }
        });
    }

    //il metodo che segue si occupa dello spawn dei mob verificando prima che essi non siano in gioco definendo anche un ritardo(delay) di spawn tra loro grazie al conteggio dei frame

    /**
     *
     */
    public void progressoBarra() {
        if (finestrabarra >= tempobarra) {
            iPanel.getBarraProgresso().setValue(iPanel.getBarraProgresso().getValue() + 1);
            
            if (iPanel.getBarraProgresso().getValue() >= 100) {
                if(iPanel.getOndManc()>0){
                iPanel.setOndManc(iPanel.getOndManc()-1);
                if(iPanel.getOndManc()==0)
                iPanel.getOndateMancanti().setText("Ondate terminate! :-)");  
                else
                iPanel.getOndateMancanti().setText("Mancano "+ (iPanel.getOndManc())+ " ondate");
                
                } 
                iPanel.getBarraProgresso().setValue(0);
                
                guadagnoMob+=1;
                vitaMob+=20;
                velMob-=1;
                if (contond >= 6) {
                    iPanel.getReady().setVisible(false);
                    iPanel.remove(iPanel.getBarraProgresso());
                   
                } else {
                    max +=3;
                   
                    mobMax += max * 3;
                    ond.add(new Ondata(map1, max, vitaMob, velMob,guadagnoMob, griglia.getDimPiastrelle(), Tipo_mob= new ImageIcon("risorse/mob"+idmob+".png").getImage() ));
                    ond.add(new Ondata(map2, max, vitaMob, velMob,guadagnoMob,griglia.getDimPiastrelle(),Tipo_mob= new ImageIcon("risorse/mob"+idmob+".png").getImage() ));
                    ond.add(new Ondata(map3, max, vitaMob, velMob,guadagnoMob, griglia.getDimPiastrelle(),Tipo_mob= new ImageIcon("risorse/mob"+idmob+".png").getImage() ));
                    iPanel.getReady().setVisible(false);
                    contond += 3;
                    idmob+=1;
                    finestraspawn = 799;
                   
                }
            }
            finestrabarra = 0;
        } else {
            finestrabarra += 1;
        }
    }

    /**
     *
     */
    public void evocatore() {
        if (finestraspawn >= tempospawn) {
            for (int i = a; i < ond.size(); i++) {
                for (Mob mob : ond.get(i).getMobs()) {
                    if (!mob.isIngioco() && !mob.isMorto()) {
                        mob.spawn();
                        break;
                    }
                }

            }
            finestraspawn = 0;

        } else {
            finestraspawn += 1;

        } 
    }

    @Override
    public void run()// il metodo run contiene il codice che descrive il funzionamento dell'applicazione
    {
      running=true;
        while (running) {
            if (!primoControl) {
                if (ready) {
                    evocatore(); 
                    
                    
                    
                   
                }// chiama il metodo evocatore
                if (prog) {
                    progressoBarra();
                }
               
                try{if (ond.get(contond).getMobs()[max -1].isIngioco() && contond < 6 ) {
                    iPanel.getReady().setVisible(true);
                    
                     
                }}catch(Exception di){System.out.println("..." + di);}

                for (int i = a; i < ond.size(); i++) {
                    
                    
                    for (Mob mob : ond.get(i).getMobs()) {

                        //questo ciclo serve per scorrere tutti i mob dell'ondata fino a completare la lunghezza di quest'ultima
                        if (mob.isIngioco()) {
                            // verifico che il mob i-esimo dell'ondata corrente è in gioco
                            mob.avanzamento(ond.get(i).getMappa().getMatricePercorso()); //chiamo il metodo avanzamento dell'i-esimo mob della relativa ondata
                            if(mob.getTempoRallentato()>0){
                            mob.setTempoRallentato(mob.getTempoRallentato()-1);}
                            else  if(mob.getTempoRallentato()<=0 && mob.isRallentato()){
                                     mob.setRallentato(false);
                                 mob.setVelocità(mob.getVelocità()-mob.getDebuffVelocità());
                                 }
                        
                           
                                for (Torretta tor : torrette) {
                        
                                    if (contTorr[torrette.indexOf(tor)]!=(tor.getVelocitàAttacco())){
                                        contTorr[torrette.indexOf(tor)] += 1;
                                    }
                                    
                                    tor.nelRange(mob);
                                

                                }
                           
                        }
                    }
                    
                }
                    

                
try{                torrette.stream().forEach((tor) -> {
                    tor.getProiettili().stream().filter((p) -> (p.isSparato())).forEach((p) -> {
                        p.calcolaDirezione();
                    });
                });}catch (Exception ecc){System.out.println("crash proiettili"+ecc);}
                

                if (giocatore.getVita() <= 0) {
                    finestra.getTimer().stop();
                    fine.HaiPerso();
                    running=false;

                }

                if (mobUccisi == mobMax && contond >= 6) {
                    finestra.getTimer().stop();

                    fine.HaiVinto();
                    running=false;

                }

            }
            /*il metodo repaint esegue la chiamata al metodo update()(che cancella la parte di schermo dedicata
            all'applicazione dipingendo tutto con il colore di sfondo causando un possibile sfarfallio nelle animazioni) 
            poi di conseguenza al metodo paint() al termine delle operazione di preparazione dell'immagine
            (il metodo paint() è un metodo chiamato automaticamente da Java tutte le volte che risulta necessario
            aggiornare la zona del video dedicata all'applicazione).*/
            repaint();

            try {
                Thread.sleep(1);//Thread.sleep fa sì che il thread corrente sospenda l'esecuzione per un periodo determinato . Si tratta di uno strumento efficace per dare tempo al processore per gestire altri thread di un'applicazione o di altre applicazioni che potrebbero essere in esecuzione su un sistema informatico .
            } catch (Exception e) {
                System.out.println("BABUDOIO");
            }
        } running=false;
    }

   

}
