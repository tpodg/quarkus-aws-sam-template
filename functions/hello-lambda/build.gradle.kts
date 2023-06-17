quarkus {
    val quarkusNativeBuilderImage: String by project

    extra["quarkus.package.type"] = "native"
    extra["quarkus.native.container-build"] = true
    extra["quarkus.native.builder-image"] = quarkusNativeBuilderImage
}