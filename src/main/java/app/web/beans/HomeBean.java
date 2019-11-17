package app.web.beans;

import app.domain.models.view.JobApplicationViewModel;
import app.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {
    private ModelMapper modelMapper;
    private JobApplicationService jobApplicationService;
    private List<JobApplicationViewModel> jobApplicationViewModel;

    public HomeBean() {
        this.jobApplicationViewModel = new ArrayList<>();
    }

    @Inject
    public HomeBean(ModelMapper modelMapper, JobApplicationService jobApplicationService) {
        this.modelMapper = modelMapper;
        this.jobApplicationService = jobApplicationService;
        this.jobApplicationViewModel = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
       this.setJobApplicationViewModel(this.jobApplicationService.getAll().stream().map(job -> this.modelMapper.map(job, JobApplicationViewModel.class)).collect(Collectors.toList()));
        this.getJobApplicationViewModel().forEach(jobApplicationViewModel1 -> jobApplicationViewModel1.setSector(jobApplicationViewModel1.getSector().toLowerCase()));
    }


    public List<JobApplicationViewModel> getJobApplicationViewModel() {
        return jobApplicationViewModel;
    }

    public void setJobApplicationViewModel(List<JobApplicationViewModel> jobApplicationViewModel) {
        this.jobApplicationViewModel = jobApplicationViewModel;
    }
}
