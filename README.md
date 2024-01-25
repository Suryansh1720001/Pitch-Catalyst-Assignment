# Android Developer Assignment - Pitch Catalyst 🚀

This repository contains my submission for the Android Developer position at Pitch Catalyst. The task was to create a simple Android app using Kotlin with a clean architecture. The app includes a list with items having a title, body, and a checkbox. Additionally, the app interacts with Firebase for adding and deleting items.

## App Overview 📱

The Android app is designed with a production-based approach and follows clean architecture principles. The main features include:

- List with title, body, and checkbox for each item.
- Firebase integration for adding and deleting items.

## Screenshots 📸

||||
|:----------------------------------------:|:-----------------------------------------:|:-----------------------------------------:|
| <img src= "https://github.com/Suryansh1720001/Pitch-Catalyst-Assignment/assets/85965606/91612ff8-d5dd-41df-a191-de9b018970bc" width="80%" height="70%"> | <img src= "https://github.com/Suryansh1720001/Pitch-Catalyst-Assignment/assets/85965606/656cc08c-0f21-40f0-8ccb-f66b9698f0d4" width="80%" height="70%"> | <img src= "https://github.com/Suryansh1720001/Pitch-Catalyst-Assignment/assets/85965606/25fa6266-1b09-4117-8302-d6f78c09eacc" width="80%" height="70%"> |



### Screen Sizes 🖥️

The app is designed to support various screen sizes:

- **Phone**: The app is optimized for phones, providing a smooth user experience on devices with smaller screens.

- **Tablet**: It also scales gracefully on tablets, making use of larger screen real estate effectively.

## Technologies Used 🛠️

- Kotlin
- Firebase (Firestore)

## Project Structure 🏗️

The project is structured in a clean and modular way:

## Project Structure 🏗️

- `com`: Root package for the project.

  - `lokal`: Primary package for the application.

    - `pitchcatalystapplication`: Core package for the Pitch Catalyst application.

      - `DataModel`: Package for data models.

        - `item.kt`: Data model class representing an item.

      - `repository`: Package for handling data operations.

        - `ItemRepository`: Interface defining operations for item data.

      - `ui`: Package for user interface components.

        - `adapter`: Package for adapters.

          - `ItemAdapter`: RecyclerView adapter for items.

        - `MainActivity`: Main activity for the app.

        - `ViewModel`: Package for ViewModels.

          - `ItemViewModel`: ViewModel for managing item-related data.

# Architecture 👷‍♂️
This app uses [MVVM(Model View View-Model)](https://developer.android.com/topic/architecture#recommended-app-arch) architecture.

![image](https://github.com/Taaveez/Taaveez-android/assets/85965606/4e2286e2-1a54-4591-8e8a-8d7b15e31e2f)



## Setup Instructions ⚙️

To run the app locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/Suryansh1720001/Pitch-Catalyst-Assignment
