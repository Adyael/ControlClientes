package mx.com.gm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import mx.com.gm.service.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private UserDetailsService userDetailsService; 

    @Autowired
    private PasswordEncoder passwordEncoder; 

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder.passwordEncoder());
    } 
	
	/*@Bean
    protected InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User
            .withUsername("admin")
            .password("{noop}123")
            .roles("USER", "ADMIN")
            .build();
        	
        UserDetails user = User
        	.withUsername("user")
    		.password("{noop}123")
    		.roles("USER")
    		.build();
        
        return new InMemoryUserDetailsManager(user,admin);
    }*/
	
	@Bean
	protected SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar", "/guardar").hasRole("ADMIN")
                .requestMatchers("/").hasAnyRole("USER", "ADMIN")
                .and()
                	.formLogin()
                        .loginPage("/login")
                .and()
                	.exceptionHandling()
                        .accessDeniedPage("/errores/403")
       ;

		return http.build();
	}
	
}
