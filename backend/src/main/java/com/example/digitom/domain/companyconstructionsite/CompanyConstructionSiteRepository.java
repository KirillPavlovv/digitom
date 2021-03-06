package com.example.digitom.domain.companyconstructionsite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyConstructionSiteRepository extends JpaRepository<CompanyConstructionSite, Integer> {

    @Query("select c from CompanyConstructionSite c where c.company.id = ?1")
    List<CompanyConstructionSite> findByCompanyId(Integer id);

    @Query("select c from CompanyConstructionSite c " +
            "where c.constructionSite.id = ?1 and c.mainContractor = ?2 " +
            "order by c.id")
    List<CompanyConstructionSite> findByConstructionSiteId(Integer id, Boolean mainContractor);

    @Query("select c from CompanyConstructionSite c where c.company.id = ?1 and c.constructionSite.id = ?2")
    CompanyConstructionSite findByCompanyIdAndConstructionSiteId(Integer id, Integer id1);

    @Query("select c from CompanyConstructionSite c where c.constructionSite.id = ?1 and c.mainContractor = ?2")
    CompanyConstructionSite findByConstructionSiteIdAndMainContractor(Integer id, Boolean mainContractor);

    @Query("select (count(c) > 0) from CompanyConstructionSite c where c.company.id = ?1 and c.constructionSite.id = ?2")
    boolean existByCompanyIdAndConstructionSiteId(Integer id, Integer id1);

    @Query("select c from CompanyConstructionSite c where c.constructionSite.id = ?1 order by c.company.name")
    List<CompanyConstructionSite> findByConstructionSiteIdOrderByCompanyNameAsc(Integer id);






}