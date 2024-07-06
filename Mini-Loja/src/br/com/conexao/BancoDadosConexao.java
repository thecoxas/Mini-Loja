/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.conexao;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author Welton
 */
public class BancoDadosConexao {
    private static final String url = "jdbc:mysql://localhost:3306/mini_loja";
    private static final String user = "root";
    private static final String password = "tyu2527tyu";
    
    private static Connection conn;
    
    public static Connection getConnection(){
        try {
            if(conn == null){
            conn = DriverManager.getConnection(url, user, password);
            return conn;
            }else{
                return conn;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }
}
