package com.bravo.bakery.currency;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRate {
	private static final Logger log = Logger.getLogger(CurrencyRate.class);
	// essential URL structure is built using constants
	public static final String ACCESS_KEY = "7ff5b779eb222e6a4b51d8a739231ebf"; // ¯\\_(ツ)_/¯ this is just a demo app
	public static final String BASE_URL = "http://apilayer.net/api/";
	public static final String ENDPOINT = "live";

	// this object is used for executing requests to the (REST) API
	static CloseableHttpClient httpClient = HttpClients.createDefault();

	/**
	 * 
	 * Notes:
	 * 
	 * A JSON response of the form {"key":"value"} is considered a simple Java JSONObject. To get a simple value from the JSONObject, use: .get("key");
	 * 
	 * A JSON response of the form {"key":{"key":"value"}} is considered a complex Java JSONObject. To get a complex value like another JSONObject, use: .getJSONObject("key")
	 * 
	 * Values can also be JSONArray Objects. JSONArray objects are simple, consisting of multiple JSONObject Objects.
	 * 
	 * 
	 */

	// sendLiveRequest() function is created to request and retrieve the data
	public BigDecimal convert(BigDecimal mountUSD) {
		BigDecimal mountCOP = null;
		Double currencyRateUSDCOP = null;
		// The following line initializes the HttpGet Object with the URL in order to send a request
		HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

		try {
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();

			// the following line converts the JSON Response to an equivalent Java Object
			JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

			currencyRateUSDCOP = exchangeRates.getJSONObject("quotes").getDouble("USDCOP");
			mountCOP = mountUSD.multiply(BigDecimal.valueOf(currencyRateUSDCOP));

			response.close();
		} catch (ClientProtocolException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (ParseException e) {
			log.error(e);
		} catch (JSONException e) {
			log.error(e);
		} finally {
//			try {
//				httpClient.close();
//			} catch (IOException e) {
//				log.error(e);
//			}
		}
		return mountCOP;
	}

	public static void main(String[] args) throws IOException {
//		sendLiveRequest();
//		httpClient.close();
//		new BufferedReader(new InputStreamReader(System.in)).readLine();
//		log.debug("5.5 USD -> " + CurrencyRate.convert(new BigDecimal(5.5)) + " COP");
	}
}