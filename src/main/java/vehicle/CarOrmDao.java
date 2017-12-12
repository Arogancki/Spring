package vehicle;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.h2.command.dml.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("carOrmDao")
@Transactional
@EnableJpaRepositories(basePackages="vehicle", entityManagerFactoryRef="emf")
public interface CarOrmDao extends JpaRepository<Car, Long>{
	
	
}
