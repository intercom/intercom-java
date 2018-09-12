package io.intercom.api;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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
                if (!isCompanyInList(company, remove)) {
                    updatableCompanies.add(prepareUpdatableCompany(company));
                }
            }
        }

        if (remove != null) {
            final List<Company> companies = remove.getPage();
            for (Company company : companies) {
                updatableCompanies.add(prepareUpdatableCompany(company).setRemove(Boolean.TRUE));
            }
        }

        return updatableCompanies;
    }

    private static boolean isCompanyInList(final Company company, CompanyCollection companyCollection) {
        if (companyCollection == null) {
            return false;
        }

        return Iterables.any(companyCollection.getPage(), new Predicate<Company>() {
            @Override
            public boolean apply(Company e) {
                return Objects.equal(company.getCompanyID(), e.getCompanyID())
                        || Objects.equal(company.getId(), e.getId());
            }
        });
    }

    private static CompanyWithStringPlan prepareUpdatableCompany(Company company) {
        final CompanyWithStringPlan updatableCompany = new CompanyWithStringPlan();
        updatableCompany.setId(company.getId());
        updatableCompany.setCompanyID(company.getCompanyID());
        updatableCompany.setName(company.getName());
        updatableCompany.setSessionCount(company.getSessionCount());
        updatableCompany.setMonthlySpend(company.getMonthlySpend());
        updatableCompany.setRemoteCreatedAt(company.getRemoteCreatedAt());
        updatableCompany.setIndustry(company.getIndustry());
        updatableCompany.setSize(company.getSize());
        updatableCompany.setWebsite(company.getWebsite());
        if (company.getCustomAttributes() != null) {
            updatableCompany.getCustomAttributes().putAll(company.getCustomAttributes());
        }
        if (company.getPlan() != null) {
            updatableCompany.setPlan(company.getPlan().getName());
        }
        return updatableCompany;
    }
}
