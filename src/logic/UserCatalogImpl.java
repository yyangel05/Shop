package logic;

import dao.UserDao;

public class UserCatalogImpl implements UserCatalog {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return this.userDao.findByUserIdAndPassword(userId, password);
	}

	@Override
	public void entryUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.create(user);
	}
	
	
	
	
}
