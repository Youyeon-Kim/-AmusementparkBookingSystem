package controller;

import java.util.List;

import model.BookingDAO;
import model.BookingVO;
import model.RideDAO;
import view.AllView;

public class RidesController {

	public static void main(String[] args) {
		mainmenu();
	}

	private static void mainmenu() {
		AllView view = new AllView();
		RideDAO ride = new RideDAO();
		BookingDAO booking = new BookingDAO();
		int no;
		no =view.menuDisplay();
		
		
		switch (no) {
		case 1:
			view.loginDisplay();
			mainmenu();
			break;
		case 2:
			view.bookingDisplay();
			mainmenu();
			break;
		case 3:
			view.yourBookingDisplay();
			mainmenu();
			break;
		case 4:
			view.facilitiesListDisplay(ride.showAllRides());
			mainmenu();
			break ;
		case 5:
			view.bookingListDisplay(booking.showAllBooking());
			mainmenu();
			break;

		default:
			System.out.println("잘못입력하셨습니다.");
			mainmenu();
			break;
		}
		
	}
}
