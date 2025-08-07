// ✅ Flight Reservation System (Monolithic)

// Flight.java
@Entity
public class Flight {
    @Id @GeneratedValue
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private int seatsAvailable;

    @OneToMany(mappedBy = "flight")
    private List<Reservation> reservations;
}

// Reservation.java
@Entity
public class Reservation {
    @Id @GeneratedValue
    private Long id;
    private String passengerName;
    private String passengerEmail;
    private int seatsBooked;
    private LocalDateTime reservedAt;

    @ManyToOne
    private Flight flight;
}

// FlightRepository.java
public interface FlightRepository extends JpaRepository<Flight, Long> {}

// ReservationRepository.java
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}

// ✅ Product-Order Management System (Spring + Mockito)

// Product.java
@Entity
public class Product {
    @Id @GeneratedValue
    private Long productId;
    private String name;
    private double price;
    private int availableQuantity;
}

// Order.java
@Entity
public class Order {
    @Id @GeneratedValue
    private Long orderId;
    private LocalDate orderDate;
    private int quantityOrdered;

    @ManyToOne
    private Product product;
}

// ProductRepository.java
public interface ProductRepository extends JpaRepository<Product, Long> {}

// OrderRepository.java
public interface OrderRepository extends JpaRepository<Order, Long> {}

// ProductService.java
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateStock(Long productId, int qty) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setAvailableQuantity(qty);
        productRepository.save(product);
    }
}

// OrderService.java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        if (product.getAvailableQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
        productRepository.save(product);

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setQuantityOrdered(quantity);
        order.setProduct(product);
        return orderRepository.save(order);
    }
}

// ProductServiceTest.java
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testAddProduct() {
        Product product = new Product();
        product.setName("Pen");
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product, productService.addProduct(product));
    }
}

// OrderServiceTest.java
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;

    @Test
    void testPlaceOrderSuccess() {
        Product product = new Product();
        product.setAvailableQuantity(10);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Order result = orderService.placeOrder(1L, 5);

        assertEquals(5, result.getQuantityOrdered());
        verify(productRepository).save(product);
        verify(orderRepository).save(any(Order.class));
    }
}
