package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:bigStone
 * Date:2019/5/14
 **/

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //保存企业
    @RequestMapping(value = "" , method = RequestMethod.POST)
    public Result save(@RequestBody Company company){

        return null;
    }
    //根据id更新企业

    //根据id删除企业

    //根据id查询企业

    //查询全部企业列表









}
