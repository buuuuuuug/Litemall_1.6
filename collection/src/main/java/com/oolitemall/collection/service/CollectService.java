package com.oolitemall.collection.service;

import com.oolitemall.collection.dao.CollectDao;
import com.oolitemall.collection.domain.CollectItem;
import com.oolitemall.collection.domain.CollectItemPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectDao collectDao;

    public CollectItemPo addCollect(CollectItemPo collectItem){
        return  collectDao.addCollect(collectItem);
    }

    public Integer deleteCollectById(Integer id){
        return collectDao.deleteCollectById(id);
    }

    public List<CollectItem> listCollectByCodition(Integer userId)
    {
        return collectDao.listcollect(userId);
    }
}
