package kg.CSoft.TechnologyTable.config;

import kg.CSoft.TechnologyTable.security.JwtAuthenticationEntryPoint;
import kg.CSoft.TechnologyTable.security.JwtSecurityConfigurer;
import kg.CSoft.TechnologyTable.security.JwtTokenProvider;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.ppolicy.PasswordPolicyAwareContextSource;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import javax.annotation.PostConstruct;

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

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

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
                .antMatchers("/api/user/findByUsername").permitAll()
                .antMatchers("/api/user/findByDn/{dn}").permitAll()
                .antMatchers("/api/user/findByCn/{cn}").permitAll()

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

    public void initIntegration() {
        try {
            authenticationManagerBuilder
                    .authenticationProvider(ldapAuthenticationProvider());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

    @Bean
    public LdapAuthenticationProvider ldapAuthenticationProvider() throws Exception {
        LdapAuthenticationProvider lAP = new LdapAuthenticationProvider(ldapAuthenticator());
        return lAP;
    }

    @Bean
    public LdapContextSource ldapContextSource() throws Exception {
        PasswordPolicyAwareContextSource contextSource = new PasswordPolicyAwareContextSource(AD_URL);
        contextSource.setUserDn(AD_USERNAME);
        contextSource.setPassword(AD_PASSWORD);
        return contextSource;
    }

    @Bean
    public LdapAuthenticator ldapAuthenticator() throws Exception {
        BindAuthenticator authenticator = new BindAuthenticator(ldapContextSource());
        authenticator.setUserDnPatterns(new String[]{AD_DN_PATTERN});
        return authenticator;
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
