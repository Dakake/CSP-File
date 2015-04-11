package kr.ac.shinhan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Member {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String name;
	@Persistent
	private String stdID;
	@Persistent
	private String telephone;
	@Persistent
	private String email;
	@Persistent
	private String kakaoID;
	@Persistent
	private String githubID;
	@Persistent
	private boolean checkInfo;
	
	public Member(String name, String stdID, String telephone, String email,
			String kakaoID, String githubID, boolean checkInfo) {
		super();
		this.name = name;
		this.stdID = stdID;
		this.telephone = telephone;
		this.email = email;
		this.kakaoID = kakaoID;
		this.githubID = githubID;
		this.checkInfo = checkInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStdID() {
		return stdID;
	}

	public void setStdID(String stdID) {
		this.stdID = stdID;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKakaoID() {
		return kakaoID;
	}

	public void setKakaoID(String kakaoID) {
		this.kakaoID = kakaoID;
	}

	public String getGithubID() {
		return githubID;
	}

	public void setGithubID(String githubID) {
		this.githubID = githubID;
	}

	public boolean isCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(boolean checkInfo) {
		this.checkInfo = checkInfo;
	}

	public Long getId() {
		return id;
	}
	
}
