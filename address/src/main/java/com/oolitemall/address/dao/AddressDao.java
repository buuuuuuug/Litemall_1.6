package com.oolitemall.address.dao;

import com.oolitemall.address.domain.Address;
import com.oolitemall.address.domain.AddressPo;
import com.oolitemall.address.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AddressDao {

    @Autowired
    AddressMapper addressMapper;

    public List<Address> getAllUserAddress(@RequestParam Integer userId, @RequestParam String name) {
        List<AddressPo> addressPoList = addressMapper.getAllUserAddress(userId, name);
        List<Address> addresses = null;
        for(AddressPo addressPo: addressPoList) {
            Address address = (Address) addressPo;
            addresses.add(address);
        }
        return addresses;
    }

    public List<Address> getAllAddressById(@RequestParam Integer userId) {

        List<AddressPo> addressPoList = addressMapper.getAllAddressById(userId);
        List<Address> addresses = null;
        for(AddressPo addressPo: addressPoList) {
            Address address = (Address) addressPo;
            addresses.add(address);
        }
        return addresses;
    }

    public AddressPo addAddress(@RequestBody AddressPo addressPo){
        AddressPo addressPo1 = addressPo;
        addressPo1.setBeDeleted(false);
        addressPo1.setGmtCreate(LocalDateTime.now());
        addressPo1.setGmtModified(LocalDateTime.now());
        if(addressMapper.addAddress(addressPo1)>0)
            return addressPo1;
        else
            return null;
    }

    public AddressPo getAddressById(@RequestParam Integer id) {
        return addressMapper.getAddressById(id);
    }

}
