package com.rockmann;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Index;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@Bean
    CommandLineRunner clr(Client meilisearchClient) {
        return args -> {

            Path fileName = new ClassPathResource("properties.json").getFile().toPath();

            String propertiesData = Files.readString(fileName);

            Index index = meilisearchClient.index("products");
            index.deleteAllDocuments();
            index.updateFilterableAttributesSettings(new String[]{"type", "rooms", "bathrooms", "area","_geo", "price"});

            index.addDocuments(propertiesData);

            System.out.println("Indexing finished");
        };
    }
}
