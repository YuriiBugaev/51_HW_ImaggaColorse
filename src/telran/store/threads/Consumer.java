package telran.store.threads;

import telran.store.model.Store;

public class Consumer extends Thread {

	private Store store;
	private int products;
	
	public Consumer(Store store, int products) {
		this.store = store;
		this.products = products;
	}

	@Override
	public void run() {
		try {
			while (products>0) {
				store.get();
				products--;
				System.out.println(getName());
				sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
