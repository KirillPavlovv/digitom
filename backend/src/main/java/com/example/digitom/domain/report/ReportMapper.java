package com.example.digitom.domain.report;

import com.example.digitom.service.reportmanagement.FindReportRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReportMapper {
    @Mapping(source = "constructionSiteId", target = "constructionSite.id")
    @Mapping(source = "constructionSiteName", target = "constructionSite.name")
    @Mapping(source = "constructionSiteAddress", target = "constructionSite.address")
    @Mapping(source = "constructionSiteLatitude", target = "constructionSite.latitude")
    @Mapping(source = "constructionSiteLongitude", target = "constructionSite.longitude")
    Report reportDtoToReport(ReportDto reportDto);

    @InheritInverseConfiguration(name = "reportDtoToReport")
    ReportDto reportToReportDto(Report report);

    @InheritConfiguration(name = "reportDtoToReport")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReportFromReportDto(ReportDto reportDto, @MappingTarget Report report);

    @Mapping(target = "constructionSite.name", source = "constructionSiteName")
    Report requestToReport(FindReportRequest findReportRequest);


}