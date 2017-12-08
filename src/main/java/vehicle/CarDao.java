package vehicle;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CarDao {
	 private DataSource dataSource;
	 private JdbcTemplate jdbcTemplateObject;
	 
	 public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	} 
	 
	public void Add(Car car){
		String SQL = "insert into cars (make, capacity, power, type) values (?, ?, ?, ?)";
	    jdbcTemplateObject.update( SQL, car.getMake(), 
	    		0.0,//car.getEngine().getCapacity(),
	    		1,//car.getEngine().getPower(),
	    		"null");//car.getEngine().getType());
	    System.out.println("Record created");
	    return;
	}
	public Car Get(String make, int power, String type){
		 String SQL = "select * from cars where make = ? AND power = ? AND type = ?";
	      Car car = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{make, power, type}, new CarMapper());
	      return car;
	}
	public List<Car> GetAll(){
		String SQL = "select * from cars";
	      return jdbcTemplateObject.query(SQL, new CarMapper());
	}
	public void DeleteCar(String make, int power, String type){
		String SQL = "delete from cars where make = ? AND power = ? AND type = ?";
	    jdbcTemplateObject.update(SQL, make, power, type);
	    System.out.println("Record deleted");
	    return;
	}
}
