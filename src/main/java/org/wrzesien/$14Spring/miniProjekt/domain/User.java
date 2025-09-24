package org.wrzesien.$14Spring.miniProjekt.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
	String email;
	String name;
	String public_name;
	String birth_date;
}
