package test;

import model.Order;
import model.Sandwich;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import services.OrderService;
import services.SandwichService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private SandwichService sandwichService;

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService(sandwichService);
    }

    @Test
    public void testPlaceOrderValid() {
        // Prepare test data
        Sandwich sandwich = new Sandwich("Turkey Sandwich", 6.99);

        // Execute the order placement
        boolean result = orderService.placeOrder("John", sandwich); // Pass the sandwich object

        // Verify that the order is placed successfully
        assertTrue(result);

        // Verify that the order is added to the list of orders
        Order order = orderService.getOrdersByUser("John").get(0);
        assertNotNull(order);
        assertEquals("John", order.getUserName());
        assertEquals(sandwich, order.getOrderedSandwich());
    }

    @Test
    public void testPlaceOrderExceedsLimit() {
        // Prepare test data
        Sandwich sandwich = new Sandwich("Turkey Sandwich", 6.99);

        // Place two orders for "John"
        orderService.placeOrder("John", sandwich); // Pass the sandwich object
        orderService.placeOrder("John", sandwich); // Pass the sandwich object

        // Try to place another order, which exceeds the limit
        boolean result = orderService.placeOrder("John", sandwich); // Pass the sandwich object

        // Verify that the order placement fails due to exceeding the limit
        assertFalse(result);

        // Verify that only two orders are associated with "John"
        assertEquals(2, orderService.getOrdersByUser("John").size());
    }
}
