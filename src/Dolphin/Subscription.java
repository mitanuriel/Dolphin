package Dolphin;

import java.util.ArrayList;

public class Subscription {
    private Member member;
    private double payment;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
    private double debt;
    private ArrayList<Member> debtList = new ArrayList<>();

    Subscription(Member member){
        this.member = member;
    }

    public void addToDebtList(Member member){
        debtList.add(member);
    }

    public void removeFromDebtList(Member member){
        debtList.remove(member);
        System.out.println(member.getName() + "has now paid their debt.");
    }

    public void saveDebtList(){

    }
    public void findPrice(Member member){
        MemberType memberType = member.getMembership().getMemberType();
        MemberStatus memberStatus = member.getMembership().getMemberStatus();
        int age = member.getAge();
        if (memberStatus == MemberStatus.ACTIVE) {
            if (memberType == MemberType.JUNIOR) {
                setPrice(1000);
                System.out.println(getPrice() + "kr om året");
            } else if (memberType == MemberType.SENIOR && age >= 60) {
                setPrice(1200);
                System.out.println(getPrice() + "kr om året");
            } else {
                setPrice(1600);
                System.out.println(getPrice() + "kr om året");
            }
        }else {
            setPrice(500);
            System.out.println(getPrice() + "kr om året");
        }
    }
}
