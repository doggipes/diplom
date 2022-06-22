package ru.itis.diplom.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.itis.diplom.model.enumeration.Permission;
import ru.itis.diplom.security.details.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurationBase extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationFailureHandler authenticationFailureHandler;
    @Qualifier(value = "customUserDetailsService")
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers(HttpMethod.GET, "/auth", "/login").permitAll()
                    .antMatchers(HttpMethod.POST, "/auth", "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority(Permission.ADMIN_READ.getPermission(),
                                                                                        Permission.OPERATOR_READ.getPermission(),
                                                                                        Permission.INSPECTOR_READ.getPermission())
                    .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(Permission.ADMIN_READ.getPermission())
                    .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Permission.ADMIN_READ.getPermission())
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/api/v1/tasks")
                    .failureHandler(authenticationFailureHandler)
                    .permitAll()
                .and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login")
    //                .deleteCookies("JSESSIONID", "remember-me", "SESSION")
                    .invalidateHttpSession(true);

//        http.formLogin()
//                .loginPage("/login")
//                .usernameParameter("email")
//                .defaultSuccessUrl("/api/v1/tasks")
//                .failureUrl("/login")
//                .permitAll();
//        http.authorizeRequests()
//                .antMatchers("/signUp").permitAll()
//                .antMatchers("/profile", "/feed", "/support", "/support-admin").authenticated();
//                .and()
//                .rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository());

//        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
////                .deleteCookies("JSESSIONID", "remember-me", "SESSION")
//                .invalidateHttpSession(true);

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
    }

//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
//        return jdbcTokenRepository;
//    }


}
