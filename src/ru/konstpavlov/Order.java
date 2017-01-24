package ru.konstpavlov;

import ru.konstpavlov.utils.SecurityType;

public class Order {

    private SecurityType securityType;
    private int securityCost;
    private int securityCount;

    public Order(SecurityType securityType, int securityCost, int securityCount) {
        this.securityType = securityType;
        this.securityCost = securityCost;
        this.securityCount = securityCount;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Order) ) return false;
        Order order = (Order) o;

        if (this.securityCount != order.getSecurityCount() ) {
            return false;
        }
        else if (this.securityCost != order.getSecurityCost()){
            return false;
        }
        return this.getSecurityType() == order.getSecurityType();
    }

    @Override
    public int hashCode (){
        int result = securityType.hashCode();
        result = 31*result + securityCost*2;
        return (31*result + securityCount);
    }


    public SecurityType getSecurityType() {
        return securityType;
    }

    public void setSecurityType(SecurityType securityType) {
        this.securityType = securityType;
    }

    public int getSecurityCost() {
        return securityCost;
    }

    public void setSecurityCost(int securityCost) {
        this.securityCost = securityCost;
    }

    public int getSecurityCount() {
        return securityCount;
    }

    public void setSecurityCount(int securityCount) {
        this.securityCount = securityCount;
    }
}
