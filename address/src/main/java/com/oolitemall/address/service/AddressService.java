package com.oolitemall.address.service;

import com.oolitemall.address.domain.Address;
import com.oolitemall.address.domain.AddressPo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface AddressService {

    public List<Address> getAllUserAddress(@RequestParam Integer userId, @RequestParam String name);

    public List<Address> getAllAddressById(@RequestParam Integer userId);

    public AddressPo addAddress(@RequestBody AddressPo addressPo);

    public AddressPo getAddressById(@RequestParam Integer id);

}
