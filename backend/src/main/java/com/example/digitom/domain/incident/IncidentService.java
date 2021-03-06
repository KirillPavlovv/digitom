package com.example.digitom.domain.incident;

import com.example.digitom.service.inspection.IncidentCounterRequest;
import com.example.digitom.service.inspection.IncidentRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncidentService {

    @Resource
    private IncidentMapper incidentMapper;

    @Resource
    private IncidentRepository incidentRepository;

    public Integer addNewIncident(IncidentRequest incidentRequest) {
        Incident incident = incidentMapper.incidentRequestToIncident(incidentRequest);
        incidentRepository.save(incident);
        return incident.getId();
    }

    public Integer incidentCounter(IncidentCounterRequest incidentCounterRequest) {
        List<Incident> incidents = incidentRepository.findByReportIdAndSafetyFieldIdAndSafe
                (incidentCounterRequest.getReportId(), incidentCounterRequest.getSafetyFieldId(),
                        incidentCounterRequest.getSafe());
        return incidents.size();
    }

    public void removeTrueIncident(IncidentCounterRequest incidentCounterRequest) {
        Incident lastById = incidentRepository.findFirstByReport_IdAndSafetyField_IdAndSafeOrderByIdDesc
                (incidentCounterRequest.getReportId(),
                        incidentCounterRequest.getSafetyFieldId(),
                        incidentCounterRequest.getSafe());
        incidentRepository.delete(lastById);
    }

    public void removeByReportId(Integer reportId) {
        incidentRepository.deleteAll(incidentRepository.findByReportId(reportId));
    }


    public void removeById(Integer id) {
        incidentRepository.deleteById(id);
    }

    public Integer countIncidents(Integer reportId, Boolean safe) {
        List<Incident> incidents = incidentRepository.findByReportIdAndSafe(reportId, safe);
        return incidents.size();
    }
}


