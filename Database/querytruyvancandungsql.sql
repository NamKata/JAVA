use DangKyHocPhan
-- Quản trị
-- Thông tin cá nhân
	-- Lấy thông tin cá nhân
	SELECT IdNguoiDung as N'Mã Người Dùng', MaNguoiDung as N'Tài khoản',HoTen as N'Họ Và Tên',NgaySinh as N'Ngày Sinh',DiaChi as N'Địa Chỉ',Sdt as N'Số điện thoại',Email as N'Email' FROM tblNguoiDung WHERE IdNguoiDung=1
	-- Cập nhập thông tin cá nhân
	UPDATE tblNguoiDung SET HoTen= N'Thầy Giáo Ba', NgaySinh = '2000-08-06', DiaChi = N'Hồ Chí Minh', Sdt = '0123456789', Email ='zxc@asd.qwe' WHERE IdNguoiDung=1
	-- Thây dổi mật khẩu
	UPDATE tblNguoiDung  SET MatKhau = '1' WHERE IdNguoiDung=1
-- Quản lý lớp
	-- Lấy thông tin Khoa vào combobox
	SELECT TenKhoa FROM Khoa 
	-- Thêm mới lớp
	INSERT INTO Lop(TenLop, IdKhoa) VALUES(N'16TT01',3)
	-- Sửa thông tin lớp
	UPDATE Lop SET TenLop = N'16TT001', IdKhoa ='3' WHERE IdLop = 4
	-- Xóa Lớp
	DELETE FROM Lop WHERE IdLop = 4
	-- Danh sách vô Table
	SELECT  IdLop as N'Mã Lớp', TenLop as N'Tên Lớp', TenKhoa as N'Khoa' FROM Lop, Khoa WHERE Lop.IdKhoa=Khoa.IdKhoa
	-- Tìm kiếm bằng tên lớp
	SELECT  IdLop as N'Mã Lớp', TenLop as N'Tên Lớp', TenKhoa as N'Khoa' FROM Lop, Khoa WHERE Lop.IdKhoa=Khoa.IdKhoa and TenLop like N'%16T%'
	-- Tìm kiếm bằng Khoa
	SELECT  IdLop as N'Mã Lớp', TenLop as N'Tên Lớp', TenKhoa as N'Khoa' FROM Lop, Khoa WHERE Lop.IdKhoa=Khoa.IdKhoa and Lop.IdKhoa =3
	SELECT  IdLop as N'Mã Lớp', TenLop as N'Tên Lớp', TenKhoa as N'Khoa' FROM Lop, Khoa WHERE Lop.IdKhoa=Khoa.IdKhoa and Khoa.TenKhoa like N'%Công Nghệ Ô Tô%'
	-- Tìm mã khoa qua tên khoa--
	SELECT IdKhoa FROM Khoa WHERE TenKhoa = N'Công Nghệ Ô Tô'
	-- kiểm tra có học sinh trong lớp học đó ko
	SELECT COUNT(*) FROM tblNguoiDung, Lop where tblNguoiDung.IdLop = Lop.IdLop and Lop.IdLop = 1

----------------------------------------------
-- Quản lý Khoa
	-- Danh sách Vô Table
	SELECT IdKhoa as N'Mã Khoa',TenKhoa as N'Tên Khoa' FROM Khoa 
	-- Thêm mới lớp
	INSERT INTO Khoa(TenKhoa) VALUES(N'Ngôn ngữ Anh')
	-- Sửa thông tin lớp
	UPDATE Khoa SET TenKhoa = N'Ngôn ngữ Anh-Nhật' WHERE IdKhoa = 4
	-- Xóa Lớp
	DELETE FROM Khoa WHERE IdKhoa = 4
	-- Danh sách
	SELECT IdKhoa as N'Mã Khoa',TenKhoa as N'Tên Khoa' FROM Khoa  WHERE IdKhoa = 4
	-- Tìm kiếm bằng tên khoa
	SELECT IdKhoa as N'Mã Khoa',TenKhoa as N'Tên Khoa' FROM Khoa  WHERE TenKhoa like N'%Công Nghệ Ô Tô%'
