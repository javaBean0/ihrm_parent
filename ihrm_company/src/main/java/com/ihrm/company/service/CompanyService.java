package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:bigStone
 * Date:2019/5/14
 **/
@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存企业
     * @param company
     */
    public void add(Company company){
        //基本属性的设置
        String id = idWorker.nextId() + "";
        company.setId(id);
        //默认的状态
        company.setAuditState("1");// 0：未审核， 1 已审核
        company.setState(0);//代表未激活， 1代表已审核
        companyDao.save(company);
    }

    /**
     * 更新企业
     * @param company
     */
    public void updata(Company company){
        //根据id查询企业对象
        Company temp = companyDao.findById(company.getId()).get();
        //设置修改的属性
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        //调用该dao完成更新
        companyDao.save(temp);

    }

    /**
     * 根据id删除
     * @param id
     */
    public void deleteById(String id){
        companyDao.deleteById(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Company findById(String id){
       return companyDao.findById(id).get();
    }

    /**
     * 查询企业列表
     * @return
     */
    public List<Company> findAll(){
        return companyDao.findAll();
    }


































}
