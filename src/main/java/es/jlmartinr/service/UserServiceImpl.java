package es.jlmartinr.service;

import es.jlmartinr.dao.UserDao;
import es.jlmartinr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional("transactionManager")
    @Override
    public Boolean save(User user) {
        return userDao.save(user);
    }

    @Transactional(value = "transactionManager", readOnly = true)
    @Override
    public List<User> list() {
        return userDao.list();
    }
}
