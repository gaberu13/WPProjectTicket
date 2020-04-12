# Gaber Event Ticket
## About creator

This project is for subject Web Programming made by Kristijan Gaber (152060) student of Faculty of Computer Science and Engineering in Skopje.

## About project

This is a RESTful web application that offers buying tickets for most popular events. Application is build with Spring Boot and Angular.
### How to?

Clone the repository to your local machine.

Build Angular application(Frontend) Using Visuel Studio Code or other IDE open the "TicketApp" folder by your IDE and in Command Prompt type "npm install". With this command you can get all the dependencies used for the frontend of the application. To strat the Angular appication type "ng build" to build tha application and "ng serve" to serve the application. Note: You need to serve your application to locahost:4200 port.

Build Spring Boot application(backend) Using IntelliJ IDEA or other IDE open the "BuyTicket" folder by your IDE and wait for IDE to resolve all the dependencies. Before your build your application you need to set your SQL connection. My database is MySQL powered by XAMPP. Configuration of application.properties :
```
#Database
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/tickets?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
```
Open XAMPP control panel, start MySQL and Apache server. Create SQL schema with name "tickets", build your Spring Boot aplication and in "tickets" SQL schema you need to execute below code to add Categories, Events, Tickets, Locations data:
```
1.Insert Category:

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Concerts'),
(2, 'Festivals'),
(3, 'Theater'),
(4, 'Opera & Ballet'),
(5, 'Sport Events'),
(6, 'Other');

2.Insert Location:
INSERT INTO `location` (`id`, `capacity`, `description`, `name`) VALUES
(1, '5000', 'A1 Arena Boris Trajkovski is bla bla bla', 'A1 Arena Boris Trajkovski'),
(2, '2000', 'Arena Todor Proevski', 'Arena Todor Proevski'),
(3, '2000', '(NOB) is designed for 781-1008 (in the case of theatrical performances) seats in the great hall, with 232 seats in the small hall (experimental stage). The program provides facilities for visitors as well as facilities for training and performance arts.', 'Opera and Ballet'),
(4, '2000', 'Philip II National Arena also known as the Telekom Arena for sponsorship reasons, is a multi-purpose stadium in Skopje, Republic of Macedonia. It is currently used mostly for football matches, but sometimes also for music concerts or other events. ', 'Philip II National Arena'),
(5, '2000', 'Macedonian Philharmonic', 'Macedonian Philharmonic');

3.Insert Event:
INSERT INTO `event` (`id`, `active`, `date`, `decription`, `name`, `price`, `time`, `place_id`) VALUES
(1, b'1', '24.05.2020', 'Music festival with a lot of famus singers on one stage', 'Music Festival', 150, '21:00', 1),
(2, b'1', '15.05.2020', 'Taksirat Festival', 'In Flames', 800, '20:30', 2),
(3, b'1', 'March', 'Do you balieve in everything you see? Visit us!', 'Ilusium', 200, '08:00 - 17:00', 3),
(4, b'1', '03 - 05.07.2020', 'D Festival 3-day with camp and more then 10 stages!', 'D Festival', 800, '00:00 - 00:00', 4),
(5, b'1', '11.07.2020', 'Sea Denace Festival is on of the most popular festival in Europe. Beach party, most famuse DJs from around the world! Ticket now!', 'Sea Dance Festival', 1700, '20:00', 5),
(6, b'1', '27.08.2020', 'Win Music Freedom', 'Tale of Us', 600, '22:00', 5),
(7, b'1', '01.06.2020', 'Young actors from the School of Drama in Skopje', 'MME', 200, '21:00', 3),
(8, b'1', '19.05.2020', 'One of the most famous ballets ever seen in the world.', 'The Nutcracker', 1200, '20:00', 3);

4.Insert Category_Event:
INSERT INTO `category_event` (`category_id`, `event_id`) VALUES
(2, 1),
(2, 2),
(6, 3),
(2, 4),
(2, 5),
(1, 6),
(3, 7),
(4, 8);

5. Insert Ticket:
INSERT INTO `ticket` (`id`, `count`, `location`, `price`, `event_id`) VALUES
(1, 200, 'Fanpit', 300, 1),
(2, 220, 'Regular', 800, 2),
(3, 100, 'Parter', 150, 1),
(4, 150, 'Regular', 200, 3),
(5, 50, 'First Rows', 400, 3),
(6, 20, 'VIP', 600, 3),
(7, 2000, 'One Day Pass', 800, 4),
(8, 2000, 'Two Day Pass', 1500, 4),
(9, 2000, 'Three Day Pass', 2100, 4),
(10, 2000, 'Three Day Pass + Camp', 2400, 4),
(11, 1100, 'Regular', 1700, 5),
(12, 6000, 'Regular', 600, 6),
(13, 600, 'VIP', 1300, 6),
(14, 200, 'Regular', 200, 7),
(15, 200, 'Regular', 1200, 8),
(16, 200, 'First Rows', 1800, 8);
```
#### WP, FINKI, 2020
#### Kristijan Gaber, 152060
