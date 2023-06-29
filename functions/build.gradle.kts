import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension

plugins {
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.allopen") version "1.8.21" apply false
    id("io.quarkus") apply false
}

subprojects {
    apply(plugin = "io.quarkus")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")

    val quarkusPlatformGroupId: String by project
    val quarkusPlatformArtifactId: String by project
    val quarkusPlatformVersion: String by project

    dependencies {
        implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
        implementation("io.quarkus:quarkus-amazon-lambda-rest")
        implementation("io.quarkus:quarkus-resteasy-jackson")
        implementation("io.quarkus:quarkus-kotlin")
        implementation("io.quarkus:quarkus-arc")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("io.quarkus:quarkus-junit5")
        testImplementation("io.rest-assured:rest-assured")
    }

    java {
        toolchain {
            val toolchainJavaVersion: String by project
            languageVersion.set(JavaLanguageVersion.of(toolchainJavaVersion))
        }
    }

    tasks.withType<Test> {
        systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
        kotlinOptions.javaParameters = true
    }

    configure<AllOpenExtension> {
        annotation("jakarta.ws.rs.Path")
        annotation("jakarta.enterprise.context.ApplicationScoped")
        annotation("io.quarkus.test.junit.QuarkusTest")
    }
}