import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherParser {

    public WeatherData parse(String jsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

        // Assuming JSON structure is something like:
        // { "temperature": 20.5, "humidity": 50.0, "windSpeed": 5.5, "description": "Sunny" }
        // Adjust the keys according to your API's response format.

        double temperature = jsonObject.get("temperature").getAsDouble();
        double humidity = jsonObject.get("humidity").getAsDouble();
        double windSpeed = jsonObject.get("windSpeed").getAsDouble();
        String description = jsonObject.get("description").getAsString();

        return new WeatherData(temperature, humidity, windSpeed, description);
    }
}
