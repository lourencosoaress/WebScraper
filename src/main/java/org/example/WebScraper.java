package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebScraper {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Path to your chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.imdb.com/chart/top/");

        Thread.sleep(600);

        String pageSource = driver.getPageSource();

        Document doc = Jsoup.parse(pageSource);

        Elements movieList = doc.select("ul.ipc-metadata-list.sc-a1e81754-0.dHaCOW li");

        System.out.println(movieList.size());

        for (Element movie : movieList) {

            String img = movie.select("img").attr("src");
            System.out.println("Image URL: " + img);

            String fullTitle = movie.select("img").attr("alt");

            if (fullTitle.contains(" in ")) {
                String[] auxArray = fullTitle.split(" in ", 2);
                String cast = auxArray[0];
                String title = auxArray[1];

                System.out.println("Title: " + title);
                System.out.println("Main Cast: " + cast);
            } else {
                System.out.println("Title: " + fullTitle);
            }

            Elements metadataDiv = movie.select("div.sc-ab348ad5-7.cqgETV.cli-title-metadata");

            if (metadataDiv.size() > 0) {
                Elements spans = metadataDiv.select("span"); // Get all span elements inside the div

                for (int i = 0; i < spans.size(); i++) {
                    String spanText = spans.get(i).text();
                    switch (i) {
                        case 0:
                            System.out.println("Year: " + spanText);
                            break;
                        case 1:
                            System.out.println("Duration: " + spanText);
                            break;
                        case 2:
                            System.out.println("Age Rating: " + spanText);
                            break;
                        default:
                            break;
                    }
                }
            }

            String rate = movie.select("span.ipc-rating-star--rating").text().trim();
            System.out.println("Rating: " + rate);

            System.out.println("------------------------------------------------");
        }
    }
}