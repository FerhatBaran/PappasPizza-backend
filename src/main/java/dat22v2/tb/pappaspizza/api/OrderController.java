package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/order")
public class OrderController {


    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    @GetMapping("/viewAll")
    public List<OrderResponse> getAllOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/viewConfirmed")
    public List<OrderResponse> getConfirmedOrders(){
        return orderService.getConfirmedOrders();
    }

    @PatchMapping("confirm/{id}")
    public void confirmOrder(@PathVariable Integer id){
        orderService.confirmOrder(id);

    }

    @PatchMapping("status/{id}")
    public void changeStatus(@PathVariable Integer id, @RequestParam String newStatus){
        orderService.changeStatus(id, newStatus);
    }
}
