
package model;


public class AppContext {
    
    
    private static AppContext instance;
    private User currentUser;

    private AppContext() {}

    public static synchronized AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
