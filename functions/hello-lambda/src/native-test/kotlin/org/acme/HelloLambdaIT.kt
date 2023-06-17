package org.acme

import io.quarkus.test.junit.QuarkusIntegrationTest

@QuarkusIntegrationTest
class HelloLambdaIT : HelloLambdaTest() { // Execute the same tests but in packaged mode.
}
