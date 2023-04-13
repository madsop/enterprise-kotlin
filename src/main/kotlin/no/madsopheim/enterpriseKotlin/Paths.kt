package no.madsopheim.enterpriseKotlin

import jakarta.enterprise.context.ApplicationScoped
import jakarta.validation.constraints.NotEmpty
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@Path("/paths")
@ApplicationScoped
open class Paths {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun hello(
        @NotEmpty
        @QueryParam("name")
        name: String,
    ) = HelloResponse("Hello, from Kotlin to $name")
}

data class HelloResponse(val text: String)
