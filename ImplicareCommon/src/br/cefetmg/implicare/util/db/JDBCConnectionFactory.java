package br.cefetmg.implicare.util.db;

/**
 *
 * @author Gabriel
 */
import java.sql.Connection;
import java.sql.SQLException;

public interface JDBCConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
