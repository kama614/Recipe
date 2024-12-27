package dao;

import dto.Admin;

public interface AdminDao {
	Admin findByLoginIdAndLoginPass(String loginId, String loginPass)
			throws Exception;

}
