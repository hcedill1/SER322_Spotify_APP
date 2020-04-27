import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    
    private String dburl= "jdbc:mysql://localhost:3306/spotify";
    private String dbuname = "root";
    private String dbpassword = ""; //Type in your password
    private String dbdriver = "com.mysql.jdbc.Driver";
    
    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public String insert(Music music) {
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "Data Entered Successfully!";
        String sql = "insert into spotify.music values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, music.getAlbum());
            ps.setString(2, music.getArtist());
            ps.setString(3, music.getGenre());
            ps.setString(4, music.getPlaylist());
            ps.setString(5, music.getPopularity());
            ps.setString(6, music.getTracks());
            ps.setString(7, music.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
        
    }
}
