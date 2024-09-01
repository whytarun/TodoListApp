plugins {
    alias(libs.plugins.todo.android.library)
    alias(libs.plugins.todo.android.room)
    alias(libs.plugins.todo.android.hilt)
}

android {
    namespace = "com.td.database"
}

dependencies {
    implementation(project(":core:model"))
}