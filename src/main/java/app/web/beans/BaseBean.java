package app.web.beans;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

public abstract class BaseBean implements Serializable {
    protected void redirect(String url) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/view"+url+".jsf");
    }
}
