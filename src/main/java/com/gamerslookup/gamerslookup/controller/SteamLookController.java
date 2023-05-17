package com.gamerslookup.gamerslookup.controller;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.Scanner;

@RestController
public class SteamLookController {

    @GetMapping("/pointtest")
    public String endpointTest() throws IOException {
        URL url = new URL ("http://api.steampowered.com/ISteamApps/GetAppList/v0002/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        StringBuilder stBuilder = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()){
            stBuilder.append(scanner.nextLine());
        }
        scanner.close();
        //String gameData = stBuilder.toString();


        System.out.println(stBuilder);

        return "";
    }
}
