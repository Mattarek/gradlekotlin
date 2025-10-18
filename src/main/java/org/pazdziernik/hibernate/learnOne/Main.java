package org.pazdziernik.hibernate.learnOne;

public class Main {
	// hibernate.connection.driver_class - Klasa sterownika JDBC
	// hibernate.connection.url - Adres URL połączenia JDBC
	// hibernate.connection.username - Nazwa użytkownika bazy danych
	// hibernate.connection.password - Haso do bazy danych

	// hibernate.dialect - Dialekt stosowany przez używaną bazę danych. Dialekt dostarcza informacji
	// na temat sposobu konwersji zapytań Hibernate (HQL) do natywnych zapytań SQL

	// hibernate.hbm2ddl.auto - jeżeli ustawimy ten parametrt o Hibernate będzie starał się automatycznie
	//								tworzyć encje w bazie danych na podstawie naszej konfiguracji encji
	// 								Na tym etapie dla uproszczenia powiedzmy, ze najlepiej jest zostawić
	// 								tę wartość ustawioną na none

	// hibernate.show_sql - Czy wykonane zapytania SQL mają być drukowane w konsoli. Gdy ustawimy ten parametr, to
	// 						Hibernate będzie drukował zapytania na ekranie ale parametry wykorzystane w tych zapytaniach
	// 						będą zastąpione znaczkiem ?.

	// hibernate.format_sql - Czy zapytania SQL mają być sformatowane przed wydrukowaniem w konsoli

	// hibernate.use_sql_comments - Hibernate będzie generował komentarze, dzięki którym bedzie starałsięnam przekazać
	// 								co właśnie robi,
}
