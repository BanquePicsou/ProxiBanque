package fr.adaming.service;

import java.math.BigDecimal;

import fr.adaming.ws.QuoteData;

public interface IBourseService {

	/**
	 * This method retrieves a current stock quote. Use a license key of 0 for
	 * testing.
	 * 
	 * @param licenseKey
	 * @param stockSymbol
	 * @return returns com.cdyne.ws.QuoteData
	 */
	public QuoteData getQuote(String stockSymbol, String licenseKey);

	/**
	 * This method retrieves just a stock price. Use a license key of 0 for
	 * testing.
	 * 
	 * @param licenseKey
	 * @param stockSymbol
	 * @return returns java.math.BigDecimal
	 */
	public BigDecimal getQuickQuote(String stockSymbol,String licenseKey);

	/**
     * This method retrieves the stock information and returns it in a dataset.  Use a , to diplay multiple quotes.  Use a license key of 0 for testing.
     * 
     * @param licenseKey
     * @param stockSymbols
     * @return
     *     returns com.cdyne.ws.GetQuoteDataSetResponse.GetQuoteDataSetResult
     */
    public fr.adaming.ws.GetQuoteDataSetResponse.GetQuoteDataSetResult getQuoteDataSet(String stockSymbols,String licenseKey);

}
