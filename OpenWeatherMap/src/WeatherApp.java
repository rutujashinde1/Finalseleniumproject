
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class WeatherApp {

    private static final String API_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,"
    		+ "us&appid=b6907d289e10d714a6e88b30761fae22";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Get weather");
            System.out.println("2. Get Wind Speed");
            System.out.println("3. Get Pressure");
            System.out.println("0. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    getWeather();
                    break;
                case 2:
                    getWindSpeed();
                    break;
                case 3:
                    getPressure();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return -1;
        }
    }

    private static String makeAPIRequest() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder responseBuilder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            responseBuilder.append(output);
        }

        conn.disconnect();

        return responseBuilder.toString();
    }

    private static void getWeather() {
        try {
            System.out.println("Enter the date (YYYY-MM-DD HH:mm:ss): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String date = reader.readLine();

            String response = makeAPIRequest();
 
            System.out.println("Temperature at " + date + ": " + response);
        }
            catch (IOException e) {
            System.out.println("Error occurred while fetching data.");
        }
    }


    private static void getWindSpeed() {
        try {
            System.out.println("Enter the date (YYYY-MM-DD HH:mm:ss): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String date = reader.readLine();

            String response = makeAPIRequest();
            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
            JsonArray weatherList = jsonResponse.getAsJsonArray("list");

            for (JsonElement element : weatherList) {
                JsonObject data = element.getAsJsonObject();
                String dateTime = data.get("dt_txt").getAsString();

                // Check if the date in the response matches the input date
                if (dateTime.contains(date)) {
                    JsonObject wind = data.getAsJsonObject("wind");
                    if (wind.has("speed") && !wind.get("speed").isJsonNull()) {
                        double windSpeed = wind.get("speed").getAsDouble();
                        System.out.println("Wind Speed at " + dateTime + ": " + windSpeed + " m/s");
                    } else {
                        System.out.println("Wind Speed data not available for the given date.");
                    }
                    return;
                }
            }

            System.out.println("Data not available for the given date.");
        } catch (IOException e) {
            System.out.println("Error occurred while fetching data.");
        }
    }

    private static void getPressure() {
        try {
            System.out.println("Enter the date (YYYY-MM-DD HH:mm:ss): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String date = reader.readLine();

            String response = makeAPIRequest();
            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
            JsonArray weatherList = jsonResponse.getAsJsonArray("list");

            for (JsonElement element : weatherList) {
                JsonObject data = element.getAsJsonObject();
                String dateTime = data.get("dt_txt").getAsString();

                // Check if the date in the response matches the input date
                if (dateTime.contains(date)) {
                    JsonObject main = data.getAsJsonObject("main");
                    if (main.has("pressure") && !main.get("pressure").isJsonNull()) {
                        double pressure = main.get("pressure").getAsDouble();
                        System.out.println("Pressure at " + dateTime + ": " + pressure + " hPa");
                    } else {
                        System.out.println("Pressure data not available for the given date.");
                    }
                    return;
                }
            }

            System.out.println("Data not available for the given date.");
        } catch (IOException e) {
            System.out.println("Error occurred while fetching data.");
        }
    }

   


}

