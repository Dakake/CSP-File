package kr.ac.shinhan.csp;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MemberManager {

	public static Member addMember(String name, String stdID, String telephone,
			String email, String kakaoID, boolean checkInfo, String githubID)
	{
		PersistenceManager pm = MyPersistenceManager.getManager();
		Member m = new Member(name,stdID,telephone,email,kakaoID,githubID,checkInfo);
		pm.makePersistent(m);
		
		return m;
	}
	
	public static Member getMember(String key)
	{
		PersistenceManager pm = MyPersistenceManager.getManager();
		Member m = pm.getObjectById(Member.class,key);
		
		return m;
	}
	
	public static List<Member> getMemberByName(String name)
	{
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query qry = pm.newQuery(Member.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");
	
		List<Member> memberList = (List<Member>) qry.execute(name);
		
		return memberList;
	}
	
	public static List<Member> getAllMembers()
	{
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query qry = pm.newQuery(Member.class);
		List<Member> memberList = (List<Member>) qry.execute();

		return memberList;
	}

}
