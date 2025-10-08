package org.pazdziernik.SpringDataAccess.project.infrastructure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseConfiguration.class)
@ComponentScan(basePackages = "org.pazdziernik.SpringDataAccess.project.infrastructure")
public class ZajavkaStoreApplication {
}
