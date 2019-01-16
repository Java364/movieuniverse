package academy.softserve.movieuniverse.security;

public class TokenModel {
    private String accessToken;
    /* private String refreshToken; */

    public TokenModel() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /*
     * public String getRefreshToken() { return refreshToken; }
     * 
     * public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }
     */

    @Override
    public String toString() {
        return "TokenModel{" + "accessToken='" + accessToken + '}';
    }
}
