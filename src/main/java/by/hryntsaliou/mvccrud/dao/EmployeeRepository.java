package by.hryntsaliou.mvccrud.dao;

import by.hryntsaliou.mvccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
