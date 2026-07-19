package com.manasvi.contextchatbot;

import java.util.Scanner;
import java.util.ArrayList;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Context {

    private static String API_KEY;
    private static String MODEL_URL;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask for API Key
        System.out.print("Enter your Gemini API Key: ");
        API_KEY = sc.nextLine().trim();

        MODEL_URL =
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                        + API_KEY;

        ArrayList<String> history = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        while (true) {

            System.out.print("\nYou: ");
            String prompt = sc.nextLine();

            if (prompt.equalsIgnoreCase("bye")) {
                System.out.println("GoldFish: Goodbye! 👋");
                break;
            }

            history.add("User: " + prompt);

            // Build conversation context
            StringBuilder context = new StringBuilder();

            for (String message : history) {
                context.append(message).append("\n");
            }

            String finalPrompt = context.toString();

            try {

                String requestBody =
                        "{\"contents\":[{\"parts\":[{\"text\":\""
                                + finalPrompt.replace("\\", "\\\\")
                                        .replace("\"", "\\\"")
                                        .replace("\n", "\\n")
                                + "\"}]}]}";

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(MODEL_URL))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

                HttpResponse<String> response = client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200) {
                    System.out.println("\nGemini API Error:");
                    System.out.println(response.body());
                    continue;
                }

                ObjectMapper mapper = new ObjectMapper();

                JsonNode root = mapper.readTree(response.body());

                String aiReply = root.path("candidates")
                        .get(0)
                        .path("content")
                        .path("parts")
                        .get(0)
                        .path("text")
                        .asText();

                history.add("AI: " + aiReply);

                System.out.println("GoldFish: " + aiReply);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}