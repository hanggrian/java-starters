plugins {
    java
    application
}

application.mainClass.set("com.example.MyApp")

dependencies.implementation(project(":library"))
