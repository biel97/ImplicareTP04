package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.model.dao.EstadoDao;
import br.cefetmg.implicare.model.domain.Estado;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.util.db.JDBCConnectionManager;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class EstadoDaoImpl implements EstadoDao {

    @Override
    public List<Estado> listAll() throws PersistenceException, RemoteException {
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM Estado ORDER BY Nom_Estado;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Estado> listAll = new ArrayList<>();

            if (rs.next()) {
                do {
                    Estado Est = new Estado();
                    Est.setCod_Estado(rs.getInt("Cod_Estado"));
                    Est.setNom_Estado(rs.getString("Nom_Estado"));
                    listAll.add(Est);
                } while (rs.next());
            }

            rs.close();
            ps.close();
            connection.close();

            return listAll;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public Estado getEstadoCod(int Cod_Estado) throws PersistenceException, RemoteException {
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM Estado WHERE Cod_Estado = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, Cod_Estado);
            ResultSet rs = ps.executeQuery();

            Estado Est = new Estado();

            if (rs.next()) {
                Est.setCod_Estado(rs.getInt("Cod_Estado"));
                Est.setNom_Estado(rs.getString("Nom_Razao_Social"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Est;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
