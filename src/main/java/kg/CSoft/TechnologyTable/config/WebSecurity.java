package kg.CSoft.TechnologyTable.config;

import kg.CSoft.TechnologyTable.security.JwtAuthenticationEntryPoint;
import kg.CSoft.TechnologyTable.security.JwtSecurityConfigurer;
import kg.CSoft.TechnologyTable.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Value("${ldap.urls}")
    private String AD_URL;
    @Value("${ldap.base.dn}")
    private String AD_BASE_DN;
    @Value("${ldap.user.dn.pattern}")
    private String AD_DN_PATTERN;
    @Value("${ldap.username}")
    private String AD_USERNAME;
    @Value("${ldap.password}")
    private String AD_PASSWORD;

    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()

                .httpBasic()
                .disable()

                .cors()

                .and()

                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())

                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                //ProjectController
                .antMatchers("/api/project/addAccess/{id}").permitAll()
                .antMatchers("/api/project").permitAll()
                .antMatchers("/api/project/{id}").permitAll()
                .antMatchers("/api/project/{id}").permitAll()
                .antMatchers("/api/project/{id}").permitAll()
                .antMatchers("/api/project").permitAll()
                .antMatchers("/api/project/search").permitAll()

                //HostController
                .antMatchers("/api/host").permitAll()
                .antMatchers("/api/host/{id}").permitAll()
                .antMatchers("/api/host/{id}").permitAll()
                .antMatchers("/api/host/{id}").permitAll()
                .antMatchers("/api/host/").permitAll()
                .antMatchers("/api/host/getById/{subNetworkId}").permitAll()

                //SubNetworkController
                .antMatchers("/api/subNetwork").permitAll()
                .antMatchers("/api/subNetwork/{id}").permitAll()
                .antMatchers("/api/subNetwork/{id}").permitAll()
                .antMatchers("/api/subNetwork/{id}").permitAll()
                .antMatchers("/api/subNetwork/getById/{projectId}").permitAll()
                .antMatchers("/api/subNetwork").permitAll()

                //UserController
                .antMatchers("/api/user").permitAll()
                .antMatchers("/api/user/findByDn/{dn}").permitAll()
                .antMatchers("/api/user/findByCn/{cn}").permitAll()
                .antMatchers("/api/user/findAllMemberOfUser").permitAll()

                //RoleController
                .antMatchers("/api/role").permitAll()

                //SearchController
                .antMatchers("/api/search").permitAll()

                //Security
                .antMatchers("/api/security/sign-in").permitAll()

                //Swagger
                .antMatchers(AUTH_WHITELIST).permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns(AD_DN_PATTERN)
                .contextSource(contextSource())
        ;

    }

    @Bean
    public BaseLdapPathContextSource contextSource() throws Exception {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(AD_URL);
        contextSource.setUserDn(AD_USERNAME);
        contextSource.setPassword(AD_PASSWORD);
        return contextSource;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
