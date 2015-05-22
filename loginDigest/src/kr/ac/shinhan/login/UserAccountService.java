package kr.ac.shinhan.login;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserAccount")
public class UserAccountService {

	private static PersistenceManagerFactory PMF;
	
	public UserAccountService() {
		PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUserAccount(UserAccount account) {
		
		
		PersistenceManager pm = PMF.getPersistenceManager();
		pm.makePersistent(account);
		
		Result result = new Result(true,"success");
		Response response = Response.ok().entity(result).build();
		
		return response;
	}
	
	@GET
	@Path("/GetUserAccount/{accountKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("accountKey") String accountKey) {
		
		PersistenceManager pm = PMF.getPersistenceManager();
		long longKey = Long.parseLong(accountKey);
		UserAccount ua = pm.getObjectById(UserAccount.class, longKey);
		
		Response response = Response.ok().entity(ua).build();
		return response;
	}
	
	@DELETE
	@Path("{accountKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("accountKey") String accountKey) {
		
		PersistenceManager pm = PMF.getPersistenceManager();
		long longKey = Long.parseLong(accountKey);
		UserAccount ua = pm.getObjectById(UserAccount.class, longKey);
		
		pm.deletePersistent(ua);
		
		Result result = new Result(true,"success");
		Response response = Response.ok().entity(result).build();
		
		return response;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(UserAccount account) {
		
		PersistenceManager pm = PMF.getPersistenceManager();
		UserAccount ua = pm.getObjectById(UserAccount.class, account.getKey());
		
		/*ua.setNicName(account.getNicName());
		ua.setPassword(account.getPassword());*/
		
		account.setKey(account.getKey());
		
		pm.makePersistent(account);
		
		Result result = new Result(true,"success");
		Response response = Response.ok().entity(result).build();
		
		return response;
	}
	
}
