package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.imdb.com/chart/top")
                .timeout(6000).get();

        Elements movieList = doc.select("ul.ipc-metadata-list li.cli-parent");

        for (Element movie : movieList) {

            String img = movie.select("img").attr("src");
            System.out.println("Image URL: " + img);

            String title = movie.select("img").attr("alt");
            System.out.println("Title: " + title);

            Elements metadataItems = movie.select("div.sc-b189961a-7 span.cli-title-metadata-item");

            String year = metadataItems.get(0).text();
            System.out.println("Year: " + year);

            String duration = metadataItems.get(1).text();
            System.out.println("Duration: " + duration);

            String ageRating = metadataItems.size() > 2 ? metadataItems.get(2).text() : "Not Rated";
            System.out.println("Age Rating: " + ageRating);

            String rate = movie.select("span.ipc-rating-star--rating").text().trim();
            System.out.println("Rating: " + rate);

            System.out.println("------------------------------------------------");
        }
    }
}