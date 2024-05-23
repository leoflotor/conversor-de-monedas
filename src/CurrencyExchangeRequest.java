import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchangeRequest {
    String address = "https://v6.exchangerate-api.com/v6/7f2f0712af360d476cfafe5c/pair/";

    CurrencyExchangeRate currencyExchange(String fromCurrency, String toCurrency) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address + fromCurrency + "/" + toCurrency))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyExchangeRate.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("The specified currency is not valid.");
        }
    }
}
