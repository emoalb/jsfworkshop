package app.web.beans;


import app.domain.models.binding.JobCreateBindingModel;
import app.domain.models.service.JobApplicationServiceModel;
import app.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;


@Named
@RequestScoped
public class JobCreateBean extends BaseBean {
    private JobCreateBindingModel jobCreateBindingModel;
    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public JobCreateBean() {

    }


    @Inject
    public JobCreateBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.jobCreateBindingModel = new JobCreateBindingModel();

    }

    public void create() throws IOException {
        this.jobCreateBindingModel.setSector(this.jobCreateBindingModel.getSector().toUpperCase());
        JobApplicationServiceModel jobApplicationServiceModel = this.modelMapper.map(this.jobCreateBindingModel, JobApplicationServiceModel.class);
        if(jobApplicationServiceModel.getSector()==null){
            this.redirect("/job-add");
            return;
        }else{
            this.jobApplicationService.save(jobApplicationServiceModel);
            this.redirect("/home");
            return;
        }
    }

    public JobCreateBindingModel getJobCreateBindingModel() {
        return jobCreateBindingModel;
    }

    public void setJobCreateBindingModel(JobCreateBindingModel jobCreateBindingModel)  {
        this.jobCreateBindingModel = jobCreateBindingModel;

    }
}
