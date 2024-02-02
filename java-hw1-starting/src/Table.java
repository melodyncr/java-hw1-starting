
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a table contains rows of Instructor
 *
 */
public class Table implements Iterable<Instructor> {
	
	private ArrayList<Instructor> instructors = new ArrayList<>();
	
	/**
	 * Add an instructor object to the table.
	 * If the ID of the instructor already exists in the table, then 
	 * do not add and return false.  Otherwise, add the instructor object
	 * and return true.
	 * @param  inst object to be added to table
	 * @return
	 */
	public boolean insert(Instructor inst) {
		//checks if instructor already exits
		for (Instructor existingInstructors : instructors) {
			//checks ID - Verification
			if (existingInstructors.getID() == inst.getID()) {
				return false; // ID already exists
			}
		}
		//OTHERWISE
		instructors.add(inst);
		return true;
	}
	
	/**
	 * Remove the instructor object with ID value
	 * from the table.  Return false if no such object
	 * exists, other return true.
	 * @param ID
	 */
	public boolean delete(int ID) {
		Iterator<Instructor> iter = instructors.iterator();
		//establishes an iterator with a specific type
		while (iter.hasNext()) {//checks what is in the array list
			Instructor inst = iter.next();//retreives next element
			if (inst.getID() == ID) {//matches ID? yes. okay remove
				iter.remove();
				return true;
			}
		}
		return false;// not specific ID? then does not exist and cannot be removed
	}
	/**
	 * Return the Instructor object with the value ID,
	 * Return null if no such object exists in the table
	 * @param ID
	 */
	public Instructor lookup(int ID) {
		for( Instructor inst: instructors){//for every inst in array list instructors
			if(inst.getID() == ID){//checks if object exists
				return inst;
			}

		}
		return null; //no object exists
	}
	
	/**
	 * Return a Table of Instructor objects filtered by the 
	 * predicate  attrName = value 
	 * @param attrName can be ID, name, dept_name or salary
	 * @param search value of data type int or String.
	 */
	public Table eval(String attrName, Object value) {
		Table result = new Table();

		for (Instructor inst : instructors) {
			switch (attrName) {
				case "ID":
					if (inst.getID() == (int) value) {
						result.insert(inst);
					}
					break;
				case "name":
					if (inst.getName().equals(value)) {
						result.insert(inst);
					}
					break;
				case "dept_name":
					if (inst.getDept_name().equals(value)) {
						result.insert(inst);
					}
					break;
				case "salary":
					if (inst.getSalary() == (double) value) {
						result.insert(inst);
					}
					break;
			}
		}

		return result;
	}
	
	public Iterator<Instructor> iterator() {
		return instructors.iterator();
	}
	
	public String toString() {
		if (instructors.isEmpty()) {
			return "Empty Table";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Instructor t : this) {
				sb.append(t.toString());
				sb.append("\n");
			}
			return sb.toString();
		}
	}

}
