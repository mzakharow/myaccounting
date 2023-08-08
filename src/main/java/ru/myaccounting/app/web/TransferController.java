package ru.myaccounting.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.myaccounting.app.dto.TransferDTO;
import ru.myaccounting.app.facade.TransferFacade;
import ru.myaccounting.app.payload.response.MessageResponse;
import ru.myaccounting.app.validations.ResponseErrorValidation;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/transfer")
@CrossOrigin
public class TransferController {
    @Autowired
    private TransferFacade transferFacade;

    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @PostMapping("/create")
    public ResponseEntity<Object> createTransfer(@Valid @RequestBody TransferDTO transferDTO,
                                             BindingResult bindingResult,
                                             Principal principal) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;
        TransferDTO createdTransfer = transferFacade.transferToTransferDTO(transferDTO, principal);
        return new ResponseEntity<>(createdTransfer, HttpStatus.OK);
    }

    @GetMapping("/user/transfers")
    public ResponseEntity<List<TransferDTO>> getAllTransfersForUser(Principal principal) {
        List<TransferDTO> transferDTOList = transferFacade.transfersList(principal);

        return new ResponseEntity<>(transferDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{transferId}/delete")
    public ResponseEntity<MessageResponse> deleteTransfer(@PathVariable("transferId") String transferId, Principal principal) {
        transferFacade.deleteTransfer(transferId, principal);
        return new ResponseEntity<>(new MessageResponse("Transfer was deleted"), HttpStatus.OK);
    }
}
