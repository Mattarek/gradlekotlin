package org.wrzesien.$14Spring.miniProjekt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.wrzesien.$14Spring.miniProjekt.Main;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class ApplicationConfiguration {

}
