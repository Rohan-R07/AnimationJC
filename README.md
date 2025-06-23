# ✨ Jetpack Compose Animation Showcase

This is a practice/demo Android app built with **Jetpack Compose** to explore and demonstrate a wide range of animation APIs and text motion techniques. The goal is to visualize how various animations work in Compose and understand how they can be applied to real UI development.

---

## 🎯 Purpose

This app is designed to help practice and understand the most commonly used **Jetpack Compose animations**, including animated UI components and animated text behaviors. It can serve as a **reference** or inspiration for other developers learning Compose.

---

## 🚀 Features

- ✅ Multiple types of animations demonstrated:
  - `animateDpAsState`
  - `animateIntAsState`
  - `animateColorAsState`
  - `updateTransition`
  - `infiniteTransition`
  - `AnimatedVisibility`
  - `AnimatedContent`
  

- 🌀 Animated splash screen:
  - Uses `LaunchedEffect` to trigger the animation and delay
  - Navigates via `Navigation 3` (Compose's newest version of compose navigation)

- 🔁 Repetitive animations with `repeatable`, `RepeatMode.Reverse`

- 🎯 Animation Specs Used:
  - `tween`
  - `spring`
  - Various easing functions (like `EaseInOutCubic` etc...)

- 🧠 State Management:
  - Compose state patterns (`remember`, `mutableStateOf`)
  - ViewModel-free design for simplicity
  - Controlled visibility and transitions

- ✍️ Text Animation Examples:
  - Smooth `AnimatedBox` with color or size changes
  - `MovingText` using `animateOffsetAsState`
  - AnimatedChanging Content via `AnimatedContent`

---

## 🧪 What You Can Learn

- How to use various `animate*AsState` APIs
- Transition animations using `updateTransition` and `AnimatedContent`
- Managing animation state with Jetpack Compose
- Implementing splash animations with letter Spacing effects
- How to animate **text** creatively in Compose
- Adding custom font fiile (.tff) and using it inside our application for custom splash screen 

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Navigation:** Navigation 3 (alpha)
- **Animations:** Compose Animation APIs
- **CustomFonts:** Adding and using Custom fonts in our application 
- **State:** Compose state + side effects

---

## 📱 APK

You can find the latest APK in the [Releases](../../releases) section.

---

## 📷 Screenshots

*(Add sample images of animated text, splash, transitions here)*

---

## 🔗 References

- [Jetpack Compose Animation Docs](https://developer.android.com/jetpack/compose/animation)
- [Navigation Compose 3 (alpha)](https://developer.android.com/jetpack/androidx/releases/navigation#compose_version_3)

---

> ⚠️ *Note: This project is built for learning purposes and is not production-grade.*

