package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RetinaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetinaProjectApplication.class, args);

        System.out.println("\n ...SERVER STARTED...\n");
        System.out.println(" INSTRUCTIONS: \n");
        System.out.println(" # to run the server: mvn compile exec:java -Dexec.mainClass=\"com.example.demo.RetinaApplicationProject\"");
        System.out.println(" # localhost:8080/dataset/stats/total -> total number of events from dataset");
        System.out.println(" # localhost:8080/dataset/stats/offesnes -> total number of events grouped by KY_CD");
        System.out.println(" # localhost:8080/dataset/{id} -> deletes the event with specified id");
        System.out.println(" # localhost:8080/dataset -> adds new event at the end of the dataset having CMPLNT_NUM and KY_CD");
    }
}


