package ru.myaccounting.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.myaccounting.app.entity.Transfer;
import ru.myaccounting.app.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.myaccounting.app.exceptions.TransferNotFoundException;
import ru.myaccounting.app.repository.TransferRepository;
import ru.myaccounting.app.repository.UserRepository;
import ru.myaccounting.app.dto.TransferDTO;

import java.security.Principal;
import java.util.List;

@Service
public class TransferService {
    public static final Logger LOG = LoggerFactory.getLogger(TransferService.class);

    private final TransferRepository transferRepository;
    private final UserRepository userRepository;


    public TransferService(TransferRepository transferRepository, UserRepository userRepository) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
    }

    public Transfer createTransfer(TransferDTO transferDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        Transfer transfer = new Transfer();
        transfer.setUser(user);
        transfer.setCategory(transferDTO.getCategory());
        transfer.setSum(transferDTO.getSum());
        transfer.setComment(transferDTO.getComment());

        LOG.info("Saving Transfer for User: {}", user.getEmail());
        return transferRepository.save(transfer);
    }

//    public List<Transfer> getAllTransfers() {
//        return transferRepository.findAllByOrderByCreatedDateDesc();
//    }

    public List<Transfer> getAllTransferForUser(Principal principal) {
        User user = getUserByPrincipal(principal);
        return transferRepository.findAllByUserOrderByCreatedDateDesc(user);
    }

    public void deleteTransfer(Long transferId, Principal principal) {
        Transfer transfer = getTransferById(transferId, principal);
//        Optional<ImageModel> imageModel = imageRepository.findByTransferId(transfer.getId());
        transferRepository.delete(transfer);
//        imageModel.ifPresent(imageRepository::delete);
    }

    public Transfer getTransferById(Long transferId, Principal principal) {
        User user = getUserByPrincipal(principal);
        return transferRepository.findTransferByIdAndUser(transferId, user)
                .orElseThrow(() -> new TransferNotFoundException("Transfer not found"));
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found."));
    }

}
