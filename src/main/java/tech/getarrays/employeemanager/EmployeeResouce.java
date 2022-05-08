package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
    private final EmployeeService employeeService;

    public EmployeeResouce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all") //pokud nekdo zada /employee z request mapping a zatim //all, tak mu to spusti tu metodu pod timhle
    public ResponseEntity<List<Employee>> getAllEmployees(){ //metoda pro vraceni vsech employu, responseEntity vraci Http response a jaky ma genericky typ
        List<Employee> employees = employeeService.findAllEmployees(); //employees  bude list kde budou vsechny employees
        return new ResponseEntity<>(employees, HttpStatus.OK); // vrati list a zpravu, ze vse probehlo v poradku
    }

    @GetMapping("/find/{id}") //uz je tam /employee z RequestMapping pak je tam /find/(cislo id)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){ //vezme to id ktere je dane v url (to ktere tam bude v url o radek vyse)
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add") //pridani noveho employee
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) { //dostaneme cokoliv co je v body requestu
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update") //upraveni  employee
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}") //upraveni  employee
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) { //nereturnuje nic, proto ?
        employeeService.deleteEmployee(id);  //neni return, proto neni novy employee nijak definovan
        return new ResponseEntity<>(HttpStatus.OK); //ani tady, jen zprava, ze to probehlo
    }
}
