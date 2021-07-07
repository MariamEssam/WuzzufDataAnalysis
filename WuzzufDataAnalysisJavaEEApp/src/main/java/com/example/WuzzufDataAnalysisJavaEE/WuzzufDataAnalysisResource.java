package com.example.WuzzufDataAnalysisJavaEE;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
/*** JAX-RS Web Service**/
@Path("Wuzzuf")
@RequestScoped
public class WuzzufDataAnalysisResource {
    @Inject
    private DataHandler datahandler;
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String getXml()
    {
        return datahandler.ShowSummary();
    }
}
