package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.ReceiptResponse;
import dat22v2.tb.pappaspizza.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



}
