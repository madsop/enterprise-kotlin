package no.madsopheim.enterpriseKotlin

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.validation.constraints.NotEmpty
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@Path("/paths")
@ApplicationScoped
class Paths(@Inject var repository: Repository) {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(
        @NotEmpty
        @QueryParam("name")
        name: String,
    ) = HelloResponse("Hello, from ${repository.language()} to $name")

    @Path("/simpleHello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello2() = HelloResponse("Hello, from Kotlin")
}

data class HelloResponse(val text: String)