-------------------------------------
-- Quản lý Phòng Học
	-- Danh sách Vô Table
	SELECT IdPhong as N'Mã Phòng',TenPhong as N'Tên Phòng', SoLuong as N'Số lượng' FROM PhongHoc 
	-- Thêm mới lớp
	INSERT INTO PhongHoc(TenPhong,SoLuong) VALUES(N'E.02.03', 70)
	-- Sửa thông tin lớp
	UPDATE PhongHoc SET TenPhong = N'E1.02.03', SoLuong='60' WHERE IdPhong = 7
	-- Xóa Lớp
	DELETE FROM PhongHoc WHERE IdPhong = 7
	-- Danh sách
	SELECT IdPhong as N'Mã Phòng',TenPhong as N'Tên Phòng', SoLuong as N'Số lượng' FROM PhongHoc WHERE IdPhong=7
	-- Tìm kiếm bằng tên phòng
	SELECT IdPhong as N'Mã Phòng',TenPhong as N'Tên Phòng', SoLuong as N'Số lượng' FROM PhongHoc WHERE TenPhong like N'%E1%'
	-- Kiểm ra xem phòng học có lớp dạy chưa --
	SELECT COUNT(*) as N'Đếm' FROM PhongHoc, DangKy where PhongHoc.IdPhong = DangKy.IdPhong and DangKy.Status in (1,2,3) and PhongHoc.IdPhong=3
-------------------------
-- Quản lý Môn học
	-- kiểm tra môn này đã giảng chưa ?--
	SELECT COUNT(*) as N'Đếm' FROM MonHoc, DangKy where MonHoc.IdKhoa = DangKy.IdMonHoc and DangKy.Status in (1,2,3) and MonHoc.IdKhoa=1
	-- Lấy thông tin Khoa vào combobox
	SELECT TenKhoa FROM Khoa 
	-- Danh sách Vô Table
	SELECT IdMonHoc as N'Mã Môn',TenMonHoc as N'Tên Môn Học', SoTinChi as N'Số Tín Chỉ', SoTiet as N'Số Tiết', SoTien as N'Tiền/Tín Chỉ', TenKhoa FROM MonHoc, Khoa  WHERE MonHoc.IdKhoa=Khoa.IdKhoa
	-- Thêm mới lớp
	INSERT INTO MonHoc(TenMonHoc,SoTinChi, SoTiet,SoTien,IdKhoa) VALUES(N'Lập trình hướng đối tượng', 3,30,650000,1)
	-- Sửa thông tin lớp
	UPDATE MonHoc SET TenMonHoc = N'Lập trình hướng đối tượng', SoTinChi='60', SoTien='700000', IdKhoa='1' WHERE IdMonHoc = 5
	-- Xóa Lớp
	DELETE FROM MonHoc WHERE IdMonHoc = 5
	-- Lấy thông tin
	SELECT IdMonHoc as N'Mã Môn',TenMonHoc as N'Tên Môn Học', SoTinChi as N'Số Tín Chỉ', SoTiet as N'Số Tiết', SoTien as N'Tiền/Tín Chỉ', TenKhoa FROM MonHoc, Khoa  WHERE MonHoc.IdKhoa=Khoa.IdKhoa and IdMonHoc=7
	-- Tìm kiếm bằng 
	SELECT IdMonHoc as N'Mã Môn',TenMonHoc as N'Tên Môn Học', SoTinChi as N'Số Tín Chỉ', SoTiet as N'Số Tiết', SoTien as N'Tiền/Tín Chỉ', TenKhoa FROM MonHoc, Khoa  WHERE MonHoc.IdKhoa=Khoa.IdKhoa and TenMonHoc like N'%Lập%'
	SELECT IdMonHoc as N'Mã Môn',TenMonHoc as N'Tên Môn Học', SoTinChi as N'Số Tín Chỉ', SoTiet as N'Số Tiết', SoTien as N'Tiền/Tín Chỉ', TenKhoa FROM MonHoc, Khoa  WHERE MonHoc.IdKhoa=Khoa.IdKhoa and MonHoc.IdKhoa =1
	SELECT IdMonHoc as N'Mã Môn',TenMonHoc as N'Tên Môn Học', SoTinChi as N'Số Tín Chỉ', SoTiet as N'Số Tiết', SoTien as N'Tiền/Tín Chỉ', TenKhoa FROM MonHoc, Khoa  WHERE MonHoc.IdKhoa=Khoa.IdKhoa and Khoa.TenKhoa like N'%Công Nghệ Thông Tin%'
