package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test

@QuarkusTest
class HelloLambdaTest {
    @Test
    fun testHelloEndpoint() {
        RestAssured.given()
                .`when`()["/hello"]
                .then()
                .statusCode(200)
                .body(CoreMatchers.`is`("Hello Lambda"))
    }

    @Test
    fun testHelloKotlinEndpoint() {
        RestAssured.given()
                .`when`()["/hello/kotlin"]
                .then()
                .statusCode(200)
                .body(CoreMatchers.`is`("Hello Kotlin"))
    }
}