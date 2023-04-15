public class SubjectGradeNode {
    String subject;
    int grade;

    public SubjectGradeNode(SubjectGradeNode subject_grade) {
    }

    public SubjectGradeNode(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return '{'+" "+subject + ", "+grade +
                " "+'}';
    }
}
