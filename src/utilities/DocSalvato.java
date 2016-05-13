/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.*;

/**
 *
 * @author User
 */
public class DocSalvato {
    String linea,testo;
    
   private  BufferedReader re;
   
    /**
     *
     * @throws IOException
     */
    public DocSalvato() throws IOException{
       
 
 testo=new String("");
   }
    
    /**
     *
     * @param f
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String caricaIlFile(File f) throws FileNotFoundException, IOException{

if ( !f.exists() )
{ System.out.println("infoGAME.txt non esiste!");
}else{
    try {FileReader fr = new FileReader(f); 
        re = new BufferedReader(fr);
         linea=re.readLine();
        
        while (linea!=null)
        { 
           testo+=linea+"\n";
        
                linea=re.readLine();;
     
             
             
    
            
       
      
        }  
 
    
    }catch(Exception esc){System.out.println(esc);}
    finally{ re.close();}

}


return testo;
}
    
    
    
}