-------------------
-- Quản lý Giảng Viên
	-- Lấy thông tin Trình Độ vào combobox
	SELECT TenTrinhDo FROM TrinhDo WHERE IdTrinhDo in (4,5,6) 
	-- Danh sách Vô Table
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' FROM tblNguoiDung, TrinhDo  WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdQuyen = 2
	-- Thêm mới giáo viên
	-- Lưu ý:
			-- Họ Tên, Ngày Sinh, Địa chỉ, Sđt, Email có thể bỏ trống
			-- IdTrinhDo getselectindex có thể sai đấy "i+3" nhé. Kiểm tra cho kỹ
			-- Xét cứng Quyền  = 2 
	INSERT INTO tblNguoiDung(MaNguoiDung,MatKhau,HoTen,NgaySinh,DiaChi,Sdt,Email,IdTrinhDo,IdQuyen) VALUES(N'GV002','1','','', '','','',5,2)
	-- Sửa thông tin lớp
	UPDATE tblNguoiDung SET HoTen = N'Nguyễn Văn A', NgaySinh='08/08/1998', DiaChi=N'700000', Sdt='0123456789' , Email='abc@gmail.com' WHERE IdNguoiDung = 4
	-- Xóa Lớp
	DELETE FROM tblNguoiDung WHERE IdNguoiDung = 5
	-- Lấy thông tin
	SELECT IdNguoiDung, HoTen, NgaySinh, DiaChi, Sdt,Email FROM tblNguoiDung where IdNguoiDung=4
	-- Tìm kiếm bằng 
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' FROM tblNguoiDung, TrinhDo  WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdQuyen = 2 and HoTen like N'%A%'
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' FROM tblNguoiDung, TrinhDo  WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdQuyen = 2 and TrinhDo.TenTrinhDo like N'%Thạc Sĩ%'
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' FROM tblNguoiDung, TrinhDo  WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdQuyen = 2 and TrinhDo.IdTrinhDo = 4
-------------------------------

-- Quản lý Sinh Viên
	-- Lấy thông tin Trình Độ vào combobox
	SELECT TenTrinhDo FROM TrinhDo WHERE IdTrinhDo in (1,2,3) 
	-- Lấy thông tin Trình Độ vào combobox
	SELECT TenLop FROM Lop  
	SELECT TenLop FROM Lop, Khoa WHERE Lop.IdKhoa=Khoa.IdKhoa and Khoa.IdKhoa =1
	-- Danh sách Vô Table
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' , TenLop as N'Lớp' FROM tblNguoiDung, TrinhDo , Lop WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdLop=Lop.IdLop and tblNguoiDung.IdQuyen = 3
	-- Thêm mới giáo viên
	-- Lưu ý:
			-- Họ Tên, Ngày Sinh, Địa chỉ, Sđt, Email có thể bỏ trống
			-- IdTrinhDo getselectindex có thể sai đấy "i" nhé. Kiểm tra cho kỹ
			-- IdLop getselectindex có thể sai đấy "i" nhé. Kiểm tra cho kỹ ** ko biết có nên làm combobox khoa để chọn lớp ko
			-- Xét cứng Quyền  = 3
	INSERT INTO tblNguoiDung(MaNguoiDung,MatKhau,HoTen,NgaySinh,DiaChi,Sdt,Email,IdTrinhDo,IdLop,IdQuyen) VALUES(N'SV002','1','','', '','','',5,2,3)
	-- Sửa thông tin lớp
	UPDATE tblNguoiDung SET HoTen = N'Nguyễn Văn B', NgaySinh='08/08/1998', DiaChi=N'700000', Sdt='0123456789' , Email='abc@gmail.com',IdLop='1' WHERE IdNguoiDung = 5
	-- Xóa Lớp
	DELETE FROM tblNguoiDung WHERE IdNguoiDung = 5
	-- Lấy thông tin
	SELECT IdNguoiDung, HoTen, NgaySinh, DiaChi, Sdt,Email,IdLop,IdTrinhDo FROM tblNguoiDung where IdNguoiDung=5
	-- Tìm kiếm bằng 
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' , TenLop as N'Lớp' FROM tblNguoiDung, TrinhDo , Lop WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdLop=Lop.IdLop and tblNguoiDung.IdQuyen = 3 and HoTen like N'%A%'
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' , TenLop as N'Lớp' FROM tblNguoiDung, TrinhDo , Lop WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdLop=Lop.IdLop and tblNguoiDung.IdQuyen = 3 and TrinhDo.TenTrinhDo like N'%Đại Học%'
	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' , TenLop as N'Lớp' FROM tblNguoiDung, TrinhDo , Lop WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdLop=Lop.IdLop and tblNguoiDung.IdQuyen = 3  and TrinhDo.IdTrinhDo = 2
