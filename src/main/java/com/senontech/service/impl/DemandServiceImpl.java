package com.senontech.service.impl;


import com.senontech.dao.IDemandDao;
import com.senontech.entity.Demand;
import com.senontech.exceptions.ErrorCodeException;
import com.senontech.param.PageSize;
import com.senontech.service.IDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class DemandServiceImpl implements IDemandService {
    @Autowired
    private IDemandDao demandDao;

    @Override
    public void add(Demand param)  {
        this.demandDao.add(param);
    }

    @Override
    public void del(Integer demandId)  {
        this.demandDao.del(demandId);

    }

    @Override
    public void delList(List<Integer> demandIdList) {
        this.demandDao.delList(demandIdList);

    }

    @Override
    public void edit(Demand param)  {
        this.demandDao.edit(param);

    }

    @Override
    public Demand query(Demand param) {
        return this.demandDao.query(param);
    }

    @Override
    public List<Demand> queryList() {
        return this.demandDao.queryList();
    }

    @Override
    public PageSize queryPageList(PageSize pageSize)  {
        return this.demandDao.queryPageList(pageSize);
    }

    @Override
    public List<Demand> queryListToday()  {
        return this.demandDao.queryListToday();
    }
}
