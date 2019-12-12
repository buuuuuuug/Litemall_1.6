package com.oolitemall.collection.mapper;

import java.util.List;

import com.oolitemall.collection.domain.CollectItem;
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
    void addCollect(CollectItem collectItem);

    void deleteCollectById(Integer id);

    List<CollectItem> listCollectByCodition();
}