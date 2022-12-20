package common.bankarskiSistem.config;


import common.bankarskiSistem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    private final UserRepository userRepository;

    private final static String[] AUTH_WHITELIST = {
            "/swagger-ui/index.html",
            "/swagger-ui.html",
            "/**/auth/**",
            "/swagger-ui/index.html/*",
            "/v3/api-docs/",
            "/v3/**",
            "/swagger-ui/",
            "/swagger-resources/",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-resources/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/users/update").hasAuthority("user_admin")
                .antMatchers("/users/add").hasAuthority("user_admin")
                .antMatchers("/users/delete").hasAuthority("user_admin")
                .antMatchers("/users").hasAuthority("user_admin")
                .antMatchers("/bank/add").hasAuthority("bank_admin")
                .antMatchers("/bank/update").hasAuthority("bank_admin")
                .antMatchers("/bank/delete").hasAuthority("bank_admin")
                .antMatchers("/users/addBankAccount").hasAuthority("account_admin")
                .antMatchers("/users/deleteBankAccount").hasAuthority("account_admin")
                .antMatchers("/users/deleteAllBankAccounts").hasAuthority("account_admin")
                .antMatchers("/users/getBankAccount").hasAuthority("account_admin")
                .antMatchers("/users/getBankAccountBalance").hasAuthority("account_admin")
                .antMatchers("/users/getAllBankAccounts").hasAuthority("account_admin")
                .antMatchers("/users/getAllBalance").hasAuthority("account_admin")
                .antMatchers("/users/payOut").hasAuthority("user_payment")
                .antMatchers("/users/payIn").hasAuthority("user_payment")
                .antMatchers("/users/transfer").hasAuthority("user_transfer")
                .antMatchers("/users/**").authenticated()
                .antMatchers("/bank/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return personalID -> userRepository.findByPersonalId(personalID)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
