package com.oolitemall.user.dao;

import com.oolitemall.user.domain.Admin;
import com.oolitemall.user.domain.User;
import com.oolitemall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public User loginuser(String username, String password){
        return userMapper.loginUser(username,password);
    }

    public Admin addAdmin(Admin admin){
         userMapper.addAdmin(admin);
         return admin;
    }

    public  Admin getAdminById(Integer id){
        return  userMapper.getAdminById(id);
    }

    public void deleteAdminById(Integer id){
        userMapper.deleteAdminById(id);
    }

    public Admin updateAdminById ( Admin admin){
        userMapper.updateAdminById(admin);
        return admin;
    }

    public List<Admin> getAdmin(){
        return userMapper.getAdmin();
    }

    public Integer getrole(String name){
        return userMapper.getRole(name);
    }
}
