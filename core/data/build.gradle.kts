 plugins {
     alias(libs.plugins.todo.android.library)
     alias(libs.plugins.todo.android.hilt)
     alias(libs.plugins.todo.android.room)
 }

 android {
  namespace ="com.td.data"

 }

 dependencies {
     implementation(project(":core:model"))
     implementation(project(":core:database"))
 }