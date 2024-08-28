document.getElementById('currencyForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get input values
    const amount = document.getElementById('amount').value;
    const fromCurrency = document.getElementById('fromCurrency').value.toUpperCase();
    const toCurrency = document.getElementById('toCurrency').value.toUpperCase();

    // Validate input values
    if (!amount || !fromCurrency || !toCurrency) {
        alert('Please fill in all fields.');
        return;
    }

    // Show "Converting" message
    document.getElementById('loading').style.display = 'block';

    // Disable the button to prevent multiple submissions
    const button = document.getElementById('convertButton');
    button.disabled = true;

    // Send request to backend
    fetch('/api/convert', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            fromCurrency: fromCurrency,
            toCurrency: toCurrency,
            amount: amount
        })
    })
    .then(response => response.json())
    .then(data => {
//        console.log('Response data:', data);

        document.getElementById('loading').style.display = 'none';
        button.disabled = false;

        // Check if the data is valid
        if (data && data.convertedAmount !== undefined && data.fromCurrency && data.toCurrency) {
            // Display the result
            document.getElementById('result').innerHTML = `
                Converted Amount: ${data.convertedAmount} ${data.toCurrency}
                <br>From Currency: ${data.fromCurrency}
                <br>To Currency: ${data.toCurrency}
            `;
        } else {
            // Show an error message
            document.getElementById('result').innerHTML = `
                <span style="color: #fff;">Conversion failed. Please try again.❗</span>
            `;
        }
    })
    .catch(error => {
        // Hide "Converting" message and enable the button
        document.getElementById('loading').style.display = 'none';
        button.disabled = false;

        // Show an error message
        document.getElementById('result').innerHTML = `
            <span style="color: red;">Error: Unable to process the request. Please try again later.</span>
        `;

        console.error('Error:', error);
    });
});
