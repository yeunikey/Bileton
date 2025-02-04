package team.bileton.application.services;

import com.yourprojectname.entity.OrderHistory;
import com.yourprojectname.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;

    @Autowired
    public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public List<OrderHistory> getAllOrderHistories() {
        return orderHistoryRepository.findAll();
    }

    public OrderHistory getOrderHistoryById(Long id) {
        return orderHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order history not found with id: " + id));
    }

    public OrderHistory createOrderHistory(OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }

    public OrderHistory updateOrderHistory(Long id, OrderHistory updatedOrderHistory) {
        OrderHistory existingOrderHistory = getOrderHistoryById(id);
        existingOrderHistory.setOrderId(updatedOrderHistory.getOrderId());
        existingOrderHistory.setProductName(updatedOrderHistory.getProductName());
        existingOrderHistory.setQuantity(updatedOrderHistory.getQuantity());
        existingOrderHistory.setPrice(updatedOrderHistory.getPrice());
        existingOrderHistory.setOrderDate(updatedOrderHistory.getOrderDate());
        existingOrderHistory.setStatus(updatedOrderHistory.getStatus());
        return orderHistoryRepository.save(existingOrderHistory);
    }

    public void deleteOrderHistory(Long id) {
        orderHistoryRepository.deleteById(id);
    }
}