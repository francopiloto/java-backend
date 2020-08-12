package demo.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired private UserDetailsService userService;

/* --------------------------------------------------------------------------------------------- */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

/* --------------------------------------------------------------------------------------------- */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        // make BCRYPT the default encoder/decoder for passwords
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

/* --------------------------------------------------------------------------------------------- */

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .cors().and()
            .csrf().disable()         // disabling CSRF verification and
            .sessionManagement()      // SESSION, since we will use JTW authentication
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

/* --------------------------------------------------------------------------------------------- */

}
