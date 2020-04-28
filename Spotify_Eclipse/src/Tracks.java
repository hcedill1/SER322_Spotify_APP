
public class Tracks {
    private String trackName, trackDur, albumId;
    
    public Tracks() {
        super();
    }

    public Tracks(String trackName, String trackDur, String albumId) {
        super();
        this.trackName = trackName;
        this.trackDur = trackDur;
        this.albumId = albumId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackDur() {
        return trackDur;
    }

    public void setTrackDur(String trackDur) {
        this.trackDur = trackDur;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
    
    
    
}
