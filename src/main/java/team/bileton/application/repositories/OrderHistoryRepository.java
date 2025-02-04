package team.bileton.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yourprojectname.entity.OrderHistory;

@team.bileton.application.repositories.Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    OrderHistory findByOrderId(String orderId);
}
