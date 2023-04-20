package no.madsopheim.enterpriseKotlin

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotEmpty
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import kotlin.random.Random

@Path("/paths")
@ApplicationScoped
class Paths(@Inject private var repository: Repository) {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun hello(
        @NotEmpty
        @QueryParam("name")
        name: String,
    ): HelloResponse {
        val id = Random.nextInt()
        repository.create(Hello(id, "the repository ${System.currentTimeMillis()}"))
        return HelloResponse("Hello, from ${repository.read(id)} to $name")
    }

    @Path("/simpleHello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun simpleHello() = HelloResponse("Hello, from Kotlin")
}

data class HelloResponse(val text: String)
