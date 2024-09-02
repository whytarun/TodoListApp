# TODO List App

## Overview
The TODO List App is a simple and intuitive application designed to help users manage their tasks and to-dos efficiently. The app allows users to addtask, organize them into different categories, and track their progress. It provides a clean and user-friendly interface to ensure a smooth task management experience.

## Key Features
- **Add Tasks:** Users can easily add new tasks.
- **Search Functionality:** Search for tasks by title.

## Technical Requirements
- **Android SDK:** Targeting Android API level 24 and above.
- **Kotlin:** The app is written in Kotlin.
- **Jetpack Compose:** For building the UI components.
- **Kotlin Coroutines:** For asynchronous operations.
- **Hilt:** For dependency injection.
- **JUnit & MockK:** For unit testing.

## Multi-Module Architecture
The app is structured using a multi-module architecture to promote modularity and separation of concerns. The key modules are:

- **App Module:** The main application module that ties together all feature modules.
- **Feature Module:** Contains the core functionality of the TODO list, including screens and view models.
- **Core Module:** Contains common components shared across the application.
- **Data Module:** Manages data-related operations and data sources.
- **Database Module:** Handles local data storage and database interactions.
- **DesignSystem Module:** Includes design and UI components for consistent styling.
- **UI Module:** Contains the Composable functions and UI-related code.
- **Common Module:** Contains utility functions and shared resources.

## Implementation Details
- **UI Components:** Built using Jetpack Compose to ensure a modern and responsive user interface.
- **State Management:** Utilizes the MVVM pattern with ViewModels managing UI-related data.
- **Data Storage:** Tasks are stored using Room for local persistence.
- **Networking:** (If applicable) Uses Retrofit for network operations.

## Testing Strategy
- **Unit Testing:** Uses JUnit and MockK for testing ViewModels and other components in isolation.
- **UI Testing:** Employs Jetpack Compose testing tools to ensure the UI components work as expected.

## App Preview
<img width="321" alt="homescreen_todo" src="https://github.com/user-attachments/assets/09f17d5f-87d1-41e3-b7bf-cac6fe99c4ce">
<img width="330" alt="addtask_todo" src="https://github.com/user-attachments/assets/e1132cd5-8d24-4b64-8713-3d4fe35feaa9">
<img width="320" alt="searchscreen_todo" src="https://github.com/user-attachments/assets/f78b6ef9-df40-45a5-a097-a624596ef245">
<img width="327" alt="Screenshot 2024-09-02 at 8 53 24 AM" src="https://github.com/user-attachments/assets/f215f7c9-1478-4506-8141-0f88596615c7">

