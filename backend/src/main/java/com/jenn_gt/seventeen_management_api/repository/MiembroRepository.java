package com.jenn_gt.seventeen_management_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jenn_gt.seventeen_management_api.model.Miembro;

import java.time.LocalDate;
import java.util.List;

// La capa Repository es una interfaz que hereda de JpaRepository.
// Spring Boot creará automáticamente toda la implementación para comunicarse con la BD.
// Otorga todos los métodos CRUD (Crear, Leer, Actualizar, Borrar) automáticamente
// y permite crear consultas personalizadas solo con el nombre del método.

@Repository // Le dice a Spring que esta es la capa de acceso a datos.
public interface MiembroRepository extends JpaRepository<Miembro, Long>{
                                        // JpaRepository<Modelo, TipoDatoPK>

    // Aquí sin agregar nada más ya se tienen los métodos básicos para
    // trabajar con la BD como:
    // -> findAll()             : Trae a todos los miembros.
    // -> findById(Long id)     : Busca por la llave primaria.
    // -> save(Miembro m)       : Guarda o actualiza.
    // -> deleteById(Long id)   : Borra.
    // -> count()               : Cuenta cuántos hay.


    // QUERY METHODS
    // Spring usa un motor de análisis de nombres y traduce el método a SQL.
    // Estructura: [Sujeto] + [Predicado] + [Criterio]
    // -> Sujeto: find...By, read...By, query...By, count...By, exists...By.
    // -> Predicado: El nombre del atributo en la clase Modelo
    // -> Criterio (Opcional): Operadores lógicos como And, Or, Between, LessThan, Like.
    
    // Igualdad (=)
    List<Miembro> findByStageName(String stageName);

    // O lógico (OR)
    List<Miembro> findByNombreOrStageName(String n, String s);

    // Contiene (LIKE '%palabra%')
    List<Miembro> findByNombreContaining(String palabra);

    // Empieza con (LIKE 'prefijo%')
    List<Miembro> findByApellidoStartingWith(String prefijo);

    // Menor que (>)
    List<Miembro> findByFechaNacimientoAfter(LocalDate fecha);

    // Contar (COUNT(*))
    List<Miembro> countByIdSubunidad(Integer id);

    // Existe?
    List<Miembro> existsByStageName(String st);

    // Orden
    List<Miembro> findByIdSubunidadOrderByApellidoAsc(Integer id);

    // Limitar resultados: All, First, Top
    List<Miembro> findFirstByOrderByFechaNacimientoAsc();

    // NO Case-sensitive
    List<Miembro> findByStageNameIgnoreCase(String st);
}
