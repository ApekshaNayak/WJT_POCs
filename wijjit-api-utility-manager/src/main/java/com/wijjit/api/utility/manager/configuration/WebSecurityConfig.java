package com.wijjit.api.utility.manager.configuration;

import com.wijjit.jwt.api.security.filter.TokenAuthenticationFilter;
import com.wijjit.jwt.api.security.handler.AuthenticationFailureHandler;
import com.wijjit.jwt.api.security.service.TokenProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationFailureHandler authenticationFailureHandler;
    private TokenProcessor tokenProcessor;
    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(AuthenticationFailureHandler authenticationFailureHandler,
                             TokenProcessor tokenProcessor,
                             UserDetailsService userDetailsService) {
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

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/refreshWijjitToken/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/endUserSession/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/retrieveUserprofile/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/retrieveUserWallets/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/refreshWijjitToken/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/changeUserPassword/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/createWallet/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/fetchWallet/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/fetchWalletsBalance/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/fetchPublicKeys/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/buyWijjit/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/emailReferral/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/stripeCharge/**").authenticated();
//
//
//        http.exceptionHandling().accessDeniedHandler(authenticationFailureHandler);
//        http.csrf().disable();
//        http.cors().configurationSource(corsConfigurationSource());
//
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
//                .antMatchers(HttpMethod.POST, "/createUser/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/receiveUserData/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/authenticateUser/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/loginWithCivic/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/loginWithoutCivic/**")//apiKey
//                .antMatchers(HttpMethod.GET, "/accountActivation/**")
//                .antMatchers(HttpMethod.GET, "/checkUserName/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/forgotUserPassword/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/forgotUserName/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/resetUserPassword/**")//apiKey
//                .antMatchers(HttpMethod.POST, "/subscribeForNewsletters/**")//apiKey
//                .antMatchers(HttpMethod.GET, "/fetchWijjitValue/**")//apiKey
//                .antMatchers(HttpMethod.GET, "/encryptChannelKeys/**")//apiKey
//                .antMatchers(HttpMethod.GET, "/unsubscribeFromNewsletters/**");//apiKey
                .antMatchers(HttpMethod.GET, "/token/**")//apiKey
                .antMatchers(HttpMethod.DELETE, "/deleteUser/**")//apiKey
                .antMatchers(HttpMethod.DELETE, "/deleteCivicData/**")//apiKey
                .antMatchers(HttpMethod.GET, "/decryptPrivateKey/**");//apiKey


    }
}
