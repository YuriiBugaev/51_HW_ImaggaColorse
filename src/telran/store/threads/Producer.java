package telran.store.threads;

import telran.store.model.Store;

public class Producer extends Thread {

	private Store store;
	private int totalProducts;

	public Producer(Store store, int totalProducts) {
		this.store = store;
		this.totalProducts = totalProducts;
	}

	@Override
	public void run() {
		try {
			while (totalProducts>0) {
				store.put();
				totalProducts--;
				sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
