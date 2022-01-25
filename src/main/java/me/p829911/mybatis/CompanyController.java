package me.p829911.mybatis;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private CompanyService companyService;

    @PostMapping
    public Company post(@RequestBody Company company) {
        companyMapper.insert(company);
        return company;
    }

    @GetMapping
    public List<Company> getAll() {
        return companyMapper.getAll();
    }

    @GetMapping("/{id}")
    // @PathVariable 이름과 파라미터 이름이 같으면 ("id") 생략 가능
    public Company getById(@PathVariable("id") int id) {
        return companyMapper.getById(id);
    }
}
