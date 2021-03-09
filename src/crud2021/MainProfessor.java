/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud2021;


import br.unicademia.crud2021.Professor;
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
 * @author jhon4
 */
public class MainProfessor {

    public static void main(String Args[]) {
        
       insere(new Professor(1, "Professor Roberto","Rua Flores","32993443333",new Date(), "Doutorado"));
       List<Professor>professores=listar();
       System.out.println(professores);
       // excluir(new Professor(1,null,null,null,null,null,null,null));
       //System.out.println("Atualização de Professor...");
       //atualizar(new Professor(2, "Christien",new Date(), "Rua Alterada", "111111111111", new Date(), 1.90f, 82.5f));
        
    }
      
    
 public static void insere(Professor professor){
     
     //conexao com o BD
       Connection con = new ConectionFactory().conecta();
     
       //criar query
       
       String sql="insert into professor(nome,endereco, telefone, datanascimento, titulacao ) "
               + "values(?,?,?,?,?)";
     
     //definir os parametros de inserção com base no objeto
       
       try {
         
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setString(1, professor.getNome());
           stm.setString(2, professor.getEndereco());
           stm.setString(3, professor.getTelefone());
           stm.setDate(4, new java.sql.Date(professor.getDataNascimento().getTime()));
           stm.setString(5, professor.getTitulacao());
          
           
           int linhasafetadas=stm.executeUpdate();
           
           if(linhasafetadas>0){
               System.out.println("Inserção realizada com sucesso");
           }else{
               System.out.println("Erro ao inserir");
           }
           
     } catch (SQLException e) {
         throw new RuntimeException("erro ao inserir o professor"+ e);
     }
 } 
    
  
 public static List <Professor> listar(){
        List<Professor> professores=new ArrayList<>();
        Connection con = new ConectionFactory().conecta();
        String sql="select * from professor";
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
                Professor professor=new Professor();
                professor.setId((int)rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setDataNascimento(rs.getDate("datanascimento"));
                professor.setTitulacao(rs.getString("titulacao"));
                professores.add(professor);
            }
         
     } catch (SQLException e) {
        System.out.println("Erro ao listar o professor");
         e.printStackTrace();
         
     }
        
     
     
     
     
     return professores;
     
 }
 
 
 public static void excluir (Professor professor){
     Connection con = new ConectionFactory().conecta();
     String sql = "delete from professor where id=?";
     
     try {
         PreparedStatement stm = con.prepareStatement(sql);
         stm.setInt(1, professor.getId());
         
         int linhasafetadas=stm.executeUpdate();
         
         if(linhasafetadas>0){
               System.out.println("Professor excluido com sucesso");
           }else{
               System.out.println("Erro ao excluir o professor");
           }
         
     } catch (SQLException e) {
         
         throw new RuntimeException("Erro ao excluir o professor"+e);
         
     }
 
 }
 
 
  public static void atualizar(Professor professor){
     
     //conexao com o BD
       Connection con = new ConectionFactory().conecta();
     
       //criar query
       
       String sql="update professor set nome=?,endereco=?,telefone=?,datanascimento=?,titulacao=? where id=?";
     
     //definir os parametros de inserção com base no objeto
       
       try {
         
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setString(1, professor.getNome());
           stm.setString(2, professor.getEndereco());
           stm.setString(3, professor.getTelefone());
           stm.setDate(4, new java.sql.Date(professor.getDataNascimento().getTime()));
           stm.setString(5, professor.getTitulacao());
           stm.setInt(6, professor.getId());
           
           int linhasafetadas=stm.executeUpdate();
           
           if(linhasafetadas>0){
               System.out.println("Atualização realizada com sucesso");
           }else{
               System.out.println("Erro ao atualizar");
           }
           
     } catch (SQLException e) {
         throw new RuntimeException("erro ao atualizar o professor"+ e);
     }
 } 
 
 
 
    
}