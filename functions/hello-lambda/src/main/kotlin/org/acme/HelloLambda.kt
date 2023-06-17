package org.acme

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/hello")
class HelloLambda {

    @GET
    fun handleGet(): String {
        return "Hello Lambda"
    }

    @GET
    @Path("/kotlin")
    fun handleGetKotlin(): String {
        return "Hello Kotlin"
    }
}