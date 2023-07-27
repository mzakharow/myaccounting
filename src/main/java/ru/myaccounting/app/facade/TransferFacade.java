package ru.myaccounting.app.facade;

import org.springframework.stereotype.Component;
import ru.myaccounting.app.dto.TransferDTO;
import ru.myaccounting.app.entity.Transfer;

@Component
public class TransferFacade {

    public TransferDTO transferToTransferDTO(Transfer transfer) {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setUsername(transfer.getUser().getUsername());
        transferDTO.setId(transfer.getId());
        transferDTO.setCategory(transfer.getCategory());
        transferDTO.setComment(transfer.getComment());
        transferDTO.setSum(transfer.getSum());
        return transferDTO;
    }
}
