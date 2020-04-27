
public class Music {
    private String album, artist, genre, playlist, popularity, tracks, user;
    
    public Music() {
        super();
    }

    public Music(String album, String artist, String genre, String playlist, String popularity, String tracks,
            String user) {
        super();
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.playlist = playlist;
        this.popularity = popularity;
        this.tracks = tracks;
        this.user = user;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
