package telran.store.controller;

import telran.store.model.Store;
import telran.store.threads.Consumer;
import telran.store.threads.Producer;

public class StoreAppl {

	public static void main(String[] args) {
		Store store = new Store(15);
		Producer producer = new Producer(store, 10);
		Consumer consumer1 = new Consumer(store,5);
		Consumer consumer2 = new Consumer(store,5);
		consumer1.start();
		consumer2.start();
		producer.start();
		

	}

}
