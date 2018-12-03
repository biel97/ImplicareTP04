package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.model.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.util.db.JDBCConnectionManager;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class AreaEstudoDaoImpl implements AreaEstudoDao {

    @Override
    public ArrayList<AreaEstudo> listAll() throws PersistenceException, RemoteException {
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {

            String sql = "SELECT * FROM AreaEstudo ORDER BY Nom_Area_Estudo;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<AreaEstudo> listAll = new ArrayList<>();

            if (rs.next()) {
                do {
                    AreaEstudo Area = new AreaEstudo();
                    Area.setCod_Area_Estudo(rs.getInt("Cod_Area_Estudo"));
                    Area.setNom_Area_Estudo(rs.getString("Nom_Area_Estudo"));
                    listAll.add(Area);
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
    public AreaEstudo getAreaEstudoCod(int Cod_Area_Estudo) throws PersistenceException, RemoteException {
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {

            String sql = "SELECT * FROM AreaEstudo WHERE Cod_Area_Estudo = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Cod_Area_Estudo);
            ResultSet rs = ps.executeQuery();

            AreaEstudo Area = new AreaEstudo();

            if (rs.next()) {
                Area.setCod_Area_Estudo(rs.getInt("Cod_Area_Estudo"));
                Area.setNom_Area_Estudo(rs.getString("Nom_Area_Estudo"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Area;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
