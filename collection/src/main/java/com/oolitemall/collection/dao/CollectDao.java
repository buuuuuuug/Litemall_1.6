package com.oolitemall.collection.dao;

import com.oolitemall.collection.domain.CollectItem;
import com.oolitemall.collection.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CollectDao {
    @Autowired
    private CollectMapper collectMapper;

    public  CollectItem addCollect(CollectItem collectItem){
         collectMapper.addCollect(collectItem);
         return collectItem;
    }

    public Integer deleteCollectById(Integer id){
        collectMapper.deleteCollectById(id);
        return id;
    }
    public List<CollectItem> listCollectByCodition()
    {
        return collectMapper.listCollectByCodition();
    }
   /* public Integer addBrand(Brand brand)
    {
        brandMapper.addBrand(brand);
        int id=brand.getId();
        return id;
    }*/

}