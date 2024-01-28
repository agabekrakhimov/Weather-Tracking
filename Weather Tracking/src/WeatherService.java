import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private static final String API_KEY = "ed58713360421eef15d8fc22155b955d"; // Replace with your actual API key
    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid={API key}"; // Replace with your API's base URL

    public String getWeatherData(String location) throws Exception {
        String urlString = WEATHER_API_URL + "?key=" + API_KEY + "&q=" + location;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try {
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Here, you can parse the response as needed
                return response.toString();
            } else {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
        } finally {
            connection.disconnect();
        }
    }
}
