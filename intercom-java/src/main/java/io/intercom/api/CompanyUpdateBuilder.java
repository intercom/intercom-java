package io.intercom.api;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

class CompanyUpdateBuilder {

    /**
     * Provide restrictions on the company data that can be sent via a user update
     */
    static List<CompanyWithStringPlan> buildUserUpdateCompanies(CompanyCollection c) {
        final ArrayList<CompanyWithStringPlan> updatableCompanies = Lists.newArrayList();
        if (c != null) {
            final List<Company> companies = c.getPage();
            for (Company company : companies) {
                final CompanyWithStringPlan updatableCompany = new CompanyWithStringPlan();
                updatableCompany.setCompanyID(company.getCompanyID());
                updatableCompany.setName(company.getName());
                updatableCompany.setSessionCount(company.getSessionCount());
                updatableCompany.setMonthlySpend(company.getMonthlySpend());
                updatableCompany.setRemoteCreatedAt(company.getRemoteCreatedAt());
                if (company.getPlan() != null) {
                    updatableCompany.setPlan(company.getPlan().getName());
                }
                updatableCompanies.add(updatableCompany);
            }
        }
        return updatableCompanies;
    }
}
