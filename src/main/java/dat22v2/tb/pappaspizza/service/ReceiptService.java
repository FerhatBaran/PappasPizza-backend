package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.ReceiptResponse;
import dat22v2.tb.pappaspizza.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptService {


    ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }


    public List<ReceiptResponse> getReceipts() {
        return receiptRepository.findAll().stream().map( receipt -> new ReceiptResponse(receipt)).collect(Collectors.toList());
    }
}
