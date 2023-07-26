package ru.myaccounting.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myaccounting.app.entity.Transfer;
import ru.myaccounting.app.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    List<Transfer> findAllByUserOrderByCreatedDateDesc(User user);

    Optional<Transfer> findTransferByIdAndUser(Long id, User user);

}
