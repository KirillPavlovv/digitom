package com.example.digitom.service.reportmanagement;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/response")
public class InspectionResponseController {

    @Resource
    private InspectionResponseService inspectionResponseService;

    @PostMapping("/add")
    @Operation(summary = "Add new task response")
    public Integer addTaskResponse(@RequestBody TaskResponseRequest taskResponseRequest) {
        return inspectionResponseService.addTaskResponse(taskResponseRequest);
    }

    @GetMapping("/get/list")
    @Operation(summary = "Get open tasks list by site ID")
    public List<TaskOverviewResponse> getOpenTasksBySiteId(@RequestParam Integer constructionSiteId) {
        return inspectionResponseService.getOpenTasksBySiteId(constructionSiteId);
    }

    @GetMapping("/get/by/userid")
    @Operation(summary = "Get open tasks list by user ID")
    public List<TaskOverviewResponse> getOpenTasksByUserId(@RequestParam Integer userId) {
        return inspectionResponseService.getOpenTasksByUserId(userId);
    }

    @PostMapping("/report/search")
    @Operation(summary = "Search reports")
    public List<ReportResponse> searchReports(@RequestBody FindReportRequest findReportRequest) {
        return inspectionResponseService.searchReports(findReportRequest);
    }

    @GetMapping("/report/search/userid")
    @Operation(summary = "Show reports list")
    public List<ReportResponse> findAllReports(@RequestParam Integer userId) {
        return inspectionResponseService.findAllReports(userId);
    }

    @GetMapping("/report/last")
    @Operation(summary = "Show 5 last reports")
    public List<ReportResponse> getLastReports(@RequestParam Integer userId) {
        return inspectionResponseService.getLastReports(userId);
    }
}
