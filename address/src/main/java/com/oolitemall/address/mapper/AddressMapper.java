package com.oolitemall.address.mapper;

import com.oolitemall.address.domain.Address;
import com.oolitemall.address.domain.AddressPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {

    public List<AddressPo> getAllUserAddress(@RequestParam Integer userId, @RequestParam String name);

    public List<AddressPo> getAllAddressById(@RequestParam Integer userId);

    public Integer addAddress(@RequestBody AddressPo addressPo);

    public AddressPo getAddressById(@RequestBody Integer id);


}
