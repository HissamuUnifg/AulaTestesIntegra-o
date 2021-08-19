package database;

import java.awt.dnd.DropTarget;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SQLite {
    private Connection conn;
    private Statement stm;  
    
    public SQLite(boolean dropTables) {
        String url = "jdbc:sqlite:banco.db";
        try {
            this.conn = DriverManager.getConnection(url);
            this.stm = this.conn.createStatement();
            
            System.out.println("Connection to SQLite has been established.");  
            
            initDB(dropTables);
        } catch (SQLException ex) {
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initDB(boolean dropTable){
        try {
            if(dropTable)
                this.stm.executeUpdate("DROP TABLE IF EXISTS funcionarios");
            
            this.stm.execute("CREATE TABLE IF NOT EXISTS funcionarios("
                    + "id INTEGER PRIMARY KEY NOT NULL, nome VARCHAR, "
                    + "salario REAL"
                    + ")");
        } catch (SQLException ex) {
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void executeQuery(String query) throws SQLException{
        this.stm = this.conn.createStatement();
        this.stm.executeUpdate(query);        
    }
    
    public ResultSet find(String query) throws SQLException{
        this.stm = this.conn.createStatement();
        ResultSet rs = this.stm.executeQuery(query);  
        
        return rs;
    }
}
