/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    conectaDAO conectadao;

    public ProdutosDAO() {

        this.conectadao = new conectaDAO();
        this.conn = this.conectadao.connectDB();

    }

    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {

        String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                + "(?,?,?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            conn = new conectaDAO().connectDB();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto!");
        }

    }

    public List<ProdutosDTO> listarProdutos() {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ProdutosDTO> listagem = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT*FROM produtos");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                ProdutosDTO produtos = new ProdutosDTO();
                
                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setValor(rs.getInt("valor"));
                produtos.setStatus(rs.getString("status"));
                listagem.add(produtos);
            }
            
        } catch (Exception e) {
            
        }
        return listagem;
    }
}
