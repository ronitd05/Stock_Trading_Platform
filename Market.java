import java.util.ArrayList;

public class Market {
	private ArrayList<Stock> stocks;
	
	public Market() {
		stocks = new ArrayList<>();
	}
	
	public void addStocks(Stock stock) {
		stocks.add(stock);
	}
	
	public Stock getStock(String symbol) {
		for(Stock stock : stocks) {
			if(stock.getSymbol().equalsIgnoreCase(symbol)) {
				return stock;
			}
		}
		return null;
	}
	
	public void displayMarketData() {
		System.out.println("Market Data: ");
		for(Stock stock : stocks) {
			System.out.println("Symbol: "+ stock.getSymbol() + ", Name: "+ stock.getName() + ", Price: "+ stock.getPrice());
		}
	}
}
