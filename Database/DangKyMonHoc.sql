USE [DangKyHocPhan]
GO
/****** Object:  Table [dbo].[DangKy]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangKy](
	[IdDangKy] [int] IDENTITY(1,1) NOT NULL,
	[Status] [int] NULL,
	[IdMonHoc] [int] NULL,
	[IdThu] [int] NULL,
	[IdThoiGian] [int] NULL,
	[IdHocKi] [int] NULL,
	[IdPhong] [int] NULL,
	[SiSoHienTai] [int] NULL,
	[SiSo] [int] NULL,
	[IdGV] [int] NULL,
	[ThoiGianMo] [datetime] NULL,
	[ThoiGianDong] [datetime] NULL,
 CONSTRAINT [PK_DangKy] PRIMARY KEY CLUSTERED 
(
	[IdDangKy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DangKyHocPhan]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangKyHocPhan](
	[IdDangKyHP] [int] IDENTITY(1,1) NOT NULL,
	[Status] [int] NULL,
	[HocPhi] [float] NULL,
	[IdSV] [int] NULL,
 CONSTRAINT [PK_DangKyHocPhan] PRIMARY KEY CLUSTERED 
(
	[IdDangKyHP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocKi]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocKi](
	[IdHocKi] [int] IDENTITY(1,1) NOT NULL,
	[TenHocKi] [nvarchar](50) NULL,
 CONSTRAINT [PK_HocKi] PRIMARY KEY CLUSTERED 
(
	[IdHocKi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khoa](
	[IdKhoa] [int] IDENTITY(1,1) NOT NULL,
	[TenKhoa] [nvarchar](150) NULL,
 CONSTRAINT [PK_Khoa] PRIMARY KEY CLUSTERED 
(
	[IdKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lop]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lop](
	[IdLop] [int] IDENTITY(1,1) NOT NULL,
	[TenLop] [nvarchar](30) NULL,
	[IdKhoa] [int] NULL,
 CONSTRAINT [PK_Lop] PRIMARY KEY CLUSTERED 
(
	[IdLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MonHoc]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MonHoc](
	[IdMonHoc] [int] IDENTITY(1,1) NOT NULL,
	[TenMonHoc] [nvarchar](100) NULL,
	[SoTinChi] [int] NULL,
	[SoTiet] [int] NULL,
	[SoTien] [float] NULL,
	[IdKhoa] [int] NULL,
 CONSTRAINT [PK_MonHoc] PRIMARY KEY CLUSTERED 
(
	[IdMonHoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongHoc]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongHoc](
	[IdPhong] [int] IDENTITY(1,1) NOT NULL,
	[SoLuong] [int] NULL,
	[TenPhong] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhongHoc] PRIMARY KEY CLUSTERED 
(
	[IdPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNguoiDung]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNguoiDung](
	[IdNguoiDung] [int] IDENTITY(1,1) NOT NULL,
	[MaNguoiDung] [varchar](25) NULL,
	[HoTen] [nvarchar](100) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](150) NULL,
	[Sdt] [varchar](11) NULL,
	[Email] [varchar](50) NULL,
	[IdQuyen] [int] NULL,
	[NgayTao] [date] NULL,
	[IdLop] [int] NULL,
	[IdTrinhDo] [int] NULL,
	[MatKhau] [varchar](25) NULL,
 CONSTRAINT [PK_tblNguoiDung] PRIMARY KEY CLUSTERED 
(
	[IdNguoiDung] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblQuyen]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblQuyen](
	[IdQuyen] [int] IDENTITY(1,1) NOT NULL,
	[TenQuyen] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblQuyen] PRIMARY KEY CLUSTERED 
(
	[IdQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThoiGianHoc]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThoiGianHoc](
	[IdThoiGian] [int] IDENTITY(1,1) NOT NULL,
	[Buoi] [nvarchar](50) NULL,
	[TietBD] [nvarchar](50) NULL,
 CONSTRAINT [PK_ThoiGianHoc] PRIMARY KEY CLUSTERED 
(
	[IdThoiGian] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThoiKhoaBieu]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThoiKhoaBieu](
	[IdTKB] [int] IDENTITY(1,1) NOT NULL,
	[IdDangKyHP] [int] NULL,
	[IdDangKy] [int] NULL,
 CONSTRAINT [PK_ThoiKhoaBieu] PRIMARY KEY CLUSTERED 
(
	[IdTKB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thu]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thu](
	[IdThu] [int] IDENTITY(1,1) NOT NULL,
	[TenThu] [nvarchar](50) NULL,
 CONSTRAINT [PK_Thu] PRIMARY KEY CLUSTERED 
(
	[IdThu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrinhDo]    Script Date: 22/06/2020 10:33:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrinhDo](
	[IdTrinhDo] [int] IDENTITY(1,1) NOT NULL,
	[TenTrinhDo] [nvarchar](150) NULL,
 CONSTRAINT [PK_TrinhDo] PRIMARY KEY CLUSTERED 
(
	[IdTrinhDo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DangKy] ADD  CONSTRAINT [DF_DangKy_Status]  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[DangKyHocPhan] ADD  CONSTRAINT [DF_DangKyHocPhan_Status]  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[tblNguoiDung] ADD  CONSTRAINT [DF_tblNguoiDung_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_HocKi] FOREIGN KEY([IdHocKi])
REFERENCES [dbo].[HocKi] ([IdHocKi])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_HocKi]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_MonHoc] FOREIGN KEY([IdMonHoc])
REFERENCES [dbo].[MonHoc] ([IdMonHoc])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_MonHoc]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_PhongHoc] FOREIGN KEY([IdPhong])
REFERENCES [dbo].[PhongHoc] ([IdPhong])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_PhongHoc]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_tblNguoiDung] FOREIGN KEY([IdGV])
REFERENCES [dbo].[tblNguoiDung] ([IdNguoiDung])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_tblNguoiDung]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_ThoiGianHoc] FOREIGN KEY([IdThoiGian])
REFERENCES [dbo].[ThoiGianHoc] ([IdThoiGian])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_ThoiGianHoc]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_Thu] FOREIGN KEY([IdThu])
REFERENCES [dbo].[Thu] ([IdThu])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_Thu]
GO
ALTER TABLE [dbo].[DangKyHocPhan]  WITH CHECK ADD  CONSTRAINT [FK_DangKyHocPhan_tblNguoiDung] FOREIGN KEY([IdSV])
REFERENCES [dbo].[tblNguoiDung] ([IdNguoiDung])
GO
ALTER TABLE [dbo].[DangKyHocPhan] CHECK CONSTRAINT [FK_DangKyHocPhan_tblNguoiDung]
GO
ALTER TABLE [dbo].[Lop]  WITH CHECK ADD  CONSTRAINT [FK_Lop_Khoa] FOREIGN KEY([IdKhoa])
REFERENCES [dbo].[Khoa] ([IdKhoa])
GO
ALTER TABLE [dbo].[Lop] CHECK CONSTRAINT [FK_Lop_Khoa]
GO
ALTER TABLE [dbo].[MonHoc]  WITH CHECK ADD  CONSTRAINT [FK_MonHoc_Khoa] FOREIGN KEY([IdKhoa])
REFERENCES [dbo].[Khoa] ([IdKhoa])
GO
ALTER TABLE [dbo].[MonHoc] CHECK CONSTRAINT [FK_MonHoc_Khoa]
GO
ALTER TABLE [dbo].[tblNguoiDung]  WITH CHECK ADD  CONSTRAINT [FK_tblNguoiDung_Lop] FOREIGN KEY([IdLop])
REFERENCES [dbo].[Lop] ([IdLop])
GO
ALTER TABLE [dbo].[tblNguoiDung] CHECK CONSTRAINT [FK_tblNguoiDung_Lop]
GO
ALTER TABLE [dbo].[tblNguoiDung]  WITH CHECK ADD  CONSTRAINT [FK_tblNguoiDung_tblQuyen] FOREIGN KEY([IdQuyen])
REFERENCES [dbo].[tblQuyen] ([IdQuyen])
GO
ALTER TABLE [dbo].[tblNguoiDung] CHECK CONSTRAINT [FK_tblNguoiDung_tblQuyen]
GO
ALTER TABLE [dbo].[tblNguoiDung]  WITH CHECK ADD  CONSTRAINT [FK_tblNguoiDung_TrinhDo] FOREIGN KEY([IdTrinhDo])
REFERENCES [dbo].[TrinhDo] ([IdTrinhDo])
GO
ALTER TABLE [dbo].[tblNguoiDung] CHECK CONSTRAINT [FK_tblNguoiDung_TrinhDo]
GO
ALTER TABLE [dbo].[ThoiKhoaBieu]  WITH CHECK ADD  CONSTRAINT [FK_ThoiKhoaBieu_DangKy] FOREIGN KEY([IdDangKy])
REFERENCES [dbo].[DangKy] ([IdDangKy])
GO
ALTER TABLE [dbo].[ThoiKhoaBieu] CHECK CONSTRAINT [FK_ThoiKhoaBieu_DangKy]
GO
ALTER TABLE [dbo].[ThoiKhoaBieu]  WITH CHECK ADD  CONSTRAINT [FK_ThoiKhoaBieu_DangKyHocPhan] FOREIGN KEY([IdDangKyHP])
REFERENCES [dbo].[DangKyHocPhan] ([IdDangKyHP])
GO
ALTER TABLE [dbo].[ThoiKhoaBieu] CHECK CONSTRAINT [FK_ThoiKhoaBieu_DangKyHocPhan]
GO
