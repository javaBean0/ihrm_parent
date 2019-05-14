package com.ihrm.company.dao;

import com.ihrm.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * author:bigStone
 * Date:2019/5/13
 **/
public interface CompanyDao extends JpaRepository<Company, String>,
        JpaSpecificationExecutor<Company> {


}
