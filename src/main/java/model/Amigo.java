package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Amigo {
    private String nome;
    private String fone;

    private static List<Amigo> listaAmigos = new ArrayList<>();

    public Amigo() {}

    public Amigo(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public boolean insertAmigoBD(String nome, String fone) {
        try {
            Amigo novoAmigo = new Amigo(nome, fone);
            listaAmigos.add(novoAmigo);
            novoAmigo.salvar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Amigo> getMinhaLista() {
        return listaAmigos;
    }

    // Getters and setters...
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
                Amigo amigo = new Amigo(rs.getString("nome"), rs.getString("fone"));
                amigos.add(amigo);
            }
        }
        return amigos;
    }

    public void atualizar() throws SQLException {
        String sql = "UPDATE amigo SET fone = ? WHERE nome = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getFone());
            stmt.setString(2, getNome());
            stmt.executeUpdate();
        }
    }

    public void deletar() throws SQLException {
        String sql = "DELETE FROM amigo WHERE nome = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.executeUpdate();
        }
    }

    public boolean updateAmigoBD(String nome, String telefone, String fone1) {
        try {
            setNome(nome);
            setFone(telefone);
            atualizar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAmigoBD(String nome) {
        try {
            setNome(nome);
            deletar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static class DatabaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/db_a3?zeroDateTimeBehavior=CONVERT_TO_NULL";
        private static final String USER = "root";
        private static final String PASSWORD = "lohnaldoN9!";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
}
