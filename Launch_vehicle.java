/**
 * Launch_vehicle picks up cars from the lift and tows them to the first
 * section.
 */

public class Launch_vehicle extends Thread {

	// launch_vehicle will try to get a car from the lift and put it
	// into the first section
	Lift lift;
	Section section;

	public Launch_vehicle(Lift lift, Section section) {
		this.lift = lift;
		this.section = section;
	}

	public void run() {
		try {
			while (true) {
				// launch a car from the lift
				Car car = lift.launchCar();
				System.out.println(car + "leaves the lift");
				Thread.sleep(Param.TOWING_TIME);
				// tow the car to the first section
				section.put(car);
				System.out.println(car + "enters section 1");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
