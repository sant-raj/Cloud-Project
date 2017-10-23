package com.cluster.serviceImpl;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cluster.daoImpl.CustomDaoImpl;
import com.cluster.service.CustomService;
import com.cluster.to.FileTO;
import com.cluster.to.LoginTO;
import com.cluster.to.RequestTO;
import com.cluster.to.RevokeTO;
import com.cluster.to.SignUpTO;
import com.cluster.to.TransactionTO;
import com.cluster.util.CustomDigitalSign;
import com.cluster.util.CustomEncryption;
import com.cluster.util.SendDetailsByMail;

public class CustomServiceImpl implements CustomService {

	String loginStatus = "";
	String signUpStatus = "";

	CustomDaoImpl dao = new CustomDaoImpl();

	/** Cloud Process */
	@Override
	public String cloudLogin(LoginTO loginTO) {
		return dao.cloudLogin(loginTO);
	}

	@Override
	public List<SignUpTO> members() {
		return dao.members();
	}

	@Override
	public List<TransactionTO> transaction() {
		return dao.transaction();
	}

	@Override
	public Map<String, List<FileTO>> uploads() {
		return dao.uploads();
	}

	/** Group Manager Process */
	public String groupManagerLogin(LoginTO loginTO) {
		return dao.groupManagerLogin(loginTO);
	}

	@Override
	public String addGroup(String groupName) {
		return dao.addGroup(groupName);
	}

	@Override
	public HashMap<Integer, String> groups() {
		return dao.groups();
	}

	@Override
	public FileTO encrypt(FileTO fileTO) {
		fileTO.setEncryptedContent(CustomEncryption.fileEncryption(fileTO
				.getContent()));
		fileTO.setPublicKey(CustomDigitalSign.digitalSign(fileTO
				.getEncryptedContent()));

		return fileTO;
	}

	@Override
	public String upload(FileTO fileTO) {
		return dao.upload(fileTO);
	}

	@Override
	public List<FileTO> groupUploads(String groupName) {
		return dao.groupUploads(groupName);
	}

	@Override
	public String deleteFile(int id) {
		return dao.deleteFile(id);
	}

	@Override
	public void addUser(int id, String groupName) {
		dao.addUser(id, groupName);
	}

	@Override
	public void revokeUser(RevokeTO to) {
		dao.revokeUser(to);
	}

	@Override
	public List<RevokeTO> revokedUser() {
		return dao.revokedUser();
	}
	
	@Override
	public List<RequestTO> userRequests() {
		return dao.userRequests();
	}
	
	@Override
	public void permit(RequestTO to) {
		SendDetailsByMail.sendOTP(to);
		dao.permit(to);
	}

	/** Group User Process */
	@Override
	public String register(SignUpTO signUpTO) {
		return dao.register(signUpTO);
	}

	@Override
	public String groupMemberLogin(LoginTO loginTO) {
		return dao.groupMemberLogin(loginTO);
	}

	@Override
	public SignUpTO profile(String email) {
		return dao.profile(email);
	}

	@Override
	public Map<String, List<FileTO>> uploads(String email) {
		return dao.uploads(email);
	}

	@Override
	public String sendRequest(RequestTO to) {
		return dao.sendRequest(to);
	}

	@Override
	public List<RequestTO> sentRequests(String email) {
		return dao.sentRequests(email);
	}

	@Override
	public String getContent(FileTO to) {
		return dao.getContent(to);
	}

	

}
