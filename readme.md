BTL: Hệ thống ATM kết nối trao đổi thông qua RMI
1. Đặc điểm của chương trình
- Chương trình phân tán
- Sử dụng ngôn ngữ lập trình Java										
- Sử dụng JDBC kết nối cơ sở dữ liệu MySQL										
- Phương pháp mã hóa mật khẩu(PIN) là Bcrypt										
- Sử dụng docker
- Sử dụng RMI
- Truyền thông bảo mật bằng SSL
- Xác thực người dùng bằng JWT
- Nếu nhập sai quá 3 lần mã PIN tài khoản sẽ bị khóa
- Tại một thời điểm chỉ đăng nhập được 1 lần
- Thời gian hiệu lực tính từ khi đăng nhập thành công là 10 phút, sau 10 phút chương trình sẽ tự tắt
- Tại cùng thời điểm đăng nhập sinh JWToken là khác nhau(Tính đến phần tích tắc)
- Kết thúc phiên là kết thúc token, chống lại tấn công phát lại
2. Chức năng phía client
- Đăng nhập
- Vấn tin tài khoản
- Chuyển khoản
- Rút tiền
- Đổi mật khẩu
- Đăng xuất
3. Chức năng phía server
- Giám sát giao dịch
- Tạo tài khoản
- Đổi mật khẩu
- Nạp tiền
- Xem danh sách tài khoản
