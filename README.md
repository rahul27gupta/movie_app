# 🎬 Movie App

A modern Android application built with Jetpack Compose that displays trending movies using The Movie Database (TMDb) API. The app features a clean architecture with MVVM pattern, search functionality with debouncing, and smooth navigation between screens.

## 📱 Features

- **Browse Trending Movies**: View a grid of trending movies with poster images and titles
- **Search Functionality**: Real-time search with 500ms debouncing and 3-character minimum
- **Movie Details**: Tap any movie to view detailed information including overview
- **Loading States**: Smooth loading indicators while fetching data
- **Error Handling**: Graceful error states with user-friendly messages
- **Modern UI**: Built entirely with Jetpack Compose and Material Design 3

## 🏗️ Architecture

This app follows **Clean Architecture** principles with the **MVVM (Model-View-ViewModel)** pattern:

```
┌─────────────────────────────────────────────────────────────┐
│                        Presentation Layer                    │
│  ┌──────────────┐      ┌──────────────┐                    │
│  │   Activity   │ ───▶ │  ViewModel   │                    │
│  │  (Compose)   │      │ (StateFlow)  │                    │
│  └──────────────┘      └──────────────┘                    │
└─────────────────────────────────┬───────────────────────────┘
                                  │
┌─────────────────────────────────▼───────────────────────────┐
│                        Domain Layer                          │
│                    ┌──────────────┐                         │
│                    │  Repository  │                         │
│                    │  (Interface) │                         │
│                    └──────────────┘                         │
└─────────────────────────────────┬───────────────────────────┘
                                  │
┌─────────────────────────────────▼───────────────────────────┐
│                         Data Layer                           │
│  ┌──────────────┐      ┌──────────────┐                    │
│  │  DataSource  │ ───▶ │  API Service │                    │
│  │    (Impl)    │      │   (Retrofit) │                    │
│  └──────────────┘      └──────────────┘                    │
└─────────────────────────────────────────────────────────────┘
```

### Architecture Components

#### **1. Presentation Layer**
- **Activities**: `HomeActivity`, `MovieDetailActivity`
- **Composables**: `HomeScreen`, `MovieDetailScreen`, `SearchBar`, `MoviesGrid`
- **ViewModels**: Manage UI state and business logic using Kotlin Flows
- **UI State Management**: Single source of truth with StateFlow

#### **2. Domain Layer**
- **Repository Interface**: Defines data operations
- **Models**: `Movie`, `MoviesResponse`
- **Resource**: Sealed class for handling Loading, Success, Error states

#### **3. Data Layer**
- **Repository Implementation**: Handles data operations and state management
- **DataSource**: Abstracts API calls
- **API Service**: Retrofit interface for TMDb API
- **BuildConfig**: Secure API key management

### Key Architectural Decisions

✅ **StateFlow over LiveData**: Modern reactive streams with better lifecycle handling  
✅ **viewModelScope**: Proper coroutine scope management  
✅ **Debounced Search**: Flow operators for efficient search with 500ms debounce  
✅ **Dependency Injection**: Dagger 2 for clean dependency management  
✅ **Repository Pattern**: Separation of data sources from business logic  
✅ **Single Source of Truth**: ViewModel as the sole provider of UI state  

## 🛠️ Technologies & Libraries

### Core
- **Kotlin**: 2.0.21
- **Jetpack Compose**: Modern declarative UI toolkit
- **Material Design 3**: Latest Material Design components
- **Kotlin Coroutines**: Asynchronous programming
- **Kotlin Flows**: Reactive data streams

### Architecture Components
- **ViewModel**: Lifecycle-aware UI state management
- **StateFlow**: Hot stream for state management
- **Lifecycle**: Android lifecycle awareness

### Networking
- **Retrofit**: 2.9.0 - Type-safe HTTP client
- **Gson Converter**: JSON serialization/deserialization
- **OkHttp**: HTTP client (bundled with Retrofit)

### Dependency Injection
- **Dagger 2**: 2.51.1 - Compile-time dependency injection
- **KSP**: 2.0.21-1.0.28 - Kotlin Symbol Processing for Dagger

### Image Loading
- **Glide Compose**: 1.0.0-beta01 - Async image loading for Compose
- **Glide**: 4.16.0 - Image loading and caching

### UI Components
- **Compose BOM**: 2024.04.01 - Bill of Materials for Compose versions
- **Compose UI**: Core UI components
- **Compose Material3**: Material Design 3 components
- **Compose Activity**: Activity integration
- **Compose ViewModel**: ViewModel integration
- **Compose Navigation**: (For future multi-screen navigation)

### Build & Tools
- **Android Gradle Plugin**: 8.7.3
- **Kotlin Compose Compiler Plugin**: Built-in support for Compose
- **Parcelize Plugin**: Object serialization for navigation

