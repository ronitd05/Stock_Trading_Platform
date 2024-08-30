import java .util.*;

public class PortfolioManager {
	private Market market;
	private Map<String, Portfolio> portfolios;
	
	public PortfolioManager(Market market) {
		this.market = market;
		this.portfolios = new HashMap<>();
	}
	
	public boolean buyStocks(String owner, String symbol, int quantity) {
		Stock stock = market.getStock(symbol);
		if(stock != null) {
			Portfolio portfolio = portfolios.getOrDefault(owner, new Portfolio(owner));
			portfolio.buyStock(symbol, quantity);
			portfolios.put(owner, portfolio);
			return true;
		}
		return false;
		
	}
	
	public boolean sellStock(String owner, String symbol, int quantity) {
		Portfolio portfolio = portfolios.get(owner);
		if(portfolio != null && portfolio.sellStock(symbol, quantity)) {
			return true;
		}
		return false;
	}
	
	public void viewPortfolio(String owner) {
		Portfolio portfolio = portfolios.get(owner);
		if(portfolio != null) {
			portfolio.displayPortfolio(market);
		}
		else {
			System.out.println("No Portfolio found for "+owner);
		}
	}
	
}
