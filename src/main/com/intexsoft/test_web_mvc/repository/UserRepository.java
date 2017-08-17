package main.com.intexsoft.test_web_mvc.repository;

import main.com.intexsoft.test_web_mvc.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User> {

    void deleteById(int id);
}