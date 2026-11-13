
package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscountCalculator {

    private static final Logger logger =
            LoggerFactory.getLogger(DiscountCalculator.class);

    public double calculateDiscount(double price, String memberType) {

        logger.info("Calculating discount: price={}, memberType={}",
                price, memberType);

        if (price < 0) {
            logger.error("Invalid price: {}", price);
            throw new IllegalArgumentException("Price cannot be negative");
        }

        double discount;

        switch (memberType) {
            case "GUEST":
                discount = 0;
                break;

            case "MEMBER":
                discount = price < 100 ? 0.05 : 0.10;
                break;

            case "VIP":
                discount = price < 100 ? 0.15 : 0.20;
                break;

            default:
                logger.error("Invalid member type: {}", memberType);
                throw new IllegalArgumentException(
                        "Invalid member type");
        }

        double result = price * (1 - discount);

        logger.info("Final price after discount: {}", result);

        return result;
    }
}
