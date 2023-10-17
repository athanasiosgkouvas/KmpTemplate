# KmpTemplate

KmpTemplate is a Kotlin Multiplatform (KMP) project template that provides a basic file structure for building cross-platform applications. It includes version catalog for dependencies management, an efficient Shared MVI (Model-View-Intent) architecture with Kotlin Flows and Coroutines, Kermit logger, Ktor HTTP client, Koin dependency injection, and SQLDelight for database integration.

## Project Structure

The project is structured as follows:

- `commonMain`: Contains code shared across all platforms.
- `androidMain`: Contains Android-specific code.
- `iosMain`: Contains iOS-specific code.
- `shared`: Common code used across platforms.

## Dependencies Management

This project uses a version catalog to manage dependencies, making it easier to maintain and update libraries.

## Shared MVI View Model

KmpTemplate follows the MVI architecture pattern for managing UI state. It includes a shared ViewModel using Kotlin Flows and Coroutines to handle business logic and UI updates efficiently across platforms.

## Kermit Logger

Kermit is used for logging purposes. It allows for configurable logging levels and helps in debugging your application.

## Ktor HTTP Client

Ktor is used for making network requests. It provides a flexible and asynchronous way to perform HTTP operations on all platforms.

## Koin Dependency Injection

Koin is used for dependency injection, making it easy to manage and inject dependencies in your KMP project.

## SQLDelight Database

SQLDelight is integrated for database operations. It provides type-safe database queries and helps maintain a consistent data layer across platforms.

## Usage

To get started with this template, follow these steps:

1. Clone this repository.
2. Open the project in your preferred Kotlin IDE.
3. Customize the project to fit your application's needs.
4. Use the shared code in your platform-specific projects to create your app.

#

### Contribute

Feel free to contribute to this project or use it as a starting point for your Kotlin Multiplatform project. If you have any questions or need assistance, please open an issue in this repository.

Happy coding! 🚀
