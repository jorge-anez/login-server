package org.login.services.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.login.dao.GenericDAOImpl;
import org.login.model.domain.User;
import org.login.model.transfer.UserDTO;
import org.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by JORGE-HP on 20/3/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SessionFactory sessionFactory;
    private GenericDAOImpl<User, Long> userDAO;
    @PostConstruct
    public void init() {
        userDAO = new GenericDAOImpl<User, Long>(sessionFactory, User.class);
    }

    @Transactional
    public void create(UserDTO personDTO) {
        User user = new User();
        user.setFirstName(personDTO.getName());
        userDAO.save(user);
    }

    @Transactional
    public void create(User user) {
        userDAO.save(user);
    }

    public void update(UserDTO personDTO) {

    }

    @Transactional
    public User findByEmail(String email) {

        return null;
    }

    @Transactional
    public User findByUsername(String username) {
        Query query = userDAO.getNamedQuery("getRoles");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        User user = CollectionUtils.isEmpty(users) ? null : users.get(0);
       return user;
    }

    @Transactional
    public List<UserDTO> listAll() {

        return null;
    }

    @Transactional
    public void resetPassword(Integer userId) {

    }

    @Transactional
    public void changePassword(Integer userID, String newPassword) {

    }
}
