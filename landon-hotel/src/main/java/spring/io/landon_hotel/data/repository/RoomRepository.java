package spring.io.landon_hotel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.io.landon_hotel.data.entity.Room;

import java.util.Optional;


public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);


}
