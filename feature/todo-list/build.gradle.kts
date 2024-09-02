plugins {
    alias(libs.plugins.todo.android.feature)
    alias(libs.plugins.todo.android.compose)
}

android {
    namespace ="com.todo.todolist"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(project(":core:database"))

    testImplementation(libs.mockito)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.hiltTesting)
    androidTestImplementation(libs.hiltTesting)

    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)

}