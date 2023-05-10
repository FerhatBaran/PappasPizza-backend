package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.OrderRequest;
import dat22v2.tb.pappaspizza.dto.OrderResponse;
import dat22v2.tb.pappaspizza.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {


    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping()
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/addOrder"  )
    public OrderResponse addOrder(@RequestBody OrderRequest body){
        return orderService.addOrder(body);
    }
}
