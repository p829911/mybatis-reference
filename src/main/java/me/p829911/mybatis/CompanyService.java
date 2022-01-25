package me.p829911.mybatis;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();
        if (!companyList.isEmpty()) {
            for (Company company : companyList) {
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
            }
        }
        return companyList;
    }

    public Company getById(int id) {
        Company company = companyMapper.getById(id);
        company.setEmployeeList(employeeMapper.getByCompanyId(id));
        return company;
    }

    @Transactional
    public Company add(Company company) {
        companyMapper.insert(company);

        // add company into legacy system
        if (true) {
            throw new RuntimeException("Legacy Exception");
        }
        return company;
    }
}
