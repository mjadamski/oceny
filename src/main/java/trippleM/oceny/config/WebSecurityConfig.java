package trippleM.oceny.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/").hasAnyAuthority("ROLE_USER")
                .anyRequest().permitAll()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login_temp")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/user/login?error")
                .defaultSuccessUrl("/profile");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery(
                        "SELECT email, password, enabled FROM user WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT email, role FROM user WHERE email = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

//      logout w przygotowaniu
//    protected void logout(HttpSecurity http) throws Exception {
//        http.logout().defaultLogoutSuccessHandlerFor("logout",  "logout");
//    }
}