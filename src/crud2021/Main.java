/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud2021;

import br.unicademia.crud2021.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdbc.ConectionFactory;

/**
 *
 * @author chris
 */
public class Main {

    public static void main(String Args[]) {
        
       //insere(new Aluno(0, "Jhonathan",new Date(),"Rua Giusepe Novelino","32991372975",new Date(), 1.93f,100f));
       //List<Aluno>alunos=listar();
       //System.out.println(alunos);
       // excluir(new Aluno(1,null,null,null,null,null,null,null));
       //System.out.println("Atualização de Aluno...");
       //atualizar(new Aluno(2, "Christien",new Date(), "Rua Alterada", "111111111111", new Date(), 1.90f, 82.5f));
        
    }
      
    
 public static void insere(Aluno aluno){
     
     //conexao com o BD
       Connection con = new ConectionFactory().conecta();
     
       //criar query
       
       String sql="insert into aluno(nome, datamatricula,endereco, telefone, datanascimento,altura,peso) "
               + "values(?,?,?,?,?,?,?)";
     
     //definir os parametros de inserção com base no objeto
       
       try {
         
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setString(1, aluno.getNome());
           stm.setDate(2, new java.sql.Date(aluno.getDataMatricula().getTime()));
           stm.setString(3, aluno.getEndereco());
           stm.setString(4, aluno.getTelefone());
           stm.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
           stm.setFloat(6, aluno.getAltura());
           stm.setFloat(7, aluno.getPeso());
           
           int linhasafetadas=stm.executeUpdate();
           
           if(linhasafetadas>0){
               System.out.println("Inserção realizada com sucesso");
           }else{
               System.out.println("Erro ao inserir");
           }
           
     } catch (SQLException e) {
         throw new RuntimeException("erro ao inserir o aluno"+ e);
     }
 } 
    
  
 public static List <Aluno> listar(){
        List<Aluno> alunos=new ArrayList<>();
        Connection con = new ConectionFactory().conecta();
        String sql="select * from aluno";
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
                Aluno aluno=new Aluno();
                aluno.setId((int)rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataMatricula(rs.getDate("datamatricula"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getDate("datanascimento"));
                aluno.setAltura(rs.getFloat("altura"));
                aluno.setPeso(rs.getFloat("peso"));
                alunos.add(aluno);
            }
         
     } catch (SQLException e) {
        System.out.println("Erro ao listar o aluno");
         e.printStackTrace();
         
     }
        
     
     
     
     
     return alunos;
     
 }
 
 
 public static void excluir (Aluno aluno){
     Connection con = new ConectionFactory().conecta();
     String sql = "delete from aluno where id=?";
     
     try {
         PreparedStatement stm = con.prepareStatement(sql);
         stm.setInt(1, aluno.getId());
         
         int linhasafetadas=stm.executeUpdate();
         
         if(linhasafetadas>0){
               System.out.println("Aluno excluido com sucesso");
           }else{
               System.out.println("Erro ao excluir o aluno");
           }
         
     } catch (SQLException e) {
         
         throw new RuntimeException("Erro ao excluir o aluno"+e);
         
     }
 
 }
 
 
  public static void atualizar(Aluno aluno){
     
     //conexao com o BD
       Connection con = new ConectionFactory().conecta();
     
       //criar query
       
       String sql="update aluno set nome=?,datamatricula=?,endereco=?,telefone=?,datanascimento=?,altura=?,peso=? where id=?";
     
     //definir os parametros de inserção com base no objeto
       
       try {
         
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setString(1, aluno.getNome());
           stm.setDate(2, new java.sql.Date(aluno.getDataMatricula().getTime()));
           stm.setString(3, aluno.getEndereco());
           stm.setString(4, aluno.getTelefone());
           stm.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
           stm.setFloat(6, aluno.getAltura());
           stm.setFloat(7, aluno.getPeso());
           stm.setInt(8, aluno.getId());
           
           int linhasafetadas=stm.executeUpdate();
           
           if(linhasafetadas>0){
               System.out.println("Atualização realizada com sucesso");
           }else{
               System.out.println("Erro ao atualizar");
           }
           
     } catch (SQLException e) {
         throw new RuntimeException("erro ao atualizar o aluno"+ e);
     }
 } 
 
 
 
    
}
