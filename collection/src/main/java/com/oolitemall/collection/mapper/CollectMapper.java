package com.oolitemall.collection.mapper;

import java.util.List;

import com.oolitemall.collection.domain.CollectItem;
import com.oolitemall.collection.domain.CollectItemPo;
import com.oolitemall.collection.domain.GoodsPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CollectMapper {


    /**
     * create a brand
     *
     * @param
     * @return id
     */
    void addCollect(CollectItemPo collectItem);

    void deleteCollectById(Integer id);

    List<CollectItemPo> listCollectByCodition(Integer userId);

    GoodsPo Goods(Integer id);
}