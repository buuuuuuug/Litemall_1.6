package com.oolitemall.address.controller;

import com.oolitemall.address.domain.Address;
import com.oolitemall.address.domain.AddressPo;
import com.oolitemall.address.service.AddressService;
import com.oolitemall.address.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**

 * 用户地址服务

 */
@RestController
@RequestMapping("/addressService")
@Validated
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**

     * 管理员查询用户地址信息

     * @param userId
     * @param name
     * @param page
     * @param limit

     * @return 用户购物车信息

     */

    @GetMapping("/admin/addresses")
    public Object userAddress(@RequestParam Integer userId,
                            @RequestParam String name,
                            @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer limit
                            ) {

        if(userId<0)
            return ResponseUtil.badArgumentValue();
        List<Address> subList=null;
        List<Address> addressList= addressService.getAllUserAddress(userId,name);
        if(addressList==null)
            return ResponseUtil.ok(addressList);
        int page_count=addressList.size()/limit;
        int remain=addressList.size()%limit;
        if(remain>0)
            page_count++;
        if(page>page_count)
            return ResponseUtil.fail(402,"page值超限");
        if(remain==0) {
            subList=addressList.subList((page-1)*limit,page*limit);
        }
        else{
            if (page==page_count){
                subList=addressList.subList((page-1)*limit,addressList.size());
            }else{
                subList=addressList.subList((page-1)*limit,page*limit);
            }
        }
        return ResponseUtil.ok(subList);

    }


    /**

     * 用户查询所有地址信息

     *
     * @param page
     * @param limit

     * @return 用户地址信息

     */

    @GetMapping("/addresses")

    public Object listAllAddress(HttpServletRequest request,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer limit) {

        Integer userId = 1;

        List<Address> subList=null;
        List<Address> addressList= addressService.getAllAddressById(userId);
        if(addressList==null)
            return ResponseUtil.ok(addressList);
        int page_count=addressList.size()/limit;
        int remain=addressList.size()%limit;
        if(remain>0)
            page_count++;
        if(page>page_count)
            return ResponseUtil.fail(402,"page值超限");
        if(remain==0) {
            subList=addressList.subList((page-1)*limit,page*limit);
        }
        else{
            if (page==page_count){
                subList=addressList.subList((page-1)*limit,addressList.size());
            }else{
                subList=addressList.subList((page-1)*limit,page*limit);
            }
        }
        return ResponseUtil.ok(subList);


    }


    /**

     * 用户查询地址信息

     *
     * @param id

     * @return 用户地址信息

     */

    @GetMapping("/addresses/{id}")

    public Object getAddress(HttpServletRequest request, @PathVariable Integer id) {

        Integer userId = 1;

        if(id<0)
            return ResponseUtil.badArgumentValue();
        AddressPo addressPo = addressService.getAddressById(id);
        Address address = (Address) addressPo;
        return ResponseUtil.ok(address);

    }




    /**

     * 用户添加地址

     *
     * @paramBody addressPo

     * @return 用户地址信息

     */

    @PostMapping("/addresses")

    public Object addNewAddress(@RequestBody AddressPo addressPo) {

        AddressPo addressPo1 = addressService.addAddress(addressPo);
        if(addressPo1==null)
            return ResponseUtil.updatedDataFailed();
        else
            return ResponseUtil.ok(addressPo1);


    }




}
