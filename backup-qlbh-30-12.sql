-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 30, 2020 lúc 05:26 PM
-- Phiên bản máy phục vụ: 10.4.16-MariaDB
-- Phiên bản PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlbh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `code_bill` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `customer_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `id_user` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `invoice_creation_date` date NOT NULL,
  `note` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`code_bill`, `customer_code`, `id_user`, `invoice_creation_date`, `note`) VALUES
('B000000001', 'CM00000001', 'US00000002', '2020-12-14', 'Khách vip'),
('B000000002', 'CM00000002', 'US00000002', '2020-12-14', ''),
('B000000003', 'CM00000004', 'US00000002', '2020-12-14', ''),
('B000000004', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000005', 'CM00000004', 'US00000002', '2020-12-14', ''),
('B000000006', 'CM00000004', 'US00000003', '2020-12-14', ''),
('B000000007', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000008', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000009', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000010', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000011', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000012', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000013', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000014', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000015', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000016', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000017', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000018', 'CM00000006', 'US00000002', '2020-12-13', 'Hello'),
('B000000019', 'CM00000001', 'US00000002', '2020-12-22', 'test ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `customer_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `trading_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`customer_code`, `customer_name`, `trading_name`, `address`, `email`, `phone_number`) VALUES
('CM00000001', 'Anh Tài', 'Mua bộ gear', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000002', 'Anh Tài', 'Build bộ PC', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000003', 'Anh Tài', 'Mua ghế Gaming', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000004', 'Bạn Duy', 'Mua chuột', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000005', 'Bạn Khoa', 'Mua bàn phím', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000006', 'Bạn Đồng', 'Mua Laptop', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `goods`
--

CREATE TABLE `goods` (
  `item_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `item_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `company_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `type_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `unit` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `import_price` float NOT NULL,
  `price` float NOT NULL,
  `image_item` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `goods`
--

INSERT INTO `goods` (`item_code`, `item_name`, `company_code`, `type_code`, `amount`, `unit`, `import_price`, `price`, `image_item`) VALUES
('BP00000001', 'Bàn phím cơ Corsair K100 RGB', 'CC00000007', 'L000000002', 3000, 'Chiếc', 3000000, 5290000, '/ImageProduct/corsair-k100-rgb.jpg'),
('BP00000002', 'Bàn phím cơ Corsair K100 RGB', 'CC00000007', 'L000000002', 3000, 'Chiếc', 3000000, 5290000, '/ImageProduct/corsair-k100-rgb.jpg'),
('CG00000001', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 0, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000002', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000003', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000005', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000006', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000007', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000008', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000009', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000010', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000011', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000012', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000013', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000014', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000015', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000016', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000017', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000018', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000019', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000020', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000021', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 1250, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('VGA0000001', 'MSI GeForce RTX 3090 VENTUS 3X 24G OC', 'CC00000001', 'L000000001', 199, 'Chiếc', 25000000, 45990000, '/ImageProduct/mis-rtx3090ventus3x24goc.png'),
('VGA0000002', 'Gigabyte GeForce RTX 3090 Eagle OC 24G', 'CC00000002', 'L000000001', 5, 'Chiếc', 28000000, 48490000, '/ImageProduct/3090_EAGLE_OC_1_compressed-568x568.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoicedetails`
--

