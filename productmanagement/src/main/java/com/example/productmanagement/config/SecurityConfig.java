// package com.example.productmanagement.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfiguration {

//   @Autowired
//   private UserDetailsService userDetailsService;

//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//     http.authorizeRequests()
//         .antMatchers("/products/**").hasAnyRole("USER", "ADMIN")
//         .antMatchers("/addproduct", "/deleteproduct", "/updateproduct").hasRole("ADMIN")
//         .anyRequest().authenticated()
//         .and()
//         .formLogin().permitAll()
//         .and()
//         .logout().permitAll();
//   }

//   @Bean
//   public PasswordEncoder passwordEncoder() {
//     return new BCryptPasswordEncoder();
//   }

//   @Override
//   @Bean
//   public UserDetailsService userDetailsService() {
//     return super.userDetailsService();
//   }
// }
