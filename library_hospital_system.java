// ✅ Case Study 1: Library Management System (Spring Boot + JPA)

// Reader.java
@Entity
public class Reader {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "reader")
    private List<Book> books;
}

// Book.java
@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private LocalDate publishDate;

    @ManyToOne
    private Reader reader;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Author author;
}

// Category.java
@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}

// Author.java
@Entity
public class Author {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}

// Repositories
public interface ReaderRepository extends JpaRepository<Reader, Long> {}
public interface BookRepository extends JpaRepository<Book, Long> {}
public interface CategoryRepository extends JpaRepository<Category, Long> {}
public interface AuthorRepository extends JpaRepository<Author, Long> {}

// LibraryController.java
@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired private ReaderRepository readerRepo;
    @Autowired private BookRepository bookRepo;
    @Autowired private AuthorRepository authorRepo;
    @Autowired private CategoryRepository categoryRepo;

    @PostMapping("/readers")
    public Reader addReader(@RequestBody Reader reader) {
        return readerRepo.save(reader);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepo.save(category);
    }
}

// ✅ Case Study 2: Hospital Management System

// Patient.java
@Entity
public class Patient {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String address;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;
}

// Doctor.java
@Entity
public class Doctor {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}

// Appointment.java
@Entity
public class Appointment {
    @Id @GeneratedValue
    private Long id;
    private LocalDate date;
    private String time;
    private String notes;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
}

// MedicalRecord.java
@Entity
public class MedicalRecord {
    @Id @GeneratedValue
    private Long id;
    private String diagnosis;
    private String treatment;
    private LocalDate date;

    @ManyToOne
    private Patient patient;
}

// Repositories
public interface PatientRepository extends JpaRepository<Patient, Long> {}
public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {}
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {}
