package authentication;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPConnectionOptions;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPURL;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.SearchResult;

public class LDAPAuthentication implements Authentication {

    LdapConfigurations ldapConfig;

    LDAPConnection ldapConnection;

	SearchResult searchResult;

	public LDAPAuthentication(LdapConfigurations ldapConfig) {
		this.ldapConfig = ldapConfig;
	}

	@Override
	public User authenticate(String username, String password) {

		try {
			LDAPURL ldapUrl = new LDAPURL(ldapConfig.getUrl());
			LDAPConnectionOptions ldapConnectionOptions = new LDAPConnectionOptions();

			ldapConnectionOptions.setConnectTimeoutMillis(50);
			ldapConnection = new LDAPConnection(ldapConnectionOptions, ldapUrl.getHost(), ldapUrl.getPort(),
					username + ldapConfig.getLdapDomain(), password);

			ldapConnection.bind(username + ldapConfig.getLdapDomain(), password);

			String lookup = String.format("(%s=%s)", "sAMAccountName", username);
			SearchRequest searchRequest = new SearchRequest(ldapConfig.getBaseDn(), SearchScope.SUB, lookup);

			searchResult = ldapConnection.search(searchRequest);

			ldapConnection.close();

		} catch (LDAPException e) {
			e.printStackTrace();

			return null;

		}

		String[] completeDN = searchCnInDn(searchResult.getSearchEntries().get(0).getDN());

		User user = new User(username, password);

		for (int i = 1; i < completeDN.length; i++) {

			String[] DnWithoutNameField = this.splitByEquals(completeDN[i]);
			

			if (DnWithoutNameField[0].equals("OU")) {
				user.getGroups().add(DnWithoutNameField[1]);
			}
		}

		return user;

	}

	private String[] searchCnInDn(String domaninName) {
		return domaninName.split(",");
	}

	private String[] splitByEquals(String completeCommonName) {
		return completeCommonName.split("=");
	}
}
