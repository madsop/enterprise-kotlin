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
class Paths(var repository: Repository) {

    constructor() : this(Repository())

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(
        @NotEmpty
        @QueryParam("name")
        name: String,
    ) = HelloResponse("Hello, from Kotlin to $name")

    @Path("/hello2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello2() = HelloResponse("Hello, from Kotlin")
}

data class HelloResponse(val text: String)
