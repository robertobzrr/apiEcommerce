package com.robertoapi.login_and_authentication_api.repository;
import com.robertoapi.login_and_authentication_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
