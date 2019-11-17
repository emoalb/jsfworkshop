package app.web.beans;


import app.domain.models.view.JobApplicationViewModel;
import app.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Named
@RequestScoped
public class DeleteBean extends BaseBean {

    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    @Inject
    public DeleteBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    public DeleteBean() {
    }

    public JobApplicationViewModel getJob(String id) {
        return this.modelMapper.map(this.jobApplicationService.getById(id), JobApplicationViewModel.class);
    }

    public void deleteJob() throws IOException {
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.jobApplicationService.deleteById(id);
        this.redirect("/home");
    }


}
