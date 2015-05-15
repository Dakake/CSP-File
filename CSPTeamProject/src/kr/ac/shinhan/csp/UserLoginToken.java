package kr.ac.shinhan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserLoginToken {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private String token;
	
	@Persistent
	private String userAccount;
	
	@Persistent
	private String exprieDate;

	public UserLoginToken(String token, String userAccount, String exprieDate) {
		super();
		this.token = token;
		this.userAccount = userAccount;
		this.exprieDate = exprieDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public String getExprieDate() {
		return exprieDate;
	}

	public void setExprieDate(String exprieDate) {
		this.exprieDate = exprieDate;
	}

	public Long getKey() {
		return key;
	}
	
}
