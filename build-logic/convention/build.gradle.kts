import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
     `kotlin-dsl`
 }

 group = "com.td.buildlogic"

 java {
     sourceCompatibility = JavaVersion.VERSION_17
     targetCompatibility = JavaVersion.VERSION_17
 }

 tasks.withType<KotlinCompile>().configureEach {
     kotlinOptions{
         jvmTarget =JavaVersion.VERSION_17.toString()
     }
 }

tasks {
      validatePlugins {
          enableStricterValidation = true
          failOnWarning = true
      }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary"){
            id ="todo.android.library"
            implementationClass ="AndroidLibraryConventionPlugin"
        }

        register("jvmLibrary"){
            id ="todo.jvm.library"
            implementationClass ="JvmLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "todo.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "todo.android.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeature") {
            id = "todo.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidRoom") {
            id = "todo.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}