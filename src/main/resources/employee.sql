-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 09 May 2020, 01:07:29
-- Sunucu sürümü: 8.0.20
-- PHP Sürümü: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `employee`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `id` int NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `date`) VALUES
(1, 'azad', 'azad', '2020-03-18 08:27:26');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `fname` varchar(35) DEFAULT NULL,
  `lname` varchar(35) DEFAULT NULL,
  `salary` float NOT NULL,
  `age` int NOT NULL,
  `department` varchar(35) NOT NULL,
  `address` varchar(35) NOT NULL,
  `dateOfBirth` varchar(2344) NOT NULL,
  `gender` varchar(35) NOT NULL,
  `education` varchar(35) NOT NULL,
  `experience` varchar(35) NOT NULL,
  `contractStart` varchar(2352) NOT NULL,
  `conrtactEnd` varchar(3524) NOT NULL,
  `nationaly` varchar(35) NOT NULL,
  `motherLanguage` varchar(35) NOT NULL,
  `otherLanguage` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`id`, `fname`, `lname`, `salary`, `age`, `department`, `address`, `dateOfBirth`, `gender`, `education`, `experience`, `contractStart`, `conrtactEnd`, `nationaly`, `motherLanguage`, `otherLanguage`) VALUES
(15, 'azad', 'Erdoğan', 10000, 20, 'CEO', 'siirt', '2000-06-19', 'erkek', 'lisans', 'tecrubeli', '2020-03-29', '2020-03-19', 'Doğu', 'türkçe ', 'ingilizce'),
(16, 'veysel', 'erdogan', 2345, 12, 'ceo', 'siirt', '2020-03-13', 'erkek', 'ilkoul', 'var', '2020-03-17', '2020-03-29', 'dogu', 'tuyrkce', 'kürtçe'),
(17, '', '', 45, 345, '', '', '2020-03-18', '', '', '', '2020-03-21', '2020-03-04', '', '', ''),
(18, '', '', 45, 345, '', '', '2020-03-18', '', '', '', '2020-03-21', '2020-03-04', '', '', ''),
(19, '', '', 45, 345, '', '', '2020-03-18', '', '', '', '2020-03-21', '2020-03-04', '', '', ''),
(20, '', '', 345, 345, '', '', '2020-03-26', '', '', '', '2020-03-12', '2020-03-10', '', '', ''),
(21, 'Azad', 'Erdoğan', 4567, 20, 'CEO helper', 'kooperatif mahallesi', '2020-04-16', 'erkek', 'lisans', '', '2020-04-03', '2020-06-26', 'dogu', 'turkce', 'ingilizce');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
