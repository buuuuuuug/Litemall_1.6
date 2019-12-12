package com.oolitemall.collection.service;

import com.oolitemall.collection.dao.CollectDao;
import com.oolitemall.collection.domain.CollectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectDao collectDao;

    public CollectItem addCollect(CollectItem collectItem){
        return  collectDao.addCollect(collectItem);
    }

    public Integer deleteCollectById(Integer id){
        return collectDao.deleteCollectById(id);
    }

    public List<CollectItem> listCollectByCodition()
    {
        return collectDao.listCollectByCodition();
    }
}
