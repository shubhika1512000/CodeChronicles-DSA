import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class TopStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive_set = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative_set = new HashSet<>(Arrays.asList(negative_feedback));

        int[] points = new int[report.length];

        Queue<Integer> students = new PriorityQueue<>(
            (index_s1, index_s2)->{
                if(points[index_s1] != points[index_s2])
                    return points[index_s1] - points[index_s2];
                else 
                    return student_id[index_s2]-student_id[index_s1];
                
            }
        );

        for(int i = 0; i < report.length; i++) {
            String[] rep_i = report[i].split(" ");

            int point = 0;
            for(String feedback: rep_i) {
                if(positive_set.contains(feedback)) point +=3;
                else if(negative_set.contains(feedback)) point -=1;
            }

            points[i] = point;
        }

        for(int index = 0; index < student_id.length; index++) {
            if(students.size() < k) {
                students.add(index);
            }
            else {
                students.add(index);
                students.poll();
            }
        }

        Integer[] resultStudent = new Integer[k];
        
        for(int i = k-1; i >=0; i--) {
            resultStudent[i] = student_id[students.poll()];
        }

        return Arrays.asList(resultStudent);

    }
}

/**

    Top K : 

 */