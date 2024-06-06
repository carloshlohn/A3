package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Amigo {
    private int id;
    private String nome;
    private String fone;

    public Amigo() {
        this(0,"","");
    }

    public Amigo(int id, String nome, String fone) {
        this.id= id;
        this.nome = nome;
        this.fone = fone;
    }

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void leitura() {
        setNome(JOptionPane.showInputDialog("Digite seu nome: "));
        setFone(JOptionPane.showInputDialog("Digite seu telefone: "));
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nTelefone: " + getFone();
    }

    // CRUD methods
    public void salvar() throws SQLException {
        String sql = "INSERT INTO amigo (nome, fone) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setString(2, getFone());
            stmt.executeUpdate();
        }
    }

    public static List<Amigo> listar() throws SQLException {
        List<Amigo> amigos = new ArrayList<>();
        String sql = "SELECT * FROM amigo";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Amigo amigo = new Amigo(rs.getInt("id"), rs.getString("nome"), rs.getString("fone"));
                amigos.add(amigo);
            }
        }
        return amigos;
    }

    public void atualizar() throws SQLException {
        String sql = "UPDATE amigo SET nome = ?, fone = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setString(2, getFone());
            stmt.setInt(3, getId());
            stmt.executeUpdate();
        }
    }

    public void deletar() throws SQLException {
        String sql = "DELETE FROM amigo WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getId());
            stmt.executeUpdate();
        }
    }

    private static class DatabaseConnection {

        private static Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public DatabaseConnection() {
        }
    }
}
