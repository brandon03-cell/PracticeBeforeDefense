package dao;

import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    String url = "jdbc:sqlite.beforeDefensa.sqlite";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void insertarCliente(Cliente c) {
        String sql = "insert into clientes (id, nombre, email, telefono, edad, " +
                "dinero_gastado, productos_comprados) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefono());
            ps.setInt(5, c.getEdad());
            ps.setDouble(6, c.getDinero_gastado());
            ps.setInt(7, c.getProductos_comprados());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}
