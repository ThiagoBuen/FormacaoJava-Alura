package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.alura.forum.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Auth. Configs
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Authorization Configs
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topics").permitAll()
		.antMatchers(HttpMethod.GET, "/topics/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth*").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
		//.and().formLogin();		//sessions
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//Static resources config (js, css, imagens, etc)
		
	}
		
}
