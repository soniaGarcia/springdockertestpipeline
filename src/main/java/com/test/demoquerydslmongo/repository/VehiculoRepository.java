package com.test.demoquerydslmongo.repository;

import com.test.demoquerydslmongo.model.QVehiculo;
import com.test.demoquerydslmongo.model.Vehiculo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sonia.cabrera
 */
public interface VehiculoRepository 
        extends CrudRepository<Vehiculo, String>, QuerydslPredicateExecutor<Vehiculo>, QuerydslBinderCustomizer<QVehiculo>{
    
    @Override
	default public void customize(QuerydslBindings bindings, QVehiculo root) {

	}
}
