plugins {
    alias(libs.plugins.todo.android.feature)
    alias(libs.plugins.todo.android.compose)
}

android {
    namespace ="com.todo.todolist"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(project(":core:database"))
}