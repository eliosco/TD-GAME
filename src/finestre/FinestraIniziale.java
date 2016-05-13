/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre;

import ascoltatori.AscoltatoreInfo;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import utilities.DocSalvato;
import static utilities.TDGAME.*;

/**
 *
 * @author User
 */
public class FinestraIniziale extends JFrame implements ActionListener {

    private JPanel pannelloIn;
    private JButton start;
    private JButton info;
    private JLabel testo, testo1;
    private JTextArea classifica;
    private File file;
    private String test;

    /**
     *
     * @return
     */
    public String getTest() {
        return test;
    }

    /**
     *
     * @param test
     */
    public void setTest(String test) {
        this.test = test;
    }

  
    private DocSalvato ds;

   
    private AscoltatoreInfo aF;

    /**
     *
     * @throws IOException
     */
    public FinestraIniziale() throws IOException {
        super(" MENU' INIZIALE");
        this.setLocation(600, 400);
       aF=new AscoltatoreInfo();
        pannelloIn = new JPanel();
DocSalvato s=new DocSalvato();
        testo = new JLabel("<html> &nbsp; &nbsp; &nbsp; &nbsp; Il cronometro partirà alla pressione del tasto START &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  !!!! Buona Fortuna!!!! </html>  ");
        start = new JButton("START");
        info=new JButton("INFO");
        testo1 = new JLabel("CLASSIFICA:");
        classifica = new JTextArea("");
        file = new File("salvato/infoGAME.txt");
        ds=new DocSalvato();
        add(pannelloIn);
        pannelloIn.setLayout(new BorderLayout());
        start.addActionListener(this);
        info.addMouseListener(aF);

        stampa(connessione.getData());
        pannelloIn.add(start,BorderLayout.SOUTH);
       pannelloIn.add(info,BorderLayout.EAST);
        pannelloIn.add(testo, BorderLayout.NORTH);
        pannelloIn.add(testo1, BorderLayout.WEST);
        pannelloIn.add(classifica, BorderLayout.CENTER);
        test=ds.caricaIlFile(file);
        classifica.setEditable(false);
      
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.dispose();

        finestra = new Finestra();

    }

    /**
     *
     * @param s
     */
    public void stampa(String[] s) {
        for (int j = 0; j < s.length; j++) {
            if (s[j] != null) {
                classifica.append("\n" + s[j] + "\n");
            }
        }
       
    
        
        
    }
    
    /**
     *
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }
    
    /**
     *
     * @return
     */
    public DocSalvato getDs() {
        return ds;
    }

    /**
     *
     * @param ds
     */
    public void setDs(DocSalvato ds) {
        this.ds = ds;
    }
}
