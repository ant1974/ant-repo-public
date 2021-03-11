package it.antoniop.springdatajpa.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.antoniop.springdatajpa.exception.RecordNotFoundException;
import it.antoniop.springdatajpa.model.EmployeeEntity;
import it.antoniop.springdatajpa.repository.EmployeeRepository;



@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees() {
		// List<EmployeeEntity> employeeList = repository.findAll();
		//
		return repository.findAll();
		
	}

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
		if (entity.getId()==null) {
			entity = repository.save(entity);
			return entity;
		}
		else {
			Optional<EmployeeEntity> employee = repository.findById(entity.getId());
			if (employee.isPresent()) {
				EmployeeEntity newEntity = employee.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity = repository.save(newEntity);	
				return newEntity;
			} else {
				entity = repository.save(entity);
				return entity;
			}
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}