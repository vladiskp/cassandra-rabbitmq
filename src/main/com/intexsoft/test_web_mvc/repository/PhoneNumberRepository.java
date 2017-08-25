package main.com.intexsoft.test_web_mvc.repository;

import main.com.intexsoft.test_web_mvc.entity.PhoneNumber;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends CassandraRepository<PhoneNumber> {

    public PhoneNumber findBySubscriberId(long subscriberId);

}