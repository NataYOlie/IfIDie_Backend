package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
