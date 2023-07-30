package ru.myaccounting.app.service;

import ru.myaccounting.app.dto.TransferDTO;
import ru.myaccounting.app.entity.Transfer;

import java.security.Principal;
import java.util.List;

public interface TransferService {
    Transfer createTransfer(TransferDTO transferDTO, Principal principal);

    List<Transfer> getAllTransferForUser(Principal principal);

    void deleteTransfer(Long transferId, Principal principal);

    Transfer getTransferById(Long transferId, Principal principal);

}
