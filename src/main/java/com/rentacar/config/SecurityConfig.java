package com.rentacar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.login, u.password, 1 FROM user u WHERE u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login, r.role, 1 " +
                        "FROM user u " +
                        "INNER JOIN user_role ur ON ur.user_id = u.id " +
                        "INNER JOIN role r ON r.role_id = ur.role_id " +
                        "WHERE u.login=?")
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // NOT WORKING - roles

        http.authorizeRequests()
                .antMatchers("/clients/**").hasRole("USER")
                .antMatchers("/rentals/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();

        http.csrf().disable().headers().frameOptions().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
