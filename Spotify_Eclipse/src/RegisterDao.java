import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
            ResultSet query = ps.executeQuery("SELECT * from album");
            while(query.next()) {
                String albumId = query.getObject(1).toString();
                String title = query.getObject(2).toString();
                String artist = query.getObject(3).toString();
                String track = query.getObject(4).toString();
                String releaseDate = query.getObject(5).toString();
                
                System.out.println("\nAlbum ID: " + albumId + " Album Title: " +
                title + " Artist: " + artist + " Track: " + track + " Release Date: " +
                        releaseDate);
            }
            
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
            
            ResultSet query = ps.executeQuery("SELECT * from genre");
            while(query.next()) {
                String genreId = query.getObject(1).toString();
                String type = query.getObject(2).toString();
                
                System.out.println("\nGenre ID: " + genreId + " Type: " + type);
            }
            
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
            
            ResultSet query = ps.executeQuery("SELECT * from tracks");
            while(query.next()) {
                String tName = query.getObject(1).toString();
                String tDur = query.getObject(2).toString();
                
                System.out.println("\nTrack Name: " + tName + " Track Duration: " + tDur);
            }
            
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
            
            ResultSet query = ps.executeQuery("SELECT * from artist");
            while(query.next()) {
                String artistId = query.getObject(1).toString();
                String albumName = query.getObject(2).toString();
                String fans = query.getObject(3).toString();
                
                System.out.println("\nArtist ID: " + artistId + " Album Name: " + albumName +
                        " Fans: " + fans);
            }
            
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
            
            ResultSet query = ps.executeQuery("SELECT * from user");
            while(query.next()) {
                String userId = query.getObject(1).toString();
                String followers = query.getObject(2).toString();
                
                System.out.println("\nUser ID: " + userId + " Followers : " + followers);
            }
            
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
            
            ResultSet query = ps.executeQuery("SELECT * from playlist");
            while(query.next()) {
                String playlistId = query.getObject(1).toString();
                String title = query.getObject(2).toString();
                String duration = query.getObject(3).toString();
                String added = query.getObject(4).toString();
                
                System.out.println("\nPlaylist ID: " + playlistId + " Playlist Title : " + title
                        + " Playlist Duration: " + duration + " Date Added: " + added);
            }
            
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
            
            ResultSet query = ps.executeQuery("SELECT * from popularity");
            while(query.next()) {
                String followers = query.getObject(1).toString();
                String likes = query.getObject(2).toString();
                
                System.out.println("\nFollowers: " + followers + " Likes: " + likes);
            }
            
        } catch (SQLException e) {
            result = "Data Not Entered!";
            e.printStackTrace();
        }
        
        return result;
    }
}
