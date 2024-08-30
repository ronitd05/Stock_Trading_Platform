import java.util.Scanner;

public class StockTradingPlatform {
	public static void main(String args[]) {
		Market market = new Market();
		PortfolioManager portfolioManager = new PortfolioManager(market);
		Scanner sc = new Scanner(System.in);
		
		market.addStocks(new Stock("Apple", "Apple Inc.", 1500.0));
		market.addStocks(new Stock("Google", "Alphabet Inc.", 2800.0));
		market.addStocks(new Stock("Amazon", "Amazon.com Inc", 3500.0));
		
		while(true) {
			System.out.println("Welcome to the Stock Trading Platform....");
			System.out.println("1. View Market Data");
			System.out.println("2. Buy Stocks");
			System.out.println("3. Sell Stocks");
			System.out.println("4. View Portfolio");
			System.out.println("5. Exit");
			System.out.println("Please choose an Option");
			int choice = sc.nextInt();
			
			if(choice==1) {
				market.displayMarketData();
			}
			else if(choice==2) {
				System.out.println("Enter Stock Symbol");
				String symbol = sc.next();
				System.out.println("Enter Quantity");
				int quantity = sc.nextInt();
				System.out.println("Enter your Name: ");
				sc.nextLine();
				String buyerName = sc.nextLine();
				if(portfolioManager.buyStocks(buyerName, symbol, quantity)) {
					System.out.println("Stocks Bought Successfully");
				}
				else{
					System.out.println("Failed to buy Stocks. Check the Stock symbol.");
				}
			}
			else if(choice==3) {
				System.out.println("Enter Stock Symbol");
				String sellSymbol = sc.next();
				System.out.println("Enter Quantity");
				int sellQuantity = sc.nextInt();
				System.out.println("Enter your Name: ");
				sc.nextLine();
				String sellerName = sc.nextLine();
				if(portfolioManager.sellStock(sellerName, sellSymbol, sellQuantity)) {
					System.out.println("Stocks Sold Successfully");
				}
				else{
					System.out.println("Failed to sell Stocks. Check the Stock symbol.");
				}
			}
			else if(choice==4) {
				System.out.println("Enter your Name");
				sc.nextLine();
				String userName = sc.nextLine();
				portfolioManager.viewPortfolio(userName);
			}
			else if(choice==5) {
				System.out.println("Thank you for using Stock Trading Platform");
			}
			else{
				System.out.println("Invallid Choice. Please try Again.");
			}
		}
	}
}
