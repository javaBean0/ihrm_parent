package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private IdWorker idWorker;


    //保存
    public void save(Department department){
        //利用雪花算法设置主键
        department.setId(idWorker.nextId() + "");
        //调用dao保存
        departmentDao.save(department);
    }
    //更新

    public void update(Department department){
        //更新先查询， 根据id查询部门
        Department dept = departmentDao.findById(department.getId()).get();
        //设置部门属性
        dept.setCode(department.getCode());
        dept.setIntroduce(department.getIntroduce());
        dept.setName(department.getName());
        //更新部门
        departmentDao.save(dept);
    }

    //根据id查询
    public Department findById(String id){
        return departmentDao.findById(id).get();
    }
    //根据id删除
    public void deleteById(String id){
        departmentDao.deleteById(id);
    }

    //查询全部部门列表
    public List<Department> findAll(String companyId){
        /**
         * 用于构造查询条件
         */
        Specification<Department> spec = new Specification<Department>() {
            /**
             * @param root              包含了所有的对象数据
             * @param criteriaQuery     一般不用
             * @param criteriaBuilder   构造查询条件
             * @return
             */
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //根据企业id查询
                return criteriaBuilder.equal(root.get("companyId").as(String.class), companyId);
            }
        };
        return departmentDao.findAll(spec);
    }



}
