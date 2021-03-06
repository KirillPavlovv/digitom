package com.example.digitom.domain.constructionsite;

import com.example.digitom.service.constractionsitemanagement.NewConstructionSiteRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConstructionSiteService {

    @Resource
    private ConstructionSiteRepository constructionSiteRepository;

    @Resource
    private ConstructionSiteMapper constructionSiteMapper;

    public Integer addNewConstructionSite(NewConstructionSiteRequest newConstructionSiteRequest) {
        ConstructionSite constructionSite = constructionSiteMapper.requestToConstructionSite(newConstructionSiteRequest);
        constructionSite.setAddress(newConstructionSiteRequest.getSiteAddress());
        constructionSite.setName(newConstructionSiteRequest.getSiteName());
        constructionSiteRepository.save(constructionSite);
        return constructionSite.getId();
    }

    public ConstructionSite findConstructionSiteById (Integer siteId){
        return constructionSiteRepository.findConstructionSiteById(siteId);
    }
}
