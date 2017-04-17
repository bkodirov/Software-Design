package facade;

import java.sql.*;

/**
 * Created by Beka on 16.04.17.
 */
public class DataFetcherFacadeImpl implements DataFetcherFacade {
    @Override
    public int getImportantValue() throws DataFetchException {
        Connection conn = null;
        PreparedStatement prep = null;
        CallableStatement call = null;
        ResultSet rset = null;
        try {
            Class.forName("<driver>").newInstance();
            conn = DriverManager.getConnection("<database>");
            String sql = "SELECT * FROM <table> WHERE <column name> =?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, "<column value>");
            rset = prep.executeQuery();
            if (rset.next()) {
                System.out.println(rset.getString("<column name"));
            }
            sql = "{call <stored procedure>( ?, ? )}";
            call = conn.prepareCall(sql);
            call.setInt(1, 1972);
            call.registerOutParameter(2, Types.INTEGER);
            call.execute();
            return call.getInt(2);
        } catch (SQLException e) {
            throw new DataFetchException(e);
        } catch (InstantiationException e) {
            throw new DataFetchException(e);
        } catch (ClassNotFoundException e) {
            throw new DataFetchException(e);
        } catch (IllegalAccessException e) {
            throw new DataFetchException(e);
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException ex) {
                    throw new DataFetchException(ex);
                }
            }
            if (prep != null) {
                try {
                    prep.close();
                } catch (SQLException ex) {
                    throw new DataFetchException(ex);
                }
            }
            if (call != null) {
                try {
                    call.close();
                } catch (SQLException ex) {
                    throw new DataFetchException(ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new DataFetchException(ex);
                }
            }
        }
    }
}
