package com.achyutraghavan.job_application.company.impl;

import com.achyutraghavan.job_application.company.Company;
import com.achyutraghavan.job_application.company.CompanyRepo;
import com.achyutraghavan.job_application.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public boolean updateCompanies(Company company, Long id) {
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isPresent()) {
            Company c = companyOptional.get();
            c.setDescription(company.getDescription());
            c.setName(company.getName());
            companyRepo.save(c);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }
}
