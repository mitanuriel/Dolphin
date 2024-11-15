package Dolphin;

import java.util.Scanner;

public class Membership {
    private MemberStatus memberStatus;
    private MemberType memberType;
    private SwimmerType swimmerType;

    Member member = new Member();
    Scanner scanner = new Scanner(System.in);

    Membership(MemberStatus memberStatus, MemberType memberType, SwimmerType swimmerType){
        this.memberStatus = memberStatus;
        this.memberType = memberType;
        this.swimmerType = swimmerType;
    }

    Membership(){
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }
    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public MemberType getMemberType() {
        return memberType;
    }
    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public SwimmerType getSwimmerType() {
        return swimmerType;
    }
    public void setSwimmerType(SwimmerType swimmerType) {
        this.swimmerType = swimmerType;
    }
/*Consider making the findMemberStatus, findSwimmerType, and findMemberType methods private,
 as they are used internally within the class and are not intended to be
  accessed directly from outside.
 */
    public void findMemberStatus() {
        boolean run = true;
        while (run) {
            System.out.println("Enter number of member status: ");
            MemberStatus[] m = MemberStatus.values();
            for (int i = 0; i < m.length; i++) {
                System.out.println(i + ". " + m[i]);
            }
                int ans = scanner.nextInt();
                scanner.nextLine();
                if (ans < m.length && ans == 0) {
                    setMemberStatus(MemberStatus.ACTIVE);
                    System.out.println("Member status: " + getMemberStatus());
                    run = false;
                } else if (ans < m.length && ans == 1) {
                    setMemberStatus(MemberStatus.PASSIVE);
                    System.out.println("Member status: " + getMemberStatus());
                    run = false;
                } else {
                    System.out.println("INVALID!!!");
                }
            }
    }

    public void findSwimmerType(){
        boolean run = true;
        while (run){
            System.out.println("Enter number of swimmer type:");
            SwimmerType[] s = SwimmerType.values();
            for (int i = 0; i < s.length; i++){
                System.out.println(i + ". " + s[i]);
            }
            int ans = scanner.nextInt();
            scanner.nextLine();
            if (ans < s.length && ans == 0){
                setSwimmerType(SwimmerType.EXERCISER);
                System.out.println("Swimmer type: " + getSwimmerType());
                run = false;
            } else if (ans < s.length && ans == 1){
                setSwimmerType(SwimmerType.COMPETITOR);
                System.out.println("Swimmer type:" + getSwimmerType());
                run = false;
            } else {
                System.out.println("INVALID!!!");
            }
        }
    }

    public void findMemberType(int age){
        if (age < 18){
            setMemberType(MemberType.JUNIOR);
            System.out.println("Member type: " + getMemberType());
        } else {
            setMemberType(MemberType.SENIOR);
            System.out.println("Member type: " + getMemberType());
        }
    }

    public void createMembership(int age){
        findSwimmerType();
        findMemberStatus();
        findMemberType(age);
    }

    @Override
    public String toString() {
        return "  MEMBERSHIP" +
                "\n  MemberStatus: " + memberStatus +
                "\n  MemberType: " + memberType +
                "\n  SwimmerType: " + swimmerType;
    }
}
