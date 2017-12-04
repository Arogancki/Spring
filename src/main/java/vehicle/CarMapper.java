package vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CarMapper implements RowMapper<Car> {
   public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Car(rs.getString("make"),
			   rs.getFloat("capacity"),
			   rs.getInt("power"),
			   rs.getString("type"));
   }
}