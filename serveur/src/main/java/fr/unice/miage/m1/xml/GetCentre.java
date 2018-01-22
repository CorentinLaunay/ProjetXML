package fr.unice.miage.m1.xml;

import org.inria.fr.ns.cr.Crs;
import org.inria.fr.ns.cr.Crs.Cr.Responsable;
import org.inria.fr.ns.sr.StructureInria;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import static org.inria.fr.ns.cr.Crs.*;

import java.util.List;

@Path("/centres")
public class GetCentre {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Crs getCentreList(@Context ServletContext servletContext) {
        // Grabbing current builder (who has access to database) from servletContext
        XQueryBuilder builder = (XQueryBuilder) servletContext.getAttribute("builder");
        return builder.getCenters();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cr getCentreInfo(@Context ServletContext servletContext, @PathParam("id") String id){
        XQueryBuilder builder = (XQueryBuilder) servletContext.getAttribute("builder");
        return builder.getCenter(id);
    }
    
    @GET
    @Path("/responsables/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Responsable> getResponsablesCentre(@Context ServletContext servletContext, @PathParam("id") String id) {
        // Grabbing current builder (who has access to database) from servletContext
        XQueryBuilder builder = (XQueryBuilder) servletContext.getAttribute("builder");
        return builder.getResponsablesCentre(id);
    }

    @GET
    @Path("/equipes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StructureInria> getEquipesParCentreDeRecherche(@Context ServletContext servletContext, @PathParam("id") String id) {
        // Grabbing current builder (who has access to database) from servletContext
        XQueryBuilder builder  = (XQueryBuilder) servletContext.getAttribute("builder");
        return builder.getEquipesParCentreDeRecherche(id);
    }

    @GET
    @Path("/equipes/nombre/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNombreEquipeParCentreDeRecherche(@Context ServletContext servletContext, @PathParam("id") String id) {
        // Grabbing current builder (who has access to database) from servletContext
        XQueryBuilder builder = (XQueryBuilder) servletContext.getAttribute("builder");
        return builder.getNombreEquipeParCentreDeRecherche(id);
    }

    @GET
    @Path("/equipes/total/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StructureInria> getEquipes(@Context ServletContext servletContext) {
        // Grabbing current builder (who has access to database) from servletContext
        XQueryBuilder builder = (XQueryBuilder) servletContext.getAttribute("builder");
        return builder.getEquipes();
    }

}