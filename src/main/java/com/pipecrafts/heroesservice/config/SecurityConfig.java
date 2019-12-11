package com.pipecrafts.heroesservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.cors().and()
          .authorizeRequests()
          // when heroes scope is present, allow request to /api/heroes**
          .mvcMatchers("/heroes/**").hasAuthority("SCOPE_heroes")
          .anyRequest().denyAll()
          .and()
          .oauth2ResourceServer()
          .jwt();
   }


}
