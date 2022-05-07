package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

//interface pro upravu tabulek
public interface EmployeeRepo extends JpaRepository<Employee, Long> {    //vytvorili jsme interface, je to potomek JpaRepository, kde mame funkce pro tabulky. Employee je odkud ta tabulka bude a Long je tam protoze nas primarni klic ID ve tride employee v tabulce je typu Long
    void deleteEmployeeById(Long id); // na zaklade toho, jak je to pojmenovane, tak se to vykona samo(funkce delete, v emploee, podle Id)

    Optional<Employee> findEmployeeById(Long id); // zase nam spring pomuze, protoze porozumi, ze chceme najit-find, employee podle Id
                                                  // Je to optional, protoze bude to toho employee najde nebo ne
}
