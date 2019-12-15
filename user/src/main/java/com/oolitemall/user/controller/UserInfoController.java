package com.oolitemall.user.controller;


import com.oolitemall.user.domain.Admin;
import com.oolitemall.user.domain.User;
import com.oolitemall.user.service.UserService;
import com.oolitemall.user.util.GetMessageCode;
import com.oolitemall.user.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * AdminController
 *
 * @author YangHong
 * @date 2019-12-03
 */
@RestController

public class UserInfoController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    User userLogin(@RequestBody User body){
        return userService.login(body.getName(),body.getPassword());
    }

    @PostMapping("/regCaptcha")
    String registerCaptcha(@PathVariable String phone){
        return GetMessageCode.getCode(phone);
    }



    @PostMapping("/admins")
    Admin addAdmin(@RequestBody Admin body){
        return userService.addAdmin(body);

    }

      @GetMapping("/admins/{id}")
      Admin getAdminById(@PathVariable Integer id){
            return userService.getAdminById(id);
      }

    @GetMapping("/admins")
    Object gerAdmin(@RequestParam String AdminName){
           if(userService.is_superAdmin(AdminName)) return userService.getAdmin();
           else return ResponseUtil.unauthz();
    }


    @DeleteMapping("/admins/{id}")
    void deleteAdminById(@PathVariable  Integer id){
        userService.deleteAdminById(id);
    }

    @PutMapping("/admins/{id}")
    Admin updataAdminById(@PathVariable  Integer id,@RequestBody Admin body){
               return userService.updateAdminById(id,body);
    }

}
