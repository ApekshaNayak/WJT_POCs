package com.wijjit.api.utility.manager.configuration;

import com.wijjit.jwt.api.security.filter.TokenAuthenticationFilter;
import com.wijjit.jwt.api.security.handler.AuthenticationFailureHandler;
import com.wijjit.jwt.api.security.service.TokenProcessor;
import com.wijjit.jwt.api.security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationFailureHandler authenticationFailureHandler;
    private TokenProcessor tokenProcessor;
    private UserDetailServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfig(AuthenticationFailureHandler authenticationFailureHandler,
                             TokenProcessor tokenProcessor,
                             UserDetailServiceImpl userDetailsService) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.tokenProcessor = tokenProcessor;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
        return new TokenAuthenticationFilter(tokenProcessor, userDetailsService);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:4200",
                "https://wijjit.com",
                "https://www.wijjit.io",
                "https://www.wijjit.com",
                "https://wijjit-application.herokuapp.com",
                "https://wijjit-application-dev.herokuapp.com",
                "https://wijjit-application-qa.herokuapp.com"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("APIKey", "Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/token/validity/**").authenticated();


        http.exceptionHandling().accessDeniedHandler(authenticationFailureHandler);
        http.csrf().disable();
        http.cors().configurationSource(corsConfigurationSource());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(HttpMethod.GET, "/token/**")//apiKey
                .antMatchers(HttpMethod.DELETE, "/deleteUser/**")//apiKey
                .antMatchers(HttpMethod.DELETE, "/deleteCivicData/**")//apiKey
                .antMatchers(HttpMethod.GET, "/decryptPrivateKey/**")//apiKey
                .antMatchers(HttpMethod.GET, "/emailConfirmationCode/**")//apiKey
                .antMatchers(HttpMethod.GET, "/confirmationCode/**")//apiKey
                .antMatchers(HttpMethod.GET, "/deleteWalletAccounts/**")
                .antMatchers(HttpMethod.POST, "/encryptAndSaveStellarAccountKeys/**");//apiKey


    }
}