--------------------------------------------------=========
-- Quản lý Xét duyệt môn
	SELECT * from ThoiGianHoc
	SElect * from Thu
	SELECT * from PhongHoc
	SELECT * from DangKy
	-- Nạp dữ liệu vào table
	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng', SiSo as N'Sỉ Số', HoTen as N'Giảng Viên', TenHocKi as N'Học Kì' 
	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi 
	where DangKy.IdGV=tblNguoiDung.IdNguoiDung 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu and Status = 0
	-- Xét duyệt lịch đăng ký
	UPDATE DangKy SET Status ='1',ThoiGianMo='2020-06-27', ThoiGianDong = '2020-07-04' WHERE IdDangKy = 1
	-- if mở lớp là Status =1 khi đăng ký mà SiSoHienTai = SiSo  (50/50) thì cập nhập Status = 2 để đóng lớp
	UPDATE DangKy SET Status ='2' WHERE IdDangKy = 1
	-- Kiểm tra xem đã tồn tại chưa
	SELECT count(*) from DangKy where IdMonHoc=1 and IdThu=1 and IdThoiGian=1 and IdHocKi=1 and IdPhong=1 and Status =1
	-- if count >=1 thì ko cho tạo, vì đã có lịch đăng ký này rồi, ngược lại nếu count = 0 thì cho phép tạo mới. 
--========================---------------
-- Quản lý lịch giảng dạy
	-- Nạp dữ liệu vào table
	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',  HoTen as N'Giảng Viên', TenHocKi as N'Học Kì' , SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết'
	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi 
	where DangKy.IdGV=tblNguoiDung.IdNguoiDung 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu and Status = 2
	-- if quá trình học đã hết thì cập nhập Status = 3
	UPDATE DangKy SET Status ='3' WHERE IdDangKy = 1
	-- Tìm kiếm 
	-- Môn học
	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',  HoTen as N'Giảng Viên', TenHocKi as N'Học Kì' , SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết'
	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi 
	where DangKy.IdGV=tblNguoiDung.IdNguoiDung 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu and Status = 2 and TenMonHoc like N'%Java%'
	--== Họ tên giáo viên
	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',  HoTen as N'Giảng Viên', TenHocKi as N'Học Kì' , SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết'
	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi 
	where DangKy.IdGV=tblNguoiDung.IdNguoiDung 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu and Status = 2 and HoTen like N'%A%'
	-- Thêm mới lớp giảng dạy
	-- Kiểm tra xem đã tồn tại chưa
	SELECT count(*) from DangKy where IdMonHoc=1 and IdThu=1 and IdThoiGian=1 and IdHocKi=1 and IdPhong=1 and Status =1
	-- if count >=1 thì ko cho tạo, vì đã có lịch đăng ký này rồi, ngược lại nếu count = 0 thì cho phép tạo mới. 
	INSERT INTO DangKy(IdMonHoc,IdThu,IdThoiGian,IdHocKi,IdPhong,IdGV, Status,SiSo) VALUES(2,2,2,2,2,4,0,50)
	-- Cập nhập
	UPDATE DangKy SET IdMonHoc='2',IdThu='2',IdThoiGian='2',IdHocKi='2',IdPhong='2',IdGV='2',Status='0',SiSo='50',SiSoHienTai='0',ThoiGianMo='2020-06-06', ThoiGianDong = '2020-06-06' WHERE IdDangKy = 3
	-- Xóa
	DELETE FROM DangKy WHERE IdDangKy = 3
-- Cập nhập thông của Quản trị
	-- thông tin cá nhân
		UPDATE tblNguoiDung SET HoTen = N'Nguyễn Văn B', NgaySinh='08/08/1998', DiaChi=N'700000', Sdt='0123456789' , Email='abc@gmail.com' WHERE IdNguoiDung = '1'
	-- mật khẩu
		UPDATE tblNguoiDung SET MatKhau ='new' WHERE IdNguoiDung='1'
--------------------------------------------------------
--******************************************************
-- Giảng Viên
-- Thời khóa biếu
	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',   TenHocKi as N'Học Kì' , SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết'
	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi 
	where DangKy.IdGV=tblNguoiDung.IdNguoiDung 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu and Status = 2 and tblNguoiDung.IdNguoiDung = 1