## 📂 Project Structure

```
app/src/main/java/com/movieapp/
├── base/
│   ├── component/
│   │   ├── AppBar.kt                 # Reusable top app bar
│   │   └── SearchBar.kt              # Search input with debounce
│   ├── theme/
│   │   └── Theme.kt                  # App theming
│   ├── utils/
│   │   └── IntentExtensions.kt       # Intent helper utilities
│   └── constans/
│       └── Constants.kt              # App constants
│
├── feature/
│   └── listing/
│       ├── ui/
│       │   ├── activity/
│       │   │   ├── HomeActivity.kt           # Main screen activity
│       │   │   └── MovieDetailActivity.kt    # Detail screen activity
│       │   └── compose/
│       │       ├── HomeScreen.kt             # Home UI composable
│       │       ├── MovieDetailScreen.kt      # Detail UI composable
│       │       └── MoviesList.kt             # Movies grid & card
│       ├── viewModels/
│       │   ├── HomeViewModel.kt              # Home business logic
│       │   └── HomeViewModelFactory.kt       # ViewModel factory
│       ├── repository/
│       │   ├── HomeRepository.kt             # Repository interface
│       │   └── HomeRepositoryImpl.kt         # Repository implementation
│       ├── dataSource/
│       │   ├── HomeDataSource.kt             # DataSource interface
│       │   └── HomeDataSourceImpl.kt         # API data source
│       └── models/
│           └── MoviesResponse.kt             # Data models
│
├── network/
│   ├── ApiServices.kt                # Retrofit API interface
│   └── Resource.kt                   # Sealed class for API states
│
└── di/
    ├── AppComponent.kt               # Dagger component
    ├── ContextModule.kt              # Context provider
    └── NetworkModule.kt              # Network dependencies
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Ladybug | 2024.2.1 or newer
- JDK 11 or higher
- Android SDK with minimum API 26 (Android 8.0)
- TMDb API Key

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone git@github.com:rahul27gupta/movie_app.git
   cd movie_app
   ```

2. **Get TMDb API Key**
   - Go to [The Movie Database](https://www.themoviedb.org/)
   - Create an account and request an API key
   - Copy your API key

3. **Configure API Key**
   - Create/edit `local.properties` file in the project root
   - Add your API key:
     ```properties
     TMDB_API_KEY=your_api_key_here
     ```
   - The API key is automatically loaded into `BuildConfig` (not committed to Git)

4. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ```
   Or simply run the app from Android Studio

## 🔑 Key Features Implementation

### 1. Search with Debouncing
```kotlin
// ViewModel handles debounce automatically
_searchQuery
    .debounce(500)
    .collect { query ->
        filterMovies(query)
    }
```

### 2. Reactive State Management
```kotlin
// StateFlow provides reactive updates
val uiState: StateFlow<HomeUiState>
val filteredMovies: StateFlow<ArrayList<Movie>?>
```

### 3. Clean Navigation
```kotlin
// Type-safe navigation with Parcelable
startActivity(
    MovieDetailActivity.newInstance(context, movie)
)
```

### 4. Secure API Key
```kotlin
// API key loaded from local.properties
buildConfigField("String", "TMDB_API_KEY", "\"$apiKey\"")

// Used in DataSource
apiService.getTrendingMovies(
    apikey = BuildConfig.TMDB_API_KEY
)
```

## 📱 Screenshots

*(Add your app screenshots here)*

## 🔒 Security

- API keys stored in `local.properties` (not committed to Git)
- Keys loaded into `BuildConfig` at build time
- `.gitignore` configured to exclude sensitive files

## 🧪 Testing

*(Future implementation)*
- Unit tests for ViewModels
- Repository tests with mock data sources
- UI tests with Compose Testing

## 🚧 Future Enhancements

- [ ] Movie categories (Popular, Top Rated, Upcoming)
- [ ] Favorites functionality with local database (Room)
- [ ] Advanced search filters
- [ ] Dark mode support
- [ ] Pagination for movie lists
- [ ] Movie trailers integration
- [ ] User ratings and reviews
- [ ] Share movie functionality
- [ ] Offline support with caching

## 📝 License

This project is created for educational purposes.

TMDb API: This product uses the TMDb API but is not endorsed or certified by TMDb.

## 👤 Author

**Rahul Gupta**
- GitHub: [@rahul27gupta](https://github.com/rahul27gupta)
- Email: rahul73.vns@gmail.com

## 🙏 Acknowledgments

- [The Movie Database (TMDb)](https://www.themoviedb.org/) for providing the API
- Android team for Jetpack Compose
- All open-source library contributors

---

**Note**: This app uses the TMDb API for movie data. Make sure to comply with their [API Terms of Use](https://www.themoviedb.org/documentation/api/terms-of-use).

