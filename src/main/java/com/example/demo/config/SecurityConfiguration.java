package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Basic authentication.
 * {@link WebSecurityConfigurerAdapter} helps in requiring the user to be authenticated prior to accessing
 * any configured URL (or all urls) within our application.
 */

@Configuration
// Configures spring security from the class WebSecurityConfigurer.

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Value("${spring.queries.users-query}")
  private String usersQuery;

  @Value("${spring.queries.roles-query}")
  private String rolesQuery;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(usersQuery)
            .authoritiesByUsernameQuery(rolesQuery)
            .passwordEncoder(passwordEncoder());
  }

  /**
   * Defines which URL paths should be secured and which should not.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            // Allow all requests to the H2 database console
            .antMatchers("/h2/**").permitAll()
            // Allow all requests to the users controller
            .antMatchers("/users/**").permitAll()
            .anyRequest().authenticated()
            .and()
            // // Authenticate users with HTTP basic authentication
            .httpBasic()
            .and()
            // Prevent session cookies from being stored in the browser
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Needed for H2
    http.csrf().disable(); // Disable CRSF (Cross-Site Request Forgery)
    http.headers().frameOptions().disable(); // Disable X-Frame-Options
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
