/*
 * Name: Parm Johal
 * ID: V00787710
 * Date: April 9, 2018
 * Filename: EmergencyTriage.java
 * Details: \CSC 115\ Assignment 4
 */

public class EmergencyTriage {
	private Heap<ERPatient> waiting;

	/**
	 * The empty EmergencyTriage is initialized.
	 */
	public EmergencyTriage() {
		waiting = new Heap<>();
	} // end constructor

	/**
	 * A patient is registered at triage. The triage
	 * nurse creates a record for the patient and the
	 * patient is then added to the triage queue.
	 */
	public void register(String lastName, String firstName, String triageCategory) {
		ERPatient newPatient = new ERPatient(lastName, firstName, triageCategory);
		waiting.insert(newPatient);
	} // end register

	/**
	 * Removes the highest priority patient from triage
	 * to enter the Emergency Room.
	 *
	 * Returns: The record of the patient that is moving
	 * into the Emergency Room
	 */
	public ERPatient admitToER() {
		return waiting.getRootItem();
	} // end admitToER

	/**
	 * Retrieves the record of the patient who currently
	 * has the highest priority. The patient's record
	 * remains in the queue.
	 *
	 * Returns: The record of the patient.
	 */
	public ERPatient whoIsNext() {
		return waiting.peek();
	} // end whoIsNext

	/**
	 * Returns: The number of patients who have been
	 * registered into triage but not yet admitted to
	 * the emergency room.
	 */
	public int numberOfPatientsWaiting() {
		return waiting.size();
	} // end numberOfPatientsWaiting

	// Internal testing
	public static void main(String[] args) {
		EmergencyTriage waitList = new EmergencyTriage();
		waitList.register("Skywalker", "Anakin", "Acute");
		waitList.register("Irving", "Kyrie", "Major fracture");
		waitList.register("Jane", "Mary", "Chronic");
		waitList.register("Man", "Bat", "Ambulatory");
		System.out.println(waitList.whoIsNext());
		System.out.println(waitList.numberOfPatientsWaiting());
		waitList.register("Skywalker", "Luke", "Life-threatening");
		System.out.println(waitList.whoIsNext());
		System.out.println(waitList.numberOfPatientsWaiting());
		System.out.println(waitList.admitToER());
		System.out.println(waitList.admitToER());
		System.out.println(waitList.numberOfPatientsWaiting());
		System.out.println(waitList.whoIsNext());
	}
}
