package telran.store.model;

public class Store {

	private int product;
	private int capacity;
	private static Object monitor = new Object();

	public Store(int capacity) {
		this.capacity = capacity;
	}

	public void get() {
		synchronized (monitor) {
			while (product < 1) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			product--;
			System.out.println("Sell one item, and product = " + product);
			monitor.notifyAll();
		}
	}

	public void put() {
		synchronized (monitor) {
			while (product >= capacity) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			product++;
			System.out.println("Buy one item, and product = " + product);
			monitor.notifyAll();
		}
	}
}
