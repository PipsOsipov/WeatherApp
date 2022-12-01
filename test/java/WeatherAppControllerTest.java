class WeatherAppControllerTest {

    private String line;

    @org.junit.jupiter.api.Test
    void initialize() {
        String output = getURLcontent("https://api.openweathermap.org/data/2.5/weather?q=  &appid=e7f998d87b31bd0a5b36b00a1acab052&units=metric");
        if (output.isEmpty()){
            System.out.println("error");
        }
    }

    @org.junit.jupiter.api.Test
    String getURLcontent(String urlAdress) {
    if (line == null)
        System.out.println("city not found");
        return urlAdress;
    }

}