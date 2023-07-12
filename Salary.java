import java.util.*;

import java.io.*;

class Employee {

    Scanner sc = new Scanner(System.in);
    String name, post;
    int id;
    float bs, hra, da, ta, ma, pf, gs, fs;

    Employee() {
        System.out.print("\nEnter Name of an Employee : ");
        name = sc.nextLine();
        System.out.print("Enter post of an employee : ");
        post = sc.nextLine();
        System.out.print("Enter Id of an Employee : ");
        id = sc.nextInt();
        System.out.print("Enter basic salary of that employee ");
        bs = sc.nextInt();

    }

    public float find_gross() {
        if (bs >= 40000) {
            hra = (float) (bs * 0.4);
            da = (float) (bs * 0.9);
            ta = (float) (bs * 0.3);
            ma = (float) (bs * 0.1);
            pf = (float) (bs * 0.1);

        }

        else if (bs >= 20000) {
            hra = (float) (bs * 0.3);
            da = (float) (bs * 0.8);
            ta = (float) (bs * 0.2);
            ma = (float) (bs * 0.1);
            pf = (float) (bs * 0.1);
        }

        else {
            hra = (float) (bs * 0.2);
            da = (float) (bs * 0.7);
            ta = (float) (bs * 0.15);
            ma = (float) (bs * 0.1);
            pf = (float) (bs * 0.1);

        }

        gs = bs + hra + da + ta + pf + ma;
        return gs;

    }

    public float find_net_salary() {
        fs = find_gross() - pf;
        return fs;
    }

    void generate_salary_slip() {
        System.out.println(" Salary Slip of Month June");
        System.out.println("---------------------------");
        System.out.println(" Employee id = " + id + "\n Name = " + name + "\n Post= " + post + "\n Basic Salary= "
                + bs + "\n Gross Salary = " + gs +
                "\n Net Salary Of " + name + " = " + fs);
        try (FileWriter f = new FileWriter("D:\\record.txt.txt", true)) {
            BufferedWriter writer = new BufferedWriter(f);
            writer.write("\n\n\nSalary Slip of Month June\n");
            writer.write("---------------------------");
            writer.write(" Employee id = " + id);
            writer.write("\n Name = " + name);
            writer.write("\n Post= " + post);
            writer.write("\n Basic Salary= " + bs);
            writer.write("\n Gross Salary = " + gs);
            writer.write("\n Net Salary Of " + fs);
            writer.close();
            f.close();
        } catch (Exception e) {
        }
        ;
    }

}

public class Salary {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.find_gross();
        e.find_net_salary();
        e.generate_salary_slip();
    }

}
