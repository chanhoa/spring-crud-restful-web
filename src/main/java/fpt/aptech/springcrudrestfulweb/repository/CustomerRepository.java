package fpt.aptech.springcrudrestfulweb.repository;

import fpt.aptech.springcrudrestfulweb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
