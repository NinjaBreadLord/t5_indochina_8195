package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import java.net.URI;
import java.net.http.HttpRequest;

public class Recipe {
    public static void main(String[] args ) throws Exception{
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
        .uri(URI.create("https://tasty.p.rapidapi.com/recipes/list"))
        .header("X-RapidAPI-Key", "bc9e5f20f9mshfceb3f679afd2b7p1960cdjsn87cb096651ab")
        .header("X-RapidAPI-Host", "tasty.p.rapidapi.com")
        .method("GET", HttpRequest.BodyPublishers.noBody())

    }