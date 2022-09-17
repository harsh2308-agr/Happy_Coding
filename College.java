
import java.time.LocalDate;
import java.time.Period;
class person{
    String name;
    int day,month,year;
    int age;
    person(String n,int d,int m,int y){
        name=n;
        day=d;
        month=m;
        year=y;
        age=FindAge();
        
    }
    int FindAge(){
        LocalDate dob = LocalDate.of(year,month,day);
        LocalDate today=LocalDate.now();
        Period diff=Period.between(dob, today);
         diff.getYears();
         diff.getMonths();
        diff.getDays();
         return diff.getDays();
    }
}
class studentinfo extends person{
    int roll;
    float cgpa,sgpa[];
    int sem;
    static String college="RCOEM";
    studentinfo(String n,int d,int m,int y,int rollno,int semester, float s[] ){
        super(n,d,m,y);
        roll =rollno;
        sem=semester;
        sgpa=s;
        
    }
    void calculateCGPA(float s1[],int n){
        float cgpa1=0;
        for(int i=0;i<n;i++)
            cgpa1=s1[i]+cgpa1;
        this.cgpa= (cgpa1/n);
    }
    void display_student(studentinfo s[],int n){
        System.out.println("student information......");
        for(int i=0;i<n;i++)
        {
            System.out.print("\nname--"+s[i].name+"\n DOB---"+s[i].day+"-"+s[i].month+"-"+s[i].year+"\n age---"+s[i].age+"\n roll number---"+s[i].roll);
            System.out.print("\ncurrently studing in ---"+s[i].sem+" semester in "+studentinfo.college+"\n CGPA---"+s[i].cgpa);
            for(int j=0;j<s[i].sem;j++){
                System.out.print("\n sgpa of  "+(j+1)+" semester is "+s[i].sgpa[j]);
            }
        }
    }
}
class professor extends person{
    int salary;
    int exp;
    String qualification;
    static String college="RCOEM";
    professor(String n,int d,int m,int y,int ex,String sal){
        super(n,d,m,y);
        salary=Salary(ex,sal);
        exp=ex;
        qualification=sal;
    }
    int Salary(int ex,String qua){
        int sal=0;
        if(qua=="m.tech"||qua=="MBA")
            sal=40000+ex*2000;
        if(qua=="PHD")
            sal=60000+ex*2000;
        return sal;
    }
        
       void display_professor(professor s[],int n){
        System.out.println("\n professor information......");
        for(int i=0;i<n;i++)
        {
            System.out.print("\n name--"+s[i].name+"\n DOB---"+s[i].day+"-"+s[i].month+"-"+s[i].year+"\n age---"+s[i].age+"\n qualification---"+s[i].qualification);
            System.out.print("\n salary---"+s[i].salary+"\n past experience "+s[i].exp+" in college "+s[i].college);
        }
    }
    float average_sal(professor p[],int n){
      int aver1 = 0;
       for(int i=0;i<n;i++)aver1= aver1 +p[i].salary;
      return aver1/n;
   }
}
class department{
    float avr_sal;
float avr_age;
float average_salary(professor[] p1, int n){
        avr_sal=0;
        int t=0;
        for(int i=0;i<n;i++)
            t=t+p1[i].salary;
        avr_sal=t/n;
        return avr_sal;
    }

float average_age_professor(professor[] p1, int n){
         Period aver=Period.of(0,0 , 0) ;
         for(int i=0;i<n;i++)
             aver=aver.plusDays(p1[i].age);
         avr_age = aver.getDays()/n;
         return avr_age;   
  }
float average_age_student(studentinfo[] p1, int n){
         Period aver=Period.of(0,0 , 0) ;
         for(int i=0;i<n;i++)
             aver=aver.plusDays(p1[i].age);
         avr_age = aver.getDays()/n;
         return avr_age;   
  }
}
public class Main {
    public static void main(String args[]){
        int no_of_professor=5;
        int no_of_student=5;
        studentinfo stu[];
        stu = new studentinfo[no_of_student];
        professor pro[];
        pro=new professor[no_of_professor];
        float semt[]={0,0,0,0,0,0,0,0};
        int sem=4;
        for(int i=0;i<sem;i++)
            semt[i]=(2*(i+1+sem))%9;
        stu[0] = new studentinfo("Amit",10,2,2001,100,sem, semt);
        stu[0].calculateCGPA(semt, sem);  
        sem=5;
        for(int i=0;i<sem;i++)
            semt[i]=(2*(i+1+sem))%9;
        stu[1] = new studentinfo("Rahul",3,2,2002,101,sem, semt);
        stu[1].calculateCGPA(semt, sem); 
        sem=6;
        for(int i=0;i<sem;i++)
           semt[i]=(2*(i+1+sem))%9;
        stu[2] = new studentinfo("Akash",10,6,1999,102,sem, semt);
        stu[2].calculateCGPA(semt, sem);  
        sem=2;
        for(int i=0;i<sem;i++)
            semt[i]=(2*(i+1+sem))%9;
        stu[3] = new studentinfo("Ajay",15,4,2003,103,sem, semt);
        stu[3].calculateCGPA(semt, sem);
        sem=3;
        for(int i=0;i<sem;i++)
            semt[i]=(2*(i+1+sem))%9;
        stu[4] = new studentinfo("eee",10,7,2001,104,sem, semt);
        stu[4].calculateCGPA(semt, sem);
        //professor(String n,int d,int m,int y,int sal,int ex,String qua)
        pro[0]= new professor("Ram",10,2,1977,24,"PHD");
        pro[1]= new professor("Shyam",3,7,1957,30,"m.tech");
        pro[2]= new professor("Rohan",21,10,1968,27,"m.tech");
        pro[3]= new professor("Rohit",25,5,1975,18,"PHD");
        pro[4]= new professor("Vivek",11,11,1967,25,"MBA");
        department d;
        stu[0].display_student(stu,no_of_student);
        pro[0].display_professor(pro, no_of_professor);
        d=new department();
        float aver=d.average_salary(pro, no_of_professor);
        System.out.println("average salary of professors are  "+aver);
        aver=d.average_age_professor(pro, no_of_professor);
        System.out.println("average age of professor is  "+aver);
        aver=d.average_age_student(stu, no_of_student);
        System.out.println("average age of student is  "+aver);
    }

}
