package ru.itis.kurguskina.internet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.kurguskina.internet.models.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    User findAllByConfirmCode(String code);
    List<User> findAllByState(User.State state);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update users set first_name = :firstName, last_name = :lastName, password = :password where email = :email",  nativeQuery = true)
    void updateUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("password") String password, @Param("email") String email);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from users where id = :id",  nativeQuery = true)
    void deleteUser(@Param("id") Long Id);

    @Query(value = "select * from users WHERE email = :email", nativeQuery = true)
    Optional<User> getUserByEmail(@Param("email") String email);
}
