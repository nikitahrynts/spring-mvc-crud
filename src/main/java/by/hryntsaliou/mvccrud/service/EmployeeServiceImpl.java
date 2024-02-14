package by.hryntsaliou.mvccrud.service;

import by.hryntsaliou.mvccrud.dao.EmployeeRepository;
import by.hryntsaliou.mvccrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee newEmployee = null;
        if (employee.isPresent()) {
            newEmployee = employee.get();
        } else {
            throw new RuntimeException("Didn't find employee id - " + id);
        }
        return newEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
