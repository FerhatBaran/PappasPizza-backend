package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
