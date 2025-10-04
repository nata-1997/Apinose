package co.edu.uco.nose.data.dao;

import java.util.List;

public interface RetrieveDAO <E, ID> {
	
	List<E> finALL();
	
	List<E> findByIdFilter(E filterEntity);
	
	E findById(ID id);
	

}