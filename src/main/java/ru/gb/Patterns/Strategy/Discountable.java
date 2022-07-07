package ru.gb.Patterns.Strategy;

import java.math.BigDecimal;

public interface Discountable {
    BigDecimal applyDiscount(BigDecimal value);
}
