Key Features
•Dynamic Blog Loading: The app fetches and displays a list of blog posts directly from the VRID API, ensuring that the content is always up-to-date.•Offline Caching with Room: To provide a robust offline experience, the app uses the Room persistence library (an abstraction over SQLite) to cache blog posts locally. When the app is launched offline, it will instantly display the cached data, ensuring that the user always has content to read.
•Smart Connectivity Handling: The app is designed to gracefully handle changes in network connectivity:
  ◦Initial Offline State: If the app is launched for the first time without an internet connection, a full-screen "No Internet" message is displayed, with options to "Open Settings" or "Retry."
  ◦In-App Offline Alerts: If the user tries to view a blog post without an internet connection, a non-intrusive dialog will appear, prompting them to check their connection.
•Seamless Reading Experience: The app uses a WebView to display the full blog post, providing a consistent and familiar reading experience without leaving the app.
•Modern & Responsive UI: The user interface is built entirely with Jetpack Compose, ensuring a clean, modern, and responsive design that works across a variety of screen sizes. The UI includes:
  ◦A centered top app bar with the title "Vrid Blogs."
  ◦Visually appealing blog post cards that display the post's image, title, and date.◦A "View Blog" button with a distinct color for clear calls to action.
•User-Friendly Navigation: Navigation is handled by Jetpack Navigation Compose, providing a smooth and predictable flow between the blog list and the blog detail screens. The app also includes a confirmation dialog that appears when the user presses the back button on the home screen, preventing accidental app exits.Technical Stack•UI: Jetpack Compose.
•Architecture: MVVM (Model-View-ViewModel)•Networking: Retrofit
•Local Storage: Room (SQLite)
•Image Loading: Coil
•Navigation: Jetpack Navigation Compose
