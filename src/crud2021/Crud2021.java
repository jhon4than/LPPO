/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud2021;

import java.sql.Connection;
import javax.swing.JOptionPane;
import jdbc.ConectionFactory;

/**
 *
 * @author chris
 */
public class Crud2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
         try{
            JOptionPane.showMessageDialog(null, "Testando a conexão.");
            Connection con = new ConectionFactory().conecta();
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso.");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
        
    }
    
}