-- Đăng Ký Môn
	-- Nạp Phòng học vào combobox
		SELECT TenPhong FROM PhongHoc
	-- Nạp thứ vào combobox
		SELECT TenThu FROM Thu
	-- Nạp thời gian học vào combobox
		SELECT (Buoi+' : '+TietBD)as N'thời gian' FROM ThoiGianHoc
	-- Nạp Học kì vào combobox
		SELECT TenHocKi FROM HocKi
	-- Kiểm tra xem đã tồn tại chưa
	SELECT count(*) from DangKy where IdMonHoc=1 and IdThu=1 and IdThoiGian=1 and IdHocKi=1 and IdPhong=1 and Status =1
	-- if count >=1 thì ko cho tạo, vì đã có lịch đăng ký này rồi, ngược lại nếu count = 0 thì cho phép tạo mới. 
	INSERT INTO DangKy(IdMonHoc,IdThu,IdThoiGian,IdHocKi,IdPhong,IdGV, Status,SiSo) VALUES(2,2,2,2,2,4,0,50)
-- Thay đổi mật khẩu
	-- kiểm tra mật khẩu cũ cho trùng mật khẩu ko
	SELECT count(*) From tblNguoiDung WHERE IdNguoiDung='1' and MatKhau = 'Matkhaucu'
	--if count = 1 thì cho phep update
	UPDATE tblNguoiDung SET MatKhau ='new' WHERE IdNguoiDung='1'
-- Thay đổi thông tin cá nhân
	UPDATE tblNguoiDung SET HoTen = N'Nguyễn Văn B', NgaySinh='08/08/1998', DiaChi=N'700000', Sdt='0123456789' , Email='abc@gmail.com', IdTrinhDo='5' WHERE IdNguoiDung = '1'
-- Lấy thông tin qua mã
	SELECT * From tblNguoiDung WHERE IdNguoiDung='1'
--****************************************************--
--====================================================--
-- Sinh Viên
-- Thời khóa biểu
	SELECT TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',  (SELECT Distinct HoTen From tblNguoiDung as a, DangKy b WHERE b.IdGV = a.IdNguoiDung and b.IdGV = DangKy.IdGV) as N'Giảng Viên', TenHocKi as N'Học Kì' ,  SoTiet as N'Số Tiết'
	From DangKy,DangKyHocPhan,ThoiKhoaBieu, PhongHoc,Thu,ThoiGianHoc,MonHoc, HocKi 
	where DangKy.IdDangKy=ThoiKhoaBieu.IdDangKy and 
		DangKyHocPhan.IdDangKyHP = ThoiKhoaBieu.IdDangKyHP 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu 
		  and DangKyHocPhan.IdSV =2
-- Đăng Ký Học Phần
	-- nạp dữ liệu danh sách đăng ký vô table
	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',   TenHocKi as N'Học Kì' , SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết',  tblNguoiDung.HoTen as N'Giảng viên'
	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi 
	where DangKy.IdGV=tblNguoiDung.IdNguoiDung 
		  and DangKy.IdHocKi = HocKi.IdHocKi 
		  and DangKy.IdMonHoc=MonHoc.IdMonHoc 
		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian
		  and DangKy.IdPhong = PhongHoc.IdPhong
		  and DangKy.IdThu = Thu.IdThu and Status = 2
	-- Thêm học phần
	INSERT INTO DangKyHocPhan(IdSV,Status,HocPhi) VALUES('5','0','0')
	-- thêm học phần xong thì mới thêm được môn
	-- phần học phí tý nữa add môn thì update lại
	INSERT INTO ThoiKhoaBieu(IdDangKyHP,IdDangKyHP)VALUES('1','2')
	-- save thì làm ở trong float tong += (sotien*tinchi)
	--update lại học phi
	UPDATE DangKyHocPhan SET HocPhi='700000' WHERE IdDangKyHP = '2'
-- Thay đổi mật khẩu
	-- kiểm tra mật khẩu cũ cho trùng mật khẩu ko
	SELECT count(*) From tblNguoiDung WHERE IdNguoiDung='1' and MatKhau = 'Matkhaucu'
	--if count = 1 thì cho phep update
	UPDATE tblNguoiDung SET MatKhau ='new' WHERE IdNguoiDung='1'
-- Thay đổi thông tin cá nhân
	UPDATE tblNguoiDung SET HoTen = N'Nguyễn Văn B', NgaySinh='08/08/1998', DiaChi=N'700000', Sdt='0123456789' , Email='abc@gmail.com', IdTrinhDo='5' WHERE IdNguoiDung = '1'
-- Lấy thông tin qua mã
	SELECT * From tblNguoiDung WHERE IdNguoiDung='1'
		