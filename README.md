# Typicode App

### Created for Code Louisville's September 2021 Android Session

This is a sample app to showcase loading and displaying data from an API. The API used is
JsonPlaceholder at: https://jsonplaceholder.typicode.com

Note: This app still uses traditional Android Views rather than Jetpack Compose

This app makes use of the following:
 * Kotlin Coroutines
 * MVVM with Android ViewModels & LiveData
 * RecyclerViews
 * Android Navigation Component w/ SafeArgs plugin
 * Dagger/Hilt for dependency injection

After replacing the current placeholder code, the app will use OkHttp, Retrofit, and Moshi
to perform api calls.