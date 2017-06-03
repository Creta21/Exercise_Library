package com.exercise.repository;

import com.exercise.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
    // This interface can remain empty.
    // By default, we will get findOne and findAll for free
    
    // to findAll den to grafw uparxei automata
    // anti gia findById uparxei automata h findOne pou kanei akrivws tin idia douleia
    // an thelw kati allo ektos apo ALL kai ID to  grafw!!!!
    // px DailyMenu findByDate(LocalDate date);
    
    //This Query return (True/False) if user have final orders(in Past).
    // @Query(value="SELECT CASE WHEN COUNT(DISTINCT final) = 1 THEN 'true' ELSE 'false' END AS bool\n" +
   //                  "FROM daily_order WHERE user_id =:user_id AND final = 1", nativeQuery = true)
   // Boolean ifHasFinalOrders (@Param("user_id") Long id);
    
    // List<OrderItem> findByFoodIdAndDailyOrderIn(Long id, Collection<DailyOrder> dailyOrders);
}
