package authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author pedro.almeida
 *  Contains all the properties that are needed to connect via ldap
 *
 */
@Configuration
public class LdapConfigurations {
	
	private String url;
	private String baseDn;
	private String ldapDomain;
	
	public LdapConfigurations(@Value("${ldap.ldapUrl}") String url, 
							  @Value("${ldap.baseDn}") String baseDn,
							  @Value("${ldap.ldapDomain}") String ldapDomain ) {
		
		this.url=url;
		this.baseDn=baseDn;
		this.ldapDomain=ldapDomain;
		
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getBaseDn() {
		return this.baseDn;
	}
	
	public String getLdapDomain() {
		return this.ldapDomain;
	}

}
