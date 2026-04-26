package users;

import enums.Language;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Language language;

    public User() {
    }

    public User(int id, String username, String password, String name, String email, Language language) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.language = language;
    }

    public boolean signIn(String username, String password) {
        System.out.println("signIn called");
        return this.username.equals(username) && this.password.equals(password);
    }
    
    
    
//    added sign out and switch language
    public void signOut() { 
        System.out.println("signOut called");
    }
    
    public void switchLanguage(Language l) {
    	this.language = l;
    }
    
    
    

    public void viewNews() {
        System.out.println("viewNews called");
    }

    public void commentNews(String text) {
        System.out.println("commentNews called: " + text);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", language=" + language +
                '}';
    }
}