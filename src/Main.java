import dao.ClienteDAO;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente(12, "pepe", "pepe@gmail.com", "611186103", 19, 10.99, 9);

        clienteDAO.insertarCliente(cliente);
    }


}