
package com.mrr.back.repository;


import com.mrr.back.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skills, Long>{
    
}
