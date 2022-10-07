package EmployeeJDBCConnectivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemp;

	public List<Employee> findAll(){
	return jdbcTemp.query("SELECT * FROM EmployeeJDBC", new BeanPropertyRowMapper<Employee>(Employee.class));
	}


	public Employee findById(int id) {
	return jdbcTemp.queryForObject("SELECT * FROM EmployeeJDBC WHERE id=?",new BeanPropertyRowMapper<Employee>(Employee.class),id);
	}


	public int deleteById(int id) {
	  return jdbcTemp.update("DELETE FROM EmployeeJDBC WHERE id=?", id=1);
	}

	public int save(Employee e) {
	return jdbcTemp.update("INSERT INTO EmployeeJDBC(id,name,designation) VALUES(?,?,?)", new Object[] {e.getId(),e.getName(), e.getDesignation()});
	}


	public int update(Employee e, int id) {
	return jdbcTemp.update("UPDATE EmployeeJDBC SET name=?,designation=? WHERE id=?", new Object[] {e.getName(), e.getDesignation(),id});
	}

	}

	
	
	
	


