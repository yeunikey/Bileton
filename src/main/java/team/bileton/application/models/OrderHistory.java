package team.bileton.application.models;

import java.time.LocalDateTime;

@Table(name = "order_history")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "status", nullable = false)
    private String status;

}
