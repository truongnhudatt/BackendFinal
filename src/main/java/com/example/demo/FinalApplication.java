package com.example.demo;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.security.PasswordEncoder;
import com.example.demo.services.impl.BookServiceImpl;
import com.example.demo.services.impl.UserServiceImpl;
import com.example.demo.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FinalApplication {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private BookServiceImpl bookService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(){
		return args -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail("truongnhudatptit@gmail.com");
			userDTO.setUsername("truongnhudat");
			userDTO.setFirstName("Truong");
			userDTO.setPassword(passwordEncoder.bCryptPasswordEncoder().encode("truongnhudat@"));
			userDTO.setLastName("Dat");
			userDTO.setRole(Role.valueOf("ADMIN"));
			userService.save(userDTO);

			UserDTO userDTO1 = new UserDTO();
			userDTO1.setEmail("truongnhudatptit1@gmail.com");
			userDTO1.setUsername("truongnhudat1");
			userDTO1.setFirstName("Truong");
			userDTO1.setPassword(passwordEncoder.bCryptPasswordEncoder().encode("truongnhudat@"));
			userDTO1.setLastName("Dat");
			userDTO1.setRole(Role.valueOf("ADMIN"));
			userService.save(userDTO1);


			BookDTO bookDTO = new BookDTO();
			bookDTO.setTitle("Những Đêm Không Ngủ, Những Ngày Chậm Trôi");
			bookDTO.setAuthor("A Crazy Mind team");
			bookDTO.setTypeBook("Sách");
			bookDTO.setDescription("“Những đêm không ngủ, những ngày chậm trôi” đại diện cho một hành tinh mới - nơi nỗi đau tinh thần được đưa ra ánh sáng và chữa lành.");
			bookDTO.setDateRelease(new Date("01/03/2021"));
			bookDTO.setTotalPage(192);
			bookDTO.setPrice(52900f);
			bookService.save(bookDTO);


			BookDTO bookDTO1 = new BookDTO();
			bookDTO1.setTitle("Yêu Những Điều Không Hoàn Hảo");
			bookDTO1.setAuthor("Hae Min");
			bookDTO1.setTypeBook("Sách");
			bookDTO1.setDescription("Đại đức Hae Min sinh ra và lớn lên tại Hàn Quốc. Sau khi hoàn thành bằng Thạc sĩ Tôn giáo học đối chiếu ở Đại học Havard và Tiến sĩ Tôn giáo học ở Đại học Princeton, ông ở lại Mỹ tham gia giảng dạy về tôn giáo ở trường Đại học Hampshire, Massachusetts. Không chỉ dừng lại ở nghiên cứu lý thuyết, mùa xuân năm 2000 ông quyết định xuất gia theo tông phái Tào Khê, một tông phái tiêu biểu của Phật giáo Hàn Quốc. Năm 2015, Đại đức Hae Min trở về Seoul, cùng nhiều chuyên gia mở trường Trị liệu tâm hồn, điều trị miễn phí cho những người gặp bất hạnh trong cuộc sống hay đang mang trong lòng nhiều khổ tâm. Đại đức Haemin là một trong những người rất có ảnh hưởng tới giới trẻ Hàn Quốc, trang Twitter cá nhân () của ông hiện có tới hơn một triệu người theo dõi. Sách cùng tác giả: - Những vỡ lẽ của tuổi trẻ - Yêu lấy những điều không hoàn hảo.");
			bookDTO1.setDateRelease(new Date("01/03/2021"));
			bookDTO1.setTotalPage(300);
			bookDTO1.setPrice(83400f);
			bookService.save(bookDTO1);

			BookDTO bookDTO2 = new BookDTO();
			bookDTO2.setTitle("Dear, Darling");
			bookDTO2.setAuthor("Hiên");
			bookDTO2.setTypeBook("Sách");
			bookDTO2.setDescription("Dear, darling. Nếu tình yêu có hạn sử dụng, Em mong là dùng được trăm năm.” Quay trở lại sau 2 năm vắng bóng, “Dear darling” của Hiên gửi tặng bạn những lời thủ thỉ rất đỗi dịu dàng, rất đỗi ngọt ngào và cũng rất đỗi thơ qua 200 trang viết. Cuốn sách kết nối những tâm hồn cùng rung cảm trước cái đẹp và có chung tần số hạnh phúc, yêu thương. Hiên ký thác tất cả niềm yêu sống, những ngày mạnh mẽ đi qua nỗi buồn và vẹn tròn tình cảm của mình lên mỗi câu chữ.");
					bookDTO2.setDateRelease(new Date("03/14/2021"));
			bookDTO2.setTotalPage(200);
			bookDTO2.setPrice(56000f);
			bookService.save(bookDTO2);
		};
	}
}
