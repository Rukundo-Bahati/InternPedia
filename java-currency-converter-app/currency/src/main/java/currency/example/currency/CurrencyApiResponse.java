package currency.example.currency;

import java.util.Map;

public class CurrencyApiResponse {
    private Map<String, Double> rates;

    // Getters and setters
    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
