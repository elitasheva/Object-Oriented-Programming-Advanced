package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.interfaces.Course;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.interfaces.Database;
import main.bg.softuni.interfaces.Student;

import java.util.Comparator;

@Alias(value = "display")
public class DisplayCommand extends Command{

    @Inject
    private Database studentRepository;

    public DisplayCommand(String input,
                          String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 3){
            throw new InvalidInputException(this.getInput());
        }

        String entityToDispaly = data[1];
        String sortType = data[2];

        if (entityToDispaly.equalsIgnoreCase("students")){
            Comparator<Student> studentComparator = this.createStudentComparator(sortType);
            SimpleSortedList<Student> list = this.studentRepository.getAllStudentsSorted(studentComparator);
            OutputWriter.writeMessageOnNewLine(list.joinWith(System.lineSeparator()));

        }else if (entityToDispaly.equalsIgnoreCase("courses")){
            Comparator<Course> courseComparator = this.createCourseComparator(sortType);
            SimpleSortedList<Course> list = this.studentRepository.getAllCoursesSorted(courseComparator);
            OutputWriter.writeMessageOnNewLine(list.joinWith(System.lineSeparator()));
        }

    }

    private Comparator<Course> createCourseComparator(String sortType){
        if (sortType.equalsIgnoreCase("ascending")){
            return (o1, o2) -> o1.compareTo(o2);
        }else if (sortType.equalsIgnoreCase("descending")){
            return (o1, o2) -> o2.compareTo(o1);
        }else {
            throw new InvalidInputException(this.getInput());
        }
    }

    private Comparator<Student> createStudentComparator(String sortType){
        if (sortType.equalsIgnoreCase("ascending")){
            return (o1, o2) -> o1.compareTo(o2);
        }else if (sortType.equalsIgnoreCase("descending")){
            return (o1, o2) -> o2.compareTo(o1);
        }else {
            throw new InvalidInputException(this.getInput());
        }

    }
}
