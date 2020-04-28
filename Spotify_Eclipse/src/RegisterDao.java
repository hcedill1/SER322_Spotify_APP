import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    
    private String dburl= "jdbc:mysql://localhost:3306/spotify_db";
    private String dbuname = "root";
    private String dbpassword = "Tuesday10!"; //Type in your password
    private String dbdriver = "com.mysql.cj.jdbc.Driver";
    
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
    
    
    public String insertAlbum(Album album) {
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "Data Entered Successfully!";
        String sql = "insert into spotify_db.album values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, album.getAlbum_id());
            ps.setString(2, album.getTitle());
            ps.setString(3, album.getArtist_name());
            ps.setString(4, album.getAlbum_track());
            ps.setString(5, album.getRelease_date());
            ps.setString(6, album.getGenre_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String insertGenre(Genre genre) {
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "Data Entered Successfully!";
        String sql = "insert into spotify_db.genre values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, genre.getGenreId());
            ps.setString(2, genre.getType());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
}
