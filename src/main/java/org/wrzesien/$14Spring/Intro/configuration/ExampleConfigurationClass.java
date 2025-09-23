package org.wrzesien.$14Spring.Intro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.wrzesien.$14Spring.Intro.Main;
import org.wrzesien.$14Spring.Intro.code.InjectedBean;

@Configuration
// Jeśli cała apka jest w 1 paczce, to nie musimy tego definiować, Spring sie domysli.
@ComponentScan(basePackageClasses = Main.class)
public class ExampleConfigurationClass {
	
}
