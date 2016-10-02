package io.intercom.api;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

class CompanyUpdateBuilder {

    /**
     * Provide restrictions on the company data that can be sent via a user update
     */
    static List<CompanyWithStringPlan> buildUserUpdateCompanies(CompanyCollection add, CompanyCollection remove) {

        final List<CompanyWithStringPlan> updatableCompanies = Lists.newArrayList();
        if (add != null) {
            final List<Company> companies = add.getPage();
            for (Company company : companies) {
                updatableCompanies.add(prepareUpdatableCompany(company));
            }
        }

        if (remove != null) {
            final List<Company> companies = remove.getPage();

            for (Company company : companies) {
                removeCompanyFromAddedList(updatableCompanies, company);
                updatableCompanies.add(prepareUpdatableCompany(company).setRemove(Boolean.TRUE));
            }
        }

        return updatableCompanies;
    }

    private static void removeCompanyFromAddedList(List<CompanyWithStringPlan> companies, Company company) {
        Iterator<CompanyWithStringPlan> companyIterator = companies.iterator();

        while (companyIterator.hasNext()) {
            CompanyWithStringPlan companyWithStringPlan = companyIterator.next();
            // TODO add equals and toHash methods to CompanyWithStringPlan and use it here
            if (companyWithStringPlan.getId() != null && company.getId() != null && companyWithStringPlan.getId().equals(company.getId())) {
                companyIterator.remove();
                break;
            }

            if (companyWithStringPlan.getCompanyID() != null && company.getCompanyID() != null && companyWithStringPlan.getCompanyID().equals(company.getCompanyID())) {
                companyIterator.remove();
                break;
            }
        }
    }

    private static CompanyWithStringPlan prepareUpdatableCompany(Company company) {
        final CompanyWithStringPlan updatableCompany = new CompanyWithStringPlan();
        updatableCompany.setId(company.getId());
        updatableCompany.setCompanyID(company.getCompanyID());
        updatableCompany.setName(company.getName());
        updatableCompany.setSessionCount(company.getSessionCount());
        updatableCompany.setMonthlySpend(company.getMonthlySpend());
        updatableCompany.setRemoteCreatedAt(company.getRemoteCreatedAt());
        if (company.getPlan() != null) {
            updatableCompany.setPlan(company.getPlan().getName());
        }
        return updatableCompany;
    }
}
