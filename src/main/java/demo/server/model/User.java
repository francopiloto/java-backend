package demo.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "users")
public class User
{
    private Long id;

    private String username;
    private String password;

/* --------------------------------------------------------------------------------------------- */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

/* --------------------------------------------------------------------------------------------- */

    @NotNull
    @Size(min = 5, max = 20)
    @Column(unique = true)
    public String getUsername() {
        return username;
    }

/* --------------------------------------------------------------------------------------------- */

    @NotNull
    @Size(min = 5, max = 100)
    @JsonIgnore
    public String getPassword() {
        return password;
    }

/* --------------------------------------------------------------------------------------------- */

    public void setId(Long id) {
        this.id = id;
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

}
