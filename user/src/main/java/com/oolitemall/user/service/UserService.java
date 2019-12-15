package com.oolitemall.user.service;

import com.oolitemall.user.dao.UserDao;

import com.oolitemall.user.domain.Admin;
import com.oolitemall.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired

    private  UserDao userDao;

    public User login(String username, String password){
        return userDao.loginuser(username,password);
    }

    public Admin addAdmin(Admin admin){
        return userDao.addAdmin(admin);
    }

    public Admin getAdminById(Integer id){
        return userDao.getAdminById(id);
    }

    public void deleteAdminById(Integer id){
        userDao.deleteAdminById(id);
    }

    public Admin updateAdminById(Integer id,Admin admin){
        admin.setId(id);
        userDao.updateAdminById(admin);
        return admin;
    }

    public boolean is_superAdmin(String name){
        if(userDao.getrole(name)==1) return true;
        else return false;
    }

    public List<Admin> getAdmin(){
        return userDao.getAdmin();
    }



}
