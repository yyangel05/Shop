package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDaoImpl implements UserDao {
	//로그인을 하기 위해 아이디와 패스워드를 받아오고, 조건에 맞으면 그 사람의 정보들을 가져옴
	private static final String SELECT_BY_USERID_PASSWORD = "SELECT user_id, password, user_name, postcode,"
			+ " address, email, job, birthday FROM user_account WHERE user_id = ? AND password = ?";
	
	//회원가입을 위한 sql문. user_account 테이블에 전송된 값을 집어넣는다.
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
	public void create(User user) { //user객체를 받아 회원가입을 수행하는 메서드
		// TODO Auto-generated method stub

		//SqlParameterSource는 이름기반 파라미터 값을 설정하기 위함
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user); //user 자바빈을 받아서 parameterSource객체를 생성?
		
		this.template.update(UserDaoImpl.INSERT, parameterSource); //자바빈의 내용을 보내서 insert문을 실행하게 한다?
		
	}
	
}
