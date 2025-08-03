package StudentManagementSystemProject;

public class Studentz {
    private int id;
    String name ;
    int age;
    String course;
    int year;

    public int getId(){
        return id;
    }
    public String getName(){
        return this.name;
    }
    public int age(){
        return this.age;
    }
    public String getCourse(String course){
        return this.course;
    }
    public int getYear(){
        return this.year;
    }

    public void setId(int newid){
        id=newid;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public void setYear(int year){
        this.year=year;
    }

    public Studentz(int Id,String name,int age,String course,int year){
       this.name =name.toUpperCase();
       this.id= Id;
       this.age=age;
       this.course=course.toUpperCase();
       this.year=year;
    }

    @Override
    public String toString() {
        return "STUDENT" + "-> " +
                "ID=" + id + "|"+
                " NAME=" + name + '|' +
                " AGE=" + age + "|"+
                " COURSE=" + course + '|' +
                " YEAR=" + year
                ;
    }
}
