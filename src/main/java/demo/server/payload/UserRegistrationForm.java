package demo.server.payload;

public class UserRegistrationForm
{
    private String username;
    private String password;
    private String confirmation;

/* --------------------------------------------------------------------------------------------- */

    public String getUsername() {
        return username;
    }

/* --------------------------------------------------------------------------------------------- */

    public String getPassword() {
        return password;
    }

/* --------------------------------------------------------------------------------------------- */

    public String getConfirmation() {
        return confirmation;
    }

/* --------------------------------------------------------------------------------------------- */

    public void setUsername(String username) {
        this.username = username;
    }

/* --------------------------------------------------------------------------------------------- */

    public void setPassword(String password) {
        this.password = password;
    }

/* --------------------------------------------------------------------------------------------- */

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

/* --------------------------------------------------------------------------------------------- */

}
