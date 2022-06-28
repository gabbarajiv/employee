package com.takeo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.binding.Employee;
import com.takeo.entity.EmployeeEntity;
import com.takeo.repo.EmployeeRepository;
import com.takeo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository empRepo;

	@Override
	public boolean saveEmployee(Employee em) {
		// TODO Auto-generated method stub

		boolean flag = false;
		EmployeeEntity entity = new EmployeeEntity();

		BeanUtils.copyProperties(em, entity);
//		entity.setSname(emp.getEname());
//		entity.setSadd(emp.getEadd());
		EmployeeEntity emp = empRepo.save(entity);

		if (emp != null) {
			flag = true;
		}

		return flag;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> entityRecords = empRepo.findAll();
		List<Employee> addRecords = new ArrayList<>();

		for (EmployeeEntity entity : entityRecords) {
			Employee e = new Employee();
			BeanUtils.copyProperties(entity, e);
			addRecords.add(e);
		}

		return addRecords;
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		Employee emp = null;
		Optional<EmployeeEntity> findById = empRepo.findById(id);
		if (findById.isPresent()) {
			EmployeeEntity entity = findById.get();
			emp = new Employee();
			BeanUtils.copyProperties(entity, emp);
		}

		return emp;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		EmployeeEntity entity = new EmployeeEntity();
		System.out.println(emp.getEno() + "\t" + emp.getEname() + "\t" + emp.getEadd());

		BeanUtils.copyProperties(emp, entity);
		System.out.println(entity.getEno() + "\t" + entity.getEname() + "\t" + entity.getEadd());
		EmployeeEntity savedEntity = empRepo.save(entity);

		// StudentEntity savedEntity=stuRepo.save(entity);

		// stuRepo.
		boolean flag = false;
		if (savedEntity.getEno() != 0)
			flag = true;

		return flag;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub

		empRepo.deleteById(id);

	}

}
