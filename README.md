# 🎬 StreamVerse

**StreamVerse** is a Movie & TV Show discovery app built using **Jetpack Compose** and **Watchmode (TMDB)** API.  
It allows users to explore popular movies and TV shows with clean UI, dark theme support, and a responsive design.

---

## 🌟 Features

- 🎥 **Movies & TV Shows** — Fetches popular movies and TV shows from the Watchmode (TMDB) API.  
- 🔄 **Real-time Loading** — Shimmer effect while content is loading for smooth UX.  
- 🏠 **Home Screen** — Toggle between Movies and TV Shows using top tabs.  
- 📖 **Details Screen** — Shows title, overview, release date, and poster of selected content.  
- 🌙 **Dark Theme** — Beautiful UI with full dark mode support.  
- 🧭 **Navigation** — Smooth navigation using Jetpack Navigation Compose.  
- ⚡ **Responsive Layout** — Adapts seamlessly across screen sizes.  
- 🚨 **Error Handling** — Clean Snackbar/Toast error feedback.

---

## 🧩 Tech Stack

- **Kotlin**  
- **Jetpack Compose** (UI)  
- **MVVM Architecture**  
- **Koin** for Dependency Injection  
- **Retrofit + RxJava3** for API Integration  
- **Coroutines & Flow**  
- **Watchmode/TMDB API**  
- **Material 3 Design System**

---

## 🧠 What I Learned

Before this project, I had only used **Hilt** for dependency injection.  
While building StreamVerse, I explored **Koin** for the first time — it was a completely new experience for me.  
Initially, I faced several errors and configuration issues (especially with ViewModel injection and Koin setup),  
but through debugging and experimentation, I learned a lot about:

- Koin modules setup (`appModule`, `networkModule`, `repositoryModule`)
- Handling API responses with RxJava & Retrofit  
- Shimmer loading animation in Jetpack Compose  
- Managing clean architecture layers (data, domain, presentation)

Overall, this project helped me **improve my understanding of DI, architecture, and reactive programming**.

---

## 📱 Screenshots

| Home Screen (Movies) | Home Screen (TV Shows) | Details Screen |
|----------------------|------------------------|----------------|
| ![Movies Screen](https://github.com/developeraj732/StreamVerse/blob/main/app/src/main/res/drawable/movies.png) | ![TV Screen](https://github.com/developeraj732/StreamVerse/blob/main/app/src/main/res/drawable/tvshows.png) | ![Details](https://github.com/developeraj732/StreamVerse/blob/main/app/src/main/res/drawable/detailscreen.png) |

---

## ⚙️ Setup & Run Instructions

Follow these steps to set up and run StreamVerse on your local machine 👇

🧩 Prerequisites

Android Studio Ladybug+ | 2024.1.2 or newer

Kotlin 2.0+

Minimum SDK: 24

API key from TMDB

🚀 Steps to Run the Project

Clone the repository

git clone https://github.com/your-username/StreamVerse.git


Open in Android Studio
Open the cloned project in Android Studio and let it sync Gradle dependencies.

Add your TMDB API key
Go to:

app/src/main/java/com/example/streamverse/di/networkModule.kt


Replace this line with your own API key 👇

.addQueryParameter("api_key", "YOUR_TMDB_API_KEY")


Build and Run the app
Select an emulator or physical device, and hit ▶️ Run.

🌙 Optional

To enable dark mode, switch your system theme or toggle inside app settings.

Make sure you have a stable internet connection for fetching movie & TV show data.

## 🚀 Future Improvements

Add Search functionality for movies & TV shows

Integrate Favorites/Watchlist feature

Add Paging for infinite scroll

Explore Compose Animation APIs for smoother transitions

💬 Acknowledgements

Thanks to TMDB API for providing open movie and TV show data.
And thanks to the countless debug sessions that made me stronger as an Android dev 💪😄

## Made with ❤️ by Aman Jha
