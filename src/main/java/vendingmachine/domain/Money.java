package vendingmachine.domain;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public void spend(int moneySpent) {
        money -= moneySpent;
    }

    public boolean isSmallerThan(int anotherMoney) {
        return money < anotherMoney;
    }

    public int get() {
        return money;
    }


}
