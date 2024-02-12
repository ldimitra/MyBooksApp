

## MyBooksApp
MyBooksApp is a simple application that displays results for books using the Gutendex API.

The application is written in Kotlin having in mind the best practices and the latest Android architecture recommendations.

### App architecture:
- Presentation layer to display the data on the screen:
  - Single-activity architecture and use of the Navigation Jetpack component to manage the app navigation
  - Android Jetpack ViewModels
  - Jetpack Data Binding
- Domain layer that uses UseCases for business logic
- Data layer which contains the repository and exposes application data to the domain layer
- Flow and Coroutines for asynchronous operations
- Dependency Injection with Hilt

### Libraries used:
* Retrofit
* Coil
* Hilt
* Shimmer
