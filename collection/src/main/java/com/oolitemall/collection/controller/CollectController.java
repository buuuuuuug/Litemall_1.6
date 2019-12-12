package com.oolitemall.collection.controller;/*
package和import需要根据项目导入
 */


import com.oolitemall.collection.VO.CollectItemVo;
import com.oolitemall.collection.domain.CollectItem;
import com.oolitemall.collection.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户收藏服务
 */
@RestController
public class CollectController {
    @Autowired
    private CollectService collectService ;

    /**
     * 用户收藏列表
     *
     * @param userId 用户ID
     * @param type   类型，如果是0则是商品收藏，如果是1则是专题收藏
     * @param page   分页页数
     * @param limit   分页大小
     * @return 用户收藏列表
     */
    @GetMapping ("/collects")
    public Object list(@RequestParam Integer userId,
                       @NotNull@RequestParam Byte type,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit
                                  ){
             return collectService.listCollectByCodition();
    }

    /**
     * 用户收藏添加或删除
     * <p>
     * 如果商品没有收藏，则添加收藏；如果商品已经收藏，则删除收藏状态。
     *
     * @param userId 用户ID
     * @param body   请求内容，{ type: xxx, valueId: xxx }
     * @return 操作结果
     */


   //@ApiOperation(value = "添加收藏 ")
    public Object add( @RequestBody CollectItem body) {
         return collectService.addCollect(body);
    }

    @DeleteMapping("/collects/{id}")
    public Object update( @PathVariable Integer id) {
          return  collectService.deleteCollectById(id);
    }
}