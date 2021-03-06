package com.senontech.service.impl;


import com.senontech.dao.ISupplyDao;
import com.senontech.entity.Supply;
import com.senontech.exceptions.ErrorCodeException;
import com.senontech.param.PageSize;
import com.senontech.service.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@Service
public class SupplyServiceImpl implements ISupplyService {
    @Autowired
    private ISupplyDao supplyDao;


    @Override
    public void add(Supply param)  {
        this.supplyDao.add(param);
    }

    @Override
    public void del(Integer demandId)  {
        this.supplyDao.del(demandId);

    }

    @Override
    public void delList(List<Integer> demandIdList) {
        this.supplyDao.delList(demandIdList);

    }

    @Override
    public void edit(Supply param)  {
        this.supplyDao.edit(param);

    }

    @Override
    public Supply query(Supply param) {
        return supplyDao.query(param);
    }

    @Override
    public List<Supply> queryList() {
        return supplyDao.queryList();
    }

    @Override
    public PageSize queryPageList(PageSize pageSize)  {
        return this.supplyDao.queryPageList(pageSize);
    }

    @Override
    public List<Supply> queryListToday()  {
        List<Supply> supplyList = this.supplyDao.queryListToday();
        if(supplyList!=null&&supplyList.size()>0){
            for (Supply supply : supplyList) {
                if(supply.getUnitType()!=null&&"公斤".equals(supply.getUnitType())){
                    BigDecimal price=new BigDecimal(supply.getPrice());
                    BigDecimal value=new BigDecimal(supply.getValue());
                    supply.setPrice(price.divide(new BigDecimal(2.0)).doubleValue());
                    supply.setValue(value.multiply(new BigDecimal(2.0)).doubleValue());
                }
            }
        }
        return supplyList;
    }
}
