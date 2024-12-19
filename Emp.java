import java.util.Scanner;
class Employee{
    int Empid;
    String Empname,Deptname;
    double Basicpay,Grosspay,da,hra,Netpay,Tax;
    Scanner sc=new Scanner(System.in);
    void read(){
        System.out.println("Enter the Employee ID: ");
        Empid=sc.nextInt();
        System.out.println();
        System.out.println("Enter Employee Name: ");
        Empname=sc.next();
        System.out.println("Enter the Depertmaent name: ");
        Deptname=sc.next();
        System.out.println("Enter the basic pay: ");
        Basicpay=sc.nextInt();
    }


    void calculate(){
        da=(0.58)*Basicpay;
        hra=(0.16)*Basicpay;
        Grosspay=Basicpay+da+hra;
        if(Grosspay<=200000){
            Tax=0.0;
        }
        else if((Grosspay>200000) && (Grosspay<=300000) ){
            Tax=(0.1)*Grosspay;
        }
        else if((Grosspay>300000) && (Grosspay<=500000) ){
            Tax=(0.15)*Grosspay;
        }
        else{
            Tax=(0.3)*Grosspay;
            Tax=Tax+(0.02)*Grosspay;
        }
        Netpay=Grosspay-Tax;
    }

    void display(){
        System.out.println("Employee ID: "+Empid);
        System.out.println("Employee Name: "+Empname);
        System.out.println("Employee Department: "+Deptname);
        System.out.println("Employee Basic Pay: "+Basicpay);
        System.out.println("Gross Pay: "+Grosspay);
        if(Grosspay<=200000){
            System.out.println("As the Grosspay is less than 2,00,000 ,NO tax");
        }
        else if((Grosspay>200000) && (Grosspay<=300000) ){
            System.out.println("As grosspay is between 2 and 3 lakhs,tax is 10% ");
        }
        else if((Grosspay>300000) && (Grosspay<=500000) ){
            System.out.println("As grosspay is between 3 and 5 lakhs,tax is 15% ");
        }
        else{
            System.out.println("As grosspay exceeds 5 lakhs,tax is 30% and an additional tax of 2% is imposed");
        }
        System.out.println("Tax: "+Tax);
        System.out.println("NetPay: "+Netpay);
    }
}
class Emp{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of Employees: ");
        int n =in.nextInt();
        Employee[] e =new Employee[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the details of Employee~"+(i+1));
            e[i]=new Employee();
            e[i].read();
            e[i].calculate();
        }
        System.out.println("***************************************************");
        for(int i=0;i<n;i++){
            System.out.println("Details of Employee~"+(i+1));
            e[i].display();
        }
        in.close();
    }
}