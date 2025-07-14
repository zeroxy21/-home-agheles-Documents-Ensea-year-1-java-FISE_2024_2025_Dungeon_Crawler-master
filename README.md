# Dungeon_Crawler-master
# 🕹️ Dungeon Crawler – FISE 2024/2025

A 2D tile-based **dungeon crawler** game developed as a **personal project** during my first year as an engineering student (FISE 2024–2025). Built in Java, this game demonstrates fundamental programming concepts such as object-oriented design, collision detection, and sprite-based rendering.

![Language](https://img.shields.io/badge/language-Java-blue)
![Status](https://img.shields.io/badge/project-personal_project-green)
![Progress](https://img.shields.io/badge/state-prototype-lightblue)

---

## 📦 About

This game was developed individually as my first full Java project in engineering school. It represents my exploration of basic game development concepts, including rendering, input handling, and simple gameplay mechanics.

The core objective was to build a simple **dungeon crawler** featuring:
- A **player-controlled hero**
- A working **health bar system**
- A **static enemy** with damage logic
- **Hitbox-based collision detection**
- A **start screen** and **game over screen**

Through this project, I strengthened my understanding of Java, object-oriented design, and user interaction in graphical applications.

---

## ✨ Features

- 🧙‍♂️ **Controllable hero character**
- ❤️ **Health bar with real-time damage**
- 🧟 **Static enemy interaction**
- 🧱 **Tile-based map rendering**
- 🧩 **Custom hitboxes and collision detection**
- 🖼️ **Start and Game Over screens**
- 🎨 **Hand-picked 2D sprite assets**

---

## 🛠️ Tech Stack

- **Language:** Java
- **Graphics:** Java AWT/Swing (manual 2D rendering)
- **IDE:** IntelliJ IDEA
- **Assets:** PNG sprites, `.txt` level files

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 11 or higher
- IntelliJ IDEA (or any Java-compatible IDE)

📋 How to Play
Use the arrow keys to move your hero.

Colliding with the static enemy causes the hero to take damage.

The health bar decreases based on damage taken.

The game starts with a welcome screen, and ends with a game over screen when health reaches zero.

## Program structure
FISE_2024_2025_Dungeon_Crawler/
├── data/                  # Level map files
├── img/                   # Sprites and tile assets
├── .idea/                 # IntelliJ configuration
├── *.java                 # Source files
├── *.iml                  # Project module file
└── *.plantuml             # UML diagram of architecture

### Installation

```bash
# Clone the repository
git clone https://github.com/Zeroxy21/FISE_2024_2025_Dungeon_Crawler.git
cd FISE_2024_2025_Dungeon_Crawler

# Open the project in IntelliJ IDEA
# Locate and run the main class
