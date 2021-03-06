package main.com.intexsoft.test_web_mvc.repository;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CassandraRepository<Subscriber> {

    void deleteById(long id);

    Subscriber findById(long id);
}