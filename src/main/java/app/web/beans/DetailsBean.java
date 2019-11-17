package app.web.beans;


import app.domain.models.view.JobApplicationViewModel;
import app.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class DetailsBean extends BaseBean {
    private JobApplicationViewModel jobApplicationViewModel;
    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;
    public DetailsBean() {

    }

    @Inject
    public DetailsBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.jobApplicationViewModel = this.modelMapper.map(this.jobApplicationService.getById(id),JobApplicationViewModel.class);

    }


    public JobApplicationViewModel getJobApplicationViewModel() {
        return jobApplicationViewModel;
    }

    public void setJobApplicationViewModel(JobApplicationViewModel jobApplicationViewModel) {
        this.jobApplicationViewModel = jobApplicationViewModel;
    }

}
