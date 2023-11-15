package christmas.model;

import christmas.dto.MenuDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RestaurantMenuTest {
    @Test
    void testGetMenuItem_ExistingMenu() {
        RestaurantMenu menu = new RestaurantMenu();
        String menuName = "티본스테이크";

        MenuDTO menuDTO = menu.getMenuItemByName(menuName);

        assertNotNull(menuDTO);
        assertEquals(menuName, menuDTO.getName());
    }

    @Test
    void testGetMenuItem_NonExistingMenu() {
        RestaurantMenu menu = new RestaurantMenu();
        String menuName = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> menu.getMenuItemByName(menuName));

        assertEquals("[ERROR] 존재하지 않는 메뉴입니다.", exception.getMessage());
    }
}