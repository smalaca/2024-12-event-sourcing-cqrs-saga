package com.smalaca;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventSourcingTest {

    @Test
    void shouldRecognizeIfEventSourcingHelps() {
        boolean actual = new EventSourcing().doesItHelp();

        assertThat(actual).isTrue();
    }
}
