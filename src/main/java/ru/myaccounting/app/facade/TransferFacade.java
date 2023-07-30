package ru.myaccounting.app.facade;

import ru.myaccounting.app.dto.TransferDTO;

import java.security.Principal;
import java.util.List;

public interface TransferFacade {
    TransferDTO transferToTransferDTO(TransferDTO transferDTO, Principal principal);

    List<TransferDTO> transfersList(Principal principal);

    void deleteTransfer(String transferId, Principal principal);
}
