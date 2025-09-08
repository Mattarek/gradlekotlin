package org.wrzesien.$7lombok.lombokPractice;

import lombok.With;

public record Dog(@With String name, @With String surname, @With String age) {
}
