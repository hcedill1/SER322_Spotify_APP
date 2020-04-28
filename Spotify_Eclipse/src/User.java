
public class User {
    private String userId, followers;
    
    public User() {
        super();
    }

    public User(String userId, String followers) {
        super();
        this.userId = userId;
        this.followers = followers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    
}
