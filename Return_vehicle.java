/**
 * Return_vehicle picks up cars from the last section and tows them to the lift.
 */

public class Return_vehicle extends Thread {

	// return_vehicle will try to get a car from the last section and put it
	// into the lift
	Section section;
	Lift lift;

	public Return_vehicle(Section section, Lift lift) {
		this.section = section;
		this.lift = lift;
	}

	public void run() {
		try {
			while (true) {
				// get a car from the last section
				Car car = section.get();
				// change the car's state for consumer to consume
				car.newcar = false;
				System.out.println(car + "leaves section 6");
				Thread.sleep(Param.TOWING_TIME);
				// tow the car to the lift
				lift.returnCar(car);
				System.out.println(car + "enters lift to go down");
				// move the lift
				lift.move();
				Thread.sleep(Param.OPERATE_TIME);
				lift.moveTo(Lift.State.GROUND);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
