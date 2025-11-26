# Key Features

### ⭐ Dynamic Blog Loading
- The app fetches and displays a list of blog posts directly from the VRID API.
- Ensures that the content is always up-to-date.

### 📦 Offline Caching with Room
- Uses the Room persistence library (SQLite abstraction) to cache blog posts locally.
- If the app is launched offline, cached data is displayed instantly.

### 🌐 Smart Connectivity Handling
- Gracefully handles network connectivity changes.

#### Initial Offline State:
- If the app launches for the first time without internet, a full-screen **"No Internet"** message is shown.
- Provides **“Open Settings”** and **“Retry”** options.

#### In-App Offline Alerts:
- If the user tries to open a blog post without internet, a non-intrusive dialog prompts them to check connection.

### 📖 Seamless Reading Experience
- Displays full blog posts using **WebView**.
- Keeps the reading experience familiar and consistent.

### 🎨 Modern & Responsive UI (Jetpack Compose)
- Clean, modern UI built entirely with Jetpack Compose.
- Responsive on all screen sizes.

Includes:
- A centered top app bar titled **"Vrid Blogs"**.
- Visually appealing blog cards (image, title, date).
- A distinct **"View Blog"** button for calls to action.

### 🧭 User-Friendly Navigation
- Navigation handled with **Jetpack Navigation Compose**.
- Smooth flow between list and detail screens.
- Home screen includes a **back press confirmation dialog** to prevent accidental exits.

---

# 🛠️ Technical Stack

- **UI:** Jetpack Compose  
- **Architecture:** MVVM (Model–View–ViewModel)  
- **Networking:** Retrofit  
- **Local Storage:** Room (SQLite)  
- **Image Loading:** Coil  
- **Navigation:** Jetpack Navigation Compose  
