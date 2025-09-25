package org.wrzesien.$14SpringBean.$2miniProjekt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.wrzesien.$14SpringBean.$2miniProjekt.Main;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class ApplicationConfiguration {

}
