package ko20127260.corejava.rating.KO20127260_CoreJAVA_Rating;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class StudentRating {

	@SuppressWarnings("unchecked")
	public void getStudentRating(String name, Distributions distributions, Assignments a) {

		ArrayList<ArrayList<Object>> ratings = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> stemp = new ArrayList<Object>();
		boolean found = false;
		for(int i=0;i<a.assignments.size();i++) {
			if(a.assignments.get(i).get(1).toString().equalsIgnoreCase(name)) {
				found = true;
			}
		}
		if(found == true) {
			for(Map.Entry<String, Integer> entry : a.subjects.entrySet()) {		
				float test = 0, tc =0, qs = 0, qc=0, lab=0, labc=0, prj=0, prjc=0;			
				for(int i=0;i<a.assignments.size();i++) {
					if(a.assignments.get(i).get(1).toString().equalsIgnoreCase(name)) {

						if(a.assignments.get(i).get(2).toString().equalsIgnoreCase(entry.getKey())) {
							if(a.assignments.get(i).get(3).toString().toLowerCase().contains("test")) {
								test+=(Integer)a.assignments.get(i).get(5);
								tc++;
							}
							if(a.assignments.get(i).get(3).toString().toLowerCase().contains("quiz")) {
								qs+=(Integer)a.assignments.get(i).get(5);
								qc++;
							}
							if(a.assignments.get(i).get(3).toString().toLowerCase().contains("lab")) {
								lab+=(Integer)a.assignments.get(i).get(5);
								labc++;
							}
							if(a.assignments.get(i).get(3).toString().toLowerCase().contains("project")) {
								prj+=(Integer)a.assignments.get(i).get(5);
								prjc++;
							}
						}

					}
				}
				stemp.add(entry.getKey().toString());

				float tr = (((distributions.Distributions.get("TEST")/tc)*test)/100), qr = (((distributions.Distributions.get("QUIZ")/qc)*qs)/100), lr = (((distributions.Distributions.get("LAB WORK")/labc)*lab)/100), pr =  (((distributions.Distributions.get("PROJECT")/prjc)*prj)/100);
				float sum=0;

				if(tc==0) stemp.add("NA");
				else {
					stemp.add(tr);
					sum+=tr;
				}

				if(qc==0) stemp.add("NA");
				else {
					stemp.add(qr);
					sum+=qr;
				}
				if(labc==0) stemp.add("NA");
				else {
					stemp.add(lr);
					sum+=lr;
				}
				if(prjc==0) stemp.add("NA");
				else {
					stemp.add(pr);
					sum+=pr;
				}

				stemp.add(sum);
				ratings.add((ArrayList<Object>) stemp.clone());
				stemp.removeAll(stemp);
			}
			System.out.println(Arrays.asList("Subject", "Test Score", "Quiz Score", "Lab Score","Project Score", "Overall Rating(%)"));
			for(int i=0;i<ratings.size();i++) {
				System.out.println(ratings.get(i));
			}
		}
		else
			System.out.println("No Record Found.");
	}

}
