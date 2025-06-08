package travel.management.system;

public class UserSession {
    private static String username;

    public static void setUsername(String user) {
        username = user;
    }

    public static String getUsername() {
        return username;
    }
}
