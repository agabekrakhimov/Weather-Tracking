import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Weather Tracker");
            System.out.print("Enter a location to get current weather data: ");
            String location = scanner.nextLine();

            // Assuming WeatherService is your class to interact with the weather API
            WeatherService weatherService = new WeatherService();
            String weatherData = weatherService.getWeatherData(location);

            // Display the weather data
            System.out.println("Current Weather Data:");
            System.out.println(weatherData);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
