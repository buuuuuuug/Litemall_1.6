package com.oolitemall.address.service.Impl;

import com.oolitemall.address.dao.AddressDao;
import com.oolitemall.address.domain.Address;
import com.oolitemall.address.domain.AddressPo;
import com.oolitemall.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;

    public List<Address> getAllUserAddress(@RequestParam Integer userId, @RequestParam String name) {

        return addressDao.getAllUserAddress(userId,name);

    }

    public List<Address> getAllAddressById(@RequestParam Integer userId) {
        return addressDao.getAllAddressById(userId);
    }

    public AddressPo addAddress(@RequestBody AddressPo addressPo){
        return addressDao.addAddress(addressPo);
    }

    public AddressPo getAddressById(@RequestParam Integer id) {
        return addressDao.getAddressById(id);
    }

}
