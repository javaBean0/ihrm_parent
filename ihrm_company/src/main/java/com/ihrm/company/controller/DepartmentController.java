package com.ihrm.company.controller;


import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "department", method = RequestMethod.POST)
    public Result save(@RequestBody Department department){

        department.setCompanyId(companyId);
        //
        departmentService.save(department);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public Result findAll(){

        Company company = companyService.findById(companyId);
        //完成查询
        List<Department> list = departmentService.findAll(companyId);
        DeptListResult deptListResult = new DeptListResult(company, list);
        //构造返回结果
        return new Result(ResultCode.SUCCESS, deptListResult);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    /**
     * 根据id更新
     * @param id
     * @param department
     * @return
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id")String id,
                         @RequestBody Department department){
        department.setId(id);
        departmentService.update(department);
        return new Result(ResultCode.SUCCESS);
    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable(value = "id")String id){
        departmentService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }











}
