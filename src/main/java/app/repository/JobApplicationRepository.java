package app.repository;

import app.domain.entities.JobApplication;

import java.util.List;

public interface JobApplicationRepository {
  void save(JobApplication jobApplication);
  List<JobApplication> findAllJobs();
  JobApplication findById(String id);
  void  deleteById(String id);
}
