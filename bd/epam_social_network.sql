-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Авг 11 2016 г., 20:50
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `epam_social_network`
--

-- --------------------------------------------------------

--
-- Структура таблицы `friends`
--

CREATE TABLE `friends` (
  `friend_of` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `confirmed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `from` int(11) NOT NULL,
  `to` int(11) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` text NOT NULL,
  `last_name` text NOT NULL,
  `first_name` text NOT NULL,
  `password` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `email`, `last_name`, `first_name`, `password`) VALUES
(1, 'grimgrinn@gmail.com', 'name', 'sername', 'f7906959d67d5ce9857c98417c991fb38270abb5a7b2cfe34d79247a70854fb1'),
(2, 'f@f', 'grim', 'grinn', 'f7906959d67d5ce9857c98417c991fb38270abb5a7b2cfe34d79247a70854fb1'),
(3, 'hitler@ss.de', 'adolf', 'hitler', 'e27117c0a925e4892c9aee9d411358293515d60f376a217f68ec9619d1fa084'),
(4, 'mm@mm.ru', 'grinn', 'name', '7b61f08cbdefad914a744e823b17638c230c31197933b6dfcdabe3726915a'),
(5, 'hhh@hhh.ru', 'ftft', 'ftft', 'f7906959d67d5ce9857c98417c991fb38270abb5a7b2cfe34d79247a70854fb1'),
(6, 'ggg@ggg.ru', 'ggg', 'ggg', 'b1ffebc1fc4328e635f6fc9d2d9e667bba6d762199e4413b1fddda1d4375c84'),
(7, 'fff@fff.ru', 'fff', 'fff', '387f932bce8c6bde93e5f78c2821b696cd42d6df60d17e79ac3f2ce717d4ddfd'),
(8, 'anton@anton.com', 'anton', 'anton', '21bdd1538b77e7429ed8d78e0378e99404ad05347e03ae27a8a45c38359ae3d'),
(9, 'd@d.ru', 'd', 'd', 'f02db5498f5ebc34a7881f58219b8c727e91e9be4c849b9b79684f8cb8fcac7e'),
(10, 'putin@kremlin.ru', 'putin', 'vladimir', '21bdd1538b77e7429ed8d78e0378e99404ad05347e03ae27a8a45c38359ae3d'),
(11, 'ad@ad.ru', 'ad', 'ad', '60d4676fd7def0f9d35275c01d3f6eb718f32a6d4c7c8f31dd6a9262adef4a73');

-- --------------------------------------------------------

--
-- Структура таблицы `walls`
--

CREATE TABLE `walls` (
  `id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `wall` int(11) NOT NULL,
  `post` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `walls`
--

INSERT INTO `walls` (`id`, `user`, `wall`, `post`, `timestamp`) VALUES
(1, 6, 0, 'f', '2016-08-11 11:16:36'),
(2, 6, 0, 'f', '2016-08-11 11:16:42'),
(3, 6, 0, 'd', '2016-08-11 11:16:48'),
(4, 6, 0, 'jopa', '2016-08-11 11:17:07'),
(5, 6, 0, '5', '2016-08-11 11:17:27'),
(6, 6, 0, 'f', '2016-08-11 11:18:44'),
(7, 6, 0, 'sdfs', '2016-08-11 11:21:20'),
(8, 6, 0, 'f', '2016-08-11 11:21:39'),
(9, 6, 0, '', '2016-08-11 11:23:37'),
(10, 6, 0, 'jopa siski pivas', '2016-08-11 11:26:11'),
(11, 6, 0, 'kill', '2016-08-11 11:26:26'),
(12, 6, 0, 'r', '2016-08-11 12:17:26'),
(13, 6, 0, 'r', '2016-08-11 12:17:31'),
(14, 6, 0, 'r', '2016-08-11 12:17:36'),
(15, 3, 0, 'r', '2016-08-11 12:17:48'),
(16, 1, 0, 'TESTTESTTEST', '2016-08-11 12:19:17'),
(17, 1, 0, 'cvbcvb', '2016-08-11 12:19:50'),
(18, 2, 0, 'fdsfsdf', '2016-08-11 12:24:01'),
(19, 6, 0, 'd', '2016-08-11 12:27:48'),
(20, 6, 0, 'fdsfsdf', '2016-08-11 12:29:11'),
(21, 6, 0, 'sdfsdf', '2016-08-11 12:29:15'),
(22, 6, 0, '1', '2016-08-11 12:29:19'),
(23, 6, 0, '2', '2016-08-11 12:29:21'),
(24, 6, 0, '3', '2016-08-11 12:29:22'),
(25, 6, 0, 'fff', '2016-08-11 12:32:29'),
(26, 6, 0, 'rrr', '2016-08-11 12:33:09'),
(27, 6, 0, 'gggRRRRRR', '2016-08-11 12:35:23'),
(28, 6, 0, 'FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF', '2016-08-11 12:40:05'),
(29, 6, 0, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '2016-08-11 12:43:06'),
(30, 6, 6, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '2016-08-11 12:44:32'),
(31, 6, 6, 'r', '2016-08-11 12:50:47'),
(32, 6, 6, 'ddd', '2016-08-11 12:50:52'),
(33, 6, 1, 'd', '2016-08-11 12:51:13'),
(34, 6, 1, 'dfsfsdf', '2016-08-11 12:52:08'),
(35, 6, 2, 'Привет!', '2016-08-11 12:53:44'),
(36, 6, 6, 'Вам привет от GGG !\r\n', '2016-08-11 13:16:06'),
(37, 11, 6, 'Здарова карова!', '2016-08-11 13:17:17'),
(38, 11, 6, 'тратата', '2016-08-11 13:17:34'),
(39, 11, 6, 'Александр Малинин!', '2016-08-11 13:18:00'),
(40, 11, 1, 'И тутя напешу', '2016-08-11 13:18:20'),
(41, 6, 6, '123', '2016-08-11 13:37:04'),
(42, 6, 6, 'fff', '2016-08-11 14:08:57'),
(43, 6, 6, 'fdgdfgdfg', '2016-08-11 15:27:37'),
(44, 6, 6, 'dfgdfgdfgdfg', '2016-08-11 15:27:43'),
(45, 6, 6, 'asdasdasd', '2016-08-11 15:34:16'),
(46, 6, 6, 'asdasdasd', '2016-08-11 15:34:31'),
(47, 6, 6, 'rrrrrrrrrrr', '2016-08-11 15:34:40'),
(48, 6, 6, 'ttttttttttttt', '2016-08-11 15:34:45'),
(49, 6, 6, 'gggggggggg', '2016-08-11 15:34:52'),
(50, 6, 6, 'dfgdfg', '2016-08-11 15:47:42'),
(51, 6, 6, 'tttttttttttt', '2016-08-11 15:47:46'),
(52, 6, 6, 'rrr', '2016-08-11 15:47:50'),
(53, 6, 6, 'dsgdfgdfg', '2016-08-11 15:48:05'),
(54, 6, 1, 'ffff', '2016-08-11 15:48:18');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `walls`
--
ALTER TABLE `walls`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT для таблицы `walls`
--
ALTER TABLE `walls`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
