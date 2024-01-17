package org.wilmer.mongodb.wmscRepositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.wilmer.mongodb.wmscModelos.WmscStudent;
@Repository
public interface WmscStudentRepository extends MongoRepository<WmscStudent, String> {
    public Page<WmscStudent> findAllBy(Pageable pageable);
}
