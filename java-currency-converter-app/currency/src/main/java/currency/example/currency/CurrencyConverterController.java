package currency.example.currency;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {

    private final CurrencyConverterService converterService;

    public CurrencyConverterController(CurrencyConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping("/convert")
    public CurrencyConversionResponse convertCurrency(@RequestBody CurrencyConversionRequest request) {
        return converterService.convert(request.getFromCurrency(), request.getToCurrency(), request.getAmount());
    }
}