CREATE TABLE `invoicedetails` (
  `code_bill` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `item_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `amount` int(11) NOT NULL,
  `discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `invoicedetails`
--

INSERT INTO `invoicedetails` (`code_bill`, `item_code`, `price`, `amount`, `discount`) VALUES
('B000000001', 'VGA0000001', 45990000, 2, 5),
('B000000001', 'VGA0000002', 48490000, 3, 7),
('B000000002', 'VGA0000002', 48490000, 3, 7),
('B000000003', 'CG00000001', 2789000, 3, 5),
('B000000005', 'CG00000002', 2789000, 10, 10),
('B000000006', 'VGA0000002', 48490000, 10, 15),
('B000000019', 'VGA0000001', 45990000, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `next_code`
--

CREATE TABLE `next_code` (
  `code_bill` int(11) NOT NULL,
  `code_customer` int(11) NOT NULL,
  `code_type` int(11) NOT NULL,
  `code_company` int(11) NOT NULL,
  `code_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `next_code`
--

INSERT INTO `next_code` (`code_bill`, `code_customer`, `code_type`, `code_company`, `code_user`) VALUES
(20, 7, 16, 16, 25);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `company_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `trading_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `logo_supplier` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`company_code`, `company_name`, `trading_name`, `address`, `email`, `phone_number`, `logo_supplier`) VALUES
('CC00000001', 'MSI', 'Cung cấp VGA thế hệ mới RTX 30 seris', 'Hà Nội', 'msicompany@gmail.com', '0982326874', '/LogoSupplier/msi-gaming-logo-spirit-vertical-black-rgb.png'),
('CC00000002', 'Gigabyte', 'Cung cấp VGA thế hệ mới RTX 30 seris', 'Hồ Chí Minh', 'gigabytecompany@gmail.com', '0982326634', '/LogoSupplier/aorus-logo.png'),
('CC00000003', 'Steelseries', 'Cung cấp Gaming Gear Steelseries', 'Hưng Yên', 'steelseriescompany@gmail.com', '0996326874', '/LogoSupplier/Steelseries-logo.png'),
('CC00000004', 'Razer', 'Cung cấp Gaming Gear Razer', 'Hà Nội', 'razercompany@gmail.com', '23414884888', '/LogoSupplier/Razer_snake_logo.png'),
('CC00000005', 'Razer', 'Cung cấp Gaming Gear Razer', 'Hà Nội', 'razercompany@gmail.com', '0932066688', '/LogoSupplier/Razer_snake_logo.png'),
('CC00000006', 'Razer', 'Cung cấp Gaming Gear Razer', 'Hà Nội', 'razercompany@gmail.com', '0932066688', '/LogoSupplier/Razer_snake_logo.png'),
('CC00000007', 'Corsair', 'Cung cấp Gaming Gear Corsair', 'Hà Nội', 'corsaircompany@gmail.com', '0932066688', '/LogoSupplier/corsair-logo.png'),
('CC00000008', 'Corsair', 'Cung cấp Gaming Gear Corsair', 'Hà Nội', 'corsaircompany@gmail.com', '0932066688', '/LogoSupplier/corsair-logo.png'),
('CC00000009', 'Corsair', 'Cung cấp Gaming Gear Corsair', 'Hà Nội', 'corsaircompany@gmail.com', '0932066688', '/LogoSupplier/corsair-logo.png'),
('CC00000010', 'Corsair', 'Cung cấp Gaming Gear Corsair', 'Hà Nội', 'corsaircompany@gmail.com', '0932066688', '/LogoSupplier/corsair-logo.png'),
('CC00000011', 'Corsair', 'Cung cấp Gaming Gear Corsair', 'Hà Nội', 'corsaircompany@gmail.com', '0932066688', '/LogoSupplier/corsair-logo.png'),
('CC00000012', 'DareU', 'Cung cấp Gaming Gear DareU', 'Hà Nội', 'dareucompany@gmail.com', '0932066688', '/LogoSupplier/dareu-logo.png'),
('CC00000013', 'DareU', 'Cung cấp Gaming Gear DareU', 'Hà Nội', 'dareucompany@gmail.com', '0932066688', '/LogoSupplier/dareu-logo.png'),
('CC00000014', 'DareU', 'Cung cấp Gaming Gear DareU', 'Hà Nội', 'dareucompany@gmail.com', '0932066688', '/LogoSupplier/dareu-logo.png'),
('CC00000015', 'DareU', 'Cung cấp Gaming Gear DareU', 'Hà Nội', 'dareucompany@gmail.com', '0932066688', '/LogoSupplier/dareu-logo.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `timekeeping`
--

CREATE TABLE `timekeeping` (
  `id_user` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `work_day` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `timekeeping`
--

INSERT INTO `timekeeping` (`id_user`, `work_day`) VALUES
('US00000002', '2020-11-11'),
('US00000002', '2020-11-12'),
('US00000002', '2020-11-13'),
('US00000002', '2020-11-14'),
('US00000002', '2020-11-15'),
('US00000002', '2020-11-16'),
('US00000002', '2020-11-17'),
('US00000002', '2020-11-18'),
('US00000002', '2020-11-19'),
('US00000002', '2020-11-20'),
('US00000002', '2020-11-21'),
('US00000002', '2020-11-22'),
('US00000002', '2020-11-23'),
('US00000002', '2020-11-24'),
('US00000002', '2020-11-25'),
('US00000002', '2020-11-26'),
('US00000002', '2020-11-27'),
('US00000002', '2020-11-28'),
('US00000002', '2020-11-29'),
('US00000002', '2020-11-30'),
('US00000002', '2020-12-01'),
('US00000002', '2020-12-02'),
('US00000002', '2020-12-04'),
('US00000002', '2020-12-06'),
('US00000004', '2020-11-02'),
('US00000004', '2020-12-01'),
('US00000004', '2020-12-08'),
('US00000005', '2020-10-21'),
('US00000024', '2020-12-15'),
('US00000024', '2020-12-16');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `typeofgoods`
--

CREATE TABLE `typeofgoods` (
  `type_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `type_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `typeofgoods`
--

INSERT INTO `typeofgoods` (`type_code`, `type_name`) VALUES
('L000000001', 'VGA - Card màn hình'),
('L000000002', 'Bàn phím'),
('L000000003', 'Chuột Gaming'),
('L000000004', 'Tai nghe'),
('L000000005', 'Ghế Gaming'),
('L000000006', 'Màn hình'),
('L000000007', 'Laptop'),
('L000000008', 'Mainboard - Bo mạch chủ'),
('L000000009', 'CPU - Bộ vi xử lý'),
('L000000010', 'Ram - Bộ nhớ trong'),
('L000000011', 'SSD - Ổ cứng thể rắn'),
('L000000012', 'HDD - Ổ cứng PC'),
('L000000013', 'Case - Vỏ máy tính'),
('L000000014', 'PSU - Nguồn máy tính'),
('L000000015', 'Tản nhiệt - Fan RGB');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id_user` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `full_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `start_date` date NOT NULL,
  `address` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `basic_salary` float NOT NULL,
  `allowance` float NOT NULL,
  `image_user` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id_user`, `user_name`, `password`, `role`, `full_name`, `gender`, `birthday`, `start_date`, `address`, `phone_number`, `email`, `basic_salary`, `allowance`, `image_user`, `status`) VALUES
('US00000001', 'admin', 'admin', 'Quản lý', 'Phạm Duy Tài', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000024', 'anhtaideptrai', 'taideptrai3d2y', 'Quản lý', 'Pham Duy Tai', 'Nam', '2000-12-22', '2020-12-12', 'Hà Nội', '0932962686', 'anhtai3d2y@gmail.com', 8888890000, 888889000, '/AvatarStaff/taideptrai2.jpg', 'Hoạt động'),
('US00000002', 'staff', 'staff', 'Nhân viên', 'Phạm Duy Tài Adm', 'Nữ', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000011', 'taideptrai10', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 10', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai2.jpg', 'Khóa'),
('US00000012', 'taideptrai11', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 11', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000015', 'taideptrai14', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 14', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Khóa'),
('US00000017', 'taideptrai16', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 16', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000018', 'taideptrai17', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 17', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000020', 'taideptrai19', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 19', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai2.jpg', 'Khóa'),
('US00000003', 'taideptrai2', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 2', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000021', 'taideptrai20', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 20', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai2.jpg', 'Khóa'),
('US00000004', 'taideptrai3', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 3', 'Nữ', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Khóa'),
('US00000005', 'taideptrai4', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 4', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000006', 'taideptrai5', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 5', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai2.jpg', 'Khóa'),
('US00000007', 'taideptrai6', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 6', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000008', 'taideptrai7', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 7', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai2.jpg', 'Khóa'),
('US00000010', 'taideptrai9', 'anhtai3d2y', 'Nhân viên', 'Phạm Duy Tài 9', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`code_bill`),
  ADD KEY `FK_customercode` (`customer_code`),
  ADD KEY `FK_iduser` (`id_user`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_code`);

--
-- Chỉ mục cho bảng `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`item_code`),
  ADD KEY `FK_companycode` (`company_code`),
  ADD KEY `FK_typecode` (`type_code`);

--
-- Chỉ mục cho bảng `invoicedetails`
--
ALTER TABLE `invoicedetails`
  ADD PRIMARY KEY (`code_bill`,`item_code`),
  ADD KEY `FK_itemcodeinvoicedetails` (`item_code`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`company_code`);

--
-- Chỉ mục cho bảng `timekeeping`
--
ALTER TABLE `timekeeping`
  ADD PRIMARY KEY (`id_user`,`work_day`);

--
-- Chỉ mục cho bảng `typeofgoods`
--
ALTER TABLE `typeofgoods`
  ADD PRIMARY KEY (`type_code`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_name`),
  ADD UNIQUE KEY `UNIQUE_idstaff` (`id_user`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FK_customercode` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`customer_code`),
  ADD CONSTRAINT `FK_iduser` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Các ràng buộc cho bảng `goods`
--
ALTER TABLE `goods`
  ADD CONSTRAINT `FK_companycode` FOREIGN KEY (`company_code`) REFERENCES `supplier` (`company_code`),
  ADD CONSTRAINT `FK_typecode` FOREIGN KEY (`type_code`) REFERENCES `typeofgoods` (`type_code`);

--
-- Các ràng buộc cho bảng `invoicedetails`
--
ALTER TABLE `invoicedetails`
  ADD CONSTRAINT `FK_codebill` FOREIGN KEY (`code_bill`) REFERENCES `bill` (`code_bill`),
  ADD CONSTRAINT `FK_itemcodeinvoicedetails` FOREIGN KEY (`item_code`) REFERENCES `goods` (`item_code`);

--
-- Các ràng buộc cho bảng `timekeeping`
--
ALTER TABLE `timekeeping`
  ADD CONSTRAINT `FK_iduserworkday` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
