package spring.io.landon_hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.io.landon_hotel.data.entity.Guest;
import spring.io.landon_hotel.data.entity.Reservation;
import spring.io.landon_hotel.data.entity.Room;
import spring.io.landon_hotel.data.repository.GuestRepository;
import spring.io.landon_hotel.data.repository.ReservationRepository;
import spring.io.landon_hotel.data.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository,
                    ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("*** GUESTS ***");
        List<Guest> guests = guestRepository.findAll();
        System.out.println(guests);
        System.out.println("*** RESERVATIONS ***");
        List<Reservation> reservations = reservationRepository.findAll();
        System.out.println(reservations);
        System.out.println("*** ROOMS ***");
        List<Room> rooms = roomRepository.findAll();
        Optional<Room> room = roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);
        rooms.forEach(System.out::println);
    }
}
