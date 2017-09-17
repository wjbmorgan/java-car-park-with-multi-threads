/**
 * Vehicles picks up cars from section i and delivers them to the successor
 * section.
 */

public class Vehicle extends Thread {

	// the number of this vehicle and sections it works on
	int i;
	Section section;
	Section section2;

	public Vehicle(int i, Section section, Section section2) {
		this.i = i;
		this.section = section;
		this.section2 = section2;
	}

	public void run() {
		try {
			while (true) {
				// get a car from the former section
				Car car = section.get();
				System.out.println(car + "leaves section " + (i + 1));
				Thread.sleep(Param.TOWING_TIME);
				// tow the car to the latter section
				section2.put(car);
				System.out.println(car + "enters section " + (i + 2));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
