package com.example.digitom.domain.constructionsite;

import com.example.digitom.service.constractionsitemanagement.NewConstructionSiteRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConstructionSiteMapper {


    ConstructionSite toEntity(ConstructionSiteDto constructionSiteDto);

    ConstructionSiteDto toDto(ConstructionSite constructionSite);

    ConstructionSite requestToConstructionSite(NewConstructionSiteRequest newConstructionSiteRequest);
}
