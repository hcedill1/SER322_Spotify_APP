
public class Popularity {
    private String followers, likes, trackName;
    
    public Popularity() {
        super();
    }

    public Popularity(String followers, String likes, String trackName) {
        super();
        this.followers = followers;
        this.likes = likes;
        this.trackName = trackName;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
    
    
}
