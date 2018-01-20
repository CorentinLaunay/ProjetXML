package fr.unice.miage.m1;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) {
        // Grab response headers
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        // Push our cors attributes
        headers.add(
                "Access-Control-Allow-Origin", "*");
        headers.add(
                "Access-Control-Allow-Credentials", "true");
        headers.add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        headers.add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}