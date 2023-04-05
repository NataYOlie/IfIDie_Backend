package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.ListType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ListTypeDao extends JpaRepository<ListType, Integer> {

    @Query("select l from ListType l where l.list_name = :listname")
    ListType findByList_name(@Param("listname") String listname);
}
