/**
 * Sections are the place where cars park.
 */

public class Section {

	// the number of this section, may contains a car
	int i;
	private Car car;

	public Section(int i) {
		this.i = i;
		this.car = null;
	}

	// conditions to put a car for vehicles
	public synchronized void put(Car car) throws InterruptedException {
		while (this.car != null)
			wait();
		this.car = car;
		notifyAll();
	}

	// conditions to get a car for vehicles
	public synchronized Car get() throws InterruptedException {
		while (this.car == null)
			wait();
		Car temp = this.car;
		this.car = null;
		notifyAll();
		return temp;
	}

	// get the car of this section
	public Car getCar() {
		return car;
	}

}
