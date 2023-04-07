package fr.eql.ai113.ifidieback.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    /**
     *  This method is used to expose the AuthenticationManager as a
     *  Spring bean so that it can be used in other parts of the application.
     *  To expose the AuthenticationManager as a Spring bean, we defined this method in this @Configuration class
     *  to returns an AuthenticationManager object and annotate it with @Bean and @Override:
     * @return AuthenticationManager object annotated with @Bean and @Override
     * @throws Exception not sure which ones
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * a Spring bean configuration method that returns an instance of a SecurityFilter
     * @return an instance of a SecurityFilter
     */
    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }

    /**
     * This methods configure the security settings for HTTP requests. It specifies which endpoints require
     * authentication, which authentication mechanisms to use, and how to handle authentication failures.
     * CORS is enabled and CSRF disabled
     * @param http HttpSecurity object
     * @throws Exception yes it does throw exceptions
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Activation du CORS, désactivation du CSRF
        http = http.cors().and().csrf().disable();

        // Gestion de session en stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Gestion des requêtes non autorisées
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(new SecurityEntryPoint())
                .and();

        // Permissions sur les point d'API
        http.authorizeRequests()
                // Points publics
                .antMatchers("/security/**").permitAll()
                .antMatchers("/space/**").permitAll()
                .antMatchers("/task/**").permitAll()
                .antMatchers("/adminboard/**").hasRole("ADMIN")

                // Points privés
                .anyRequest().authenticated();

        http.addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
