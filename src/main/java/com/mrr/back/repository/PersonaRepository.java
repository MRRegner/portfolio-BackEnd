
package com.mrr.back.repository;

import com.mrr.back.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
   public List<Persona> findByNombreContaining(@Param("nombre")String nombre); 
}
