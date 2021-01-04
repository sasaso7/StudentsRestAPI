package com.example.demo.Repository;

import com.example.demo.Model.Supervisor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {
}
