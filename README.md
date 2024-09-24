# IMDb Top Movies Scraper

A simple Java-based web scraper that retrieves the top 250 movies from IMDb, along with their details such as image URL, title, main cast, release year, duration, age rating, and IMDb rating.

## Features

- Scrapes the IMDb Top 250 Movies list.
- Retrieves movie details including:
  - Image URL
  - Title
  - Main Cast
  - Release Year
  - Duration
  - Age Rating
  - IMDb Rating

## Requirements

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Chrome WebDriver (make sure it matches your Chrome version)
- Jsoup library (included in the project)

## Getting Started

### 1. Clone the Repository

git clone https://github.com/yourusername/imdb-top-movies-scraper.git
cd imdb-top-movies-scraper

### 2. Set Up ChromeDriver
Make sure you have the ChromeDriver executable compatible with your Chrome version. You can download it from ChromeDriver Downloads.
https://googlechromelabs.github.io/chrome-for-testing/

System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
