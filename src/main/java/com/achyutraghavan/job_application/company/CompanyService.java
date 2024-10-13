package com.achyutraghavan.job_application.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void createCompany(Company company);
    boolean updateCompanies(Company company, Long id);
    boolean deleteCompany(Long id);
}
