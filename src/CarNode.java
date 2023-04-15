// Create Node data which has "CarNode" data type
public class CarNode {
    String registration;
    String owner_Name;
    String contact_Number;
    String problem_Description;
    int cost_Of_Fixing_The_Problem;
    String car_Status;

    public String getRegistration() {
        return registration;
    }


    public int getCost_Of_Fixing_The_Problem() {
        return cost_Of_Fixing_The_Problem;
    }


    public String getCar_Status() {
        return car_Status;
    }

    public CarNode(String registration, String owner_Name, String contact_Number, String problem_Description, int cost_Of_Fixing_The_Problem, String car_Status) {
        this.registration = registration;
        this.owner_Name = owner_Name;
        this.contact_Number = contact_Number;
        this.problem_Description = problem_Description;
        this.cost_Of_Fixing_The_Problem = cost_Of_Fixing_The_Problem;
        this.car_Status = car_Status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+"(");
        sb.append(registration + ", ");
        sb.append(owner_Name + ", ");
        sb.append(contact_Number + ", ");
        sb.append(problem_Description + ", ");
        sb.append(cost_Of_Fixing_The_Problem + ", ");
        sb.append(car_Status + ")");
        return sb.toString();
    }
}
