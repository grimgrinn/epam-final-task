-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Авг 10 2016 г., 20:46
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
(10, 'putin@kremlin.ru', 'putin', 'vladimir', '21bdd1538b77e7429ed8d78e0378e99404ad05347e03ae27a8a45c38359ae3d');

-- --------------------------------------------------------

--
-- Структура таблицы `walls`
--

CREATE TABLE `walls` (
  `id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `post` text NOT NULL,
  `timestamp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `walls`
--
ALTER TABLE `walls`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
