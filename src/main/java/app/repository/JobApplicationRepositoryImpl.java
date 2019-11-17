package app.repository;

import app.domain.entities.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobApplicationRepositoryImpl implements JobApplicationRepository {
    private final EntityManager entityManager;
    private final TransactionUtil transactionUtil;


    @Inject
    public JobApplicationRepositoryImpl(EntityManager entityManager, TransactionUtil transactionUtil) {
        this.entityManager = entityManager;
        this.transactionUtil = transactionUtil;
    }

    @Override
    public void save(JobApplication jobApplication) {
        this.transactionUtil.createTransaction(jobApplication);
    }

    @Override
    public List<JobApplication> findAllJobs() {
        return this.entityManager.createQuery("SELECT j from JobApplication j", JobApplication.class).getResultList();
    }

    @Override
    public JobApplication findById(String id) {
        List<JobApplication> jobApplications = this.entityManager.createQuery("SELECT j FROM JobApplication  j WHERE j.id = :id", JobApplication.class).setParameter("id", id).getResultList();
        if (jobApplications.isEmpty()) {
            return null;
        }
        return jobApplications.get(0);
    }

    @Override
    public void deleteById(String id) {
        JobApplication jobApplication = findById(id);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(jobApplication);
        this.entityManager.getTransaction().commit();
        System.out.println();
    }
}
