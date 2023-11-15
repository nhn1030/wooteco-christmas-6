package christmas.model;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {
    @Test
    void testChristmasDiscount() {
        LocalDate december25 = LocalDate.of(2023, 12, 25);
        int discountDecember25 = Discount.christmasDiscount(december25);
        assertEquals(3400, discountDecember25);
    }
}