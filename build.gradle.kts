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
        palantirJavaFormat("2.81.0")
        removeUnusedImports()
        forbidWildcardImports()
    }
}
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("6.0.1")
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
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}
tasks.check {
    finalizedBy(tasks.jacocoTestCoverageVerification)
}
tasks.test {
    dependsOn(tasks.vaadinBuildFrontend)
}
