package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDaoImpl implements UserDao {
	//�α����� �ϱ� ���� ���̵�� �н����带 �޾ƿ���, ���ǿ� ������ �� ����� �������� ������
	private static final String SELECT_BY_USERID_PASSWORD = "SELECT user_id, password, user_name, postcode,"
			+ " address, email, job, birthday FROM user_account WHERE user_id = ? AND password = ?";
	
	//ȸ�������� ���� sql��. user_account ���̺� ���۵� ���� ����ִ´�.
	private static final String INSERT = "INSERT INTO user_account(user_id, user_name, password, postcode, address, "
			+ "email, job, birthday) VALUES(:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)";
	
	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.template.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userId, password);
	}

	@Override
	public void create(User user) { //user��ü�� �޾� ȸ�������� �����ϴ� �޼���
		// TODO Auto-generated method stub

		//SqlParameterSource�� �̸���� �Ķ���� ���� �����ϱ� ����
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user); //user �ڹٺ��� �޾Ƽ� parameterSource��ü�� ����?
		
		this.template.update(UserDaoImpl.INSERT, parameterSource); //�ڹٺ��� ������ ������ insert���� �����ϰ� �Ѵ�?
		
	}
	
}
