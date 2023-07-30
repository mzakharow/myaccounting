package ru.myaccounting.app.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.myaccounting.app.dto.TransferDTO;
import ru.myaccounting.app.entity.Transfer;
import ru.myaccounting.app.service.TransferService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransferFacadeImpl implements TransferFacade {

    @Autowired
    private TransferService transferService;

    public TransferDTO transferToTransferDTO(TransferDTO transferDTO, Principal principal) {
        Transfer transfer = transferService.createTransfer(transferDTO, principal);
        TransferDTO responseTransferDTO = transferToDTO(transfer);
        return responseTransferDTO;
    }

    public void deleteTransfer(String transferId, Principal principal) {
        transferService.deleteTransfer(Long.parseLong(transferId), principal);
    }

    public List<TransferDTO> transfersList(Principal principal) {
        List<TransferDTO> transferDTOList = transferService.getAllTransferForUser(principal)
                .stream()
                .map(transfer -> transferToDTO(transfer))
                .collect(Collectors.toList());
        return transferDTOList;
    }

    private TransferDTO transferToDTO(Transfer transfer) {
        TransferDTO responseTransferDTO = new TransferDTO();
        responseTransferDTO.setUsername(transfer.getUser().getUsername());
        responseTransferDTO.setId(transfer.getId());
        responseTransferDTO.setCategory(transfer.getCategory());
        responseTransferDTO.setComment(transfer.getComment());
        responseTransferDTO.setSum(transfer.getSum());
        return responseTransferDTO;
    }
}
