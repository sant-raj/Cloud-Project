package com.cluster.dao;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cluster.to.FileTO;
import com.cluster.to.LoginTO;
import com.cluster.to.RequestTO;
import com.cluster.to.RevokeTO;
import com.cluster.to.SignUpTO;
import com.cluster.to.TransactionTO;

public interface CustomDao {

	/** Cloud Process */
	public String cloudLogin(LoginTO loginTO);

	public List<SignUpTO> members();

	public List<TransactionTO> transaction();
	
	public Map<String, List<FileTO>> uploads();

	/** Group Manager Process */
	public String groupManagerLogin(LoginTO loginTO);

	public String addGroup(String groupName);

	public HashMap<Integer, String> groups();

	public String upload(FileTO fileTO);

	public List<FileTO> groupUploads(String groupName);
	
	public String deleteFile(int id);
	
	public void addUser(int id, String groupName);
	
	public void revokeUser(RevokeTO to);
	
	public List<RevokeTO> revokedUser();
	
	public List<RequestTO> userRequests();
	
	public void permit(RequestTO to);

	/** Group User Process */
	public String register(SignUpTO signUpTO);
	
	public String groupMemberLogin(LoginTO loginTO);
	
	public SignUpTO profile(String email);
	
	public Map<String, List<FileTO>> uploads(String email);
	
	public String sendRequest(RequestTO to);
	
	public List<RequestTO> sentRequests(String email);
	
	public String getContent(FileTO to);
}
