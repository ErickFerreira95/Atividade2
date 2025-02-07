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
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    conectaDAO conectadao;

    public ProdutosDAO() {

        this.conectadao = new conectaDAO();
        this.conn = this.conectadao.connectDB();

    }

    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {

        String sql = "INSERT INTO pordutos(nome, valor, status) VALUES "
                + "(?,?,?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.execute();

            conn = new conectaDAO().connectDB();
        } catch (Exception e) {

        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
