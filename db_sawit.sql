-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Des 2019 pada 07.13
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sawit`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `kode_cust` varchar(10) DEFAULT NULL,
  `nama_pt` varchar(100) DEFAULT NULL,
  `npwp` varchar(100) DEFAULT NULL,
  `sppkp` varchar(100) DEFAULT NULL,
  `tgl_bergabung` date DEFAULT NULL,
  `tgl_habis_kontrak` date DEFAULT NULL,
  `no_hp` varchar(100) DEFAULT NULL,
  `no_telp` varchar(100) DEFAULT NULL,
  `alamat` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id`, `kode_cust`, `nama_pt`, `npwp`, `sppkp`, `tgl_bergabung`, `tgl_habis_kontrak`, `no_hp`, `no_telp`, `alamat`) VALUES
(1, 'CST01', 'PT. SAWIT MAJU MUNDUR', '9999', '9999', '2019-12-22', '2022-12-31', '0511', '0813', 'JL. BANJARMASIN');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id` int(11) NOT NULL,
  `nama` varchar(250) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `jenkel` enum('l','p') DEFAULT NULL,
  `no_hp` varchar(50) DEFAULT NULL,
  `alamat` text,
  `jabatan` varchar(50) DEFAULT NULL,
  `status_aktif` enum('1','0') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `tgl_lahir`, `jenkel`, `no_hp`, `alamat`, `jabatan`, `status_aktif`) VALUES
(1, 'Herzi', '2019-03-24', 'l', '0813', 'jl. banjarmasin kalimantan selatan', 'MANAGER', '0');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kebun`
--

CREATE TABLE `kebun` (
  `id` int(11) NOT NULL,
  `nama` varchar(250) DEFAULT NULL,
  `lahan_id` int(11) DEFAULT NULL,
  `varietas` varchar(250) DEFAULT NULL,
  `total_pohon` int(11) DEFAULT NULL,
  `tgl_tanam` date DEFAULT NULL,
  `tgl_perkiraan_panen` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kebun`
--

INSERT INTO `kebun` (`id`, `nama`, `lahan_id`, `varietas`, `total_pohon`, `tgl_tanam`, `tgl_perkiraan_panen`) VALUES
(1, 'KEBUN SAWIT', 1, 'UNGGUL', 400, '2019-12-22', '2019-12-31');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kebun_detail`
--

CREATE TABLE `kebun_detail` (
  `id` int(11) NOT NULL,
  `kebun_id` int(11) DEFAULT NULL,
  `progress_kebun` enum('proses_tanam','perawatan','siap_panen','panen_gagal','penanaman_kembali','proses_panen','selesai_panen') DEFAULT NULL,
  `tgl_update` datetime DEFAULT NULL,
  `ket` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kebun_detail`
--

INSERT INTO `kebun_detail` (`id`, `kebun_id`, `progress_kebun`, `tgl_update`, `ket`) VALUES
(1, 1, 'proses_tanam', '2019-12-22 00:00:00', 'AMAN'),
(2, 1, 'perawatan', '2019-12-22 00:00:00', 'sedang perawatan nih'),
(3, 1, 'siap_panen', '2019-12-22 00:00:00', 'siaapp');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lahan`
--

CREATE TABLE `lahan` (
  `id` int(11) NOT NULL,
  `lokasi` varchar(100) DEFAULT NULL,
  `koordinat` varchar(100) DEFAULT NULL,
  `luas` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `lahan`
--

INSERT INTO `lahan` (`id`, `lokasi`, `koordinat`, `luas`) VALUES
(1, 'JL. BANJARMASIN', '90-22.12.244.555', '800');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendapatan`
--

CREATE TABLE `pendapatan` (
  `id` int(11) NOT NULL,
  `kebun_id` int(11) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `jumlah_panen` int(11) DEFAULT NULL,
  `harga_kg` int(11) DEFAULT NULL,
  `total_pendapatan` int(11) DEFAULT NULL,
  `ket` text,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pendapatan`
--

INSERT INTO `pendapatan` (`id`, `kebun_id`, `customer_id`, `jumlah_panen`, `harga_kg`, `total_pendapatan`, `ket`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 4000, 200, 800000, 'ok', '2019-12-22 05:53:58', '2019-12-22 05:53:58');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `id` int(11) NOT NULL,
  `kebun_id` int(11) DEFAULT NULL,
  `biaya_tanaman` int(11) DEFAULT NULL,
  `biaya_panen` int(11) DEFAULT NULL,
  `biaya_lain` int(11) DEFAULT NULL,
  `total_pengeluaran` int(11) DEFAULT NULL,
  `ket` text,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`id`, `kebun_id`, `biaya_tanaman`, `biaya_panen`, `biaya_lain`, `total_pengeluaran`, `ket`, `created_at`, `updated_at`) VALUES
(1, 1, 50000, 10000, 0, 60000, '', '2019-12-22 05:54:18', '2019-12-22 05:54:18');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `kebun`
--
ALTER TABLE `kebun`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lahan_id` (`lahan_id`);

--
-- Indeks untuk tabel `kebun_detail`
--
ALTER TABLE `kebun_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `lahan`
--
ALTER TABLE `lahan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pendapatan`
--
ALTER TABLE `pendapatan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `kebun_id` (`kebun_id`);

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kebun_id` (`kebun_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `kebun`
--
ALTER TABLE `kebun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `kebun_detail`
--
ALTER TABLE `kebun_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `lahan`
--
ALTER TABLE `lahan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pendapatan`
--
ALTER TABLE `pendapatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kebun`
--
ALTER TABLE `kebun`
  ADD CONSTRAINT `kebun_ibfk_1` FOREIGN KEY (`lahan_id`) REFERENCES `lahan` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pendapatan`
--
ALTER TABLE `pendapatan`
  ADD CONSTRAINT `pendapatan_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pendapatan_ibfk_2` FOREIGN KEY (`kebun_id`) REFERENCES `kebun` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`kebun_id`) REFERENCES `kebun` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
