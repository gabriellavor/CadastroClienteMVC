/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroclientemvc.dao;

import br.com.cadastroclientemvc.clientes.Clientes;
import br.com.cadastroclientemvc.conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Lavor
 */
public class ClientesDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet resultado = null;    
  
    public boolean incluir(Clientes clientes){
        conexao = ModuloConexao.conectar();
        try {
            String sql = "INSERT INTO clientes (nome,email,sexo,soube_nos,receber_notificacao) VALUES (?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, clientes.getNome());
            pst.setString(2, clientes.getEmail());
            pst.setString(3, clientes.getSexo());
            pst.setString(4, clientes.getSoube_nos());
            pst.setString(5,clientes.getReceber_notificacao() );
            pst.executeUpdate();        
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public boolean atualizar(Clientes clientes){
        conexao = ModuloConexao.conectar();
        try {
            String sql = "UPDATE clientes SET nome = ? ,email = ?,sexo = ? ,soube_nos = ?,receber_notificacao =? WHERE codigo = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, clientes.getNome());
            pst.setString(2, clientes.getEmail());
            pst.setString(3, clientes.getSexo());
            pst.setString(4, clientes.getSoube_nos());
            pst.setString(5,clientes.getReceber_notificacao() );
            pst.setString(6,clientes.getCodigo()+"");
            pst.executeUpdate();        
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        
    }
    
    public boolean excluir(String codigo){
        conexao = ModuloConexao.conectar();
        try {
            String sql = "DELETE FROM clientes WHERE codigo = ?";
            pst = conexao.prepareStatement(sql);
            System.out.println(pst);
            pst.setString(1, codigo);     
            pst.executeUpdate();                        
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
