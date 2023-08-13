package io.nopecho.members.domain.policy.grade;

import io.nopecho.members.domain.Grade;
import io.nopecho.members.domain.policy.Factor;
import io.nopecho.members.domain.policy.Policy;
import io.nopecho.members.domain.policy.grade.factor.OrderCountFactor;

public class GradePolicyByOrderCount implements Policy<Grade, OrderCountFactor> {

    @Override
    public boolean canApply(Factor factor) {
        return factor.getType().equals(OrderCountFactor.class);
    }

    @Override
    public Grade apply(OrderCountFactor factor) {
        if(factor.getOrderCount() >= 20) {
            return Grade.DIAMOND;
        }
        if(factor.getOrderCount() >= 15) {
            return Grade.PLATINUM;
        }
        if (factor.getOrderCount() >= 10) {
            return Grade.GOLD;
        }
        if(factor.getOrderCount() >= 5) {
            return Grade.SILVER;
        }
        return Grade.BRONZE;
    }
}
