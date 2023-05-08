package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.ReceiptRequest;
import dat22v2.tb.pappaspizza.dto.ReceiptResponse;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.service.ReceiptService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/receipts")
public class ReceiptController {


    ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public ResponseEntity<List<ReceiptResponse>> getReceipts() {
        return ResponseEntity.ok(receiptService.getReceipts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReceiptResponse> getReceipt(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(receiptService.getReceipt(id));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReceiptResponse> addReceiptToOrder(@RequestBody ReceiptRequest body) {
        System.out.println(body.getOrderId());
        return ResponseEntity.ok(receiptService.addReceiptToOrder(body.getOrderId()));
    }



}
