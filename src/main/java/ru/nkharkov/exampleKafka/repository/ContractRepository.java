package ru.nkharkov.exampleKafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nkharkov.exampleKafka.models.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
