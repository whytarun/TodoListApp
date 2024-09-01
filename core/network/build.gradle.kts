plugins {
    alias(libs.plugins.todo.android.library)
    alias(libs.plugins.todo.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace ="com.td.network"

}

dependencies {
        implementation(libs.retrofit)
        implementation(libs.retrofit.logger)
        implementation(libs.retrofit.kotlin.serialization)
        implementation(libs.kotlin.serialization.json)
}