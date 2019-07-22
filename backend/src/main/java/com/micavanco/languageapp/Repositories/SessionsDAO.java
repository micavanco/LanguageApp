package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.Sessions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SessionsDAO extends CrudRepository<Sessions, Long> {

    @Query("SELECT s FROM Sessions s WHERE s.user_id=:user_id")
    Sessions getByUser_id(@Param("user_id")Long user_id);
}
