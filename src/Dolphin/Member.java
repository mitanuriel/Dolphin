package Dolphin;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private String name;
    private LocalDate birthday;
    private int age;
    private Membership membership;
    private ArrayList<Member> members = new ArrayList<>();
    final String filename = "MembersList.txt";

    Scanner scanner = new Scanner(System.in);

    Member(String name, LocalDate birthday,int age, Membership membership){
        this.name = name;
        this.birthday = birthday;
        this.membership = membership;
        this.age = age;
    }

    Member(){
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void findName(){
        boolean run = true;
        while (run) {
            System.out.println("Enter first and last name: ");
            String name = scanner.nextLine();
            String[] n = name.split(" ");
            if (n.length == 2) {
                String firstName = n[0];
                String lastName = n[1];
                setName(name);
                System.out.println("Name: " + getName());
                run = false;
            } else {
                System.out.println("INVALID!!!");
            }
        }
    }

    public void findBirthday(){
        LocalDate today = LocalDate.now();
        System.out.println("Enter year of birth");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter month of birth");
        int monthOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter date of birth");
        int dateOfBirth = scanner.nextInt();
        scanner.nextLine();

            birthday = LocalDate.of(yearOfBirth, monthOfBirth, dateOfBirth);
            setBirthday(birthday);
            Period p = Period.between(birthday, today);
            age = p.getYears();
            setAge(age);
            System.out.println(getBirthday());
            System.out.println("Age: " + getAge());
    }

    public void createMember(){
        findName();
        findBirthday();
        Membership membership = new Membership();
        membership.createMembership(getAge());
        setMembership(membership);
        Member m = new Member(getName(),getBirthday(), getAge(), getMembership());
        members.add(m);
        System.out.println(m);
    }

    public void viewMembers(){
        System.out.println("VIEW MEMBERS");
        for (int i = 0; i < members.size(); i++){
            System.out.println(i + ". " + members.get(i));
        }
    }


    @Override
    public String toString() {
        return  "--------------------------------" +
                "\nName: " + name +
                "\nBirthday: " + birthday +
                ", age: " + age + "\n" + membership;
    }
}
