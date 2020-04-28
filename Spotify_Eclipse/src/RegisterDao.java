import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    
    private String dburl= "jdbc:mysql://localhost:3306/spotify_database";
    private String dbuname = "root";
    private String dbpassword = "root"; //Type in your password
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
 
    public String insertAlbum(Album album) {
        Genre genre = new Genre();
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "Data Entered Successfully!";
        String sql = "insert into spotify_database.album values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, album.getAlbum_id());
            ps.setString(2, album.getTitle());
            ps.setString(3, album.getArtist_name());
            ps.setString(4, album.getAlbum_track());
            ps.setString(5, album.getRelease_date());
            ps.setString(6, genre.getGenreId());
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
        String result = "\nData Entered Successfully!";
        String sql = "insert into spotify_database.genre values(?,?)";
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
    
    public String insertTracks(Tracks tracks) {
        Album album = new Album();
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "\nData Entered Successfully!";
        String sql = "insert into spotify_database.tracks values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tracks.getTrackName());
            ps.setString(2, tracks.getTrackDur());
            ps.setString(3, album.getAlbum_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String insertArtist(Artist artist) {
        Tracks tracks = new Tracks();
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "\nData Entered Successfully!";
        String sql = "insert into spotify_database.artist values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, artist.getArtistId());
            ps.setString(2, artist.getAlbumName());
            ps.setString(3, artist.getFans());
            ps.setString(4, tracks.getTrackName());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String insertUser(User user) {
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "\nData Entered Successfully!";
        String sql = "insert into spotify_database.user values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getFollowers());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String insertPlaylist(Playlist playlist) {
        User user = new User();
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "\nData Entered Successfully!";
        String sql = "insert into spotify_database.playlist values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, playlist.getPlaylistId());
            ps.setString(2, playlist.getPlaylistTitle());
            ps.setString(3, playlist.getPlaylistDur());
            ps.setString(4, playlist.getDateAdded());
            ps.setString(5, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String insertPopularity(Popularity popularity) {
        Tracks tracks = new Tracks();
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "\nData Entered Successfully!";
        String sql = "insert into spotify_database.popularity values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, popularity.getFollowers());
            ps.setString(2, popularity.getLikes());
            ps.setString(3, tracks.getTrackName());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
}
