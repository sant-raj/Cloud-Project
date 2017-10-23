package com.cluster.daoImpl;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cluster.dao.CustomDao;
import com.cluster.to.FileTO;
import com.cluster.to.LoginTO;
import com.cluster.to.RequestTO;
import com.cluster.to.RevokeTO;
import com.cluster.to.SignUpTO;
import com.cluster.to.TransactionTO;
import com.cluster.util.CustomDateUtil;
import com.cluster.util.CustomEncryption;
import com.cluster.util.DBUtil;

public class CustomDaoImpl implements CustomDao {

	int value = 0;

	String loginStatus = "";
	String status = "";

	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ResultSet rs1 = null;

	/** DBConnection Process */
	public CustomDaoImpl() {
		con = DBUtil.getConnection();
	}

	/** Cloud Server Process */
	@Override
	public String cloudLogin(LoginTO loginTO) {
		String checkLogin = "SELECT password FROM cloud WHERE username='"
				+ loginTO.getUserName() + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(loginTO.getPassword())) {
					loginStatus = "Success";
				} else {
					loginStatus = "Sorry Password Invalid";
				}
			} else {
				loginStatus = "Sorry Username Invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	@Override
	public List<SignUpTO> members() {
		List<SignUpTO> list = new ArrayList<SignUpTO>();
		String query = "select * from user";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SignUpTO to = new SignUpTO();

				to.setId(rs.getInt(1));
				to.setFirstName(rs.getString(2));
				to.setLastName(rs.getString(3));
				to.setEmail(rs.getString(5));
				to.setLocation(rs.getString(6));
				to.setStatus(rs.getString(8));
				list.add(to);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;
	}

	@Override
	public List<TransactionTO> transaction() {
		List<TransactionTO> list = new ArrayList<TransactionTO>();
		String query = "select * from transaction  ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {

				TransactionTO transactionTO = new TransactionTO();

				transactionTO.setId(rs.getInt(1));
				transactionTO.setUser(rs.getString(2));
				transactionTO.setGroupName(rs.getString(3));
				transactionTO.setFileName(rs.getString(4));
				transactionTO.setDate(rs.getString(5));
				transactionTO.setTransaction(rs.getString(6));
				list.add(transactionTO);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;
	}

	@Override
	public Map<String, List<FileTO>> uploads() {

		Map<String, List<FileTO>> map = new HashMap<String, List<FileTO>>();
		String query = "select groupname from groups";

		try {

			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				List<FileTO> list = new ArrayList<FileTO>();

				rs1 = con
						.createStatement()
						.executeQuery(
								"select uploadby, filename, publickey, upload_date, rank from file where group_name = '"
										+ rs.getString(1) + "' ");

				while (rs1.next()) {

					FileTO to = new FileTO();
					to.setId(++value);
					to.setUploadBy(rs1.getString(1));
					to.setFileName(rs1.getString(2));
					to.setPublicKey(rs1.getString(3));
					to.setDate(rs1.getString(4));
					to.setRank(rs1.getInt(5));
					list.add(to);

				}

				map.put(rs.getString(1), list);

			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return map;
	}

	/** Group Manager Process */
	public String groupManagerLogin(LoginTO loginTO) {
		String checkLogin = "SELECT password FROM group_manager WHERE username='"
				+ loginTO.getUserName() + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(loginTO.getPassword())) {
					loginStatus = "Success";
				} else {
					loginStatus = "Sorry Password Invalid";
				}
			} else {
				loginStatus = "Sorry Username Invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	@Override
	public String addGroup(String groupName) {
		try {
			con.createStatement()
					.executeUpdate(
							"insert into groups(groupname) value('" + groupName
									+ "') ");
			status = "Group " + groupName + " added Successfully";
		} catch (SQLException e) {
			status = "Group " + groupName + " already Exists";
		}
		return status;
	}

	@Override
	public HashMap<Integer, String> groups() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		String query = "select * from groups";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				map.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return map;
	}

	@Override
	public String upload(FileTO fileTO) {

		String regQuery = "INSERT INTO file(uploadby, group_name, filename, content, publickey, upload_date, rank) VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {

			pst = con.prepareStatement(regQuery);
			pst.setString(1, fileTO.getUploadBy());
			pst.setString(2, fileTO.getGroup());
			pst.setString(3, fileTO.getFileName());
			pst.setString(4, fileTO.getEncryptedContent());
			pst.setString(5, fileTO.getPublicKey());
			pst.setString(6, fileTO.getDate());
			pst.setInt(7, 0);

			value = pst.executeUpdate();

			if (value > 0) {
				status = "File " + fileTO.getFileName()
						+ " Uploaded Successfully";

				con.createStatement()
						.executeUpdate(
								"insert into transaction(user, group_name, filename, date_time, transaction) value('"
										+ fileTO.getUploadBy()
										+ "', '"
										+ fileTO.getGroup()
										+ "', '"
										+ fileTO.getFileName()
										+ "', '"
										+ fileTO.getDate() + "', 'Upload')");
			} else {
				status = "File " + fileTO.getFileName() + " Uploading failed";
			}

		} catch (Exception e) {
			System.err.println(e);
			status = "File " + fileTO.getFileName() + " Uploading failed";
		}

		return status;
	}

	@Override
	public List<FileTO> groupUploads(String groupName) {
		List<FileTO> list = new ArrayList<FileTO>();

		String query = "select s_no, uploadby, filename, publickey, upload_date, rank from file where group_name = '"
				+ groupName + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				FileTO to = new FileTO();
				to.setId(rs.getInt(1));
				to.setUploadBy(rs.getString(2));
				to.setFileName(rs.getString(3));
				to.setPublicKey(rs.getString(4));
				to.setDate(rs.getString(5));
				to.setRank(rs.getInt(6));
				list.add(to);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;
	}

	@Override
	public String deleteFile(int id) {
		try {
			con.createStatement().executeUpdate(
					"delete from file where s_no = " + id + " ");
			status = "File Deleted successfully";
		} catch (SQLException e) {
			System.err.println(e);
		}
		return status;
	}

	@Override
	public void addUser(int id, String groupName) {
		try {
			con.createStatement().executeUpdate(
					"update user set status = '" + groupName
							+ "' where user_id = " + id + " ");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	@Override
	public void revokeUser(RevokeTO to) {
		try {
			con.createStatement().executeUpdate(
					"update user set status = 'Revoked' where user_id = "
							+ to.getId() + " ");

			con.createStatement().executeUpdate(
					"insert into revokeduser(user_id, username, groupname, revokeddate) value("
							+ to.getId() + ", '" + to.getUser() + "', '"
							+ to.getGroupName() + "', '" + to.getDate() + "')");

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	@Override
	public List<RevokeTO> revokedUser() {
		List<RevokeTO> list = new ArrayList<RevokeTO>();

		String query = "select * from revokeduser";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				RevokeTO to = new RevokeTO();

				to.setId(rs.getInt(1));
				to.setUser(rs.getString(2));
				to.setGroupName(rs.getString(3));
				to.setDate(rs.getString(4));

				list.add(to);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;
	}

	@Override
	public List<RequestTO> userRequests() {
		List<RequestTO> list = new ArrayList<RequestTO>();

		String query = "select r.file_id, r.user_email, r.request_date, r.status, f.group_name, f.filename from request r join file f on r.file_id = f.s_no ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {

				RequestTO to = new RequestTO();

				to.setFileId(rs.getInt("r.file_id"));
				to.setUserEmail(rs.getString("r.user_email"));
				to.setDate(rs.getString("r.request_date"));
				to.setStatus(rs.getString("r.status"));
				to.setGroupName(rs.getString("f.group_name"));
				to.setFileName(rs.getString("f.filename"));
				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public void permit(RequestTO to) {
		try {
			con.createStatement().executeUpdate(
					"update request set status = '" + to.getStatus()
							+ "' where file_id = " + to.getFileId()
							+ " and user_email = '" + to.getUserEmail() + "' ");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	/** Group User Process */
	@Override
	public String register(SignUpTO signUpTO) {

		String regQuery = "INSERT INTO user(first_name, last_name, date_of_birth, email, location, password, status) VALUES(?,?,?,?,?,?,?)";

		try {

			pst = con.prepareStatement(regQuery);
			pst.setString(1, signUpTO.getFirstName());
			pst.setString(2, signUpTO.getLastName());
			pst.setString(3, signUpTO.getDateOfBirth());
			pst.setString(4, signUpTO.getEmail());
			pst.setString(5, signUpTO.getLocation());
			pst.setString(6, signUpTO.getPassword());
			pst.setString(7, "Revoked");
			value = pst.executeUpdate();

			if (value > 0) {
				status = signUpTO.getFirstName() + " Registered Successfully";
			} else {
				status = "Registration failed";
			}

		} catch (SQLException e) {
			System.err.println(e);
			status = "Registration failed";
		}

		return status;
	}

	@Override
	public String groupMemberLogin(LoginTO loginTO) {
		String checkLogin = "SELECT password, status FROM user WHERE email='"
				+ loginTO.getUserName() + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkLogin);
			if (rs.next()) {
				if (rs.getString(1).equals(loginTO.getPassword())) {
					if (!rs.getString(2).equals("Revoked")) {
						loginStatus = "Success";
					} else {
						loginStatus = "You where not added in Any group, Please wait....!";
					}
				} else {
					loginStatus = "Sorry Password Invalid";
				}
			} else {
				loginStatus = "Sorry Username Invalid";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return loginStatus;
	}

	@Override
	public SignUpTO profile(String email) {
		SignUpTO to = new SignUpTO();

		String query = "select * from user where email = '" + email + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {

				to.setId(1);
				to.setFirstName(rs.getString(2));
				to.setLastName(rs.getString(3));
				to.setDateOfBirth(rs.getString(4));
				to.setEmail(rs.getString(5));
				to.setLocation(rs.getString(6));
				to.setStatus(rs.getString(8));

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return to;
	}

	@Override
	public Map<String, List<FileTO>> uploads(String email) {

		Map<String, List<FileTO>> map = new HashMap<String, List<FileTO>>();
		String query = "select status from user where email = '" + email + "' ";

		try {

			st = con.createStatement();
			rs = st.executeQuery(query);

			if (rs.next()) {

				List<FileTO> list = new ArrayList<FileTO>();

				rs1 = con
						.createStatement()
						.executeQuery(
								"select s_no, uploadby, filename, publickey, upload_date, rank from file where group_name = '"
										+ rs.getString(1) + "' ");

				while (rs1.next()) {

					FileTO to = new FileTO();
					to.setId(rs1.getInt(1));
					to.setUploadBy(rs1.getString(2));
					to.setFileName(rs1.getString(3));
					to.setPublicKey(rs1.getString(4));
					to.setDate(rs1.getString(5));
					to.setRank(rs1.getInt(6));
					list.add(to);

				}

				map.put(rs.getString(1), list);

			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return map;
	}

	@Override
	public String sendRequest(RequestTO to) {
		String requestStatus = "";
		String checkRequest = "select * from request where file_id="
				+ to.getFileId() + " and user_email='" + to.getUserEmail()
				+ "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(checkRequest);
			if (rs.next()) {

				requestStatus = " Request already sent, Please check your REQUEST_STATUS ";

			} else {
				con.createStatement().executeUpdate(
						"insert into request(file_id,user_email,request_date,status) values("
								+ to.getFileId() + ",'" + to.getUserEmail()
								+ "','" + to.getDate() + "','Pending')");
				requestStatus = "Request sent Successfully";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return requestStatus;
	}

	@Override
	public List<RequestTO> sentRequests(String email) {
		List<RequestTO> list = new ArrayList<RequestTO>();

		String query = "select r.file_id, r.request_date, r.status, f.group_name, f.filename from request r join file f on r.file_id = f.s_no where r.user_email = '"
				+ email + "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {

				RequestTO to = new RequestTO();

				to.setFileId(rs.getInt("r.file_id"));
				to.setDate(rs.getString("r.request_date"));
				to.setStatus(rs.getString("r.status"));
				to.setGroupName(rs.getString("f.group_name"));
				to.setFileName(rs.getString("f.filename"));
				list.add(to);

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return list;
	}

	@Override
	public String getContent(FileTO to) {
		String query = "select f.s_no, f.group_name, f.content from file f join request r on f.s_no = r.file_id where  f.filename = '"
				+ to.getFileName()
				+ "' and f.publickey = '"
				+ to.getPublicKey()
				+ "' and r.user_email = '"
				+ to.getUploadBy()
				+ "' and r.status = '"
				+ to.getPrivateKey()
				+ "' ";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				status = CustomEncryption.fileDecryption(rs
						.getString("f.content"));

				con.createStatement()
						.executeUpdate(
								"update file f, (select rank from file)f1 set f.rank = f1.rank+1 where f.s_no = "
										+ rs.getInt("f.s_no") + " ");

				con.createStatement().executeUpdate(
						"update request set status = 'downloaded' where file_id = "
								+ rs.getInt("f.s_no") + " and user_email = '"
								+ to.getUploadBy() + "' ");

				con.createStatement()
						.executeUpdate(
								"insert into transaction(user, group_name, filename, date_time, transaction) value('"
										+ to.getUploadBy()
										+ "', '"
										+ rs.getString("f.group_name")
										+ "', '"
										+ to.getFileName()
										+ "', '"
										+ CustomDateUtil.customDate()
										+ "', 'Download')");

			} else {
				status = "Wrong Credential";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return status;
	}

}
