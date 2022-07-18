package ko20127260.corejava.rating.KO20127260_CoreJAVA_Rating;
import java.util.Scanner;

public class MainApp {
	
	// This is a main class for accessing the features 

	public static void main(String[] args) {
		Distributions distributions = new Distributions();
		Assignments assignments = new Assignments();
		StudentRating studentRating = new StudentRating();
		SubjectRating subjectRating = new SubjectRating();

		try {
			while(true) {
				int option=0;
				Scanner scanner = new Scanner(System.in);
				System.out.println("\n---------------------------");
				System.out.println("         MENU              ");
				System.out.println("---------------------------");
				System.out.println("0. Exit");
				System.out.println("1. Display student average score per assignment category & overall rating for assigned subject(s).");
				System.out.println("2. Display subject average score per assignment category & overall rating for assigned student(s).");
				System.out.println("3. Add assignment category with weights to the existing list.");
				System.out.println("4. Read assignment category with weights from the existing list.");
				System.out.println("5. Update assignment category with weights in the existing list.");
				System.out.println("6. Remove assignment category with weights from the existing list.");
				System.out.println("7. Display all assignment categories with their weights.");
				System.out.println("8. CREATE a new student record with details to the exisitng list.");
				System.out.println("9. READ a student record from the existing list.");
				System.out.println("10. UPDATE a student record in the existing list.");
				System.out.println("11. DELETE a student record from the exisitng list.");
				System.out.println("12. Display all students records with details from the existing list.\n");
				option = scanner.nextInt();
				switch(option) {
				case 0:
					scanner.close();
					System.out.println("Thank you! GoodBye.");
					System.exit(0);
					break;
				case 1:
					System.out.println("Please enter the Student Name:");
					scanner.nextLine();
					String name = scanner.nextLine();
					studentRating.getStudentRating(name, distributions, assignments);
					break;
				case 2:
					System.out.println("Please enter the Subject Name:");
					scanner.nextLine();
					String subject = scanner.nextLine();
					subjectRating.getSubjectRating(subject, distributions, assignments);
					break;
				case 3:
					System.out.println("Please enter the new Assignment Category:");
					scanner.nextLine();
					String assignmentCategory = scanner.nextLine();
					System.out.println("Please enter Weight for the new Assignment Category:");
					int weight = scanner.nextInt();
					distributions.createAssignmentCategory(assignmentCategory, weight);
					break;
				case 4:
					System.out.println("Please enter the Assignment Category:");
					scanner.nextLine();
					String assignmentCategory1 = scanner.nextLine();
					distributions.readAssignmentCategory(assignmentCategory1);
					break;
				case 5:
					System.out.println("Please enter the new Assignment Category:");
					scanner.nextLine();
					String assignmentCategory2 = scanner.nextLine();
					System.out.println("Please enter Weight for the new Assignment Category:");
					int weight1 = scanner.nextInt();
					distributions.updateAssignmentCategory(assignmentCategory2, weight1);
					break;
				case 6:
					System.out.println("Please enter the new Assignment Category:");
					scanner.nextLine();
					String assignmentCategory3 = scanner.nextLine();
					distributions.deleteAssignmentCategory(assignmentCategory3);
					break;
				case 7:
					distributions.displayAssignmentCategories();
					break;
				case 8:
					System.out.println("Please enter the student name:");
					scanner.nextLine();
					String name1 = scanner.nextLine();
					System.out.println("Please enter the subject:");
					String subject1 = scanner.nextLine();
					System.out.println("Please enter the assignment category:");
					String assgCat = scanner.nextLine();
					System.out.println("Please enter the new date of submission (DD-Month-YY Ex: 17-Jul-22):");
					String dos = scanner.nextLine();
					System.out.println("Please enter the points:");
					int points = scanner.nextInt();
					assignments.createStudentRecord(name1, subject1, assgCat, dos, points);
					break;
				case 9:
					System.out.println("Please enter the student name:");
					scanner.nextLine();
					String sname = scanner.nextLine();
					assignments.readStudentRecord(sname);
					break;
				case 10:
					assignments.displayStudentRecords();
					System.out.println("Please enter the s.no from the above list to update that record:");
					int sno = scanner.nextInt();
					System.out.println("Please enter the student name:");
					scanner.nextLine();
					String sn = scanner.nextLine();
					System.out.println("Please enter the subject:");
					String su = scanner.nextLine();
					System.out.println("Please enter the assignment category:");
					String ac = scanner.nextLine();
					System.out.println("Please enter the date of submission:");
					String ds = scanner.nextLine();
					System.out.println("Please enter the points:");
					int p = scanner.nextInt();
					assignments.updateStudentRecord(sno ,sn, su, ac, ds, p);
					break;
				case 11:
					assignments.displayStudentRecords();
					System.out.println("Please enter the S.NO from the above list to delete that record:");
					int slno = scanner.nextInt();
					assignments.deleteStudentRecord(slno);
					break;
				case 12:
					assignments.displayStudentRecords();
					break;
				default:
					System.out.println("Please enter a valid option or enter 0 to exit");
					break;
				}
			}
		}	
		catch(Exception e) {
			System.out.println("Program terminated due to Exception:" + e);
		}
	}

}
