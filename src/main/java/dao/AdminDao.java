package dao;

import dto.Admin;

public interface AdminDao {
	Admin findByLoginIdAndPass(String loginId, String loginPass)
			throws Exception;

}
