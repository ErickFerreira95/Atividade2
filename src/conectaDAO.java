
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
public class conectaDAO {

    Connection conn;

    public Connection connectDB() {

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/atividade2uc11?autoReconnect=true&useSSL=false",
                    "root",
                    "Picoricos2Nina." //senha
            );
            return conn;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return null;
    }

}
