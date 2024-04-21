package ma.fsumi.hopital2.repository;

import ma.fsumi.hopital2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Patientrespositoty  extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String keyword , Pageable pageable);
    @Query("select p from Patient p where p.nom like :x")
    Page <Patient> chercher(@Param("x") String keyword , Pageable pageable);
}
