package com.oolitemall.collection.dao;

import com.oolitemall.collection.domain.CollectItem;
import com.oolitemall.collection.domain.CollectItemPo;
import com.oolitemall.collection.domain.GoodsPo;
import com.oolitemall.collection.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CollectDao {
    @Autowired
    private CollectMapper collectMapper;

    public CollectItemPo addCollect(CollectItemPo collectItem){
         collectMapper.addCollect(collectItem);
         return collectItem;
    }

    public  List<CollectItem> listcollect(Integer userId){
        List<GoodsPo>  goods=new ArrayList<GoodsPo>() ;
        List<CollectItem>  collectItems=new ArrayList<CollectItem>();
               for(CollectItemPo collect:collectMapper.listCollectByCodition(userId)){
                   CollectItem A=new CollectItem();
                   goods.add(collectMapper.Goods(collect.getId()));
                   A.setGoodsPo(collectMapper.Goods(collect.getId()));
                   A.setGmtCreate(collect.getGmtCreate());
                   A.setGmtModified(collect.getGmtModified());
                   A.setGoodsId(collect.getGoodsId());
                   A.setId(collect.getId());
                   A.setUserId(collect.getUserId());
                   collectItems.add(A);
               }
               return collectItems;
    }

    public Integer deleteCollectById(Integer id){
        collectMapper.deleteCollectById(id);
        return id;
    }
   /* public List<CollectItemPo> listCollectByCodition()
    {
        return collectMapper.listCollectByCodition();
    }*/
   /* public Integer addBrand(Brand brand)
    {
        brandMapper.addBrand(brand);
        int id=brand.getId();
        return id;
    }*/

}