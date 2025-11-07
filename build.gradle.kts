plugins {
    java
    jacoco
    alias(libs.plugins.vaadin)
    alias(libs.plugins.spring)
    alias(libs.plugins.spotless)
}
dependencies {
    implementation(libs.vaadin.spring.boot.starter)
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.playwright)
}
vaadin {
    // Default to production mode for JARs and Docker images
    productionMode = gradle.startParameter.taskNames.any {
        it.contains("bootJar")
        it.contains("bootBuildImage")
    }
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}
spotless {
    java {
        endWithNewline()
        palantirJavaFormat()
        removeUnusedImports()
        forbidWildcardImports()
    }
}
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            targets {
                all {
                    testTask.configure {
                        finalizedBy(tasks.jacocoTestReport)
                    }
                }
            }
        }
    }
}
tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                // Set minimum coverage to 80%
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}
tasks.check {
    // Ensure minimum code coverage on check lifecycle phase
    finalizedBy(tasks.jacocoTestCoverageVerification)
}
tasks.test {
    // Build frontend before tests to allow tests to run in production mode
    dependsOn(tasks.vaadinBuildFrontend)
}
