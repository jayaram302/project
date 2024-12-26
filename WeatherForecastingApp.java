import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
public class WeatherForecastingApp {
    private static final String API_KEY = "your_api_key";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    public static void main(String[] args) {
        String city = "London"; // Change to desired city
        String response = getWeatherData(city);
        parseWeatherData(response);
    }
    private static String getWeatherData(String city) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    private static void parseWeatherData(String response) {
        JSONObject jsonObject = new JSONObject(response);
        String cityName = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        double humidity = main.getDouble("humidity");
        String weatherDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        System.out.println("Weather in " + cityName + ":");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Description: " + weatherDescription);
    }
}