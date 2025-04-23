/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        Connection conn = new conectaDAO().connectDB(); // Abrir a conexão com o banco
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());

            int rowsAffected = stmt.executeUpdate();  // Executa a inserção
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();  // Fecha a conexão
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

