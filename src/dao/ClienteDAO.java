package dao;

import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    String url = "jdbc:sqlite:beforeDefensa.sqlite";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void insertarCliente(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, email, telefono, edad, " +
                "dinero_gastado, productos_comprados) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setDouble(5, c.getDinero_gastado());
            ps.setInt(6, c.getProductos_comprados());
            ps.executeUpdate();
            System.out.println("Cliente insertado con éxito");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
