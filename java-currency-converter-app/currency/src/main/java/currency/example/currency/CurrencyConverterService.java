package currency.example.currency;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConverterService {

  private final RestTemplate restTemplate;

  public CurrencyConverterService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public CurrencyConversionResponse convert(String fromCurrency, String toCurrency, double amount) {
    String url = "https://api.exchangerate-api.com/v4/latest/" + fromCurrency;
    CurrencyApiResponse apiResponse = restTemplate.getForObject(url, CurrencyApiResponse.class);

    double rate = apiResponse.getRates().get(toCurrency);
    double convertedAmount = amount * rate;

    CurrencyConversionResponse response = new CurrencyConversionResponse();
    response.setConvertedAmount(convertedAmount);
    response.setFromCurrency(fromCurrency);
    response.setToCurrency(toCurrency);

    return response;
  }
}
