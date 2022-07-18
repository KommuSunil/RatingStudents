package ko20127260.corejava.rating.KO20127260_CoreJAVA_Rating;
import java.util.*;

public class Assignments {

	public ArrayList<ArrayList<Object>> assignments = new ArrayList<ArrayList<Object>>();
	public TreeMap<String, Integer> subjects = new TreeMap<String, Integer>();
	public TreeMap<String, Integer> students = new TreeMap<String, Integer>();


	@SuppressWarnings("unchecked")
	public Assignments() {	
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Electro Fields","test_1","21-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Bhagath","Electro Fields","test_1","21-Jul-16",78)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Chaya","Electro Fields","test_1","21-Jul-16",68)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Esharath","Electro Fields","test_1","21-Jul-16",87)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Bhagath","Electro Fields","quiz_1","22-Jul-16",20)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Chaya","Electro Fields","lab_1","23-Jul-16",10)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Electro Fields","project_1","24-Jul-16",100)));		
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Davanth","Electro Fields","project_1","24-Jul-16",100)));		
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Bhagath","Electro Fields","quiz_2","25-Jul-16",50)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Electro Fields","quiz_1","26-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Bhagath","Electro Fields","lab_1","27-Jul-16",10)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Chaya","Electro Fields","project_1","28-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Bhagath","Electro Fields","project_1","28-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Computing Techniques","test_1","29-Jul-16",86)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Electro Fields","quiz_2","29-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Bhagath","Computing Techniques","project_1","30-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Electro Fields","lab_1","30-Jul-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Chaya","Computing Techniques","quiz_1","31-Jul-16",20)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Ananth","Electro Fields","test_2","1-Aug-16",100)));
		assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1,"Chaya","Electro Fields","test_2","1-Aug-16",92)));
		this.updateStudents();
		this.updateSubjects();	
	}

	public void updateSubjects() {
		subjects.clear();
		int subcnt=0;
		for(int i=0;i<assignments.size();i++) {
			if(!subjects.containsKey(assignments.get(i).get(2).toString())) {
				subjects.put(assignments.get(i).get(2).toString(), subcnt);
				subcnt++;
			}
		}
	}

	public void updateStudents() {
		students.clear();
		int stucnt=0;
		for(int i=0;i<assignments.size();i++) {
			if(!students.containsKey(assignments.get(i).get(1).toString())) {
				students.put(assignments.get(i).get(1).toString(), stucnt);
				stucnt++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void createStudentRecord(String student_name, String subject, String assignment_category, String dateOfSubmission, int points) {
		this.assignments.add(new ArrayList<Object>(Arrays.asList(this.assignments.size()+1, student_name, subject, assignment_category, dateOfSubmission, points)));
		System.out.println("Student '"+ student_name + "' created successfully with below details:");
		System.out.println(Arrays.asList("S.No", "StudentName", "Subject", "AssignmentCategory", "DateOfSubmission", "Points"));
		System.out.println(assignments.get(assignments.indexOf(Arrays.asList(this.assignments.size(), student_name, subject, assignment_category, dateOfSubmission, points)))+"\n");
		this.updateStudents();
		this.updateSubjects();
	}

	public void readStudentRecord(String student_name) {
		boolean found = false;
		int cnt=0;
		for(int i=0;i<this.assignments.size();i++) {
			if(this.assignments.get(i).get(1).toString().toLowerCase().contains(student_name.toLowerCase())) {
				++cnt;
				if(cnt==1)
					System.out.println(Arrays.asList("S.No", "StudentName", "Subject", "AssignmentCategory", "DateOfSubmission", "Points"));
				System.out.println(this.assignments.get(i));
				found = true;
			}
		}
		if(found==false) {
			System.out.println("Record not Found");
		}
	}

	public void updateStudentRecord(int sno, String student_name, String subject, String assignment_category, String dateOfSubmission, int points) {
		boolean found = false;
		for(int i=0;i<this.assignments.size();i++) {
			if((Integer)this.assignments.get(i).get(0) == sno) {
				this.assignments.get(i).set(1, student_name);
				this.assignments.get(i).set(2, subject);
				this.assignments.get(i).set(3, assignment_category);
				this.assignments.get(i).set(4, dateOfSubmission);
				this.assignments.get(i).set(5, points);
				found = true;
				System.out.println("Record "+ sno +" updated successfully.");
			}
		}
		if(found==false) {
			System.out.println("Record not Found");
		}
	}

	public void deleteStudentRecord(int sno) {
		boolean found = false;
		for(int i=0;i<this.assignments.size();i++) {
			if((Integer)this.assignments.get(i).get(0) == sno) {
				this.assignments.remove(i);
				this.resetSno();
				found = true;
				System.out.println("Record "+ sno +" deleted successfully.");
			}
		}
		if(found==false) {
			System.out.println("Record not Found");
		}
	}

	public void displayStudentRecords(){
		System.out.println(Arrays.asList("S.No", "StudentName", "Subject", "AssignmentCategory", "DateOfSubmission", "Points"));
		for(int i=0;i<this.assignments.size();i++) {
			System.out.println(this.assignments.get(i));
		}
	}

	public void resetSno() {
		int cnt = 0;
		for(int i=0;i<this.assignments.size();i++) {
			this.assignments.get(i).set(0, ++cnt);
		}
	}
}
