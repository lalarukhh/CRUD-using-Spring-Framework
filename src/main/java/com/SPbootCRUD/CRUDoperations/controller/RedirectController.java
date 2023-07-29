package com.SPbootCRUD.CRUDoperations.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/redirect")
public class RedirectController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/add")
    public void addEmployee() {
        // Set the URL you want to request
        String url = "http://localhost:8080/employee/add?name=Aamna&email=Faiza@gmail.com";

        // Make the request and get the response
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // Get the response body
        String responseBody = response.getBody();

        // Do something with the response...
        if (response.getStatusCode().is2xxSuccessful()) {
            // Process the successful response
            System.out.println("Add request successful!");

            // Do something with the response body...
            System.out.println("Response body: " + responseBody);
        } else {
            // Handle the unsuccessful response
            System.out.println("Add request failed with status code: " + response.getStatusCodeValue());
        }
    }

   }
