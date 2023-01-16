package com.example.restclienttrackingmainapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String HOME_PAGE = "/";
    private static final String SIGN_IN_PAGE = "/sign-in";
    private static final String SIGN_IN_API = "/api/sign-in";
    private static final String SIGN_OUT_API = "/api/sign-out";
    private static final String REGISTER_PAGE = "/register/**";

    private final UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests((authorize) ->
                        authorize.antMatchers("/css/**", "/bootstrap/**", "/assets/bootstrap-solid.svg",
                                        HOME_PAGE,
                                        SIGN_IN_PAGE,
                                        SIGN_IN_API,
                                        REGISTER_PAGE).permitAll()
                                .anyRequest().authenticated()
                ).formLogin(
                        form -> form
                                .loginPage(SIGN_IN_PAGE)
                                .loginProcessingUrl(SIGN_IN_API)
                                .defaultSuccessUrl(HOME_PAGE, true)
                                .failureUrl(SIGN_IN_PAGE + "?error")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutUrl(SIGN_OUT_API)
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                                .logoutSuccessUrl(HOME_PAGE)
                                .permitAll()
                );
        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}

