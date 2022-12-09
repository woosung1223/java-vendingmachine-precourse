package vendingmachine.domain;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
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

    private void validate(int money) {
        checkIsPositive(money);
        checkIsDivisible(money);
    }

    private void checkIsPositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 양수만 가능합니다.");
        }
    }

    private void checkIsDivisible(int money) {
        if (money % Coin.getSmallestAmount() != 0) {
            throw new IllegalArgumentException("[ERROR] 1원 단위는 입력해서는 안됩니다.");
        }
    }
}
