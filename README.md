# Khóa luận tốt nghiệp
## Website tìm kiếm nhà trọ
| Tác giả| MSSV | Email|
| ------------- |:-------------:|:-----------:|
| Đoàn Huỳnh Thiện| 15110129 | thiendoanspkt@gmail.com
 
Tìm kiếm phòng trọ tại thành phố Hồ Chí Minh để ở luôn là một trong những vấn đề khó khăn đối với những người đi thuê, đặc biệt là đối với các bạn học sinh, sinh viên từ quê vào thành phố để tiếp tục con đường học tập. Còn đối với người cho thuê, họ cũng khó có thể tiếp cận với những người đi thuê với các cách tiếp thị truyền thống.

Để giảm thiểu khó khăn này, chúng tôi đã quyết định phát triển một website tìm kiếm nhà trọ.

Website được phát triển bằng Spring Boot và Angular.
### Các chức năng hiện có:
- Người dùng chưa đăng nhập:
	- Tìm kiếm phòng trọ
	- Đăng ký
	- Đăng nhập
- Thành viên:
	- Các chức năng của người dùng chưa đăng nhập
	- Quản lý tin đăng
	- Quản lý bình luận và đánh giá
	- Quản lý thông báo
	- Đăng xuất
- Kiểm duyệt viên:
	- Các chức năng của thành viên
	- Quản lý tin đăng của thành viên
	- Xem hoạt động của hệ thống
- Quản trị viên:
	- Các chức năng của kiểm duyệt viên
	- Quản lý thành viên
### Hướng dẫn chạy chương trình
1.	Cài đặt MySQL Workbench.
2.	Reset password user root thành "". ([Cách thực hiện](https://dev.mysql.com/doc/mysql-windows-excerpt/5.7/en/resetting-permissions-windows.html))
3.	Tạo một database tên là "moteldb".
4.	Cài đặt môi trường Java 8.
5.	Mở command line.
6.	Trong command line gõ lệnh `cd [location]`. [location] là thư mục nơi chứa file .jar. (trong thư mục motel-service).
7.	Sau khi chuyển thư mục thành công, gõ lệnh `java -jar motel-service-0.0.1-SNAPSHOT.jar` để bắt đầu chạy chương trình.
8.	Bật trình duyệt, gõ `localhost:8080` để vào trang dành cho người dùng hoặc `localhost:8080/admin` để vào trang quản lý.

**Danh sách tài khoản để test**

|Email|Password|Role|
|:--:|:--:|:--:|
|admin@gmail.com|123| Quản trị viên
|mod@gmail.com|123| Kiểm duyệt viên
|user@gmail.com|123| Thành viên
