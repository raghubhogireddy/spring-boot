package spring.io.landon_hotel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.io.landon_hotel.data.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
