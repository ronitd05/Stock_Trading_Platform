import java.util.HashMap;
import java.util.Map;

public class Portfolio {
	private String owner;
	private Map<String, Integer> stocks;
	
	public Portfolio(String owner) {
		this.owner = owner;
		this.stocks = new HashMap<>();
	}
	
	public String getOwner() {
		return owner;
	}
	
	public Map<String, Integer> getStocks(){
		return stocks;
	}
	
	public void buyStock(String symbol, int quantity) {
		stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
	}
	
	public boolean sellStock(String symbol, int quantity) {
		if(stocks.containsKey(symbol) && stocks.get(symbol) >= quantity) {
			stocks.put(symbol, stocks.get(symbol) - quantity);
			if(stocks.get(symbol)==0) {
				stocks.remove(symbol);
			}
			return true;
		}
		return false;
	}
	
	public void displayPortfolio(Market market) {
		System.out.println("Portfolio for "+ owner + ": ");
		for(Map.Entry<String, Integer> entry : stocks.entrySet()) {
			Stock stock = market.getStock(entry.getKey());
			if(stock != null) {
				System.out.println("Symbol: " + entry.getKey() + ", Quantity: " + entry.getValue());
			}
		}
	}

}
