
public class Artist {
    private String artistId, albumName, fans, trackName;
    
    public Artist() {
        super();
    }

    public Artist(String artistId, String albumName, String fans, String trackName) {
        super();
        this.artistId = artistId;
        this.albumName = albumName;
        this.fans = fans;
        this.trackName = trackName;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
    
    
}
