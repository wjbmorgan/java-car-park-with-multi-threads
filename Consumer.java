/**
 * Consumer removes cars that are ready to depart.
 */

public class Consumer extends Thread {

	// consumer will try to get a car from the lift
	Lift lift;

	public Consumer(Lift lift) {
		this.lift = lift;
	}

	public void run() {
		try {
			while (true) {
				// consume a car at random time if conditions satisfied
				Car car = lift.consume();
				System.out.println(car + "departs");
				Thread.sleep(Param.departureLapse());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
