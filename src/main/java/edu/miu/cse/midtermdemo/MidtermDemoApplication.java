package edu.miu.cse.midtermdemo;

import edu.miu.cse.midtermdemo.model.Course;
import edu.miu.cse.midtermdemo.model.Department;
import edu.miu.cse.midtermdemo.model.Professor;
import edu.miu.cse.midtermdemo.service.CourseService;
import edu.miu.cse.midtermdemo.service.DepartmentService;
import edu.miu.cse.midtermdemo.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@SpringBootApplication
@RequiredArgsConstructor
public class MidtermDemoApplication {
    private final ProfessorService professorService;
    private final CourseService courseService;
    private final DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(MidtermDemoApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            List<Professor> professorList = Arrays.asList(
                                            new Professor("Alice","Smith"),
                                            new Professor("John","Doe"),
                                            new Professor("Emma","Johnson"),
                                            new Professor("Daniel","Lee")
                    );
            List<Department>departmentList = Arrays.asList(

                    new Department("Computer Science"),
                    new Department("Mathematics"),
                    new Department("Physics")

            );
            Integer departmentIndex = 0;
            for (var Professor:professorList){
                Professor.setDepartment(departmentList.get(departmentIndex));
                if(departmentIndex ==2) departmentIndex =0;
                else departmentIndex++;
            }
            for (Department department : departmentList) {
                departmentService.addNewDepartment(department);
            }
            for (Professor professor : professorList) {
                professorService.addNewProfessor(professor);
            }

            List<Course>courseList = Arrays.asList(
                                            new Course("Data Structure"),
                                            new Course("Algorithms"),
                                            new Course("Operating Systems"),
                                            new Course("Calculus"),
                                            new Course("Linear Algebra"),
                                            new Course("departmentListMechanics"),
                                            new Course("Quantum Physics")
                    );
            courseList.get(0).setDepartment(departmentList.get(0));
            courseList.get(1).setDepartment(departmentList.get(0));
            courseList.get(2).setDepartment(departmentList.get(0));
            courseList.get(3).setDepartment(departmentList.get(1));
            courseList.get(4).setDepartment(departmentList.get(1));
            courseList.get(5).setDepartment(departmentList.get(2));
            courseList.get(6).setDepartment(departmentList.get(2));
            List<Professor>dataStructureProfessorList = Arrays.asList(professorList.get(0),professorList.get(1));
            courseList.get(0).setListProfessor(dataStructureProfessorList);
            List<Professor> algorithmProfessorList = Arrays.asList(professorList.get(0));
            courseList.get(1).setListProfessor(algorithmProfessorList);
            List<Professor> operatingSystemList = Arrays.asList(professorList.get(3));
            courseList.get(2).setListProfessor(operatingSystemList);
            List<Professor> calculusList = Arrays.asList(professorList.get(1));
            courseList.get(3).setListProfessor(calculusList);
            List<Professor> linear = Arrays.asList(professorList.get(3));
            courseList.get(4).setListProfessor(linear);
            List<Professor> mechanic = Arrays.asList(professorList.get(2),professorList.get(1));
            courseList.get(5).setListProfessor(mechanic);
            List<Professor> quantum = Arrays.asList(professorList.get(2),professorList.get(1),professorList.get(0));
            courseList.get(5).setListProfessor(quantum);
            //List<Professor> algorithmProfessorList = Arrays.asList(professorList.get(0));
            //            courseList.get(1).setListProfessor(algorithmProfessorList);

            for(Course course:courseList){
                courseService.addCourse(course);
            }
            Optional<Course> algorithms = courseService.findCourseByName("Algorithms");
            courseService.deleteCourse(algorithms.get());

            professorService.sortByLastname().forEach(r->{
                System.out.println(r);
            });
            System.out.println(org.hibernate.Version.getVersionString()+"nnnnnnnnnnnnnnnnnnnnnnnn");
            Optional<Department> department = departmentService.findByDepartmentName("Computer Science");
            List<Course>listCourseByDepartment = courseService.findAllCoursesSortedByName(department.get());
            listCourseByDepartment.forEach(System.out::println);

            List<Department> departments = departmentService.getDepartmentsGroupedAndSorted();
            departments.forEach(department1 -> {
                System.out.println(department1);
                department1.getCourses().forEach(course -> { System.out.println(course.getCourseName());});
            });
        };
    }
}
