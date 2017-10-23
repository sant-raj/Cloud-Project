package com.cluster.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/************* java Packages *************/
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/************* User Defined Packages *************/
import com.cluster.serviceImpl.CustomServiceImpl;
import com.cluster.to.FileTO;
import com.cluster.to.LoginTO;
import com.cluster.to.RequestTO;
import com.cluster.to.RevokeTO;
import com.cluster.to.SignUpTO;
import com.cluster.to.TransactionTO;
import com.cluster.util.CustomDateUtil;
import com.cluster.util.CustomKey;

@MultipartConfig(maxFileSize = 16177215)
public class ControllerServlet extends HttpServlet {

	/**
	 * @ Cluster Info Solution Solution, Author (SHARANABAU)
	 */

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String path = req.getServletPath();
		CustomServiceImpl service = new CustomServiceImpl();
		HttpSession session = req.getSession();

		String status = "";

		if (path.equals("/index.do")) {

			req.getRequestDispatcher("/html/index.html").forward(req, res);

		}

		/** Cloud Process */

		if (path.equals("/cloudLogin.do")) {

			req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req, res);

		}

		if (path.equals("/cLogin.do")) {
			LoginTO loginTO = new LoginTO();
			loginTO.setUserName(req.getParameter("nme"));
			loginTO.setPassword(req.getParameter("pwd"));

			status = service.cloudLogin(loginTO);

			if (status.equals("Success")) {
				session.setAttribute("CLOUD", loginTO.getUserName());
				req.setAttribute("PATH", "/cloudMain.do");
				req.getRequestDispatcher("/jsp/cloudMain.jsp")
						.forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", status);
				req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req,
						res);
			}

		}

		if (path.equals("/cloudMain.do")) {

			if (session.getAttribute("CLOUD") != null) {
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/cloudMain.jsp")
						.forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req,
						res);
			}

		}

		if (path.equals("/cloudLogout.do")) {

			session.invalidate();
			req.setAttribute("LOGIN_STATUS", "Logout Successful....!");
			req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req, res);

		}

		if (path.equals("/groups.do")) {

			if (session.getAttribute("CLOUD") != null) {
				HashMap<Integer, String> map = service.groups();

				session.setAttribute("GROUPS", map);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/cloudMain.jsp")
						.forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req,
						res);
			}

		}

		if (path.equals("/groupMembers.do")) {

			if (session.getAttribute("CLOUD") != null) {

				List<SignUpTO> list = service.members();

				session.setAttribute("MEMBERS", list);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/cloudMain.jsp")
						.forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req,
						res);
			}

		}

		if (path.equals("/uploads.do")) {

			if (session.getAttribute("CLOUD") != null) {

				Map<String, List<FileTO>> map = service.uploads();

				session.setAttribute("UPLOADS", map);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/cloudMain.jsp")
						.forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req,
						res);
			}

		}

		if (path.equals("/transactions.do")) {

			if (session.getAttribute("CLOUD") != null) {

				List<TransactionTO> list = service.transaction();
				session.setAttribute("TRANSACTIONS", list);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/cloudMain.jsp")
						.forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/cloudLogin.jsp").forward(req,
						res);
			}

		}

		/** Group Manager Process */

		if (path.equals("/groupManagerLogin.do")) {

			req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(req,
					res);

		}

		if (path.equals("/gManagerLogin.do")) {
			LoginTO loginTO = new LoginTO();
			loginTO.setUserName(req.getParameter("nme"));
			loginTO.setPassword(req.getParameter("pwd"));

			status = service.groupManagerLogin(loginTO);

			if (status.equals("Success")) {
				session.setAttribute("GM", loginTO.getUserName());
				req.setAttribute("PATH", "/groupManagerMain.do");
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", status);
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/groupManagerMain.do")) {

			if (session.getAttribute("GM") != null) {
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/groupManagerLogout.do")) {

			session.invalidate();
			req.setAttribute("LOGIN_STATUS", "Logout Successful....!");
			req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(req,
					res);

		}

		if (path.equals("/addGroup.do")) {

			if (session.getAttribute("GM") != null) {
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/addGroup.do")) {

			if (session.getAttribute("GM") != null) {

				status = service.addGroup(req.getParameter("groupName"));

				req.setAttribute("STATUS", status);
				req.getRequestDispatcher("addGroup.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/groups.do")) {

			if (session.getAttribute("GM") != null) {

				HashMap<Integer, String> map = service.groups();

				session.setAttribute("GROUPS", map);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("addGroup.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/gmUpload.do")) {

			if (session.getAttribute("GM") != null) {
				HashMap<Integer, String> map = service.groups();

				session.setAttribute("GROUPS", map);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/encrypt.do")) {

			if (session.getAttribute("GM") != null) {
				FileTO to = new FileTO();

				to.setFileName(req.getParameter("fileName"));
				to.setContent(req.getParameter("content"));
				to.setGroup(req.getParameter("groupName"));

				FileTO fileTO = service.encrypt(to);

				req.setAttribute("ENCRYPTED_FILE", fileTO);
				req.getRequestDispatcher("encrypted.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/gmUpload.do")) {

			if (session.getAttribute("GM") != null) {
				FileTO to = new FileTO();

				to.setUploadBy((String) session.getAttribute("GM"));
				to.setFileName(req.getParameter("fileName"));
				to.setEncryptedContent(req.getParameter("content"));
				to.setGroup(req.getParameter("groupName"));
				to.setPublicKey(req.getParameter("publicKey"));
				to.setDate(CustomDateUtil.customDate());

				status = service.upload(to);

				req.setAttribute("UPLOAD_STATUS", status);
				req.getRequestDispatcher("upload.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/groupUploads.do")) {

			if (session.getAttribute("GM") != null) {

				HashMap<Integer, String> map = service.groups();
				session.setAttribute("GROUPS", map);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/groupUploads.do")) {

			if (session.getAttribute("GM") != null) {

				List<FileTO> list = service.groupUploads(req
						.getParameter("groupName"));

				req.setAttribute("GROUP_UPLOADS", list);

				req.setAttribute("STATUS",
						"Files in group " + req.getParameter("groupName"));
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("groupUploads.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/delete.do")) {

			if (session.getAttribute("GM") != null) {

				status = service.deleteFile(Integer.parseInt(req
						.getParameter("id")));

				req.setAttribute("DELETE_STATUS", status);
				req.getRequestDispatcher("groupUploads.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/users.do")) {

			if (session.getAttribute("GM") != null) {

				List<SignUpTO> list = service.members();

				session.setAttribute("MEMBERS", list);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/addUser.do")) {

			if (session.getAttribute("GM") != null) {

				HashMap<Integer, String> map = service.groups();

				session.setAttribute("GROUPS", map);
				req.setAttribute("id", req.getParameter("id"));
				req.getRequestDispatcher("addUser.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/add.do")) {

			if (session.getAttribute("GM") != null) {

				service.addUser(Integer.parseInt(req.getParameter("id")),
						req.getParameter("groupName"));

				List<SignUpTO> list = service.members();
				session.setAttribute("MEMBERS", list);

				req.getRequestDispatcher("users.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/revokeUser.do")) {

			if (session.getAttribute("GM") != null) {

				RevokeTO to = new RevokeTO();
				to.setId(Integer.parseInt(req.getParameter("id")));
				to.setUser(req.getParameter("firstName"));
				to.setGroupName(req.getParameter("groupName"));
				to.setDate(CustomDateUtil.customDate());

				service.revokeUser(to);

				List<SignUpTO> list = service.members();
				session.setAttribute("MEMBERS", list);

				req.getRequestDispatcher("users.jsp").forward(req, res);

			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/userRequests.do")) {

			if (session.getAttribute("GM") != null) {

				List<RequestTO> list = service.userRequests();

				session.setAttribute("USER_REQUESTS", list);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/permit.do")) {

			if (session.getAttribute("GM") != null) {

				RequestTO to = new RequestTO();

				to.setFileId(Integer.parseInt(req.getParameter("fileId")));
				to.setUserEmail(req.getParameter("userEmail"));
				to.setStatus(CustomKey.generateKey());

				service.permit(to);

				List<RequestTO> list = service.userRequests();

				session.setAttribute("USER_REQUESTS", list);
				req.getRequestDispatcher("userRequests.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/revokedUser.do")) {

			if (session.getAttribute("GM") != null) {

				List<RevokeTO> list = service.revokedUser();

				session.setAttribute("REVOKED_USERS", list);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupManagerMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupManagerLogin.jsp").forward(
						req, res);
			}

		}

		/** Group Member Process */

		if (path.equals("/groupMemberLogin.do")) {

			req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(req,
					res);

		}

		if (path.equals("/register.do")) {

			req.getRequestDispatcher("/jsp/register.jsp").forward(req, res);

		}

		if (path.equalsIgnoreCase("/userRegister.do")) {

			SignUpTO signUpTO = new SignUpTO();

			signUpTO.setFirstName(req.getParameter("First_Name"));
			signUpTO.setLastName(req.getParameter("Last_Name"));
			signUpTO.setDateOfBirth(req.getParameter("dob"));
			signUpTO.setEmail(req.getParameter("Email_Id"));
			signUpTO.setLocation(req.getParameter("Location"));
			signUpTO.setPassword(req.getParameter("Password2"));

			status = service.register(signUpTO);

			req.setAttribute("SIGNUP_STATUS", status);
			req.getRequestDispatcher("/jsp/register.jsp").forward(req, res);
		}

		if (path.equals("/gMemberLogin.do")) {
			LoginTO loginTO = new LoginTO();
			loginTO.setUserName(req.getParameter("nme"));
			loginTO.setPassword(req.getParameter("pwd"));

			status = service.groupMemberLogin(loginTO);

			if (status.equals("Success")) {
				session.setAttribute("MEMBER", loginTO.getUserName());
				req.setAttribute("PATH", "/groupMemberMain.do");
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS", status);
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/groupMemberMain.do")) {

			if (session.getAttribute("MEMBER") != null) {
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/groupMemberLogout.do")) {

			session.invalidate();
			req.setAttribute("LOGIN_STATUS", "Logout Successful....!");
			req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(req,
					res);

		}

		if (path.equals("/profile.do")) {

			if (session.getAttribute("MEMBER") != null) {

				SignUpTO to = service.profile((String) session
						.getAttribute("MEMBER"));

				session.setAttribute("PROFILE", to);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/mUpload.do")) {

			if (session.getAttribute("MEMBER") != null) {

				SignUpTO to = service.profile((String) session
						.getAttribute("MEMBER"));

				session.setAttribute("PROFILE", to);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/mEncrypt.do")) {

			if (session.getAttribute("MEMBER") != null) {
				FileTO to = new FileTO();

				to.setFileName(req.getParameter("fileName"));
				to.setContent(req.getParameter("content"));
				to.setGroup(req.getParameter("groupName"));

				FileTO fileTO = service.encrypt(to);

				req.setAttribute("ENCRYPTED_FILE", fileTO);
				req.getRequestDispatcher("mEncrypted.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/mUpload.do")) {

			if (session.getAttribute("MEMBER") != null) {
				FileTO to = new FileTO();

				to.setUploadBy((String) session.getAttribute("MEMBER"));
				to.setFileName(req.getParameter("fileName"));
				to.setEncryptedContent(req.getParameter("content"));
				to.setGroup(req.getParameter("groupName"));
				to.setPublicKey(req.getParameter("publicKey"));
				to.setDate(CustomDateUtil.customDate());

				status = service.upload(to);

				req.setAttribute("UPLOAD_STATUS", status);
				req.getRequestDispatcher("mUpload.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/groupFiles.do")) {

			if (session.getAttribute("MEMBER") != null) {

				Map<String, List<FileTO>> map = service
						.uploads((String) session.getAttribute("MEMBER"));

				session.setAttribute("UPLOADS", map);

				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/sendRequest.do")) {

			if (session.getAttribute("MEMBER") != null) {

				RequestTO to = new RequestTO();

				to.setFileId(Integer.parseInt(req.getParameter("id")));
				to.setUserEmail((String) session.getAttribute("MEMBER"));
				to.setDate(CustomDateUtil.customDate());
				to.setStatus("Pending");

				status = service.sendRequest(to);

				Map<String, List<FileTO>> map = service
						.uploads((String) session.getAttribute("MEMBER"));

				session.setAttribute("UPLOADS", map);
				req.setAttribute("REQUEST_STATUS", status);
				req.getRequestDispatcher("groupFiles.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/sentRequests.do")) {

			if (session.getAttribute("MEMBER") != null) {

				List<RequestTO> list = service.sentRequests((String) session
						.getAttribute("MEMBER"));

				session.setAttribute("SENT_REQUESTS", list);
				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/download.do")) {

			if (session.getAttribute("MEMBER") != null) {

				req.setAttribute("PATH", path);
				req.getRequestDispatcher("/jsp/groupMemberMain.jsp").forward(
						req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

		if (path.equals("/jsp/download.do")) {

			if (session.getAttribute("MEMBER") != null) {

				FileTO to = new FileTO();

				to.setFileName(req.getParameter("fileName"));
				to.setPublicKey(req.getParameter("publicKey"));
				to.setPrivateKey(req.getParameter("privateKey"));
				to.setUploadBy((String) session.getAttribute("MEMBER"));

				status = service.getContent(to);

				req.setAttribute("CONTENT", status);
				req.getRequestDispatcher("download.jsp").forward(req, res);
			} else {
				req.setAttribute("LOGIN_STATUS",
						"Please Login to Continue....!");
				req.getRequestDispatcher("/jsp/groupMemberLogin.jsp").forward(
						req, res);
			}

		}

	}
}
