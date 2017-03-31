package fr.adaming.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import fr.adaming.ws.DelayedStockQuote;
import fr.adaming.ws.DelayedStockQuoteSoap;
import fr.adaming.ws.GetQuoteDataSetResponse.GetQuoteDataSetResult;
import fr.adaming.ws.QuoteData;

@Service
public class BourseService implements IBourseService {

	DelayedStockQuote dsq = new DelayedStockQuote();

	DelayedStockQuoteSoap dsqs = dsq.getDelayedStockQuoteSoap();

	@Override
	public QuoteData getQuote(String stockSymbol, String licenseKey) {
		
		return dsqs.getQuote(stockSymbol, "0");
	}

	@Override
	public BigDecimal getQuickQuote(String stockSymbol, String licenseKey) {
		
		return dsqs.getQuickQuote(stockSymbol, "0");
	}

	@Override
	public GetQuoteDataSetResult getQuoteDataSet(String stockSymbols, String licenseKey) {
		
		return dsqs.getQuoteDataSet(stockSymbols, "0");
	}

	

}
