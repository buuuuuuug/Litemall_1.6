package com.oolitemall.user.mapper;

import com.oolitemall.user.domain.Admin;
import com.oolitemall.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User loginUser(String username, String password);

    void addAdmin(Admin admin);

    Admin getAdminById(Integer id);

    void deleteAdminById(Integer id);

    void updateAdminById(Admin admin);

    Integer getRole(String name);

    List<Admin> getAdmin();
}
