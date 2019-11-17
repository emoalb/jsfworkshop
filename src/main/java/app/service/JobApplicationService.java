package app.service;


import app.domain.models.service.JobApplicationServiceModel;

import java.util.List;

public interface JobApplicationService {
    void save(JobApplicationServiceModel jobApplicationServiceModel);

    List<JobApplicationServiceModel> getAll();

    JobApplicationServiceModel getById(String id);

    void deleteById(String id);

}
