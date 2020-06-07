/*
 * Name: Parm Johal
 * ID: V00787710
 * Date: March 20, 2018
 * Filename: AdmittedPatients.java
 * Details: \CSC 115\ Assignment 3
 */

/**
 * AdmittedPatients is a data structure that
 * is used to maintain a current list of
 * patients in a hospital. The data structure
 * of choice is a referenced-based structure
 * that contains a subset of the capabilities
 * of a standard BinarySearchTree ADT. Because
 * the elements are unique, there are no
 * duplicates in this tree. A BinarySearch tree
 * is defined recursively: each left subtree
 * rooted at any node contains elements that
 * lexicographically smaller than the element in
 * the node, while the right subtree rooted at
 * that node contains elements that are
 * lexicographically greater than the element in
 * that node.
 */
public class AdmittedPatients {

	/**
	 *The root node is null if there are no
	 *patient records in the tree. It is not
	 *null and contains a record if the tree
	 *is not empty. It only accessible to
	 *programs that are within the same package
	 *as this class
	 */
	protected TreeNode root;

	//creates an empty binary tree
	public AdmittedPatients() {
		root = null;

	}

	/**
	 * Enters the record of an admitted patients
	 * into the current BinarySearchTree,
	 * maintaining the ordering of the tree.
	 */

	public void admit(HospitalPatient patient) {
		TreeNode p = new TreeNode(patient);
		if(root == null) {
			root = p;
		} else {
			root = admit(p, root);
		}
	}
	private TreeNode admit (TreeNode p, TreeNode curr) {
		if(curr == null) {
			curr = p;
			p.parent = curr;
			p.left = null;
			p.right = null;
		}
		if(curr.item.compareTo(p.item) > 0) {
			curr.left = admit(p, curr.left);
		}
		if(curr.item.compareTo(p.item) < 0) {
			curr.right = admit(p, curr.right);
		}
		return curr;
	}

	/**
	 * Removes a patient's record from the
	 * BinarySearchTree.
	 */
	public void discharge(HospitalPatient patient) {
		discharge(patient, root);
	} // end discharge

	private void discharge(HospitalPatient patient, TreeNode curr) {
		if(curr.item.equals(patient)) {
			if(curr.left == null && curr.right == null) { // Case 1
				if(curr.parent.left == null) {
					curr = curr.parent;
					curr.left = null;
				} else {
					curr = curr.parent;
					curr.right = null;
				}
			} // End Case 1
			else if((curr.left == null && curr.right != null) || (curr.left != null && curr.right == null)) { // Case 2
				if(curr.left == null) {
					if(curr.parent.left == null) {
						curr.parent.left = curr.right;
					} else if(curr.parent.right == curr) {
						curr.parent.right = curr.right;
					}
				} else {
					if(curr.parent.right == null) {
						curr.parent.left = curr.left;
					} else if(curr.parent.right == curr) {
						curr.parent.right = curr.left;
					}
				}
				curr = null;
			} // End Case 2
			else { // Case 3
				TreeNode stationary = new TreeNode();
				stationary = curr;
				curr = curr.right;
				while(curr.left != null) {
					curr = curr.left;
				}
				stationary.item = curr.item;

				if(stationary.right == curr) {
					stationary.right = curr.right;
					curr = null;
				} else {
					curr.parent.left = null;
				}
			} // End Case 3
		} else {
			// recursively traverses the tree as long as the patient is not found
			if(curr.left != null) {
				discharge(patient, curr.left);
			}
			if(curr.right != null) {
				discharge(patient, curr.right);
			} // End if
		} // end if
	} // End discharge

	/**
	 * Retrieves the information about a patient,
	 * given an id number.
	 */
	public HospitalPatient getPatientInfo(String id) {
		if(root == null) {
			return null;
		} else {
			return getPatientInfo(id, root);
		}
	}
	private HospitalPatient getPatientInfo(String id, TreeNode curr) {
		if (curr.item.getId().equals(id)) {
			return curr.item;
		}
		if(curr.left != null) {
			return getPatientInfo(id, curr.left); // go to left subpatient Node and repeat
		} // end if
		if(curr.right != null) {
			return getPatientInfo(id, curr.right); // go to right subpatient Node and repeat
		} // end if
		return null;
	} // end getPatientInfo

	/**
	 * Prints out a list of patient locations in
	 * alphabetical order, one entry per line.
	 */
	public void printLocations() {
		if(root == null) {
			System.out.println("No patients admitted");
		} else {
			try {
				printLocations(root);
			} catch (NullPointerException e) {

			}
		}
	}
	private void printLocations(TreeNode curr) {
		if(curr.left != null) { // if(the current patientNodes left and right ref is null)
			printLocations(curr.left); // print out the patient Node
		}
		System.out.println(curr.item.getLocation()); // go to left subpatient Node and repeat

		if(curr.right != null) { // print current patient Node
			printLocations(curr.right); // go to right subpatient Node and repeat
		}
	}
	// Used for internal testing.
	public static void main(String[] args) {
		AdmittedPatients hospital = new AdmittedPatients();

		HospitalPatient p0 = new HospitalPatient(new SimpleDate(2018,1,1),"Trump","Donald",'D',169);
		//HospitalPatient p0 = new HospitalPatient(new SimpleDate(2018,1,1),"Trump","Donald",'D',169);
		HospitalPatient p1 = new HospitalPatient(new SimpleDate(2018,3,9),"Mill","Meek",'B',420);
		HospitalPatient p2 = new HospitalPatient(new SimpleDate(2018,3,7),"Bandit","Yamcha",'A',100);
		HospitalPatient p3 = new HospitalPatient(new SimpleDate(2018,5,1),"Solo","Han",'C',100);
		HospitalPatient p4 = new HospitalPatient(new SimpleDate(2018,6,6),"Oh","Yugi",'A',101);
		//System.out.println(p1.compareTo(p2));
		hospital.admit(p0);
		hospital.admit(p1);
		//hospital.admit(new HospitalPatient(new SimpleDate(2018,3,9),"Mill","Meek",'B',420));
		hospital.admit(p2);
		hospital.admit(p3);
		hospital.admit(p4);
		hospital.printLocations();
		System.out.println(p0.getId());
		System.out.println(p1.getId());
		//hospital.getPatientInfo("Mill_1");
		//ViewableTree ap = new ViewableTree(hospital);
		//ap.showFrame();
		//ap.setTree(hospital);
		//System.out.println("Taking patient out:");
		System.out.println(hospital.getPatientInfo("Oh_5"));
		System.out.println(hospital.getPatientInfo("Trump_0"));
		hospital.discharge(p2);
		System.out.println();
		hospital.printLocations();
		//hospital.discharge(p2);
		//hospital.discharge(p1);




	}
}
